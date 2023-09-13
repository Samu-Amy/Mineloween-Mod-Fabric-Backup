package net.samu.mineloween.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.samu.mineloween.MineloweenMod;
import net.samu.mineloween.block.ModBlocks;

// TODO: i clerici vendono cose legate alla magia, fare dei clerici di livello più alto o direttamente dei maghi e/o streghe
public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> HERBORISM_POI_KEY = registerPoiKey("herborismpoi");
    public static final PointOfInterestType HERBORISM_POI = registerPoi("herborismpoi", ModBlocks.MALVA_CROP); //TODO: cambia in mortaio e pestello (o altro legato all'erboristeria)
    public static final VillagerProfession HERBORIST = registerProfession("herborist", HERBORISM_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(MineloweenMod.MOD_ID, name),
                new VillagerProfession(name, entry -> true, entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_MASON));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(MineloweenMod.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(MineloweenMod.MOD_ID, name));
    }


    public static void registerVillagers() {
        MineloweenMod.LOGGER.info("Registering Villagers for " + MineloweenMod.MOD_ID);
    }
}
