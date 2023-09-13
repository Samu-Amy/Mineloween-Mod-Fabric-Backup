package net.samu.mineloween.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MineloweenMod.MOD_ID, GemstoneGrinderRecipe.Serializer.ID),
                GemstoneGrinderRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MineloweenMod.MOD_ID, GemstoneGrinderRecipe.Type.ID),
                GemstoneGrinderRecipe.Type.INSTANCE);
    }
}
