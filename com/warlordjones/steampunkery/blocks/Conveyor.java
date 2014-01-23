package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityConveyor;

public class Conveyor extends BlockContainer{

    protected Conveyor(int par1, Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setBlockBounds(0, 0, 0, 1, 0.3F,1);
    }
 // You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
	return -1;
    }

    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    public boolean renderAsNormalBlock() {
	return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	// TODO Auto-generated method stub
	return new TileEntityConveyor();
    }

}
