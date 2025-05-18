package net.lavder.blafecho.block.custom;

import net.lavder.blafecho.item.ModItems;
import net.lavder.blafecho.particle.ModParticles;
import net.lavder.blafecho.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) { // right click

        world.addParticle(ModParticles.PINK_GARNET_PARTICLE, pos.getX() + 0.5f, pos.getY() + 1.0f,pos.getZ() + 0.5f, 0, 1, 0); // client side

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f,1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) { //entity stepped on block
        if (entity instanceof ItemEntity itemEntity) {
            if (IsValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean IsValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.blafecho.magic_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}