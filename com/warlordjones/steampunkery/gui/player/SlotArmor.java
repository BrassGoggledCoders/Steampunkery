/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gui.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

// Armor Slot:
public class SlotArmor extends Slot {
    /**
     * The armor type that can be placed on that slot, it uses the same values
     * of armorType field on ItemArmor.
     */
    final int armorType;

    /**
     * The parent class of this slot, ContainerPlayer, SlotArmor is a Anon inner
     * class.
     */
    final EntityPlayer player;

    public SlotArmor(final EntityPlayer player, final IInventory inventory,
	    final int par3, final int par4, final int par5, final int par6) {
	super(inventory, par3, par4, par5);
	this.player = player;
	armorType = par6;
    }

    /**
     * Returns the icon index on items.png that is used as background image of
     * the slot.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBackgroundIconIndex() {
	return ItemArmor.func_94602_b(armorType);
    }

    /**
     * Returns the maximum stack size for a given slot (usually the same as
     * getInventoryStackLimit(), but 1 in the case of armor slots)
     */
    @Override
    public int getSlotStackLimit() {
	return 1;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for
     * the armor slots.
     */
    @Override
    public boolean isItemValid(final ItemStack itemstack) {
	final Item item = itemstack == null ? null : itemstack.getItem();
	return item != null && item.isValidArmor(itemstack, armorType, player);
    }
}