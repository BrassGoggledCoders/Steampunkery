/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityGaslight;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Gaslight extends BlockContainer {
    public Gaslight(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("gaslight");
	setHardness(0.1F);
	setStepSound(Block.soundGlassFootstep);
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public TileEntity createNewTileEntity(final World var1) {
	return new TileEntityGaslight();
    }

    @Override
    public int damageDropped(final int par1) {
	return par1;
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
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.modid + ":"
		+ getUnlocalizedName().substring(5));
    } // You don't want the normal render type, or it wont render properly.

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }
}
