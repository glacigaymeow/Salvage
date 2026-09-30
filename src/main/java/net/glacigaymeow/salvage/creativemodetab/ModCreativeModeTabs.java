package net.glacigaymeow.salvage.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.glacigaymeow.salvage.Salvage;
import net.glacigaymeow.salvage.block.ModBlocks;
import net.glacigaymeow.salvage.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class                           ModCreativeModeTabs {
    public static final CreativeModeTab SALVAGE_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Salvage.MOD_ID, "salvage_items"),
    FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_SCRAP))
            .title(Component.translatable("creativemodetab.salvage.salvage_items"))
            .displayItems((parameters, output) -> {
                 output.accept(ModItems.IRON_SCRAP);
                 output.accept(ModBlocks.PLATED_NETHERITE);
                 output.accept(ModBlocks.CUT_PLATED_NETHERITE);


            }).build());

    public static void registerModCreativeModeTabs() {
        Salvage.LOGGER.info("Registering Creative Mode Tabs for " + Salvage.MOD_ID);


    }

}
