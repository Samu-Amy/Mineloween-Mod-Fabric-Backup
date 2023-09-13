package net.samu.mineloween.datagen;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;

import java.util.Optional;

public class CustomModels {
    public static final Model DECORATIVE_BOOKSHELF_EMPTY = CustomModels.block("decorative_bookshelf", "_empty", TextureKey.TEXTURE);
    public static final Model DECORATIVE_BOOKSHELF_VARIANT_1 = CustomModels.block("decorative_bookshelf", "_variant_1", TextureKey.TEXTURE);
    public static final Model DECORATIVE_BOOKSHELF_VARIANT_2 = CustomModels.block("decorative_bookshelf", "_variant_2", TextureKey.TEXTURE);
    public static final Model DECORATIVE_BOOKSHELF_VARIANT_3 = CustomModels.block("decorative_bookshelf", "_variant_3", TextureKey.TEXTURE);
    public static final Model DECORATIVE_BOOKSHELF_VARIANT_4 = CustomModels.block("decorative_bookshelf", "_variant_4", TextureKey.TEXTURE);
    public static final Model DECORATIVE_BOOKSHELF_VARIANT_5 = CustomModels.block("decorative_bookshelf", "_variant_5", TextureKey.TEXTURE);
    public static final Model DECORATIVE_BOOKSHELF_VARIANT_6 = CustomModels.block("decorative_bookshelf", "_variant_6", TextureKey.TEXTURE);

    private static Model make(TextureKey ... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(MineloweenMod.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parent, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(MineloweenMod.MOD_ID, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(MineloweenMod.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
}
