package net.samu.mineloween.datagen;

import com.google.gson.JsonElement;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.custom.DecorativeBookshelfBlock;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CustomBlockStateModelGenerator extends BlockStateModelGenerator {
    public CustomBlockStateModelGenerator(Consumer<BlockStateSupplier> blockStateCollector, BiConsumer<Identifier, Supplier<JsonElement>> modelCollector, Consumer<Item> simpleItemModelExemptionCollector) {
        super(blockStateCollector, modelCollector, simpleItemModelExemptionCollector);
    }

    public static BlockStateSupplier createCustomDecorativeBookshelfBlockState(Block customDecorativeBookshelfBlock, Identifier... modelId) {
        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(customDecorativeBookshelfBlock);
                for(int i = 0; i < modelId.length; i++) {
                    multipartBlockStateSupplier.with((When) When.create().set(DecorativeBookshelfBlock.VARIANT, i));
                }
        return multipartBlockStateSupplier;
    }
}
