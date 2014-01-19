package com.warlordjones.steampunkery.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDeepCarpet extends ItemBlock {
    public ItemBlockDeepCarpet(final int id) {
	super(id);
	setHasSubtypes(true);
    }

    @Override
    public int getMetadata(final int par1) {
	return par1;
    }

    @Override
    public String getUnlocalizedName(final ItemStack itemstack) {
	String name = "";
	switch (itemstack.getItemDamage()) {
	case 0: {
	    name = "red";
	    break;
	}
	case 1: {
	    name = "green";
	    break;
	}
	case 2: {
	    name = "gold";
	    break;
	}
	default:
	    name = "broken";
	}
	return this.getUnlocalizedName() + "." + name;
    }
}
