package com.warlordjones.steampunkery.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;

public class SlateBlock extends BlockBase {
    public SlateBlock(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("slate");
	// TODO Auto-generated constructor stub
    }

    @Override
    public int idDropped(final int par1, final Random par2Random, final int par3) {
	return SteamBlocks.slate_cobble.blockID;
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly,
     * and not its normal drops.
     */
    @Override
    protected boolean canSilkHarvest() {
	return true;
    }
}
