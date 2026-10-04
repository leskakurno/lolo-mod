package ru.lolo.seasons.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/** Базовый предмет мода: добавляет строку лора из lang-файла (ключ "<id предмета>.desc"). */
public class LoloItem extends Item {
    public LoloItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable(this.getDescriptionId() + ".desc")
                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
    }
}
