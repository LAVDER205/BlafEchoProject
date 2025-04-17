package net.lavder.blafecho;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.lavder.blafecho.block.ModBlocks;
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


        ModModelPredicates.registerModelPredicates();
    }
}
