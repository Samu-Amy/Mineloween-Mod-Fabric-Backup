package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.datagen.recipe.GemstoneGrinderRecipeBuilder;
import net.samu.mineloween.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // -------- Items --------
        offerSmelting(exporter, List.of(ModBlocks.GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2f, 200, "gem");
        offerBlasting(exporter, List.of(ModBlocks.GEM_ORE), RecipeCategory.MISC, ModItems.RAW_GEM, 2f, 100, "gem");

        // TODO: metti questa ricetta nel gemstone grinder e aggiungi polvere di altri minerali
//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_POWDER, 2)
//                .input(ModItems.RAW_GEM)
//                .criterion(hasItem(ModItems.RAW_GEM), conditionsFromItem(ModItems.RAW_GEM))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_POWDER)));

        new GemstoneGrinderRecipeBuilder(ModItems.RAW_GEM, ModItems.GEM_POWDER, 2)
                .criterion(hasItem(ModItems.RAW_GEM), conditionsFromItem(ModItems.RAW_GEM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_CRYSTALS, 6)
                .pattern(" P ")
                .pattern("PSP")
                .pattern(" P ")
                .input('P', ModItems.GEM_POWDER)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.GEM_POWDER), conditionsFromItem(ModItems.GEM_POWDER))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_CRYSTALS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM)
                .pattern("PPP")
                .pattern("PSP")
                .pattern("PPP")
                .input('P', ModItems.GEM_POWDER)
                .input('S', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.GEM_POWDER), conditionsFromItem(ModItems.GEM_POWDER))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM)));


        // -------- Blocks --------
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE, 4)
                .pattern(" C ")
                .pattern("CGC")
                .pattern(" C ")
                .input('G', ModItems.GEM_CRYSTALS)
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(ModItems.GEM_CRYSTALS), conditionsFromItem(ModItems.GEM_CRYSTALS))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_STAIRS, 4)
                .pattern("C  ")
                .pattern("CC ")
                .pattern("CCC")
                .input('C', ModBlocks.GEMMED_COBBLESTONE)
                .criterion(hasItem(ModBlocks.GEMMED_COBBLESTONE), conditionsFromItem(ModBlocks.GEMMED_COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("CCC")
                .input('C', ModBlocks.GEMMED_COBBLESTONE)
                .criterion(hasItem(ModBlocks.GEMMED_COBBLESTONE), conditionsFromItem(ModBlocks.GEMMED_COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEMMED_COBBLESTONE_WALL, 6)
                .pattern(" G ")
                .pattern("CCC")
                .pattern("CCC")
                .input('G', ModItems.GEM_CRYSTALS)
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(ModItems.GEM_CRYSTALS), conditionsFromItem(ModItems.GEM_CRYSTALS))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GEMMED_COBBLESTONE_WALL)));


        // -------- Tools --------
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_SWORD)
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_PICKAXE)
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_AXE)
                .pattern("GG ")
                .pattern("GS ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_SHOVEL)
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_HOE)
                .pattern("GG ")
                .pattern(" S ")
                .pattern(" S ")
                .input('G', ModItems.GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_HOE)));


        // -------- Armor --------
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_HELMET)
                .pattern("GGG")
                .pattern("G G")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_CHESTPLATE)
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_LEGGINGS)
                .pattern("GGG")
                .pattern("G G")
                .pattern("G G")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEM_BOOTS)
                .pattern("G G")
                .pattern("G G")
                .input('G', ModItems.GEM)
                .criterion(hasItem(ModItems.GEM), conditionsFromItem(ModItems.GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEM_BOOTS)));
    }
}
