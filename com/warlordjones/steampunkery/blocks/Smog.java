package com.warlordjones.steampunkery.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Smog extends BlockBase {
    public Smog(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("smog");
	setTickRandomly(true);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World,
	    final int par2, final int par3, final int par4) {
	return null;
    }

    public int getRenderBlockPass() {
	return 1;
    }

    @Override
    public int quantityDropped(final Random par1Random) {
	return 0;
    }

    @Override
    public void updateTick(final World par1World, final int par2,
	    final int par3, final int par4, final Random par5Random) {
	if (!par1World.isRemote)
	    for (int l = 0; l < 1; ++l) {
		final int wx = par2 + par5Random.nextInt(3) - 1;
		final int wy = par3 + par5Random.nextInt(5) - 3;
		final int wz = par4 + par5Random.nextInt(3) - 1;
		par1World.getBlockId(wx, wy + 1, wz);
		// Kodehawa code: Tested and fully working c: | Arona: If you
		// need to add
		// another ID just do the same than in the bottom of this text
		final ArrayList<Integer> blocksToDestroy = new ArrayList<Integer>();
		blocksToDestroy.add(Block.crops.blockID);
		blocksToDestroy.add(Block.leaves.blockID);
		blocksToDestroy.add(Block.mushroomBrown.blockID);
		blocksToDestroy.add(Block.mushroomRed.blockID);
		blocksToDestroy.add(Block.plantRed.blockID);
		blocksToDestroy.add(Block.plantYellow.blockID);
		blocksToDestroy.add(Block.reed.blockID);
		blocksToDestroy.add(Block.tallGrass.blockID);
		for (final Integer blockid : blocksToDestroy) {
		    if (par1World.getBlockId(wx, wy, wz) == blockid)
			par1World.setBlock(wx, wy, wz, blockID);
		    if (par1World.getBlockId(wx, wy, wz) == 0)
			par1World.setBlock(wx, wy, wz, blockID);
		}
	    }
    }
}
