package net.kyryllkotyk.nuggetium.sound;
import net.kyryllkotyk.nuggetium.Nuggetium;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Nuggetium.MOD_ID);

    public static final RegistryObject<SoundEvent> ARROW_SHOOT = registerSoundEvent("arrow_shoot");
    public static final RegistryObject<SoundEvent> NUGGET_BLOCK_BREAK = registerSoundEvent("nugget_block_break");
    public static final RegistryObject<SoundEvent> NUGGET_BLOCK_STEP = registerSoundEvent("nugget_block_step");
    public static final RegistryObject<SoundEvent> NUGGET_BLOCK_PLACE = registerSoundEvent("nugget_block_place");
    public static final RegistryObject<SoundEvent> NUGGET_BLOCK_HIT = registerSoundEvent("nugget_block_hit");
    public static final RegistryObject<SoundEvent> NUGGET_BLOCK_FALL = registerSoundEvent("nugget_block_fall");

    public static final ForgeSoundType NUGGET_BLOCK_SOUNDS = new ForgeSoundType(2f,1f, NUGGET_BLOCK_BREAK, NUGGET_BLOCK_STEP, NUGGET_BLOCK_PLACE,
            NUGGET_BLOCK_HIT, NUGGET_BLOCK_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Nuggetium.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
