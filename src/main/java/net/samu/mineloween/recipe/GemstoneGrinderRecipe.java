package net.samu.mineloween.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class GemstoneGrinderRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    public GemstoneGrinderRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }


    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient) {
            return false;
        }

        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public static class Type implements RecipeType<GemstoneGrinderRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "gemstone_grinder";
    }

    public static class Serializer implements RecipeSerializer<GemstoneGrinderRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "gemstone_grinder";
        // this is the name given in the json file

        @Override
        public GemstoneGrinderRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY); // 1 ingrediente solo

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new GemstoneGrinderRecipe(id, output, inputs);
        }

        @Override
        public GemstoneGrinderRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new GemstoneGrinderRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, GemstoneGrinderRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput(null));
        }
    }
}
