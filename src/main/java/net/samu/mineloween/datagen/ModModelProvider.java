package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.block.custom.MalvaCropBlock;
import net.samu.mineloween.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEM_ORE);
        BlockStateModelGenerator.BlockTexturePool gemmedCobblestoneTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GEMMED_COBBLESTONE);
        gemmedCobblestoneTexturePool.stairs(ModBlocks.GEMMED_COBBLESTONE_STAIRS);
        gemmedCobblestoneTexturePool.slab(ModBlocks.GEMMED_COBBLESTONE_SLAB);
        gemmedCobblestoneTexturePool.wall(ModBlocks.GEMMED_COBBLESTONE_WALL);
        gemmedCobblestoneTexturePool.fenceGate(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GEMSTONE_GRINDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DECORATIVE_BOOKSHELF);

        blockStateModelGenerator.registerCrop(ModBlocks.MALVA_CROP, MalvaCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LAVANDA, ModBlocks.POTTED_LAVANDA, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    public BlockStateModelGenerator.BlockTexturePool registerDecorativeBookshelfBlock(BlockStateModelGenerator blockStateModelGenerator, Block decorativeBookshelfBlock) {
        TextureMap textureMap = TextureMap.textureParticle(decorativeBookshelfBlock);
        Identifier identifier = CustomModels.DECORATIVE_BOOKSHELF_EMPTY.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = CustomModels.DECORATIVE_BOOKSHELF_VARIANT_1.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = CustomModels.DECORATIVE_BOOKSHELF_VARIANT_2.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier4 = CustomModels.DECORATIVE_BOOKSHELF_VARIANT_3.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier5 = CustomModels.DECORATIVE_BOOKSHELF_VARIANT_4.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier6 = CustomModels.DECORATIVE_BOOKSHELF_VARIANT_5.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier7 = CustomModels.DECORATIVE_BOOKSHELF_VARIANT_6.upload(decorativeBookshelfBlock, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(CustomBlockStateModelGenerator.createCustomDecorativeBookshelfBlockState(decorativeBookshelfBlock, identifier, identifier2, identifier3, identifier4, identifier5, identifier6, identifier7));
        blockStateModelGenerator.registerParentedItemModel(decorativeBookshelfBlock, identifier);
        return null;
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_CRYSTALS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.GEM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GEM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GEM_BOOTS));

        itemModelGenerator.register(ModItems.SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARK_SCYTHE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CHOCOLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.MALVA_FLOWERS, Models.GENERATED);
    }
}

