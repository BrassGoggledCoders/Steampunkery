package com.warlordjones.steampunkery.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.warcore.SmartOreGeneration;

import cpw.mods.fml.common.IWorldGenerator;
import Reika.DragonAPI.Interfaces.RetroactiveGenerator;

public class RetroGenerationHandler implements IWorldGenerator,
	RetroactiveGenerator {
    @Override
    public void generate(final Random random, final int chunkX,
	    final int chunkZ, final World world,
	    final IChunkProvider chunkGenerator,
	    final IChunkProvider chunkProvider) {
	switch (world.provider.dimensionId) {
	case -1:
	    generateNether(world, random, chunkX * 16, chunkZ * 16);
	case 0:
	    generateSurface(world, random, chunkX * 16, chunkZ * 16);
	case 1:
	    generateEnd(world, random, chunkX * 16, chunkZ * 16);
	case -10:
	    generateEther(world, random, chunkX * 16, chunkZ * 16);
	}

    }

    private void generateEther(final World world, final Random random,
	    final int x, final int z) {
    }

    private void generateEnd(final World world, final Random random,
	    final int x, final int z) {
    }

    private void generateNether(final World world, final Random random,
	    final int x, final int z) {
    }

    private void generateSurface(final World world, final Random random,
	    final int x, final int z) {

    }

    @Override
    public void generate(Random rand, World world, int chunkX, int chunkZ) {

	final int chunkXcoord = chunkX + rand.nextInt(16);
	final int Ycoord = 10 + rand.nextInt(60);
	final int chunkzcoord = chunkZ + rand.nextInt(16);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 0, 3, 50,
		Block.stone.blockID).generate(world, rand, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 1, 15, 50,
		Block.stone.blockID).generate(world, rand, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 2, 5, 50,
		Block.stone.blockID).generate(world, rand, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.ore_blocks.blockID, 3, 3, 50,
		Block.stone.blockID).generate(world, rand, chunkXcoord, Ycoord,
		chunkzcoord);
	new SmartOreGeneration(SteamBlocks.slate.blockID, 0, 25, 50,
		Block.stone.blockID).generate(world, rand, chunkXcoord, Ycoord,
		chunkzcoord);
	int RandPoschunkX = chunkX + rand.nextInt(16);
	int RandPosY = rand.nextInt(4);
	int RandPoschunkz = chunkZ + rand.nextInt(16);
	for (int k = 0; k < 50; k++) {
	    new WorldGenBedrockFissure().generate(world, rand, RandPoschunkX,
		    RandPosY, RandPoschunkz);
	}
    }

    @Override
    public boolean canGenerateAt(Random rand, World world, int chunkX,
	    int chunkZ) {
	return true;
    }

    @Override
    public String getIDString() {
	// TODO Auto-generated method stub
	return SteamConstants.prefix + "retrogenhandler";
    }
}
