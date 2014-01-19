package com.warlordjones.warcore;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;

public class WorldGenFlatBedrock implements IWorldGenerator {
    public static WorldGenFlatBedrock instance = new WorldGenFlatBedrock();

    public void generate(Random random, int chunkX, int chunkZ, World world,
	    IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	generateWorld(random, chunkX, chunkZ, world);
    }

    public void generateWorld(Random rand, int chunkX, int chunkZ, World world) {
	if (world.provider.dimensionId == -1) {
	    generateNether(rand, chunkX, chunkZ, world);
	}
	if (world.provider.dimensionId == 0)
	    generateSurface(rand, chunkX, chunkZ, world);
    }

    public void generateSurface(Random rand, int chunkX, int chunkZ, World world) {
	int stoneID = Block.stone.blockID;
	generateFlatBottom(world, chunkX, chunkZ, stoneID);
    }

    public void generateNether(Random rand, int chunkX, int chunkZ, World world) {
	int netherrackID = Block.netherrack.blockID;
	generateFlatTop(world, chunkX, chunkZ, netherrackID);
	generateFlatBottom(world, chunkX, chunkZ, netherrackID);
    }

    public void generateFlatTop(World world, int chunkX, int chunkZ,
	    int replacementID) {
	for (int blockX = 0; blockX < 16; blockX++)
	    for (int blockZ = 0; blockZ < 16; blockZ++)
		for (int blockY = 126; blockY > 121; blockY--)
		    if (world.getBlockId(chunkX * 16 + blockX, blockY, chunkZ
			    * 16 + blockZ) == Block.bedrock.blockID)
			world.setBlock(chunkX * 16 + blockX, blockY, chunkZ
				* 16 + blockZ, replacementID, 0, 2);
    }

    public void generateFlatBottom(World world, int chunkX, int chunkZ,
	    int replacementID) {
	for (int blockX = 0; blockX < 16; blockX++)
	    for (int blockZ = 0; blockZ < 16; blockZ++)
		for (int blockY = 5; blockY > 0; blockY--)
		    if (world.getBlockId(chunkX * 16 + blockX, blockY, chunkZ
			    * 16 + blockZ) == Block.bedrock.blockID)
			world.setBlock(chunkX * 16 + blockX, blockY, chunkZ
				* 16 + blockZ, replacementID, 0, 2);
    }
}