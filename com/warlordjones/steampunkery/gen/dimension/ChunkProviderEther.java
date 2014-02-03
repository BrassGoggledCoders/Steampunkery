/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen.dimension;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderEther implements IChunkProvider {
    public NoiseGeneratorOctaves mobSpawnerNoise;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen5;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen6;
    /** The biomes that are used to generate the chunk */
    private BiomeGenBase[] biomesForGeneration;
    private MapGenBase caveGenerator = new MapGenCaves();
    /** are map structures going to be generated (e.g. strongholds) */
    private final boolean mapFeaturesEnabled;
    /** Holds Mineshaft Generator */
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    /** A NoiseGeneratorOctaves used in generating terrain */
    private NoiseGeneratorOctaves noiseGen1;
    /** A NoiseGeneratorOctaves used in generating terrain */
    private NoiseGeneratorOctaves noiseGen2;
    /** A NoiseGeneratorOctaves used in generating terrain */
    private NoiseGeneratorOctaves noiseGen3;
    /** A NoiseGeneratorOctaves used in generating terrain */
    private NoiseGeneratorOctaves noiseGen4;
    /** RNG. */
    private final Random rand;
    /** Holds ravine generator */
    private MapGenBase ravineGenerator = new MapGenRavine();
    private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    private double[] stoneNoise = new double[256];
    /** Holds Stronghold Generator */
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    /** Holds Village Generator */
    private MapGenVillage villageGenerator = new MapGenVillage();
    /** Reference to the World object. */
    private final World worldObj;
    int[][] field_73219_j = new int[32][32];
    /** A double array that hold terrain noise */
    double[] noise1;
    /** A double array that hold terrain noise from noiseGen2 */
    double[] noise2;
    /** A double array that hold terrain noise from noiseGen3 */
    double[] noise3;
    /** A double array that hold terrain noise from noiseGen5 */
    double[] noise5;
    /** A double array that holds terrain noise from noiseGen6 */
    double[] noise6;
    /**
     * Used to store the 5x5 parabolic field that is used during terrain
     * generation.
     */
    float[] parabolicField;
    {
	caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
	strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(
		strongholdGenerator, STRONGHOLD);
	villageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(
		villageGenerator, VILLAGE);
	mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(
		mineshaftGenerator, MINESHAFT);
	scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen
		.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
	ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderEther(final World par1World, final long par2,
	    final boolean par4) {
	worldObj = par1World;
	mapFeaturesEnabled = par4;
	rand = new Random(par2);
	noiseGen1 = new NoiseGeneratorOctaves(rand, 16);
	noiseGen2 = new NoiseGeneratorOctaves(rand, 16);
	noiseGen3 = new NoiseGeneratorOctaves(rand, 8);
	noiseGen4 = new NoiseGeneratorOctaves(rand, 4);
	noiseGen5 = new NoiseGeneratorOctaves(rand, 10);
	noiseGen6 = new NoiseGeneratorOctaves(rand, 16);
	mobSpawnerNoise = new NoiseGeneratorOctaves(rand, 8);
	NoiseGeneratorOctaves[] noiseGens = { noiseGen1, noiseGen2, noiseGen3,
		noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise };
	noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, rand,
		noiseGens);
	noiseGen1 = noiseGens[0];
	noiseGen2 = noiseGens[1];
	noiseGen3 = noiseGens[2];
	noiseGen4 = noiseGens[3];
	noiseGen5 = noiseGens[4];
	noiseGen6 = noiseGens[5];
	mobSpawnerNoise = noiseGens[6];
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    @Override
    public boolean canSave() {
	return true;
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    @Override
    public boolean chunkExists(final int par1, final int par2) {
	return true;
    }

    // }
    /**
     * Returns the location of the closest structure of the specified type. If
     * not found returns null.
     */
    @Override
    public ChunkPosition findClosestStructure(final World par1World,
	    final String par2Str, final int par3, final int par4, final int par5) {
	return "Stronghold".equals(par2Str) && strongholdGenerator != null ? strongholdGenerator
		.getNearestInstance(par1World, par3, par4, par5) : null;
    }

    /**
     * Generates the shape of the terrain for the chunk though its all stone
     * though the water is frozen if the temperature is low enough
     */
    public void generateTerrain(final int par1, final int par2,
	    final byte[] par3ArrayOfByte) {
	/**
	 * byte b0 = 4; byte b1 = 16; byte b2 = 63; int k = b0 + 1; byte b3 =
	 * 17; int l = b0 + 1; this.biomesForGeneration =
	 * this.worldObj.getWorldChunkManager
	 * ().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2,
	 * par2 * 4 - 2, k + 5, l + 5); this.noiseArray =
	 * this.initializeNoiseField(this.noiseArray, par1 * b0, 0, par2 * b0,
	 * k, b3, l); for (int i1 = 0; i1 < b0; ++i1) { for (int j1 = 0; j1 <
	 * b0; ++j1) { for (int k1 = 0; k1 < b1; ++k1) { double d0 = 0.125D;
	 * double d1 = this.noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
	 * double d2 = this.noiseArray[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
	 * double d3 = this.noiseArray[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
	 * double d4 = this.noiseArray[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
	 * double d5 = (this.noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] -
	 * d1) * d0; double d6 = (this.noiseArray[((i1 + 0) * l + j1 + 1) * b3 +
	 * k1 + 1] - d2) * d0; double d7 = (this.noiseArray[((i1 + 1) * l + j1 +
	 * 0) * b3 + k1 + 1] - d3) * d0; double d8 = (this.noiseArray[((i1 + 1)
	 * * l + j1 + 1) * b3 + k1 + 1] - d4) * d0; for (int l1 = 0; l1 < 8;
	 * ++l1) { double d9 = 0.25D; double d10 = d1; double d11 = d2; double
	 * d12 = (d3 - d1) * d9; double d13 = (d4 - d2) * d9; for (int i2 = 0;
	 * i2 < 4; ++i2) { int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8
	 * + l1; short short1 = 128; j2 -= short1; double d14 = 0.25D; double
	 * d15 = (d11 - d10) * d14; double d16 = d10 - d15; for (int k2 = 0; k2
	 * < 4; ++k2) { if ((d16 += d15) > 0.0D) { par3ArrayOfByte[j2 += short1]
	 * = (byte)Block.stone.blockID; } else if (k1 * 8 + l1 < b2) {
	 * par3ArrayOfByte[j2 += short1] = (byte)Block.waterStill.blockID; }
	 * else { par3ArrayOfByte[j2 += short1] = 0; } } d10 += d12; d11 += d13;
	 * } d1 += d5; d2 += d6; d3 += d7; d4 += d8; } } } }
	 */
    }

    @Override
    public int getLoadedChunkCount() {
	return 0;
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the
     * given location.
     */
    @Override
    public List getPossibleCreatures(
	    final EnumCreatureType par1EnumCreatureType, final int par2,
	    final int par3, final int par4) {
	final BiomeGenBase biomegenbase = worldObj.getBiomeGenForCoords(par2,
		par4);
	return biomegenbase == null ? null
		: par1EnumCreatureType == EnumCreatureType.monster
			&& scatteredFeatureGenerator.func_143030_a(par2, par3,
				par4) ? scatteredFeatureGenerator
			.getScatteredFeatureSpawnList() : biomegenbase
			.getSpawnableList(par1EnumCreatureType);
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    @Override
    public Chunk loadChunk(final int par1, final int par2) {
	return provideChunk(par1, par2);
    }

    /**
     * Converts the instance data to a readable string.
     */
    @Override
    public String makeString() {
	return "RandomLevelSource";
    }

    /**
     * Populates chunk with ores etc etc
     */
    @Override
    public void populate(final IChunkProvider par1IChunkProvider,
	    final int par2, final int par3) {
	BlockSand.fallInstantly = true;
	int k = par2 * 16;
	int l = par3 * 16;
	final BiomeGenBase biomegenbase = worldObj.getBiomeGenForCoords(k + 16,
		l + 16);
	rand.setSeed(worldObj.getSeed());
	final long i1 = rand.nextLong() / 2L * 2L + 1L;
	final long j1 = rand.nextLong() / 2L * 2L + 1L;
	rand.setSeed(par2 * i1 + par3 * j1 ^ worldObj.getSeed());
	boolean flag = false;
	MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(
		par1IChunkProvider, worldObj, rand, par2, par3, flag));
	if (mapFeaturesEnabled) {
	    mineshaftGenerator.generateStructuresInChunk(worldObj, rand, par2,
		    par3);
	    flag = villageGenerator.generateStructuresInChunk(worldObj, rand,
		    par2, par3);
	    strongholdGenerator.generateStructuresInChunk(worldObj, rand, par2,
		    par3);
	    scatteredFeatureGenerator.generateStructuresInChunk(worldObj, rand,
		    par2, par3);
	}
	int k1;
	int l1;
	int i2;
	if (biomegenbase != BiomeGenBase.desert
		&& biomegenbase != BiomeGenBase.desertHills
		&& !flag
		&& rand.nextInt(4) == 0
		&& TerrainGen.populate(par1IChunkProvider, worldObj, rand,
			par2, par3, flag, LAKE)) {
	    k1 = k + rand.nextInt(16) + 8;
	    l1 = rand.nextInt(128);
	    i2 = l + rand.nextInt(16) + 8;
	    new WorldGenLakes(Block.waterStill.blockID).generate(worldObj,
		    rand, k1, l1, i2);
	}
	if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3,
		flag, LAVA) && !flag && rand.nextInt(8) == 0) {
	    k1 = k + rand.nextInt(16) + 8;
	    l1 = rand.nextInt(rand.nextInt(120) + 8);
	    i2 = l + rand.nextInt(16) + 8;
	    if (l1 < 63 || rand.nextInt(10) == 0)
		new WorldGenLakes(Block.lavaStill.blockID).generate(worldObj,
			rand, k1, l1, i2);
	}
	boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand,
		par2, par3, flag, DUNGEON);
	for (k1 = 0; doGen && k1 < 8; ++k1) {
	    l1 = k + rand.nextInt(16) + 8;
	    i2 = rand.nextInt(128);
	    final int j2 = l + rand.nextInt(16) + 8;
	    new WorldGenDungeons().generate(worldObj, rand, l1, i2, j2);
	}
	biomegenbase.decorate(worldObj, rand, k, l);
	SpawnerAnimals.performWorldGenSpawning(worldObj, biomegenbase, k + 8,
		l + 8, 16, 16, rand);
	k += 8;
	l += 8;
	doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2,
		par3, flag, ICE);
	for (k1 = 0; doGen && k1 < 16; ++k1)
	    for (l1 = 0; l1 < 16; ++l1) {
		i2 = worldObj.getPrecipitationHeight(k + k1, l + l1);
		if (worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l))
		    worldObj.setBlock(k1 + k, i2 - 1, l1 + l,
			    Block.ice.blockID, 0, 2);
		if (worldObj.canSnowAt(k1 + k, i2, l1 + l))
		    worldObj.setBlock(k1 + k, i2, l1 + l, Block.snow.blockID,
			    0, 2);
	    }
	MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(
		par1IChunkProvider, worldObj, rand, par2, par3, flag));
	BlockSand.fallInstantly = false;
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it
     * will generates all the blocks for the specified chunk from the map seed
     * and chunk seed
     */
    @Override
    public Chunk provideChunk(final int par1, final int par2) {
	rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
	final byte[] abyte = new byte[32768];
	generateTerrain(par1, par2, abyte);
	biomesForGeneration = worldObj.getWorldChunkManager()
		.loadBlockGeneratorData(biomesForGeneration, par1 * 16,
			par2 * 16, 16, 16);
	replaceBlocksForBiome(par1, par2, abyte, biomesForGeneration);
	caveGenerator.generate(this, worldObj, par1, par2, abyte);
	ravineGenerator.generate(this, worldObj, par1, par2, abyte);
	if (mapFeaturesEnabled) {
	    mineshaftGenerator.generate(this, worldObj, par1, par2, abyte);
	    villageGenerator.generate(this, worldObj, par1, par2, abyte);
	    strongholdGenerator.generate(this, worldObj, par1, par2, abyte);
	    scatteredFeatureGenerator.generate(this, worldObj, par1, par2,
		    abyte);
	}
	final Chunk chunk = new Chunk(worldObj, abyte, par1, par2);
	final byte[] abyte1 = chunk.getBiomeArray();
	for (int k = 0; k < abyte1.length; ++k)
	    abyte1[k] = (byte) biomesForGeneration[k].biomeID;
	chunk.generateSkylightMap();
	return chunk;
    }

    @Override
    public void recreateStructures(final int par1, final int par2) {
	if (mapFeaturesEnabled) {
	    mineshaftGenerator.generate(this, worldObj, par1, par2,
		    (byte[]) null);
	    villageGenerator
		    .generate(this, worldObj, par1, par2, (byte[]) null);
	    strongholdGenerator.generate(this, worldObj, par1, par2,
		    (byte[]) null);
	    scatteredFeatureGenerator.generate(this, worldObj, par1, par2,
		    (byte[]) null);
	}
    }

    /**
     * Replaces the stone that was placed in with blocks that match the biome
     */
    public void replaceBlocksForBiome(final int par1, final int par2,
	    final byte[] par3ArrayOfByte,
	    final BiomeGenBase[] par4ArrayOfBiomeGenBase) {
	final ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(
		this, par1, par2, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
	MinecraftForge.EVENT_BUS.post(event);
	if (event.getResult() == Result.DENY)
	    return;
	final byte b0 = 63;
	final double d0 = 0.03125D;
	stoneNoise = noiseGen4.generateNoiseOctaves(stoneNoise, par1 * 16,
		par2 * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);
	for (int k = 0; k < 16; ++k)
	    for (int l = 0; l < 16; ++l) {
		final BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[l + k
			* 16];
		final float f = biomegenbase.getFloatTemperature();
		final int i1 = (int) (stoneNoise[k + l * 16] / 3.0D + 3.0D + rand
			.nextDouble() * 0.25D);
		int j1 = -1;
		byte b1 = biomegenbase.topBlock;
		byte b2 = biomegenbase.fillerBlock;
		for (int k1 = 127; k1 >= 0; --k1) {
		    final int l1 = (l * 16 + k) * 128 + k1;
		    // if (k1 <= 0 + this.rand.nextInt(5))
		    // {
		    // par3ArrayOfByte[l1] = (byte)Block.bedrock.blockID;
		    // }
		    // else
		    // {
		    final byte b3 = par3ArrayOfByte[l1];
		    if (b3 == 0)
			j1 = -1;
		    else if (b3 == Block.stone.blockID)
			if (j1 == -1) {
			    if (i1 <= 0) {
				b1 = 0;
				b2 = (byte) Block.stone.blockID;
			    } else if (k1 >= b0 - 4 && k1 <= b0 + 1) {
				b1 = biomegenbase.topBlock;
				b2 = biomegenbase.fillerBlock;
			    }
			    if (k1 < b0 && b1 == 0)
				if (f < 0.15F)
				    b1 = (byte) Block.ice.blockID;
				else
				    b1 = (byte) Block.waterStill.blockID;
			    j1 = i1;
			    if (k1 >= b0 - 1)
				par3ArrayOfByte[l1] = b1;
			    else
				par3ArrayOfByte[l1] = b2;
			} else if (j1 > 0) {
			    --j1;
			    par3ArrayOfByte[l1] = b2;
			    if (j1 == 0 && b2 == Block.sand.blockID) {
				j1 = rand.nextInt(4);
				b2 = (byte) Block.sandStone.blockID;
			    }
			}
		}
	    }
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go. If
     * passed false, save up to two chunks. Return true if all chunks have been
     * saved.
     */
    @Override
    public boolean saveChunks(final boolean par1,
	    final IProgressUpdate par2IProgressUpdate) {
	return true;
    }

    /**
     * Save extra data not associated with any Chunk. Not saved during autosave,
     * only during world unload. Currently unimplemented.
     */
    @Override
    public void saveExtraData() {
    }

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to
     * unload every such chunk.
     */
    @Override
    public boolean unloadQueuedChunks() {
	return false;
    }
}
