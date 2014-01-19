package com.warlordjones.steampunkery.gen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.gen.biome.BiomeGenDeeps;
import com.warlordjones.steampunkery.gen.biome.BiomeGenDenseJungle;
import com.warlordjones.steampunkery.gen.biome.BiomeGenDenseJungleMountains;
import com.warlordjones.steampunkery.gen.biome.BiomeGenEther;
import com.warlordjones.steampunkery.gen.biome.BiomeGenScalded;
import com.warlordjones.steampunkery.gen.dimension.WorldProviderDeeps;
import com.warlordjones.steampunkery.gen.dimension.WorldProviderEther;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class GenerationHandler {
    public static BiomeGenBase dense_jungle;
    public static BiomeGenBase dense_jungle_M;
    public static BiomeGenBase ether_biome;
    public static BiomeGenBase deeps;
    public static BiomeGenBase martian_biome;
    public static BiomeGenBase scalded_biome;

    public static void registerGenerators() {
	if (ConfigSetup.world_gen_B) {
	    GameRegistry.registerWorldGenerator(new SteamWorldGenerator());
	    GameRegistry.registerWorldGenerator(new WorldGenObsidianBottom());
	}
	if (Loader.isModLoaded("DragonAPI") && ConfigSetup.retrogen_B) {
	    GameRegistry.registerWorldGenerator(new RetroGenerationHandler());
	}
    }

    public static void initBiomes() {
	// Biomes
	ether_biome = new BiomeGenEther(ConfigSetup.ether_biomeID);
	// GameRegistry.addBiome(ether_biome);
	deeps = new BiomeGenDeeps(ConfigSetup.deeps_biomeID);
	if (ConfigSetup.scalded_lands_B) {
	    scalded_biome = new BiomeGenScalded(ConfigSetup.scalded_landsID);
	    GameRegistry.addBiome(scalded_biome);
	    BiomeDictionary.registerBiomeType(scalded_biome,
		    BiomeDictionary.Type.WASTELAND);
	}
	dense_jungle = new BiomeGenDenseJungle(ConfigSetup.dense_jungleID);
	if (ConfigSetup.dense_jungle_B) {
	    GameRegistry.addBiome(dense_jungle);
	    dense_jungle_M = new BiomeGenDenseJungleMountains(
		    ConfigSetup.dense_jungle_MID);
	    GameRegistry.addBiome(dense_jungle_M);
	    BiomeManager.addSpawnBiome(dense_jungle);
	    BiomeManager.addSpawnBiome(dense_jungle_M);
	    BiomeDictionary.registerBiomeType(dense_jungle,
		    BiomeDictionary.Type.FOREST);
	}
    }

    public static void registerDimensions() {
	// Dimensions
	DimensionManager.registerProviderType(ConfigSetup.etherID,
		WorldProviderEther.class, false);
	DimensionManager.registerDimension(ConfigSetup.etherID,
		ConfigSetup.etherID);
	DimensionManager.registerProviderType(ConfigSetup.deepsID,
		WorldProviderDeeps.class, false);
	DimensionManager.registerDimension(ConfigSetup.deepsID,
		ConfigSetup.deepsID);
    }
}