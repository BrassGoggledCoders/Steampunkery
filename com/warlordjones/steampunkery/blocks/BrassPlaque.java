package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentitities.TileEntityBrassPlaque;

public class BrassPlaque extends BlockContainer {

    protected BrassPlaque(int par1, Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.steampunkeryTab);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	// TODO Auto-generated method stub
	return new TileEntityBrassPlaque();
    }

    public int getRenderType() {
	return -1;
    }

    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    public boolean renderAsNormalBlock() {
	return false;
    }

}
