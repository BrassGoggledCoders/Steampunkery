package com.warlordjones.steampunkery.items.tool;

import com.warlordjones.steampunkery.items.ItemBase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Telescope extends ItemBase {

    public Telescope(final int par1) {
	super(par1);
	setUnlocalizedName("telescope");
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer) {
	return par1ItemStack;
    }
}
