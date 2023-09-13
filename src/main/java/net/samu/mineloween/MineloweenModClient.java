package net.samu.mineloween;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.screen.GemstoneGrinderScreen;
import net.samu.mineloween.screen.ModScreenHandlers;

public class MineloweenModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MALVA_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVANDA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LAVANDA, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.GEMSTONE_GRINDER_SCREEN_HANDLER, GemstoneGrinderScreen::new);
    }
}
