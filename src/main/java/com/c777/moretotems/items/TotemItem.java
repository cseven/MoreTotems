package com.c777.moretotems.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public abstract class TotemItem extends Item {

    public TotemItem(Properties properties, int durability) {
        super(properties.maxDamage(durability));
    }

    protected void activate(ItemStack stack, LivingEntity entity, Hand hand){
        stack.damageItem(1, entity, e -> e.sendBreakAnimation(hand));
    }

}
