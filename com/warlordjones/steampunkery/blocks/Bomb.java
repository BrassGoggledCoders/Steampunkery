package com.warlordjones.steampunkery.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.entity.EntityBomb;

public class Bomb extends BlockBase {

    public Bomb(int par1, Material par2Material) {
	super(par1, par2Material);
	// TODO Auto-generated constructor stub
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID,
		this.tickRate(par1World));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: x, y, z,
     * neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3,
	    int par4, int par5) {
	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID,
		this.tickRate(par1World));
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4,
	    Random par5Random) {
	if (!par1World.isRemote) {
	    this.tryToFall(par1World, par2, par3, par4);
	}
    }

    private void tryToFall(World par1World, int par2, int par3, int par4) {
	if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0) {
	    byte b0 = 32;

	    if (par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0,
		    par2 + b0, par3 + b0, par4 + b0)) {
		if (!par1World.isRemote) {
		    EntityBomb entityfallingsand = new EntityBomb(par1World,
			    (double) ((float) par2 + 0.5F),
			    (double) ((float) par3 + 0.5F),
			    (double) ((float) par4 + 0.5F), this.blockID,
			    par1World.getBlockMetadata(par2, par3, par4));
		    this.onStartFalling(entityfallingsand);
		    par1World.spawnEntityInWorld(entityfallingsand);
		}
	    } else {
		par1World.setBlockToAir(par2, par3, par4);

		while (canFallBelow(par1World, par2, par3 - 1, par4)
			&& par3 > 0) {
		    --par3;
		}

		if (par3 > 0) {
		    par1World.setBlock(par2, par3, par4, this.blockID);
		}
	    }
	}
    }

    /**
     * Called when the falling block entity for this block is created
     */
    protected void onStartFalling(EntityBomb entityfallingsand) {
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World) {
	return 2;
    }

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(World par0World, int par1, int par2,
	    int par3) {
	int l = par0World.getBlockId(par1, par2, par3);

	if (par0World.isAirBlock(par1, par2, par3)) {
	    return true;
	} else if (l == Block.fire.blockID) {
	    return true;
	} else {
	    Material material = Block.blocksList[l].blockMaterial;
	    return material == Material.water ? true
		    : material == Material.lava;
	}
    }

    /**
     * Called when the falling block entity for this block hits the ground and
     * turns back into a block
     */
    public void onFinishFalling(World par1World, int par2, int par3, int par4,
	    int par5) {

    }
}
