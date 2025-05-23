package net.lavder.blafecho.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lavder.blafecho.block.ModBlocks;
import net.lavder.blafecho.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.PINK_GARNET_NETHER_ORE)
                .add(ModBlocks.PINK_GARNET_END_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.PINK_GARNET_NETHER_ORE)
                .add(ModBlocks.PINK_GARNET_END_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PINK_GARNET_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE); // connecting to other fences
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL); // we can mine everything iron mineable with pink garnet

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN) // for leaves not decay
                .add(ModBlocks.DRIFTWOOD_LOG)
                .add(ModBlocks.DRIFTWOOD_WOOD)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);


    }
}
