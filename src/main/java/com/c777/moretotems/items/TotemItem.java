package com.c777.moretotems.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public abstract class TotemItem extends Item {

    public TotemItem(Properties properties, int durability) {
        super(properties.maxDamage(durability));
    }

    protected static boolean isActive(ItemStack stackIn, Entity entityIn) {
        return (entityIn instanceof PlayerEntity && ((PlayerEntity) entityIn).getHeldItemOffhand() == stackIn);
    }

    protected static void damageTotem(ItemStack stackIn, PlayerEntity entityIn) {
        stackIn.damageItem(1, entityIn, e -> e.sendBreakAnimation(Hand.OFF_HAND));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack;
    }
}
