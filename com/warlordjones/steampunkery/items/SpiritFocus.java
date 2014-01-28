package com.warlordjones.steampunkery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandFocus;


public class SpiritFocus extends ItemBase implements IWandFocus {

    public SpiritFocus(int id) {
	super(id);
	setNoRepair();
	setMaxStackSize(1);
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
    public WandFocusAnimation getAnimation() {
	return WandFocusAnimation.CHARGE;
    }

    @Override
    public AspectList getVisCost() {
	//return AspectList.this.remove(Aspect.MECHANISM, 200);
	return null;
    }

    @Override
    public boolean isVisCostPerTick() {
	return false;
    }

    @Override
    public ItemStack onFocusRightClick(ItemStack itemstack, World world,
	    EntityPlayer player, MovingObjectPosition movingobjectposition) {
                Vec3 vec = player.getLookVec();
                player.motionX = vec.xCoord;
                player.motionY = vec.yCoord;
                player.motionZ = vec.zCoord;
                player.fallDistance = 0F;
        if(world.isRemote)
                player.swingItem();
	return itemstack;
    }

    @Override
    public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player,
	    int count) {
	
    }

    @Override
    public void onPlayerStoppedUsingFocus(ItemStack itemstack, World world,
	    EntityPlayer player, int count) {
	
    }

    @Override
    public String getSortingHelper(ItemStack itemstack) {
	return "SPIRIT_OF_THE_MACHINE";
    }

    @Override
    public boolean onFocusBlockStartBreak(ItemStack itemstack, int x, int y,
	    int z, EntityPlayer player) {
	return false;
    }

    @Override
    public boolean acceptsEnchant(int id) {
	return false;
    }

}
