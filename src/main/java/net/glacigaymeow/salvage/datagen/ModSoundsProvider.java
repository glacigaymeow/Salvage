package net.glacigaymeow.salvage.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.fabricmc.fabric.impl.datagen.client.SoundTypeBuilderImpl;
import net.glacigaymeow.salvage.Salvage;
import net.glacigaymeow.salvage.sound.ModSounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.SoundType;

import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {

    public ModSoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);

    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
        exporter.add(ModSounds.SCRAP_BLOCK_PLACE, SoundTypeBuilder.of(ModSounds.SCRAP_BLOCK_PLACE).subtitle("sounds.salvage.scrap_block_place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Salvage.MOD_ID, "scrap_block_place"))));

    }

    @Override
    public String getName() {
        return "Salvage Sounds";
    }
}
