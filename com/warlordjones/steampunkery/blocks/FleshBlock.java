package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.material.Material;

import com.warlordjones.steampunkery.Steampunkery;

public class FleshBlock extends BlockBase {
    public FleshBlock(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setUnlocalizedName("flesh_block");
    }
}
