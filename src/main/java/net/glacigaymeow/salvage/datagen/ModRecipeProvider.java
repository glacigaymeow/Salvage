package net.glacigaymeow.salvage.datagen;

import com.ibm.icu.impl.duration.impl.DataRecord;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.glacigaymeow.salvage.block.ModBlocks;
import net.glacigaymeow.salvage.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> IRON_INGOT_SMELTABLES = List.of(ModItems.METAL_SCRAP);
             oreSmelting(IRON_INGOT_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
             oreBlasting(IRON_INGOT_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_INGOT, 0.35f, 100, "iron_ingot");

             shapeless(RecipeCategory.MISC, ModItems.NETHERITE_PLATE, 4)
                     .requires(Items.GOLD_INGOT)
                     .requires(Items.NETHERITE_SCRAP)
                     .requires(ModItems.METAL_SCRAP)
                     .unlockedBy(getHasName(ModItems.METAL_SCRAP), has(ModItems.METAL_SCRAP))
                     .save(output);

             shapeless(RecipeCategory.MISC, ModItems.METAL_SCRAP, 4)
                     .requires((ModItems.DRILL_MECHANISM))
                     .unlockedBy(getHasName(ModItems.DRILL_MECHANISM), has(ModItems.DRILL_MECHANISM))
                     .save(output);

             shaped(RecipeCategory.TOOLS, ModItems.HANDHELD_DRILL)
                     .pattern(" S ")
                     .pattern("PMP")
                     .pattern(" P ")
                     .define('S', ModItems.METAL_SCRAP)
                     .define('P', ModItems.NETHERITE_PLATE)
                     .define('M', ModItems.DRILL_MECHANISM)
                     .unlockedBy(getHasName(ModItems.DRILL_MECHANISM), has(ModItems.DRILL_MECHANISM))
                     .save(output);


             shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATED_NETHERITE, 8)
                     .pattern("XX")
                     .pattern("XX")
                     .define('X', ModBlocks.PLATED_NETHERITE)
                     .unlockedBy(getHasName(ModBlocks.PLATED_NETHERITE), has(ModBlocks.PLATED_NETHERITE))
                     .save(output);

             stairBuilder(ModBlocks.CUT_PLATED_NETHERITE_STAIRS, Ingredient.of(ModBlocks.CUT_PLATED_NETHERITE))
                     .unlockedBy(getHasName(ModBlocks.CUT_PLATED_NETHERITE),has(ModBlocks.PLATED_NETHERITE))
                     .save(output);

             slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATED_NETHERITE_SLAB, Ingredient.of(ModBlocks.CUT_PLATED_NETHERITE))
                     .unlockedBy(getHasName(ModBlocks.CUT_PLATED_NETHERITE),has(ModBlocks.PLATED_NETHERITE))
                     .save(output);

            };
        };
    }

    @Override
    public String getName() {
        return "Salvage Recipes";
    }
}
