package net.lavder.blafecho;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lavder.blafecho.block.ModBlocks;
import net.lavder.blafecho.entity.ModEntities;
import net.lavder.blafecho.entity.client.MantisModel;
import net.lavder.blafecho.entity.client.MantisRenderer;
import net.lavder.blafecho.entity.client.TomahawkProjectileModel;
import net.lavder.blafecho.entity.client.TomahawkProjectileRenderer;
import net.lavder.blafecho.util.ModModelPredicates;
import net.minecraft.client.render.RenderLayer;

public class BlafEchoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Transparent parts of textures
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEY_BERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

        // Entities
        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
    }
}
