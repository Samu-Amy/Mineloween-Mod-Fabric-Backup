package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.samu.mineloween.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.GEM_ORE,
                ModBlocks.GEMMED_COBBLESTONE,
                ModBlocks.GEMMED_COBBLESTONE_STAIRS,
                ModBlocks.GEMMED_COBBLESTONE_SLAB,
                ModBlocks.GEMMED_COBBLESTONE_WALL,
                ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE,
                ModBlocks.GEMSTONE_GRINDER
        );

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.GEM_ORE);

        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.GEMMED_COBBLESTONE_WALL);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "need_tool_level_5")));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "need_tool_level_6")));
    }
}
