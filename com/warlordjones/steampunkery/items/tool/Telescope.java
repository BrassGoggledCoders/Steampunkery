package com.warlordjones.steampunkery.items.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.items.ItemBase;

public class Telescope extends ItemBase {
    ItemStack itemstack;

    public Telescope(final int par1) {
	super(par1);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setUnlocalizedName("telescope");
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer) {
	return par1ItemStack;
    }

    public void onUpdate() {
	itemstack.setItemName("The Longeye");
    }
}
