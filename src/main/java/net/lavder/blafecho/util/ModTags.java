package net.lavder.blafecho.util;

import net.lavder.blafecho.BlafEcho;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        // Item tags



        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BlafEcho.MOD_ID, name));
        }
    }
    public static class Items {
        // Block tags
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BlafEcho.MOD_ID, name));
        }
    }
}
