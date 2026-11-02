package ru.infinityexpansion;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;

public final class InfinityPickaxeItem extends PickaxeItem {
    public InfinityPickaxeItem(Item.Properties properties) {
        super(Tiers.NETHERITE, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 1_000_000.0F;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        // No durability loss from block mining.
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // No durability loss from attacking.
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("§7Мгновенная добыча"));
        tooltip.add(Component.literal("§7Бесконечная прочность"));
        tooltip.add(Component.literal("§7Настройки: клавиша V"));
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
