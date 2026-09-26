package net.glacigaymeow.salvage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.glacigaymeow.salvage.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

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
                List<ItemLike> IRON_INGOT_SMELTABLES = List.of(ModItems.IRON_SCRAP);
                oreSmelting(IRON_INGOT_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
                oreBlasting(IRON_INGOT_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_INGOT, 0.35f, 100, "iron_ingot");
            }
        };
    }

    @Override
    public String getName() {
        return "Salvage Recipes";
    }
}
