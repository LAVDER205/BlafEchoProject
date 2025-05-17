package net.lavder.blafecho.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.lavder.blafecho.BlafEcho;
import net.lavder.blafecho.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> ALCHEMIST_POI_KEY = registerPoiKey("alchemist_poi");
    public static final PointOfInterestType ALCHEMIST_POI = registerPOI("alchemist_poi", ModBlocks.MAGIC_BLOCK);

    public static final VillagerProfession ALCHEMIST = registerProfession("alchemist", ALCHEMIST_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(BlafEcho.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(BlafEcho.MOD_ID, name),
                1, 1, block); //ticketCount - how many villagers can get profession from 1 block
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) { // block with profession
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(BlafEcho.MOD_ID, name));
    }

    public static void registerVillagers() {
        BlafEcho.LOGGER.info("Registering Villagers for " + BlafEcho.MOD_ID);
    }

}
