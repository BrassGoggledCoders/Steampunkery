/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import java.util.Random;

import com.warlordjones.steampunkery.entity.EntityBomb;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class Bomb extends BlockBase {

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(final World par0World, final int par1,
	    final int par2, final int par3) {
	final int l = par0World.getBlockId(par1, par2, par3);

	if (par0World.isAirBlock(par1, par2, par3))
	    return true;
	else if (l == Block.fire.blockID)
	    return true;
	else {
	    final Material material = Block.blocksList[l].blockMaterial;
	    return material == Material.water ? true
		    : material == Material.lava;
	}
    }

    public Bomb(final int par1, final Material par2Material) {
	super(par1, par2Material);
	// TODO Auto-generated constructor stub
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockAdded(final World par1World, final int par2,
	    final int par3, final int par4) {
	par1World.scheduleBlockUpdate(par2, par3, par4, blockID,
		tickRate(par1World));
    }

    /**
     * Called when the falling block entity for this block hits the ground and
     * turns back into a block
     */
    public void onFinishFalling(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {

    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: x, y, z,
     * neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {
	par1World.scheduleBlockUpdate(par2, par3, par4, blockID,
		tickRate(par1World));
    }

    /**
     * How many world ticks before ticking
     */
    @Override
    public int tickRate(final World par1World) {
	return 2;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(final World par1World, final int par2,
	    final int par3, final int par4, final Random par5Random) {
	if (!par1World.isRemote)
	    tryToFall(par1World, par2, par3, par4);
    }

    private void tryToFall(final World par1World, final int par2, int par3,
	    final int par4) {
	if (Bomb.canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0) {
	    final byte b0 = 32;

	    if (par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0,
		    par2 + b0, par3 + b0, par4 + b0)) {
		if (!par1World.isRemote) {
		    final EntityBomb entityfallingsand = new EntityBomb(
			    par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F,
			    blockID, par1World.getBlockMetadata(par2, par3,
				    par4));
		    onStartFalling(entityfallingsand);
		    par1World.spawnEntityInWorld(entityfallingsand);
		}
	    } else {
		par1World.setBlockToAir(par2, par3, par4);

		while (Bomb.canFallBelow(par1World, par2, par3 - 1, par4)
			&& par3 > 0)
		    --par3;

		if (par3 > 0)
		    par1World.setBlock(par2, par3, par4, blockID);
	    }
	}
    }

    /**
     * Called when the falling block entity for this block is created
     */
    protected void onStartFalling(final EntityBomb entityfallingsand) {
    }
}
