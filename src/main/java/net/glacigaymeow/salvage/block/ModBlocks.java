package net.glacigaymeow.salvage.block;

import com.mojang.blaze3d.opengl.Uniform;
import net.glacigaymeow.salvage.Salvage;
import net.glacigaymeow.salvage.datagen.ModBlockLootTableProvider;
import net.jpountz.lz4.LZ4FrameOutputStream;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static final Block SCRAP_BLOCK = registerBlock("scrap_block",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK).explosionResistance(6)));

    public static final Block PLATED_NETHERITE = registerBlock("plated_netherite",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK).explosionResistance(50)));

    public static final Block CUT_PLATED_NETHERITE = registerBlock("cut_plated_netherite",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK).explosionResistance(50)));

    public static final Block CUT_PLATED_NETHERITE_STAIRS = registerBlock("cut_plated_netherite_stairs",
    properties -> new StairBlock(ModBlocks.CUT_PLATED_NETHERITE.defaultBlockState(),
    properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final Block CUT_PLATED_NETHERITE_SLAB = registerBlock("cut_plated_netherite_slab",
            properties -> new SlabBlock(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name)))));

    }

    public static void registerModBlocks() {
        Salvage.LOGGER.info("Registering Mod Blocks for " + Salvage.MOD_ID);
    }

}
