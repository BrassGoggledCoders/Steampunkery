package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityTeslaCoil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TeslaCoil extends BlockContainer {

    public static boolean isPowered;

    public TeslaCoil(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.BlockTab);
	setUnlocalizedName("tesla_coil");
	// this.setBlockBounds(0.5F, 1F, 0.5F, 1F, 0.5F, 1F);
    }

    @Override
    public TileEntity createNewTileEntity(final World par1World) {
	return new TileEntityTeslaCoil();
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
    public void onBlockAdded(final World par1World, final int par2,
	    final int par3, final int par4) {
	if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
	    isPowered = true;
	else
	    isPowered = false;
    }

    @Override
    public void onNeighborBlockChange(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {
	if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
	    isPowered = true;
	else
	    isPowered = false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.prefix
		+ getUnlocalizedName().substring(5));
    }

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }
}
