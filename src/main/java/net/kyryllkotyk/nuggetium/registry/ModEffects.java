package net.kyryllkotyk.nuggetium.registry;

import net.kyryllkotyk.nuggetium.Nuggetium; // Your main mod class
import net.kyryllkotyk.nuggetium.effect.RapidFireEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Nuggetium.MOD_ID);

    public static final RegistryObject<MobEffect> RAPID_FIRE =
            MOB_EFFECTS.register("rapid_fire", RapidFireEffect::new);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}