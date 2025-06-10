package net.lavder.blafecho.recipe;

import net.lavder.blafecho.BlafEcho;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<GrowthChamberRecipe> GROWTH_CHAMBER_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(BlafEcho.MOD_ID, "growth_chamber"),
                    new GrowthChamberRecipe.Serializer());
    public static final RecipeType<GrowthChamberRecipe> GROWTH_CHAMBER_TYPE =
            Registry.register(Registries.RECIPE_TYPE, Identifier.of(BlafEcho.MOD_ID, "growth_chamber"),
                    new RecipeType<GrowthChamberRecipe>() {
                        @Override
                        public String toString() {
                            return "growth_chamber";
                        }});

    public static void registerRecipes() {
        BlafEcho.LOGGER.info("Registering Custom Recipes for " + BlafEcho.MOD_ID);
    }
}
