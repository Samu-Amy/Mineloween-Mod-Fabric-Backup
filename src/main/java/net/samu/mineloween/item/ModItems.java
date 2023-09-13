package net.samu.mineloween.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.custom.ModScytheItem;

public class ModItems {

    public static final Item ICON = registerItem("icon", new Item(new FabricItemSettings()));


    // -------- Minerali e derivati --------
    public static final Item RAW_GEM = registerItem("raw_gem", new Item(new FabricItemSettings()));
    public static final Item GEM_POWDER = registerItem("gem_powder", new Item(new FabricItemSettings()));
    public static final Item GEM = registerItem("gem", new Item(new FabricItemSettings()));
    public static final Item GEM_CRYSTALS = registerItem("gem_crystals", new Item(new FabricItemSettings()));
    public static final Item DARK_INGOT = registerItem("dark_ingot", new Item(new FabricItemSettings()));


    // -------- Tools --------
    public static final Item GEM_SWORD = registerItem("gem_sword", new SwordItem(ModToolMaterial.GEM, 7, -2.4f, new FabricItemSettings()));
    public static final Item GEM_PICKAXE = registerItem("gem_pickaxe", new PickaxeItem(ModToolMaterial.GEM, -1, -2.8f, new FabricItemSettings()));
    public static final Item GEM_AXE = registerItem("gem_axe", new AxeItem(ModToolMaterial.GEM, 9, -3f, new FabricItemSettings()));
    public static final Item GEM_SHOVEL = registerItem("gem_shovel", new ShovelItem(ModToolMaterial.GEM, 0, -3f, new FabricItemSettings()));
    public static final Item GEM_HOE = registerItem("gem_hoe", new HoeItem(ModToolMaterial.GEM, -6, 0f, new FabricItemSettings()));


    // -------- Armor --------
    public static final Item GEM_HELMET = registerItem("gem_helmet", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GEM_CHESTPLATE = registerItem("gem_chestplate", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GEM_LEGGINGS = registerItem("gem_leggings", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GEM_BOOTS = registerItem("gem_boots", new ArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    // -------- Weapons --------
    public static final Item SCYTHE = registerItem("scythe", new ModScytheItem(ModToolMaterial.DARK, 11, -3f, new FabricItemSettings(), false));
    public static final Item DARK_SCYTHE = registerItem("dark_scythe", new ModScytheItem(ModToolMaterial.DARK, 15, -2.8f, new FabricItemSettings(), true));


    // -------- Food --------
    public static final Item CHOCOLATE = registerItem("chocolate", new Item(new FabricItemSettings().food(ModFoodComponents.CHOCOLATE)));


    // -------- Nature --------
    public static final Item LEAF = registerItem("leaf", new Item(new FabricItemSettings()));
    public static final Item MALVA_SEEDS = registerItem("malva_seeds", new AliasedBlockItem(ModBlocks.MALVA_CROP, new FabricItemSettings()));
    public static final Item MALVA_FLOWERS = registerItem("malva_flowers", new Item(new FabricItemSettings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MineloweenMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    }

    public static void registerModItems() {
        MineloweenMod.LOGGER.info("Registering Mod Items for " + MineloweenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
