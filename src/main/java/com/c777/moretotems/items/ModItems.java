package com.c777.moretotems.items;

import com.c777.moretotems.lib.LibItems;
import com.c777.moretotems.lib.LibMisc;
import com.c777.moretotems.setup.MoreTotemsCreativeTab;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(LibMisc.MOD_ID)
public class ModItems {

    // Registry helper functions
    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> entry, ResourceLocation location) {
        reg.register(entry.setRegistryName(location));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, IForgeRegistryEntry<V> entry, String name) {
        register(reg, entry, new ResourceLocation(LibMisc.MOD_ID, name));
    }
    // End registry helpers

    @ObjectHolder(LibItems.IRON_GOLEM_TOTEM) public static Item ironGolemTotem;
    @ObjectHolder(LibItems.WITHER_TOTEM) public static Item witherTotem;
    @ObjectHolder(LibItems.BAT_TOTEM) public static Item batTotem;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        Item.Properties defaultProperties = new Item.Properties().group(MoreTotemsCreativeTab.INSTANCE);
        Item.Properties unstackable = new Item.Properties().group(MoreTotemsCreativeTab.INSTANCE).maxStackSize(1);

        register(r, new IronGolemTotemItem(unstackable), LibItems.IRON_GOLEM_TOTEM);
        register(r, new WitherTotemItem(unstackable), LibItems.WITHER_TOTEM);
        register(r, new BatTotemItem(unstackable), LibItems.BAT_TOTEM);
    }

}
