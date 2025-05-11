package net.lavder.blafecho.entity;

import net.lavder.blafecho.BlafEcho;
import net.lavder.blafecho.entity.custom.MantisEntity;
import net.lavder.blafecho.entity.custom.TomahawkProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    // ENTITIES
    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BlafEcho.MOD_ID, "mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build()); // 1 & 2.5 - collision box

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BlafEcho.MOD_ID, "tomahawk"),
            EntityType.Builder.<TomahawkProjectileEntity>create(TomahawkProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build());

    // HELPING METHOD
    public static void registerModEntities() {
        BlafEcho.LOGGER.info("Registering Mod Entities for " + BlafEcho.MOD_ID);
    }

}
