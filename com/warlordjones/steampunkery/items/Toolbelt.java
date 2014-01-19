package com.warlordjones.steampunkery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;

public class Toolbelt extends ItemBase {
    public Toolbelt(int id) {
	super(id);
	// TODO Auto-generated constructor stub
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
	    EntityPlayer par3EntityPlayer)// , int par2, int par3, int par4)
    {
	if (!par2World.isRemote) {
	    return par1ItemStack;
	} else {
	    par3EntityPlayer.openGui(Steampunkery.instance, 100, par2World, 0,
		    0, 0);
	    // displayGUIToolbelt(par1ItemStack);
	    return par1ItemStack;
	}

    }
}
