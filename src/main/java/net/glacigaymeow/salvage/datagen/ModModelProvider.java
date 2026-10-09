package net.glacigaymeow.salvage.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.glacigaymeow.salvage.block.ModBlocks;
import net.glacigaymeow.salvage.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.PLATED_NETHERITE);
       // blockModelGenerators.createTrivialCube(ModBlocks.CUT_PLATED_NETHERITE);

        blockModelGenerators.family(ModBlocks.CUT_PLATED_NETHERITE)
                .stairs(ModBlocks.CUT_PLATED_NETHERITE_STAIRS)
                .slab(ModBlocks.CUT_PLATED_NETHERITE_SLAB);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.METAL_SCRAP, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHERITE_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRILL_MECHANISM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.declareCustomModelItem(ModItems.HANDHELD_DRILL);
    }
}