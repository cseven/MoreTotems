package com.c777.moretotems.items;

import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class IronGolemTotemItem extends TotemItem {

    private static final int durability = 256;
    private static final int ATTACK_DAMAGE_INCREASE = 4;

    public IronGolemTotemItem(Properties properties) {
        super(properties, durability);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<String, AttributeModifier> attributes = super.getAttributeModifiers(slot);
        if(slot == EquipmentSlotType.OFFHAND) {
            attributes.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                    new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Offhand Damage", ATTACK_DAMAGE_INCREASE,
                    AttributeModifier.Operation.ADDITION));
        }

        return attributes;
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        PlayerEntity player = event.getPlayer();
        if(player.getHeldItemOffhand().getItem() instanceof IronGolemTotemItem) {
            damageTotem(player.getHeldItemOffhand(), player);
        }
    }

}
