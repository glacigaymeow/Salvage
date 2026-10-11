package net.glacigaymeow.salvage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.impl.resource.pack.FabricPack;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class ModRegistryDataProvider extends FabricDynamicRegistryProvider {


    public ModRegistryDataProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure (HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.DAMAGE_TYPE));
    }

    @Override
    public String getName() {
        return "Salavage Data Provider";
    }
}
