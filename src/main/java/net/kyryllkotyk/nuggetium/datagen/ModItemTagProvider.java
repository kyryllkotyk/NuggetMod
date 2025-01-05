package net.kyryllkotyk.nuggetium.datagen;

import net.kyryllkotyk.nuggetium.Nuggetium;
import net.kyryllkotyk.nuggetium.item.ModItems;
import net.kyryllkotyk.nuggetium.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, Nuggetium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.NUGGET.get())
                .add(ModItems.NUGGET_COOKED.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.NFC_BUCKET.get())
            .add(ModItems.DEEP_FRIED_CHESTPLATE.get())
            .add(ModItems.DRUMSTICK_TROUSERS.get())
            .add(ModItems.CRISPY_FLIP_FLOPS.get());
    }
}
