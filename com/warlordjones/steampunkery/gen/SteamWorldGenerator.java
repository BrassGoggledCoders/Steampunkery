/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen;

import java.util.Random;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.warcore.SmartOreGeneration;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class SteamWorldGenerator implements IWorldGenerator {
    
    @Override
    public void generate(final Random random, final int chunkX,
	    final int chunkZ, final World world,
	    final IChunkProvider chunkGenerator,
	    final IChunkProvider chunkProvider) {
	if (world.provider.dimensionId == -1)
	    generateNether(world, random, chunkX * 16, chunkZ * 16);
	else if (world.provider.dimensionId == 0)
	    generateSurface(world, random, chunkX * 16, chunkZ * 16);
	else if (world.provider.dimensionId == 1)
	    generateEnd(world, random, chunkX * 16, chunkZ * 16);
	else if (world.provider.dimensionId == ConfigSetup.etherID)
	    generateEther(world, random, chunkX * 16, chunkZ * 16);
	else if (world.provider.dimensionId == ConfigSetup.deepsID)
	{
	   generateDeeps(world, random, chunkX * 16, chunkZ * 16); 
	}
	else if(!world.provider.hasNoSky)
	{
	    generateStars(world, random, chunkX * 16, chunkZ * 16);
	}
	else
	{
	    generateElse(world, random, chunkX * 16, chunkZ * 16);
	}
    }

    private void generateStars(World world, Random random, int i, int j) {
	// TODO Auto-generated method stub
	
    }

    private void generateElse(World world, Random random, int x, int z) {
	//Stub
    }

    private void generateDeeps(World world, Random random, int x, int z) {
	/*for (int k = 0; k < 70; k++)
	{
		final int RandPosX = x + random.nextInt(16);
		final int RandPosY = random.nextInt(4);
		final int RandPosZ = z + random.nextInt(16);
	    new WorldGenBedrockFissure().generate(world, random, RandPosX,
		    RandPosY, RandPosZ);
	}*/
    }

    private void generateSurface(final World world, final Random random,
	    final int x, final int z) {
	final int Xcoord = x + random.nextInt(16);
	final int Ycoord = 10 + random.nextInt(60);
	final int Zcoord = z + random.nextInt(16);
	if (ConfigSetup.aluminum_ore_B)
	    new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 0, 3,
		    ConfigSetup.aluminum_ore_chance, Block.stone.blockID)
		    .generate(world, random, Xcoord, Ycoord, Zcoord);
	if (ConfigSetup.copper_ore_B)
	    new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 1, 15,
		    ConfigSetup.copper_ore_chance, Block.stone.blockID)
		    .generate(world, random, Xcoord, Ycoord, Zcoord);
	if (ConfigSetup.tin_ore_B)
	    new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 2, 5,
		    ConfigSetup.tin_ore_chance, Block.stone.blockID).generate(
		    world, random, Xcoord, Ycoord, Zcoord);
	if (ConfigSetup.zinc_ore_B)
	    new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 3, 3,
		    ConfigSetup.zinc_ore_chance, Block.stone.blockID).generate(
		    world, random, Xcoord, Ycoord, Zcoord);
	new SmartOreGeneration(SteamBlocks.slate.blockID, 0, 25, 50,
		Block.stone.blockID).generate(world, random, Xcoord, Ycoord,
		Zcoord);
	final int RandPosX = x + random.nextInt(16);
	final int RandPosY = random.nextInt(4);
	final int RandPosZ = z + random.nextInt(16);
	for (int k = 0; k < 50; k++)
	    new WorldGenBedrockFissure().generate(world, random, RandPosX,
		    RandPosY, RandPosZ);
	for (int blockX = 0; blockX < 16; blockX++)
	    for (int blockZ = 0; blockZ < 16; blockZ++)
		for (int blockY = 4; blockY > 0; blockY--)
		    if (world.getBlockId(blockX * 16 + blockX, blockY, blockZ
			    * 16 + blockZ) == Block.bedrock.blockID)
			world.setBlock(blockX * 16 + blockX, blockY, blockZ
				* 16 + blockZ, Block.obsidian.blockID, 0, 2);
	if (!ConfigSetup.structureddeepsentrance_B)
	    for (int blockX = 0; blockX < 16; blockX++)
		for (int blockZ = 0; blockZ < 16; blockZ++)
		    for (int blockY = 1; blockY > 0; blockY--)
			world.setBlock(blockX * 16 + blockX, blockY, blockZ
				* 16 + blockZ, SteamBlocks.deeps.blockID, 0, 2);

    }

    private void generateEnd(final World world, final Random random,
	    final int x, final int z) {
	//Stub
    }

    private void generateEther(final World world, final Random random,
	    final int x, final int z) {
	final int Xcoord = x + random.nextInt(16);
	final int Ycoord = 10 + random.nextInt(world.getActualHeight());
	final int Zcoord = z + random.nextInt(16);
	for (int k = 0; k < 70; k++)
	    new WorldGenAsteroid().generate(world, random, Xcoord, Ycoord,
		    Zcoord);
    }

    private void generateNether(final World world, final Random random,
	    final int x, final int z) {
	//Stub
    }
}
