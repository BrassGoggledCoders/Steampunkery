/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityBrassPlaque;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BrassPlaque extends BlockContainer {

    protected BrassPlaque(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public TileEntity createNewTileEntity(final World world) {
	// TODO Auto-generated method stub
	return new TileEntityBrassPlaque();
    }

    @Override
    public int getRenderType() {
	return -1;
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }

}
