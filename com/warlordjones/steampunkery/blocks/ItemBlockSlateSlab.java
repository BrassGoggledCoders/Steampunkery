/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSlateSlab extends ItemBlock {
    public ItemBlockSlateSlab(final int id) {
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
	    name = "smooth";
	    break;
	}
	case 1: {
	    name = "cobble";
	    break;
	}
	case 2: {
	    name = "brick";
	    break;
	}
	default:
	    name = "broken";
	}
	return this.getUnlocalizedName() + "." + name;
    }
}
