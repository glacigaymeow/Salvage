package net.glacigaymeow.salvage.datagen;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.glacigaymeow.salvage.block.ModBlocks;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.PLATED_NETHERITE);
        dropSelf(ModBlocks.CUT_PLATED_NETHERITE);
        dropSelf(ModBlocks.CUT_PLATED_NETHERITE_STAIRS);

        add(ModBlocks.CUT_PLATED_NETHERITE_SLAB, this::createSlabItemTable);

    }
}
