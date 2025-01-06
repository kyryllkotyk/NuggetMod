package net.kyryllkotyk.nuggetium.item;

import net.kyryllkotyk.nuggetium.Nuggetium;
import net.kyryllkotyk.nuggetium.item.custom.ModArmorItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Nuggetium.MOD_ID);

    public static final RegistryObject<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_COOKED = ITEMS.register("nugget_cooked",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NUGGET_COOKED)));

    public static final RegistryObject<Item> CATACLYSM = ITEMS.register("cataclysm",
            () -> new BowItem(new Item.Properties().durability(2500)));

    public static final RegistryObject<Item> NUGSCALIBUR = ITEMS.register("nugscalibur",
            () -> new SwordItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.NUGGET, 3, -2.4f))));
    public static final RegistryObject<Item> STARCAT_PICKAXE = ITEMS.register("starcat_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NUGGET, 1, -2.8f))));
    public static final RegistryObject<Item> TERRACLAW = ITEMS.register("terraclaw",
            () -> new ShovelItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.NUGGET, 1.5f, -3.0f))));
    public static final RegistryObject<Item> PAWERFUL_AXE = ITEMS.register("pawerful_axe",
            () -> new AxeItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.NUGGET, 6, -3.2f))));
    public static final RegistryObject<Item> CLAWTIVATOR = ITEMS.register("clawtivator",
            () -> new HoeItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.NUGGET, 0, -3.0f))));

    public static final RegistryObject<Item> NFC_BUCKET = ITEMS.register("nfc_bucket",
            () -> new ModArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));
    public static final RegistryObject<Item> DEEP_FRIED_CHESTPLATE = ITEMS.register("deep_fried_chestplate",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50))));
    public static final RegistryObject<Item> DRUMSTICK_TROUSERS = ITEMS.register("drumstick_trousers",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50))));
    public static final RegistryObject<Item> CRISPY_FLIP_FLOPS = ITEMS.register("crispy_flip_flops",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
