/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen;

import java.util.Random;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.warcore.SmartOreGeneration;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import Reika.DragonAPI.Interfaces.RetroactiveGenerator;

public class RetroGenerationHandler implements IWorldGenerator,
	RetroactiveGenerator {
    @Override
    public boolean canGenerateAt(final Random rand, final World world,
	    final int chunkX, final int chunkZ) {
	return true;
    }
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
	    IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
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
	else
	{
	    generateElse(world, random, chunkX * 16, chunkZ * 16);
	}
    }
    private void generateElse(World world, Random random, int i, int j) {
	// TODO Auto-generated method stub
	
    }
    private void generateDeeps(World world, Random random, int i, int j) {
	// TODO Auto-generated method stub
	
    }
    @Override
    public void generate(Random rand, World world, int chunkX, int chunkZ) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public String getIDString() {
	return SteamConstants.prefix + "retrogenhandler";
    }

    private void generateEnd(final World world, final Random random,
	    final int x, final int z) {
    }

    private void generateEther(final World world, final Random random,
	    final int x, final int z) {
    }

    private void generateNether(final World world, final Random random,
	    final int x, final int z) {
    }

    private void generateSurface(final World world, final Random random,
	    final int x, final int z) {

	final int chunkXcoord = x + random.nextInt(16);
	final int Ycoord = 10 + random.nextInt(60);
	final int chunkzcoord = z + random.nextInt(16);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 0, 3, 50,
		Block.stone.blockID).generate(world, random, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 1, 15, 50,
		Block.stone.blockID).generate(world, random, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 2, 5, 50,
		Block.stone.blockID).generate(world, random, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 3, 3, 50,
		Block.stone.blockID).generate(world, random, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.slate.blockID, 0, 25, 50,
		Block.stone.blockID).generate(world, random, chunkXcoord, Ycoord,
		chunkzcoord);
	final int RandPoschunkX = x + random.nextInt(16);
	final int RandPosY = random.nextInt(4);
	final int RandPoschunkz = z + random.nextInt(16);
	for (int k = 0; k < 50; k++)
	    new WorldGenBedrockFissure().generate(world, random, RandPoschunkX,
		    RandPosY, RandPoschunkz);
    }
}
