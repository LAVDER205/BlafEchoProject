package net.lavder.blafecho;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lavder.blafecho.block.ModBlocks;
import net.lavder.blafecho.component.ModDataComponentTypes;
import net.lavder.blafecho.effect.ModEffects;
import net.lavder.blafecho.enchantment.ModEnchantmentEffects;
import net.lavder.blafecho.item.ModItemGroups;
import net.lavder.blafecho.item.ModItems;
import net.lavder.blafecho.potion.ModPotions;
import net.lavder.blafecho.sound.ModSounds;
import net.lavder.blafecho.util.HammerUsageEvent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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

		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModEnchantmentEffects.registerEnchantmentEffect();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600); // u can do this like a previous 2 ^^

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof SheepEntity SheepEntity && !world.isClient) {
				if(player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("The Player just hit a ship with an end rod"));
					player.getMainHandStack().decrement(1);
					SheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 6));
				}
				return ActionResult.PASS;
			}
			return ActionResult.PASS;
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
	}
}