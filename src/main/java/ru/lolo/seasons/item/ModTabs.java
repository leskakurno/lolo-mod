package ru.lolo.seasons.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.lolo.seasons.LoloSeasons;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LoloSeasons.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.lolo_seasons"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.SPARK_SHARD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.SPARK_SHARD.get());
                output.accept(ModItems.TIME_FRAGMENT.get());
                output.accept(ModItems.ARCHEY_INGOT.get());
                output.accept(ModItems.EMBER.get());
                output.accept(ModItems.ARCHEY_ORE_ITEM.get());
                output.accept(ModItems.ARCHEY_BLOCK_ITEM.get());
                output.accept(ModItems.BRAZIER_ITEM.get());
                output.accept(ModItems.ARCHEY_SWORD.get());
                output.accept(ModItems.ARCHEY_PICKAXE.get());
                output.accept(ModItems.SPARK_STAFF.get());
                output.accept(ModItems.TIME_CLOCK.get());
                output.accept(ModItems.SMARTPHONE.get());
                output.accept(ModItems.SCARAB_AMULET.get());
                output.accept(ModItems.RUBBER_DUCK.get());
                output.accept(ModItems.WANDERER_SPAWN_EGG.get());
                output.accept(ModItems.AUTOMATON_SPAWN_EGG.get());
            }).build());
}
