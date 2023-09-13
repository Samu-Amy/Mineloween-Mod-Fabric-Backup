package net.samu.mineloween.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GemstoneGrinderScreenHandler> GEMSTONE_GRINDER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(MineloweenMod.MOD_ID, "gemstone_grinder_screen_handler"),
            new ExtendedScreenHandlerType<>(GemstoneGrinderScreenHandler::new));

    public static void registerScreenHandler() {
        MineloweenMod.LOGGER.info("Registering Screen Handlers for " + MineloweenMod.MOD_ID);
    }
}
