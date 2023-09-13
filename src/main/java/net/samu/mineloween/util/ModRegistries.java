package net.samu.mineloween.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;
import net.samu.mineloween.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuff() {
        registerFuels();
        registerModCompostables();
        registerCustomTrades();
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LEAF, 50);
    }

    private static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MALVA_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MALVA_FLOWERS, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LAVANDA, 0.65f);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.LAVANDA, 3), 26, 4, 0.02f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.MALVA_FLOWERS, 2), 26, 3, 0.02f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.HERBORIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.MALVA_SEEDS, 3), 18, 6, 0.04f));
        });
    }
}
