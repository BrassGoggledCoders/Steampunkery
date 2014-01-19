package com.warlordjones.steampunkery.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.blocks.SteamBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenObsidianBottom implements IWorldGenerator {
    public void generateObsidianBottom(World world, int chunkX, int chunkZ,
	    int replacementID) {
	for (int blockX = 0; blockX < 16; blockX++)
	    for (int blockZ = 0; blockZ < 16; blockZ++)
		for (int blockY = 4; blockY > 0; blockY--)
		    if (world.getBlockId(chunkX * 16 + blockX, blockY, chunkZ
			    * 16 + blockZ) == Block.bedrock.blockID) {
			world.setBlock(chunkX * 16 + blockX, blockY, chunkZ
				* 16 + blockZ, replacementID, 0, 2);
		    }
	if (!ConfigSetup.structureddeepsentrance_B) {
	    for (int blockX = 0; blockX < 16; blockX++)
		for (int blockZ = 0; blockZ < 16; blockZ++)
		    for (int blockY = 1; blockY > 0; blockY--)
			world.setBlock(chunkX * 16 + blockX, blockY, chunkZ
				* 16 + blockZ, SteamBlocks.deeps.blockID, 0, 2);
	}
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
	    IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	generateWorld(random, chunkX, chunkZ, world);

    }

    public void generateWorld(Random rand, int chunkX, int chunkZ, World world) {
	if (world.provider.dimensionId == 0)
	    generateSurface(rand, chunkX, chunkZ, world);
    }

    public void generateSurface(Random rand, int chunkX, int chunkZ, World world) {
	int obsidianID = Block.obsidian.blockID;
	generateObsidianBottom(world, chunkX, chunkZ, obsidianID);
    }
}
