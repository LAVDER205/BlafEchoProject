package net.lavder.blafecho.item.custom;

import net.lavder.blafecho.block.ModBlocks;
import net.lavder.blafecho.component.ModDataComponentTypes;
import net.lavder.blafecho.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    public static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.OAK_LOG, ModBlocks.PINK_GARNET_BLOCK,
                    Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) { // trigger
        World world = context.getWorld(); // context - все зависимости
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) { // делаем не на клиенте
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item ->context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND)); // damaging item

                world.playSound(null, context.getBlockPos(), ModSounds.CHISEL_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos()); // now this itemstack REREMBERS last clicked block coordinates
                // u can do this with vanilla components too!
            }
        }
        return ActionResult.SUCCESS; // adds right click animation
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.blafecho.chisel.tooltip"));
            if (stack.get(ModDataComponentTypes.COORDINATES) != null) {
                tooltip.add(Text.literal("Last block changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
            }
        } else {
            tooltip.add(Text.translatable("tooltip.blafecho.press_shift.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
