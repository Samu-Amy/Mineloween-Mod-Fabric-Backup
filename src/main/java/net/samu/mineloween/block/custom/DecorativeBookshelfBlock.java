package net.samu.mineloween.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DecorativeBookshelfBlock extends Block {
    public static final int MAX_VARIANTS = 6;
    public static final IntProperty VARIANT = IntProperty.of("variant", 0, MAX_VARIANTS);

    public DecorativeBookshelfBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(VARIANT, 0));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            world.setBlockState(pos, state.cycle(VARIANT));
            System.out.println(state.get(VARIANT));
        }

        return ActionResult.SUCCESS;
    }



    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }
}
