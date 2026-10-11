package net.glacigaymeow.salvage.item;

import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.glacigaymeow.salvage.Salvage;
import net.glacigaymeow.salvage.datagen.ModDamageTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.function.Function;

public class ModItems {
    public static final Item METAL_SCRAP = regsiterItem("metal_scrap", properties -> new Item(properties
            .attributes(ItemAttributeModifiers.builder()
                    .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Identifier.fromNamespaceAndPath(Salvage.MOD_ID, "tetanus_damage"), 1.0,
                            AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ANY).build())));
    public static final Item NETHERITE_PLATE = regsiterItem("netherite_plate", properties -> new Item(properties.fireResistant()));
    public static final Item DRILL_MECHANISM = regsiterItem("drill_mechanism", Item::new);
    public static final Item HANDHELD_DRILL = regsiterItem("handheld_drill", properties -> new Item(
            properties.stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .attributes(ItemAttributeModifiers.builder()
                            .add(Attributes.MINING_EFFICIENCY, new AttributeModifier(Identifier.fromNamespaceAndPath(Salvage.MOD_ID,"mining_boost"),30.0,
                                        AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND).build())));

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item regsiterItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Salvage.MOD_ID, name)))));
    }

    public static void registerModItems(){
        Salvage.LOGGER.info("Registering Mod Items for " + Salvage.MOD_ID);

    }


}
