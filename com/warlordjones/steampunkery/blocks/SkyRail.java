package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.BlockRailPowered;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SkyRail extends BlockRailPowered {

    protected SkyRail(int par1) {
	super(par1);
	setCreativeTab(Steampunkery.steampunkeryTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon("steampunkery" + ":"
		+ this.getUnlocalizedName().substring(5));
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
	return true;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3,
	    int par4, int par5) {
	if (!par1World.isRemote) {
	    int i1 = par1World.getBlockMetadata(par2, par3, par4);
	    int j1 = i1;

	    if (this.isPowered) {
		j1 = i1 & 7;
	    }
	    boolean flag = false;
	    if (flag) {
		this.dropBlockAsItem(par1World, par2, par3, par4,
			par1World.getBlockMetadata(par2, par3, par4), 0);
		par1World.setBlockToAir(par2, par3, par4);
	    } else {
		this.func_94358_a(par1World, par2, par3, par4, i1, j1, par5);
	    }
	}
    }
}
