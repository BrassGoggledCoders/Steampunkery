/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen;

import java.util.Random;

import com.warlordjones.steampunkery.blocks.SteamBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBedrockFissure extends WorldGenerator {
    @Override
    public boolean generate(final World world, final Random rand, final int i,
	    final int j, final int k) {
	world.setBlock(i + 0, j + 1, k + 1, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 2, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 3, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 4, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 5, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 6, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 7, Block.bedrock.blockID);
	world.setBlock(i + 0, j + 1, k + 11, 0);
	world.setBlock(i + 0, j + 2, k + 1, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 2, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 3, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 4, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 5, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 6, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 7, Block.stone.blockID);
	world.setBlock(i + 0, j + 2, k + 11, 0);
	world.setBlock(i + 0, j + 3, k + 11, 0);
	world.setBlock(i + 1, j + 1, k + 0, Block.bedrock.blockID);
	world.setBlock(i + 1, j + 1, k + 1, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 2, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 3, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 4, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 5, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 6, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 7, SteamBlocks.deeps.blockID);
	world.setBlock(i + 1, j + 1, k + 8, Block.bedrock.blockID);
	world.setBlock(i + 1, j + 1, k + 9, Block.bedrock.blockID);
	world.setBlock(i + 1, j + 1, k + 11, 0);
	world.setBlock(i + 1, j + 2, k + 0, Block.cobblestone.blockID);
	world.setBlock(i + 1, j + 2, k + 1, 0);
	world.setBlock(i + 1, j + 2, k + 2, 0);
	world.setBlock(i + 1, j + 2, k + 3, 0);
	world.setBlock(i + 1, j + 2, k + 4, 0);
	world.setBlock(i + 1, j + 2, k + 5, 0);
	world.setBlock(i + 1, j + 2, k + 6, 0);
	world.setBlock(i + 1, j + 2, k + 7, 0);
	world.setBlock(i + 1, j + 2, k + 8, Block.bedrock.blockID);
	world.setBlock(i + 1, j + 2, k + 9, Block.bedrock.blockID);
	world.setBlock(i + 1, j + 2, k + 11, 0);
	world.setBlock(i + 1, j + 3, k + 1, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 2, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 3, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 4, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 5, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 6, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 7, Block.stone.blockID);
	world.setBlock(i + 1, j + 3, k + 11, 0);
	world.setBlock(i + 2, j + 1, k + 0, Block.bedrock.blockID);
	world.setBlock(i + 2, j + 1, k + 1, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 2, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 3, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 4, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 5, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 6, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 7, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 8, SteamBlocks.deeps.blockID);
	world.setBlock(i + 2, j + 1, k + 9, Block.bedrock.blockID);
	world.setBlock(i + 2, j + 1, k + 11, 0);
	world.setBlock(i + 2, j + 2, k + 0, Block.stone.blockID);
	world.setBlock(i + 2, j + 2, k + 1, 0);
	world.setBlock(i + 2, j + 2, k + 2, 0);
	world.setBlock(i + 2, j + 2, k + 3, 0);
	world.setBlock(i + 2, j + 2, k + 4, 0);
	world.setBlock(i + 2, j + 2, k + 5, 0);
	world.setBlock(i + 2, j + 2, k + 6, 0);
	world.setBlock(i + 2, j + 2, k + 7, 0);
	world.setBlock(i + 2, j + 2, k + 8, 0);
	world.setBlock(i + 2, j + 2, k + 9, Block.bedrock.blockID);
	world.setBlock(i + 2, j + 2, k + 11, 0);
	world.setBlock(i + 2, j + 3, k + 1, Block.stone.blockID);
	world.setBlock(i + 2, j + 3, k + 2, 0);
	world.setBlock(i + 2, j + 3, k + 3, 0);
	world.setBlock(i + 2, j + 3, k + 4, 0);
	world.setBlock(i + 2, j + 3, k + 5, 0);
	world.setBlock(i + 2, j + 3, k + 6, 0);
	world.setBlock(i + 2, j + 3, k + 7, Block.stone.blockID);
	world.setBlock(i + 2, j + 3, k + 8, Block.cobblestone.blockID);
	world.setBlock(i + 2, j + 3, k + 11, 0);
	world.setBlock(i + 3, j + 1, k + 1, Block.bedrock.blockID);
	world.setBlock(i + 3, j + 1, k + 2, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 3, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 4, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 5, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 6, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 7, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 8, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 9, SteamBlocks.deeps.blockID);
	world.setBlock(i + 3, j + 1, k + 10, Block.bedrock.blockID);
	world.setBlock(i + 3, j + 1, k + 11, Block.bedrock.blockID);
	world.setBlock(i + 3, j + 2, k + 1, Block.stone.blockID);
	world.setBlock(i + 3, j + 2, k + 2, 0);
	world.setBlock(i + 3, j + 2, k + 3, 0);
	world.setBlock(i + 3, j + 2, k + 4, 0);
	world.setBlock(i + 3, j + 2, k + 5, 0);
	world.setBlock(i + 3, j + 2, k + 6, 0);
	world.setBlock(i + 3, j + 2, k + 7, 0);
	world.setBlock(i + 3, j + 2, k + 8, 0);
	world.setBlock(i + 3, j + 2, k + 9, 0);
	world.setBlock(i + 3, j + 2, k + 10, Block.cobblestone.blockID);
	world.setBlock(i + 3, j + 2, k + 11, Block.cobblestone.blockID);
	world.setBlock(i + 3, j + 3, k + 1, Block.stone.blockID);
	world.setBlock(i + 3, j + 3, k + 2, Block.stone.blockID);
	world.setBlock(i + 3, j + 3, k + 3, Block.stone.blockID);
	world.setBlock(i + 3, j + 3, k + 4, 0);
	world.setBlock(i + 3, j + 3, k + 5, 0);
	world.setBlock(i + 3, j + 3, k + 6, 0);
	world.setBlock(i + 3, j + 3, k + 7, 0);
	world.setBlock(i + 3, j + 3, k + 8, Block.cobblestone.blockID);
	world.setBlock(i + 3, j + 3, k + 9, Block.stone.blockID);
	world.setBlock(i + 3, j + 3, k + 11, 0);
	world.setBlock(i + 4, j + 1, k + 1, Block.bedrock.blockID);
	world.setBlock(i + 4, j + 1, k + 2, Block.bedrock.blockID);
	world.setBlock(i + 4, j + 1, k + 3, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 4, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 5, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 6, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 7, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 8, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 9, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 10, SteamBlocks.deeps.blockID);
	world.setBlock(i + 4, j + 1, k + 11, Block.bedrock.blockID);
	world.setBlock(i + 4, j + 2, k + 1, Block.stone.blockID);
	world.setBlock(i + 4, j + 2, k + 2, Block.cobblestone.blockID);
	world.setBlock(i + 4, j + 2, k + 3, 0);
	world.setBlock(i + 4, j + 2, k + 4, 0);
	world.setBlock(i + 4, j + 2, k + 5, 0);
	world.setBlock(i + 4, j + 2, k + 6, 0);
	world.setBlock(i + 4, j + 2, k + 7, 0);
	world.setBlock(i + 4, j + 2, k + 8, 0);
	world.setBlock(i + 4, j + 2, k + 9, 0);
	world.setBlock(i + 4, j + 2, k + 10, 0);
	world.setBlock(i + 4, j + 2, k + 11, Block.cobblestone.blockID);
	world.setBlock(i + 4, j + 3, k + 3, Block.stone.blockID);
	world.setBlock(i + 4, j + 3, k + 4, Block.stone.blockID);
	world.setBlock(i + 4, j + 3, k + 5, Block.stone.blockID);
	world.setBlock(i + 4, j + 3, k + 6, 0);
	world.setBlock(i + 4, j + 3, k + 7, 0);
	world.setBlock(i + 4, j + 3, k + 8, 0);
	world.setBlock(i + 4, j + 3, k + 9, Block.stone.blockID);
	world.setBlock(i + 4, j + 3, k + 10, Block.stone.blockID);
	world.setBlock(i + 4, j + 3, k + 11, 0);
	world.setBlock(i + 5, j + 1, k + 2, Block.bedrock.blockID);
	world.setBlock(i + 5, j + 1, k + 3, Block.bedrock.blockID);
	world.setBlock(i + 5, j + 1, k + 4, SteamBlocks.deeps.blockID);
	world.setBlock(i + 5, j + 1, k + 5, SteamBlocks.deeps.blockID);
	world.setBlock(i + 5, j + 1, k + 6, SteamBlocks.deeps.blockID);
	world.setBlock(i + 5, j + 1, k + 7, SteamBlocks.deeps.blockID);
	world.setBlock(i + 5, j + 1, k + 8, SteamBlocks.deeps.blockID);
	world.setBlock(i + 5, j + 1, k + 9, SteamBlocks.deeps.blockID);
	world.setBlock(i + 5, j + 1, k + 10, Block.bedrock.blockID);
	world.setBlock(i + 5, j + 1, k + 11, 0);
	world.setBlock(i + 5, j + 2, k + 2, Block.cobblestone.blockID);
	world.setBlock(i + 5, j + 2, k + 3, Block.cobblestone.blockID);
	world.setBlock(i + 5, j + 2, k + 4, 0);
	world.setBlock(i + 5, j + 2, k + 5, 0);
	world.setBlock(i + 5, j + 2, k + 6, 0);
	world.setBlock(i + 5, j + 2, k + 7, 0);
	world.setBlock(i + 5, j + 2, k + 8, 0);
	world.setBlock(i + 5, j + 2, k + 9, 0);
	world.setBlock(i + 5, j + 2, k + 10, Block.bedrock.blockID);
	world.setBlock(i + 5, j + 2, k + 11, 0);
	world.setBlock(i + 5, j + 3, k + 4, Block.stone.blockID);
	world.setBlock(i + 5, j + 3, k + 5, Block.stone.blockID);
	world.setBlock(i + 5, j + 3, k + 6, Block.stone.blockID);
	world.setBlock(i + 5, j + 3, k + 7, Block.stone.blockID);
	world.setBlock(i + 5, j + 3, k + 8, Block.stone.blockID);
	world.setBlock(i + 5, j + 3, k + 9, Block.stone.blockID);
	world.setBlock(i + 5, j + 3, k + 11, 0);
	world.setBlock(i + 6, j + 1, k + 0, 0);
	world.setBlock(i + 6, j + 1, k + 1, 0);
	world.setBlock(i + 6, j + 1, k + 2, 0);
	world.setBlock(i + 6, j + 1, k + 3, 0);
	world.setBlock(i + 6, j + 1, k + 4, Block.bedrock.blockID);
	world.setBlock(i + 6, j + 1, k + 5, Block.bedrock.blockID);
	world.setBlock(i + 6, j + 1, k + 6, Block.bedrock.blockID);
	world.setBlock(i + 6, j + 1, k + 7, Block.bedrock.blockID);
	world.setBlock(i + 6, j + 1, k + 8, Block.bedrock.blockID);
	world.setBlock(i + 6, j + 1, k + 9, Block.bedrock.blockID);
	world.setBlock(i + 6, j + 1, k + 10, 0);
	world.setBlock(i + 6, j + 1, k + 11, 0);
	world.setBlock(i + 6, j + 2, k + 0, 0);
	world.setBlock(i + 6, j + 2, k + 1, 0);
	world.setBlock(i + 6, j + 2, k + 2, 0);
	world.setBlock(i + 6, j + 2, k + 3, 0);
	world.setBlock(i + 6, j + 2, k + 4, Block.stone.blockID);
	world.setBlock(i + 6, j + 2, k + 5, Block.stone.blockID);
	world.setBlock(i + 6, j + 2, k + 6, Block.cobblestone.blockID);
	world.setBlock(i + 6, j + 2, k + 7, Block.cobblestone.blockID);
	world.setBlock(i + 6, j + 2, k + 8, Block.stone.blockID);
	world.setBlock(i + 6, j + 2, k + 9, Block.stone.blockID);
	world.setBlock(i + 6, j + 2, k + 10, 0);
	world.setBlock(i + 6, j + 2, k + 11, 0);
	world.setBlock(i + 6, j + 3, k + 0, 0);
	world.setBlock(i + 6, j + 3, k + 1, 0);
	world.setBlock(i + 6, j + 3, k + 2, 0);
	world.setBlock(i + 6, j + 3, k + 3, 0);
	world.setBlock(i + 6, j + 3, k + 4, 0);
	world.setBlock(i + 6, j + 3, k + 5, Block.stone.blockID);
	world.setBlock(i + 6, j + 3, k + 6, 0);
	world.setBlock(i + 6, j + 3, k + 7, 0);
	world.setBlock(i + 6, j + 3, k + 8, 0);
	world.setBlock(i + 6, j + 3, k + 9, 0);
	world.setBlock(i + 6, j + 3, k + 10, 0);
	world.setBlock(i + 6, j + 3, k + 11, 0);

	return true;

    }

    protected int[] GetValidSpawnBlocks() {
	return new int[] { Block.bedrock.blockID, Block.stone.blockID };
    }

}