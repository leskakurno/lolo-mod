package ru.lolo.seasons;

import net.neoforged.neoforge.common.ModConfigSpec;

/** Настройки мода (файл config/lolo_seasons-common.toml). */
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue BLINK_DISTANCE = BUILDER
            .comment("Дальность прыжка Посоха Мироходца (в блоках)")
            .defineInRange("blinkDistance", 16, 4, 64);

    public static final ModConfigSpec.IntValue BLINK_COOLDOWN_TICKS = BUILDER
            .comment("Перезарядка Посоха Мироходца (в тиках, 20 тиков = 1 секунда)")
            .defineInRange("blinkCooldownTicks", 60, 0, 6000);

    public static final ModConfigSpec.IntValue CLOCK_COOLDOWN_TICKS = BUILDER
            .comment("Перезарядка Часов Конца Времени (в тиках)")
            .defineInRange("clockCooldownTicks", 1200, 0, 72000);

    public static final ModConfigSpec SPEC = BUILDER.build();
}
