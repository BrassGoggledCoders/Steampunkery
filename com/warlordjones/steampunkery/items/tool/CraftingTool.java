package com.warlordjones.steampunkery.items.tool;

import net.minecraft.item.ItemStack;

import com.warlordjones.steampunkery.items.ItemBase;

public class CraftingTool extends ItemBase {

    public CraftingTool(final int id) {
	super(id);
	setHasSubtypes(true);
	setUnlocalizedName("hammer");
	setMaxDamage(64);
    }

    @Override
    public boolean hasContainerItem() {
	return true;
    }

    @Override
    public ItemStack getContainerItemStack(ItemStack ist) {
	ist.setItemDamage(ist.getItemDamage() + 1);

	if (ist.getItemDamage() > ist.getMaxDamage()) {
	    ist = null;
	}

	return ist;
    }
}