package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentitities.TileEntityGaslight;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Gaslight extends BlockContainer {
    public Gaslight(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("gaslight");
	setHardness(0.1F);
	setStepSound(Block.soundGlassFootstep);
	setCreativeTab(Steampunkery.steampunkeryTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.modid + ":"
		+ getUnlocalizedName().substring(5));
    } // You don't want the normal render type, or it wont render properly.

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

    public int damageDropped(int par1) {
	return par1;
    }

    public TileEntity createNewTileEntity(World var1) {
	return new TileEntityGaslight();
    }
}
