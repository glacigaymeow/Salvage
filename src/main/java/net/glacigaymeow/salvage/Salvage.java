package net.glacigaymeow.salvage;

import net.fabricmc.api.ModInitializer;

import net.glacigaymeow.salvage.item.ModItems;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Salvage implements ModInitializer {
	public static final String MOD_ID = "salvage";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}


	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
