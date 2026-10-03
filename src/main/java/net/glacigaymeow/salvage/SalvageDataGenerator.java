package net.glacigaymeow.salvage;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.glacigaymeow.salvage.datagen.ModBlockLootTableProvider;
import net.glacigaymeow.salvage.datagen.ModBlockTagsProvider;
import net.glacigaymeow.salvage.datagen.ModModelProvider;
import net.glacigaymeow.salvage.datagen.ModRecipeProvider;

public class SalvageDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);


	}
}
