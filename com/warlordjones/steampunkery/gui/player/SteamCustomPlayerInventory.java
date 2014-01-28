package com.warlordjones.steampunkery.gui.player;

import com.warlordjones.steampunkery.items.Goggles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class SteamCustomPlayerInventory implements IInventory {
    /** Define the inventory size here for easy reference */
    // This is also the place to define which slot is which if you have
    // different types,
    // for example SLOT_SHIELD = 0, SLOT_AMULET = 1;
    public static final int INV_SIZE = 2;

    /** The name for your custom inventory, possibly just "Inventory" */
    private final String name = "Steam Custom Inventory";

    /**
     * In case your inventory name is too generic, define a name to store the
     * NBT tag in as well
     */
    private final String tagName = "SteamCustomInventoryTag";

    /**
     * Inventory's size must be same as number of slots you add to the Container
     * class
     */
    ItemStack[] inventory = new ItemStack[SteamCustomPlayerInventory.INV_SIZE];

    public SteamCustomPlayerInventory() {
	// don't need anything here!
    }

    @Override
    public void closeChest() {
    }

    @Override
    public ItemStack decrStackSize(final int slot, final int amount) {
	ItemStack stack = getStackInSlot(slot);
	if (stack != null)
	    if (stack.stackSize > amount) {
		stack = stack.splitStack(amount);
		onInventoryChanged();
	    } else
		setInventorySlotContents(slot, null);
	return stack;
    }

    /**
     * Our custom slots are similar to armor - only one item per slot
     */
    @Override
    public int getInventoryStackLimit() {
	return 1;
    }

    @Override
    public String getInvName() {
	return name;
    }

    @Override
    public int getSizeInventory() {
	return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(final int slot) {
	return inventory[slot];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(final int slot) {
	final ItemStack stack = getStackInSlot(slot);
	setInventorySlotContents(slot, null);
	return stack;
    }

    @Override
    public boolean isInvNameLocalized() {
	return name.length() > 0;
    }

    /**
     * This method doesn't seem to do what it claims to do, as items can still
     * be left-clicked and placed in the inventory even when this returns false
     */
    @Override
    public boolean isItemValidForSlot(final int slot, final ItemStack itemstack) {
	// If you have different kinds of slots, then check them here:
	// if (slot == SLOT_SHIELD && itemstack.getItem() instanceof ItemShield)
	// return true;

	// For now, only ItemUseMana items can be stored in these slots
	return itemstack.getItem() instanceof Goggles;
    }

    @Override
    public boolean isUseableByPlayer(final EntityPlayer entityplayer) {
	return true;
    }

    @Override
    public void onInventoryChanged() {
	for (int i = 0; i < getSizeInventory(); ++i)
	    if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
		setInventorySlotContents(i, null);
    }

    @Override
    public void openChest() {
    }

    public void readFromNBT(final NBTTagCompound tagcompound) {
	final NBTTagList items = tagcompound.getTagList(tagName);

	for (int i = 0; i < items.tagCount(); ++i) {
	    final NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
	    final byte slot = item.getByte("Slot");

	    if (slot >= 0 && slot < getSizeInventory())
		setInventorySlotContents(slot,
			ItemStack.loadItemStackFromNBT(item));
	}
    }

    @Override
    public void setInventorySlotContents(final int slot,
	    final ItemStack itemstack) {
	inventory[slot] = itemstack;

	if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
	    itemstack.stackSize = getInventoryStackLimit();

	onInventoryChanged();
    }

    public void writeToNBT(final NBTTagCompound tagcompound) {
	final NBTTagList items = new NBTTagList();

	for (int i = 0; i < getSizeInventory(); ++i)
	    if (getStackInSlot(i) != null) {
		final NBTTagCompound item = new NBTTagCompound();
		item.setByte("Slot", (byte) i);
		getStackInSlot(i).writeToNBT(item);
		items.appendTag(item);
	    }

	// We're storing our items in a custom tag list using our 'tagName' from
	// above
	// to prevent potential conflict
	tagcompound.setTag(tagName, items);
    }
}
