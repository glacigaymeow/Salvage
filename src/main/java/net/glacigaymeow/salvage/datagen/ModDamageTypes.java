package net.glacigaymeow.salvage.datagen;

import net.glacigaymeow.salvage.Salvage;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> TETANUS = ResourceKey.create(Registries.DAMAGE_TYPE,
            Identifier.fromNamespaceAndPath(Salvage.MOD_ID, "tetanus"));

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(TETANUS, new DamageType("tetanus", 0.1f, DamageEffects.HURT));
    }

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(key));
    }
}
