package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBase extends Block {
    public BlockBase(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setHardness(1F);
	setResistance(1F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.prefix
		+ this.getUnlocalizedName().substring(5));
    }
}
