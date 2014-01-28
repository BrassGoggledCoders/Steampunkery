package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.ConfigSetup;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockDeeps extends Block {

    public BlockDeeps(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setBlockUnbreakable();
	setResistance(-1);
	setTextureName("dragon_egg");
	setUnlocalizedName("deeps");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World,
	    final int par2, final int par3, final int par4) {
	return null;
    }

    @Override
    public void onEntityCollidedWithBlock(final World par1World,
	    final int par2, final int par3, final int par4,
	    final Entity par5Entity) {
	if (par5Entity.ridingEntity == null
		&& par5Entity.riddenByEntity == null && !par1World.isRemote)
	    par5Entity.travelToDimension(ConfigSetup.deepsID);
    }
}
