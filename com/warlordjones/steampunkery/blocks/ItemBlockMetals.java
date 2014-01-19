package com.warlordjones.steampunkery.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetals extends ItemBlock {
    public ItemBlockMetals(final int id) {
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
	    name = "aluminum";
	    break;
	}
	case 1: {
	    name = "copper";
	    break;
	}
	case 2: {
	    name = "tin";
	    break;
	}
	case 3: {
	    name = "zinc";
	    break;
	}
	default:
	    name = "broken";
	}
	return this.getUnlocalizedName() + "." + name;
    }
}
