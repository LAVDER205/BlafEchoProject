package net.lavder.blafecho.enchantment;

import com.mojang.serialization.MapCodec;
import net.lavder.blafecho.BlafEcho;
import net.lavder.blafecho.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTING_STRIKER =
            registerEntityEffect("lighting_striker", LightningStrikerEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(BlafEcho.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffect() {
        BlafEcho.LOGGER.info("Registering Enchantment Effects for " + BlafEcho.MOD_ID);
    }
}
