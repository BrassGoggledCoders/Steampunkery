/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityGaslamp;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Gaslamp extends BlockContainer {
    public Gaslamp(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setHardness(0.1F);
	setStepSound(Block.soundGlassFootstep);
	setUnlocalizedName("gaslamp");
	setLightValue(1.0F);
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public TileEntity createNewTileEntity(final World world) {
	// TODO Auto-generated method stub
	return new TileEntityGaslamp();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.modid + ":"
		+ getUnlocalizedName().substring(5));
    }
}