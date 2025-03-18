package net.lavder.blafecho;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lavder.blafecho.block.ModBlocks;
import net.lavder.blafecho.item.ModItemGroups;
import net.lavder.blafecho.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlafEcho implements ModInitializer {
	public static final String MOD_ID = "blafecho";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() { // initialization of mod
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlock();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600); // u can do this like a previous 2 ^^
	}
}