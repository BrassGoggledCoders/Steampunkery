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