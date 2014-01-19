package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentitities.TileEntityTeslaCoil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TeslaCoil extends BlockContainer {

    public static boolean isPowered;

    public TeslaCoil(int par1, Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setUnlocalizedName("tesla_coil");
	// this.setBlockBounds(0.5F, 1F, 0.5F, 1F, 0.5F, 1F);
    }

    public TileEntity createNewTileEntity(World par1World) {
	return new TileEntityTeslaCoil();
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
	if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
	    this.isPowered = true;
	} else {
	    this.isPowered = false;
	}
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3,
	    int par4, int par5) {
	if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
	    this.isPowered = true;
	} else {
	    this.isPowered = false;
	}
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.prefix
		+ this.getUnlocalizedName().substring(5));
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
