package net.glacigaymeow.salvage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.glacigaymeow.salvage.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {


    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.PLATED_NETHERITE))
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE))
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE_SLAB));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.PLATED_NETHERITE))
                .add(ModBlocks.getRK(ModBlocks.PLATED_NETHERITE));

        tag(BlockTags.STAIRS)
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE_STAIRS));
        tag(BlockTags.SLABS)
                .add(ModBlocks.getRK(ModBlocks.CUT_PLATED_NETHERITE_SLAB));



    }
}
