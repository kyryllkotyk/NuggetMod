package net.kyryllkotyk.nuggetium.item.custom;

import net.kyryllkotyk.nuggetium.item.ModItems;
import net.kyryllkotyk.nuggetium.registry.ModEffects;
import net.kyryllkotyk.nuggetium.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.event.ForgeEventFactory;

public class ModBowItem extends BowItem {
    public ModBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        arrow.setBaseDamage(arrow.getBaseDamage() * 2.0);
        arrow.addTag("nugget_arrow");
       // arrow.setNoGravity(true);
        arrow.setInvulnerable(true);
        arrow.setSilent(true);
        return arrow;
    }

    public static void onArrowHit(AbstractArrow arrow, Entity entity){
        if(arrow.getTags().contains("nugget_arrow") && entity instanceof LivingEntity livingTarget){
            livingTarget.addEffect(new MobEffectInstance(ModEffects.RAPID_FIRE.getHolder().get(), 100, 0));
        }
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(pStack);
            if (!itemstack.isEmpty()) {
                int i = this.getUseDuration(pStack, pEntityLiving) - pTimeLeft;  // Fixed: added pEntityLiving
                i = ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, true);
                if (i < 0) return;

                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    if (pLevel instanceof ServerLevel serverlevel) {
                        // Create 5 arrows with spread
                        for(int arrowCount = 0; arrowCount < 5; arrowCount++) {
                            AbstractArrow arrow = ((ArrowItem)Items.ARROW).createArrow(serverlevel, itemstack, player, pStack);
                            arrow = this.customArrow(arrow);
                            // Add random spread to each arrow
                            arrow.shootFromRotation(player,
                                    player.getXRot() + (pLevel.getRandom().nextFloat() - 0.5F) * 3,
                                    player.getYRot() + (pLevel.getRandom().nextFloat() - 0.5F) * 3,
                                    0.0F,
                                    f * 1000.0F,
                                    1.0F);

                            if (f == 1.0F) {
                                arrow.setCritArrow(true);
                            }
                            serverlevel.addFreshEntity(arrow);
                            arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                        }

                        itemstack.shrink(1);
                    }

                    pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                            ModSounds.ARROW_SHOOT.get(), SoundSource.PLAYERS, 2.0F,
                            1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    if (itemstack.isEmpty()) {
                        player.getInventory().removeItem(itemstack);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

//SHORTBOW: IMPLEMENT LATER
//    @Override
//    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
//        if(!stack.is(ModItems.CATACLYSM.get())){
//            return false;
//        }
//        player.
//    }
}