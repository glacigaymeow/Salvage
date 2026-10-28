package net.glacigaymeow.salvage.sound;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.glacigaymeow.salvage.Salvage;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.level.block.SoundType;

import java.util.Objects;

public class ModSounds {

    public static final SoundEvent SCRAP_BLOCK_PLACE = registerSoundEvent("scrap_block_place");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));

    }

    public static void registerSounds() {
        Salvage.LOGGER.info("Registering sounds for " + Salvage.MOD_ID);
    }
}
