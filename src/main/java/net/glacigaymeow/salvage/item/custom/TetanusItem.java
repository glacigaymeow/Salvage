package net.glacigaymeow.salvage.item.custom;

import net.glacigaymeow.salvage.datagen.ModDamageTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.core.jmx.Server;

public class TetanusItem extends Item {
    public TetanusItem(Properties properties) {
        super(properties);
    }

    @Override

    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        mob.hurtServer(((ServerLevel) mob.level()), ModDamageTypes.create(mob.level(), ModDamageTypes.TETANUS), (float) attacker.getAttributeValue(Attributes.ATTACK_DAMAGE) * 10 );
    }
}





