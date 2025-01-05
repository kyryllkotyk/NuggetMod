package net.kyryllkotyk.nuggetium.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties NUGGET_COOKED = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(10)
            .alwaysEdible()
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 2000, 5),1f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 5), 1f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2000, 5), 1f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 5), 1f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 2000, 1), .5f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5000, 0), .8f)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 5000, 25), .5f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10000, 5), .9f)
            .build();

}
