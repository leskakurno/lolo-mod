package ru.lolo.seasons.entity;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import ru.lolo.seasons.LoloSeasons;

/**
 * Базовый мирный NPC. Минимум целей ИИ (5 штук), ничего не тикает сверх ванильного,
 * не деспавнится вдали от игрока, чтобы не создавать лишней нагрузки на спавн.
 */
public abstract class NpcEntity extends PathfinderMob {
    private long lastTalkTick = -100L;

    protected NpcEntity(EntityType<? extends NpcEntity> type, Level level) {
        super(type, level);
    }

    /** Короткий id для ключей диалогов. */
    protected abstract String npcId();

    /** Сколько обычных реплик лежит в lang-файле (dialog.lolo_seasons.<id>.0 ... N-1). */
    protected abstract int lineCount();

    public static AttributeSupplier.Builder createNpcAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResult.PASS;
        }
        if (!this.level().isClientSide) {
            this.getNavigation().stop();
            this.getLookControl().setLookAt(player, 30.0F, 30.0F);
            long now = this.level().getGameTime();
            if (now - this.lastTalkTick >= 10L) {
                this.lastTalkTick = now;
                this.talk(player, player.getItemInHand(hand));
            }
        }
        return InteractionResult.sidedSuccess(this.level().isClientSide);
    }

    protected void talk(Player player, ItemStack held) {
        say(player, "dialog." + LoloSeasons.MODID + "." + npcId() + "." + this.random.nextInt(lineCount()));
    }

    protected void say(Player player, String translationKey) {
        MutableComponent msg = this.getName().copy().withStyle(ChatFormatting.AQUA)
                .append(Component.literal(": ").withStyle(ChatFormatting.GRAY))
                .append(Component.translatable(translationKey));
        player.sendSystemMessage(msg);
    }
}
