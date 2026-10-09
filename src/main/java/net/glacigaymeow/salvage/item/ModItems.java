package net.glacigaymeow.salvage.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.glacigaymeow.salvage.Salvage;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItems {
    public static final Item METAL_SCRAP = regsiterItem("metal_scrap", Item::new);
    public static final Item NETHERITE_PLATE = regsiterItem("netherite_plate", Item::new);
    public static final Item DRILL_MECHANISM = regsiterItem("drill_mechanism", Item::new);
    public static final Item HANDHELD_DRILL = regsiterItem("handheld_drill", Item::new);

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item regsiterItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name)))));
    }

    public static void registerModItems(){
        Salvage.LOGGER.info("Registering Mod Items for " + Salvage.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output ->
                output.accept(METAL_SCRAP));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output ->
                output.accept(NETHERITE_PLATE));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output ->
                output.accept(DRILL_MECHANISM));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output ->
                output.accept(HANDHELD_DRILL));


    }


}
