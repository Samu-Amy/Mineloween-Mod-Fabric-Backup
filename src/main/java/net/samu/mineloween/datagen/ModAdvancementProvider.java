package net.samu.mineloween.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    // TODO: sposta la gemma dopo le bacchette di base (come gerarchia) e fai advancements con più criteri (es. aver scoperto tutte le lavorazioni delle gemme, come raw, powder, ecc.)
    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {

        // -------- Magic --------
        Advancement magicRootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.GEM), Text.literal("The way of the magic"),
                        Text.literal("A great upgrade to your magic powers"), new Identifier(MineloweenMod.MOD_ID, "textures/block/gemmed_cobblestone.png"),
                        AdvancementFrame.TASK, true, true, false))
                .criterion("has_gem", InventoryChangedCriterion.Conditions.items(ModItems.GEM))
                .build(consumer, MineloweenMod.MOD_ID + ":magic_gem");

        Advancement scythe = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.SCYTHE), Text.literal("The discovery of dark weapons"),
                        Text.literal("This weapon is dangerous, but not quite like some others..."), new Identifier(MineloweenMod.MOD_ID, "textures/block/gemmed_cobblestone.png"),
                        AdvancementFrame.TASK, true, true, false))
                .criterion("has_scythe", InventoryChangedCriterion.Conditions.items(ModItems.SCYTHE))
                .parent(magicRootAdvancement)
                .build(consumer, MineloweenMod.MOD_ID + ":scythe");

        Advancement dark_scythe = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.DARK_SCYTHE), Text.literal("The queen of the dark weapons"),
                        Text.literal("One of the most powerful weapon."), new Identifier(MineloweenMod.MOD_ID, "textures/block/gemmed_cobblestone.png"),
                        AdvancementFrame.TASK, true, true, false))
                .criterion("has_dark_scythe", InventoryChangedCriterion.Conditions.items(ModItems.DARK_SCYTHE))
                .parent(scythe)
                .build(consumer, MineloweenMod.MOD_ID + ":dark_scythe");


        // -------- Herbalism --------
        Advancement herbalismRootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.MALVA_FLOWERS), Text.literal("First steps in herbalism"),
                        Text.literal("Discover the benefits of plants"), new Identifier(MineloweenMod.MOD_ID, "textures/item/malva_flowers.png"),
                        AdvancementFrame.TASK, true, true, true))
                .criterion("has_malva_flowers", InventoryChangedCriterion.Conditions.items(ModItems.MALVA_FLOWERS))
                .build(consumer, MineloweenMod.MOD_ID + ":plants");
    }
}
