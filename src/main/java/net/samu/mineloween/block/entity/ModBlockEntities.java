package net.samu.mineloween.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<GemstoneGrinderBlockEntity> GEMSTONE_GRINDER_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MineloweenMod.MOD_ID, "gemstone_grinder_block_entity"),
            FabricBlockEntityTypeBuilder.create(GemstoneGrinderBlockEntity::new, ModBlocks.GEMSTONE_GRINDER).build(null));

    public static void registerBlockEntities() {
        MineloweenMod.LOGGER.info("Registering Block Entities for " + MineloweenMod.MOD_ID);
    }
}
