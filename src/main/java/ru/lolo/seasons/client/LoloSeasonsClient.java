package ru.lolo.seasons.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import ru.lolo.seasons.LoloSeasons;
import ru.lolo.seasons.entity.ModEntities;

// Этот класс не загружается на выделенном сервере.
@Mod(value = LoloSeasons.MODID, dist = Dist.CLIENT)
public class LoloSeasonsClient {
    public LoloSeasonsClient(IEventBus modEventBus, ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modEventBus.addListener(LoloSeasonsClient::registerRenderers);
    }

    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.WANDERER.get(), ctx -> new NpcRenderer(ctx, "wanderer"));
        event.registerEntityRenderer(ModEntities.AUTOMATON.get(), ctx -> new NpcRenderer(ctx, "automaton"));
    }
}
