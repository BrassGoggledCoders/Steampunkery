/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityConveyor;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Conveyor extends BlockContainer {

    protected Conveyor(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.BlockTab);
	setBlockBounds(0, 0, 0, 1, 0.3F, 1);
    }

    @Override
    public TileEntity createNewTileEntity(final World world) {
	// TODO Auto-generated method stub
	return new TileEntityConveyor();
    }

    // You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
	return -1;
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    @Override
    public void onBlockPlacedBy(final World world, final int x, final int y,
	    final int z, final EntityLivingBase player,
	    final ItemStack par6ItemStack) {
	final int dir = MathHelper
		.floor_double(player.rotationYaw * 4F / 360F + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    }

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }

}
