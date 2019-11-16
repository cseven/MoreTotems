package com.c777.moretotems.setup;

import com.c777.moretotems.lib.LibMisc;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MoreTotemsCreativeTab extends ItemGroup {
    public static final MoreTotemsCreativeTab INSTANCE = new MoreTotemsCreativeTab();

    public MoreTotemsCreativeTab() {
        super(LibMisc.MOD_ID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.TOTEM_OF_UNDYING);
    }
}
