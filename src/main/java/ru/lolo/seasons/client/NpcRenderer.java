package ru.lolo.seasons.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import ru.lolo.seasons.LoloSeasons;
import ru.lolo.seasons.entity.NpcEntity;

/** Один лёгкий рендерер для всех NPC: стандартная гуманоидная модель + своя 64x64 текстура. */
public class NpcRenderer extends HumanoidMobRenderer<NpcEntity, HumanoidModel<NpcEntity>> {
    private final ResourceLocation texture;

    public NpcRenderer(EntityRendererProvider.Context context, String textureName) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5F);
        this.texture = LoloSeasons.id("textures/entity/" + textureName + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(NpcEntity entity) {
        return texture;
    }
}
