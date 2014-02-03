/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.warcore;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenFlatBedrock implements IWorldGenerator {
    public static WorldGenFlatBedrock instance = new WorldGenFlatBedrock();

    @Override
    public void generate(final Random random, final int chunkX,
	    final int chunkZ, final World world,
	    final IChunkProvider chunkGenerator,
	    final IChunkProvider chunkProvider) {
	generateWorld(random, chunkX, chunkZ, world);
    }

    public void generateFlatBottom(final World world, final int chunkX,
	    final int chunkZ, final int replacementID) {
	for (int blockX = 0; blockX < 16; blockX++)
	    for (int blockZ = 0; blockZ < 16; blockZ++)
		for (int blockY = 5; blockY > 0; blockY--)
		    if (world.getBlockId(chunkX * 16 + blockX, blockY, chunkZ
			    * 16 + blockZ) == Block.bedrock.blockID)
			world.setBlock(chunkX * 16 + blockX, blockY, chunkZ
				* 16 + blockZ, replacementID, 0, 2);
    }

    public void generateFlatTop(final World world, final int chunkX,
	    final int chunkZ, final int replacementID) {
	for (int blockX = 0; blockX < 16; blockX++)
	    for (int blockZ = 0; blockZ < 16; blockZ++)
		for (int blockY = 126; blockY > 121; blockY--)
		    if (world.getBlockId(chunkX * 16 + blockX, blockY, chunkZ
			    * 16 + blockZ) == Block.bedrock.blockID)
			world.setBlock(chunkX * 16 + blockX, blockY, chunkZ
				* 16 + blockZ, replacementID, 0, 2);
    }

    public void generateNether(final Random rand, final int chunkX,
	    final int chunkZ, final World world) {
	final int netherrackID = Block.netherrack.blockID;
	generateFlatTop(world, chunkX, chunkZ, netherrackID);
	generateFlatBottom(world, chunkX, chunkZ, netherrackID);
    }

    public void generateSurface(final Random rand, final int chunkX,
	    final int chunkZ, final World world) {
	final int stoneID = Block.stone.blockID;
	generateFlatBottom(world, chunkX, chunkZ, stoneID);
    }

    public void generateWorld(final Random rand, final int chunkX,
	    final int chunkZ, final World world) {
	if (world.provider.dimensionId == -1)
	    generateNether(rand, chunkX, chunkZ, world);
	if (world.provider.dimensionId == 0)
	    generateSurface(rand, chunkX, chunkZ, world);
    }
}