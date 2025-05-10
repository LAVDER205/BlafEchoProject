package net.lavder.blafecho.entity;

import net.lavder.blafecho.BlafEcho;
import net.lavder.blafecho.entity.custom.MantisEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BlafEcho.MOD_ID, "mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build()); // 1 & 2.5 - collision box


    public static void registerModEntities() {
        BlafEcho.LOGGER.info("Registering Mod Entities for " + BlafEcho.MOD_ID);
    }

}
