/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class SkyRail extends BlockRailPowered {

    protected SkyRail(final int par1) {
	super(par1);
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public boolean canPlaceBlockAt(final World par1World, final int par2,
	    final int par3, final int par4) {
	return true;
    }

    @Override
    public void onNeighborBlockChange(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {
	if (!par1World.isRemote) {
	    final int i1 = par1World.getBlockMetadata(par2, par3, par4);
	    int j1 = i1;

	    if (isPowered)
		j1 = i1 & 7;
	    final boolean flag = false;
	    if (flag) {
		dropBlockAsItem(par1World, par2, par3, par4,
			par1World.getBlockMetadata(par2, par3, par4), 0);
		par1World.setBlockToAir(par2, par3, par4);
	    } else
		func_94358_a(par1World, par2, par3, par4, i1, j1, par5);
	}
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon("steampunkery" + ":"
		+ getUnlocalizedName().substring(5));
    }
}
