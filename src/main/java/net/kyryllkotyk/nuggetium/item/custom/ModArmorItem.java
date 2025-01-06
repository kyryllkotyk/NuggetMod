package net.kyryllkotyk.nuggetium.item.custom;

import com.google.common.collect.ImmutableMap;
import net.kyryllkotyk.nuggetium.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.NUGGET_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.JUMP, 100, 4, false, false),
                                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 4, false, false),
                                    new MobEffectInstance(MobEffects.GLOWING, 100, 1, false, false),
                                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 100, 5, false, false),
                                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1, false, false),
                                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2, false, false),
                                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 3, false, false),
                                    new MobEffectInstance(MobEffects.DIG_SPEED, 100, 4, false, false),
                                    new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 5, false, false)))
                    .build();
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP_2 =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.NUGGET_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.JUMP, 100, 2, false, false),
                                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2, false, false),
                                    new MobEffectInstance(MobEffects.GLOWING, 100, 1, false, false),
                                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 100, 2, false, false),
                                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1, false, false),
                                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1, false, false),
                                    new MobEffectInstance(MobEffects.DIG_SPEED, 100, 2, false, false)))
                    .build();

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide()) {
            evaluateArmorEffects(player);
        }
    }

    private int countArmorPieces(Player player, Holder<ArmorMaterial> targetMaterial) {
        int count = 0;
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (armorStack.getItem() instanceof ArmorItem) {
                ArmorItem armorItem = (ArmorItem) armorStack.getItem();
                if (armorItem.getMaterial() == targetMaterial) {
                    count++;
                }
            }
        }
        return count;
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> material = entry.getKey();
            int pieceCount = countArmorPieces(player, material);

            if (pieceCount == 4 && hasPlayerCorrectArmorOn(material, player)) {  // Full set
                addEffectToPlayer(player, entry.getValue());
            } else if (pieceCount > 0) {  // Partial set
                addEffectToPlayer(player, MATERIAL_TO_EFFECT_MAP_2.get(material));
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));
        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }
}