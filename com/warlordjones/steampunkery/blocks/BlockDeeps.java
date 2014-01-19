package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.ConfigSetup;

public class BlockDeeps extends Block {

    public BlockDeeps(int par1, Material par2Material) {
	super(par1, par2Material);
	setBlockUnbreakable();
	setResistance(-1);
	setTextureName("dragon_egg");
	setUnlocalizedName("deeps");
    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
	    int par4, Entity par5Entity) {
	if (par5Entity.ridingEntity == null
		&& par5Entity.riddenByEntity == null && !par1World.isRemote) {
	    par5Entity.travelToDimension(ConfigSetup.deepsID);
	}
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
	    int par2, int par3, int par4) {
	return null;
    }
}
