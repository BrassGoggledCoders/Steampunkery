/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items.tool;

import com.warlordjones.steampunkery.items.ItemBase;

import net.minecraft.item.ItemStack;

public class CraftingTool extends ItemBase {

    public CraftingTool(final int id) {
	super(id);
	setHasSubtypes(true);
	setUnlocalizedName("hammer");
	setMaxDamage(64);
    }

    @Override
    public ItemStack getContainerItemStack(ItemStack ist) {
	ist.setItemDamage(ist.getItemDamage() + 1);

	if (ist.getItemDamage() > ist.getMaxDamage())
	    ist = null;

	return ist;
    }

    @Override
    public boolean hasContainerItem() {
	return true;
    }
}