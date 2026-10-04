package ru.lolo.seasons.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.lolo.seasons.LoloSeasons;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, LoloSeasons.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<WandererEntity>> WANDERER = ENTITIES.register("wanderer",
            () -> EntityType.Builder.of(WandererEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F).clientTrackingRange(10).build("wanderer"));

    public static final DeferredHolder<EntityType<?>, EntityType<AutomatonEntity>> AUTOMATON = ENTITIES.register("automaton",
            () -> EntityType.Builder.of(AutomatonEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F).clientTrackingRange(10).build("automaton"));

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(WANDERER.get(), NpcEntity.createNpcAttributes().build());
        event.put(AUTOMATON.get(), NpcEntity.createNpcAttributes().build());
    }
}
