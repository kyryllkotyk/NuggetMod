package net.kyryllkotyk.nuggetium.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.particles.ParticleTypes;

public class RapidFireEffect extends MobEffect {
    public RapidFireEffect() {
        super(MobEffectCategory.HARMFUL, 0xFFA500); // Orange color
    }

    @Override
    public boolean isInstantenous() {
        return false; // Make it a lingering effect rather than instant
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true; // This makes the effect tick every time
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        entity.invulnerableTime = 0;
        entity.setRemainingFireTicks(20);
        entity.hurt(entity.damageSources().magic(), 1.0F);

        entity.level().addParticle(ParticleTypes.FLAME,
                entity.getX(), entity.getY() + 0.5D, entity.getZ(),
                0, 0.1D, 0);

        return true;
    }
}