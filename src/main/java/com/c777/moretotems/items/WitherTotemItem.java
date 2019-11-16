package com.c777.moretotems.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WitherTotemItem extends TotemItem {

    private static final int durability = 16;

    public WitherTotemItem(Properties properties) {
        super(properties, durability);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!isActive(stack, entityIn))
            return;

        PlayerEntity player = (PlayerEntity)entityIn;
        if(player.isPotionActive(Effects.WITHER)) {
            player.removePotionEffect(Effects.WITHER);
            damageTotem(stack, player);
        }
    }
}
