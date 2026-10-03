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

import java.util.function.Function;

public class ModItems {
    public static final Item IRON_SCRAP = regsiterItem("iron_scrap", Item::new);

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
                output.accept(IRON_SCRAP));
    }


}
