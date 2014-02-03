/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandFocus;

public class SpiritFocus extends ItemBase implements IWandFocus {

    public SpiritFocus(final int id) {
	super(id);
	setNoRepair();
	setMaxStackSize(1);
	setUnlocalizedName("spirit_focus");
    }

    @Override
    public boolean acceptsEnchant(final int id) {
	return false;
    }

    @Override
    public WandFocusAnimation getAnimation() {
	return WandFocusAnimation.CHARGE;
    }

    @Override
    public int getFocusColor() {
	return 10;
    }

    @Override
    public Icon getFocusDepthLayerIcon() {
	return null;
    }

    @Override
    public Icon getOrnament() {
	return null;
    }

    @Override
    public String getSortingHelper(final ItemStack itemstack) {
	return "SPIRIT_OF_THE_MACHINE";
    }

    @Override
    public AspectList getVisCost() {
	return new AspectList(1, 10);
    }

    @Override
    public boolean isVisCostPerTick() {
	return false;
    }

    @Override
    public boolean onFocusBlockStartBreak(final ItemStack itemstack,
	    final int x, final int y, final int z, final EntityPlayer player) {
	return false;
    }

    @Override
    public ItemStack onFocusRightClick(final ItemStack itemstack,
	    final World world, final EntityPlayer player,
	    final MovingObjectPosition movingobjectposition) {
	final Vec3 vec = player.getLookVec();
	player.motionX = vec.xCoord;
	player.motionY = vec.yCoord;
	player.motionZ = vec.zCoord;
	player.fallDistance = 0F;
	if (world.isRemote)
	    player.swingItem();
	return itemstack;
    }

    @Override
    public void onPlayerStoppedUsingFocus(final ItemStack itemstack,
	    final World world, final EntityPlayer player, final int count) {

    }

    @Override
    public void onUsingFocusTick(final ItemStack itemstack,
	    final EntityPlayer player, final int count) {

    }

}
