package net.kyryllkotyk.nuggetium.item;

import net.kyryllkotyk.nuggetium.Nuggetium;
import net.kyryllkotyk.nuggetium.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Nuggetium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUGGET_TAB = CREATIVE_MODE_TABS.register("nugget_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .title(Component.translatable("creativetab.nuggetium.nugget_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.NUGGET.get());
                        output.accept(ModItems.NUGGET_COOKED.get());

                        output.accept(ModItems.CATACLYSM.get());

                        output.accept(ModItems.NUGSCALIBUR.get());
                        output.accept(ModItems.STARCAT_PICKAXE.get());
                        output.accept(ModItems.TERRACLAW.get());
                        output.accept(ModItems.PAWERFUL_AXE.get());
                        output.accept(ModItems.CLAWTIVATOR.get());

                        output.accept(ModItems.NFC_BUCKET.get());
                        output.accept(ModItems.DEEP_FRIED_CHESTPLATE.get());
                        output.accept(ModItems.DRUMSTICK_TROUSERS.get());
                        output.accept(ModItems.CRISPY_FLIP_FLOPS.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> NUGGET_BLOCKS_TAB = CREATIVE_MODE_TABS.register("nugget_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK.get()))
                    .withTabsBefore(NUGGET_TAB.getId())
                    .title(Component.translatable("creativetab.nuggetium.nugget_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.NUGGET_BLOCK.get());
                        output.accept(ModBlocks.NUGGET_ORE.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
