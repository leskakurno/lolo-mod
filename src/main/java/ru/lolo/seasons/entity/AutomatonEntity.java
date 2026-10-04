package ru.lolo.seasons.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import ru.lolo.seasons.item.ModItems;

/** Автоматон Хенфорта: «совершенно обычный житель города». Реагирует на смартфон. */
public class AutomatonEntity extends NpcEntity {
    public AutomatonEntity(EntityType<? extends AutomatonEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected String npcId() {
        return "automaton";
    }

    @Override
    protected int lineCount() {
        return 5;
    }

    @Override
    protected void talk(Player player, ItemStack held) {
        if (held.is(ModItems.SMARTPHONE.get())) {
            say(player, "dialog.lolo_seasons.automaton.phone");
        } else {
            super.talk(player, held);
        }
    }
}
