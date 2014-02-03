/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gui.player;

import com.warlordjones.steampunkery.items.Goggles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ContainerSteamCustomPlayer extends Container {
    /**
     * Avoid magic numbers! This will greatly reduce the chance of you making
     * errors in 'transferStackInSlot' method
     */
    private static final int ARMOR_START = SteamCustomPlayerInventory.INV_SIZE,
	    ARMOR_END = ContainerSteamCustomPlayer.ARMOR_START + 3,
	    INV_START = ContainerSteamCustomPlayer.ARMOR_END + 1,
	    INV_END = ContainerSteamCustomPlayer.INV_START + 26,
	    HOTBAR_START = ContainerSteamCustomPlayer.INV_END + 1,
	    HOTBAR_END = ContainerSteamCustomPlayer.HOTBAR_START + 8;

    public ContainerSteamCustomPlayer(final EntityPlayer player,
	    final InventoryPlayer inventoryPlayer,
	    final SteamCustomPlayerInventory

	    inventoryCustom) {
	int i;

	// Add CUSTOM slots - we'll just add two for now, both of the same type.
	// Make a new Slot class for each different item type you want to add
	addSlotToContainer(new SlotSteam(inventoryCustom, 0, 80, 8));
	addSlotToContainer(new SlotSteam(inventoryCustom, 1, 80, 26));

	// Add ARMOR slots; note you need to make a public version of SlotArmor
	// just copy and paste the vanilla code into a new class and change what
	// you need
	for (i = 0; i < 4; ++i)
	    addSlotToContainer(new SlotArmor(player, inventoryPlayer,
		    inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18,

		    i));

	// Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla
	// classes
	for (i = 0; i < 3; ++i)
	    for (int j = 0; j < 9; ++j)
		addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
			8 + j * 18, 84 + i * 18));

	// Add ACTION BAR - just copied/pasted from vanilla classes
	for (i = 0; i < 9; ++i)
	    addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
    }

    /**
     * This should always return true, since custom inventory can be accessed
     * from anywhere
     */
    @Override
    public boolean canInteractWith(final EntityPlayer player) {
	return true;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or
     * you will crash when someone does that. Basically the same as every other
     * container I make, since I define the same constant indices for all of
     * them
     */
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer player,
	    final int par2) {
	ItemStack itemstack = null;
	final Slot slot = (Slot) inventorySlots.get(par2);

	if (slot != null && slot.getHasStack()) {
	    final ItemStack itemstack1 = slot.getStack();
	    itemstack = itemstack1.copy();

	    // Either armor slot or custom item slot was clicked
	    if (par2 < ContainerSteamCustomPlayer.INV_START) {
		// try to place in player inventory / action bar
		if (!mergeItemStack(itemstack1,
			ContainerSteamCustomPlayer.INV_START,
			ContainerSteamCustomPlayer.HOTBAR_END + 1, true))
		    return null;

		slot.onSlotChange(itemstack1, itemstack);
	    } else // if item is our custom item
	    if (itemstack1.getItem() instanceof Goggles) {
		if (!mergeItemStack(itemstack1, 0,
			SteamCustomPlayerInventory.INV_SIZE, false))
		    return null;
	    }
	    // if item is armor
	    else if (itemstack1.getItem() instanceof ItemArmor) {
		final int type = ((ItemArmor) itemstack1.getItem()).armorType;
		if (!mergeItemStack(itemstack1,
			ContainerSteamCustomPlayer.ARMOR_START + type,
			ContainerSteamCustomPlayer.ARMOR_START + type + 1,
			false))
		    return null;
	    }
	    // item in player's inventory, but not in action bar
	    else if (par2 >= ContainerSteamCustomPlayer.INV_START
		    && par2 < ContainerSteamCustomPlayer.HOTBAR_START) {
		// place in action bar
		if (!mergeItemStack(itemstack1,
			ContainerSteamCustomPlayer.HOTBAR_START,
			ContainerSteamCustomPlayer.HOTBAR_START + 1, false))
		    return null;
	    }
	    // item in action bar - place in player inventory
	    else if (par2 >= ContainerSteamCustomPlayer.HOTBAR_START
		    && par2 < ContainerSteamCustomPlayer.HOTBAR_END + 1)
		if (!mergeItemStack(itemstack1,
			ContainerSteamCustomPlayer.INV_START,
			ContainerSteamCustomPlayer.INV_END + 1, false))
		    return null;

	    if (itemstack1.stackSize == 0)
		slot.putStack((ItemStack) null);
	    else
		slot.onSlotChanged();

	    if (itemstack1.stackSize == itemstack.stackSize)
		return null;

	    slot.onPickupFromSlot(player, itemstack1);
	}

	return itemstack;
    }
}