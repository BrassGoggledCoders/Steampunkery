/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.gen.biome.*;
import com.warlordjones.steampunkery.gen.dimension.WorldProviderDeeps;
import com.warlordjones.steampunkery.gen.dimension.WorldProviderEther;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

public class GenerationHandler {
    public static BiomeGenBase deeps;
    public static BiomeGenBase dense_jungle;
    public static BiomeGenBase dense_jungle_M;
    public static BiomeGenBase ether_biome;
    public static BiomeGenBase martian_biome;
    public static BiomeGenBase scalded_biome;

    public static void initBiomes() {
	// Biomes
	GenerationHandler.ether_biome = new BiomeGenEther(
		ConfigSetup.ether_biomeID);
	GenerationHandler.deeps = new BiomeGenDeeps(ConfigSetup.deeps_biomeID);
	if (ConfigSetup.scalded_lands_B) {
	    GenerationHandler.scalded_biome = new BiomeGenScalded(
		    ConfigSetup.scalded_landsID);
	    GameRegistry.addBiome(GenerationHandler.scalded_biome);
	    BiomeDictionary.registerBiomeType(GenerationHandler.scalded_biome,
		    BiomeDictionary.Type.WASTELAND);
	}
	GenerationHandler.dense_jungle = new BiomeGenDenseJungle(
		ConfigSetup.dense_jungleID);
	if (ConfigSetup.dense_jungle_B) {
	    GameRegistry.addBiome(GenerationHandler.dense_jungle);
	    GenerationHandler.dense_jungle_M = new BiomeGenDenseJungleMountains(
		    ConfigSetup.dense_jungle_MID);
	    GameRegistry.addBiome(GenerationHandler.dense_jungle_M);
	    BiomeManager.addSpawnBiome(GenerationHandler.dense_jungle);
	    BiomeManager.addSpawnBiome(GenerationHandler.dense_jungle_M);
	    BiomeDictionary.registerBiomeType(GenerationHandler.dense_jungle,
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

    public static void registerGenerators() {
	if (ConfigSetup.world_gen_B) {
	    GameRegistry.registerWorldGenerator(new SteamWorldGenerator());
	}
	if (Loader.isModLoaded("DragonAPI") && ConfigSetup.retrogen_B)
	    GameRegistry.registerWorldGenerator(new RetroGenerationHandler());
    }
}