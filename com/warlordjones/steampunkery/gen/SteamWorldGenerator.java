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

    static int ether_id = ConfigSetup.etherID;

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
	else if (world.provider.dimensionId == SteamWorldGenerator.ether_id)
	    generateEther(world, random, chunkX * 16, chunkZ * 16);
    }

    public void generateSurface(final World world, final Random random,
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

    }

    private void generateEnd(final World world, final Random random,
	    final int x, final int z) {
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
    }
}
