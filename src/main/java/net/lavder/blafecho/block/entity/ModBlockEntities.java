package net.lavder.blafecho.block.entity;

import net.lavder.blafecho.BlafEcho;
import net.lavder.blafecho.block.ModBlocks;
import net.lavder.blafecho.block.entity.custom.GrowthChamberBlockEntity;
import net.lavder.blafecho.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BlafEcho.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static final BlockEntityType<GrowthChamberBlockEntity> GROWTH_CHAMBER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BlafEcho.MOD_ID, "growth_chamber_be"),
                    BlockEntityType.Builder.create(GrowthChamberBlockEntity::new, ModBlocks.GROWTH_CHAMBER).build(null));

    public static void registerBlockEntities() {
        BlafEcho.LOGGER.info("Registering Block Entities for " + BlafEcho.MOD_ID);
    }
}
