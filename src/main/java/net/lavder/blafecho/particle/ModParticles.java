package net.lavder.blafecho.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.lavder.blafecho.BlafEcho;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType PINK_GARNET_PARTICLE =
            registerParticle("pink_garnet_particle", FabricParticleTypes.simple());



    // HELPING METHODS
    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(BlafEcho.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        BlafEcho.LOGGER.info("Registering Particles for " + BlafEcho.MOD_ID);
    }
}
