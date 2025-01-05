package net.kyryllkotyk.nuggetium.item;

import net.kyryllkotyk.nuggetium.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier NUGGET = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_NUGGET_TOOL, () -> Ingredient.of(ModItems.NUGGET.get()),
            ModTags.Blocks.INCORRECT_FOR_NUGGET_TOOL);
}
