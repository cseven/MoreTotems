package com.c777.moretotems.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BatTotemItem extends TotemItem {

    private static final int durability = 2048;

    public BatTotemItem(Properties properties) {
        super(properties, durability);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        PlayerEntity player = (PlayerEntity)entityIn;

        if(isActive(stack, entityIn)) {
            player.abilities.allowFlying = true;
            if(player.abilities.isFlying) {
                damageTotem(stack, player);
            }
        }
        else {
            if(!player.isCreative() && !player.isSpectator()) {
                player.abilities.allowFlying = false;
                player.abilities.isFlying = false;
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @SubscribeEvent
    public static void onTotemDestroy(PlayerDestroyItemEvent event) {
        if(event.getOriginal().getItem() == ModItems.batTotem) {
            PlayerEntity player = event.getPlayer();
            if(!player.isCreative() && !player.isSpectator()) {
                player.abilities.allowFlying = false;
                player.abilities.isFlying = false;
            }
        }
    }
}
