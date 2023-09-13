package net.samu.mineloween.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.samu.mineloween.item.ModItems;

public class MalvaCropBlock extends CropBlock {
    public static final int  MAX_AGE = 6;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);
    public MalvaCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.MALVA_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
