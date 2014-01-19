package com.warlordjones.steampunkery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.entity.EntityBullet;

public class Musket extends ItemBase {
    public Musket(final int par1) {
	super(par1);
	maxStackSize = 1;
	setMaxDamage(384);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setFull3D();
    }

    /**
     * returns the action that specifies what animation to play when the items
     * is being used
     */
    @Override
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
	return EnumAction.bow;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
	return 72000;
    }

    @Override
    public ItemStack onEaten(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer) {
	return par1ItemStack;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer) {
	if (par3EntityPlayer.capabilities.isCreativeMode
		|| par3EntityPlayer.inventory.hasItem(SteamItems.bullet.itemID))
	    par3EntityPlayer.setItemInUse(par1ItemStack,
		    getMaxItemUseDuration(par1ItemStack));
	return par1ItemStack;
    }

    @Override
    public void onPlayerStoppedUsing(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer,
	    final int par4) {
	final int j = getMaxItemUseDuration(par1ItemStack) - par4;
	final boolean flag = par3EntityPlayer.capabilities.isCreativeMode;
	if (flag
		|| par3EntityPlayer.inventory.hasItem(SteamItems.bullet.itemID)) {

	    float f = j / 20.0F;
	    f = (f * f + f * 2.0F) / 3.0F;
	    if (f < 0.1D)
		return;
	    if (f > 1.0F)
		f = 1.0F;
	    final EntityBullet entitybullet = new EntityBullet(par2World,
		    f * 2.0F, f, f);
	    // if (f == 1.0F)
	    // entitybullet.setIsCritical(true);
	    // else
	    par3EntityPlayer.inventory
		    .consumeInventoryItem(SteamItems.bullet.itemID);
	    if (!par2World.isRemote) {
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow",
			0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		par2World.spawnEntityInWorld(new EntityBullet(par2World,
			par3EntityPlayer));
	    }
	    // entitybullet.setVelocity(10F, 10F, 10F);
	    par1ItemStack.damageItem(1, par3EntityPlayer);
	}
    }
}
