package com.warlordjones.steampunkery.items;

import java.util.List;

import com.warlordjones.steampunkery.entity.EntityMechanicalHorse;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class MechanicalHorse extends ItemBase {
    public MechanicalHorse(final int id) {
	super(id);
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer) {
	final float f = 1.0F;
	final float f1 = par3EntityPlayer.prevRotationPitch
		+ (par3EntityPlayer.rotationPitch - par3EntityPlayer.prevRotationPitch)
		* f;
	final float f2 = par3EntityPlayer.prevRotationYaw
		+ (par3EntityPlayer.rotationYaw - par3EntityPlayer.prevRotationYaw)
		* f;
	final double d0 = par3EntityPlayer.prevPosX
		+ (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * f;
	final double d1 = par3EntityPlayer.prevPosY
		+ (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * f
		+ 1.62D - par3EntityPlayer.yOffset;
	final double d2 = par3EntityPlayer.prevPosZ
		+ (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * f;
	final Vec3 vec3 = par2World.getWorldVec3Pool().getVecFromPool(d0, d1,
		d2);
	final float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
	final float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
	final float f5 = -MathHelper.cos(-f1 * 0.017453292F);
	final float f6 = MathHelper.sin(-f1 * 0.017453292F);
	final float f7 = f4 * f5;
	final float f8 = f3 * f5;
	final double d3 = 5.0D;
	final Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
	final MovingObjectPosition movingobjectposition = par2World.clip(vec3,
		vec31, true);
	if (movingobjectposition == null)
	    return par1ItemStack;
	else {
	    final Vec3 vec32 = par3EntityPlayer.getLook(f);
	    boolean flag = false;
	    final float f9 = 1.0F;
	    final List list = par2World.getEntitiesWithinAABBExcludingEntity(
		    par3EntityPlayer,
		    par3EntityPlayer.boundingBox.addCoord(vec32.xCoord * d3,
			    vec32.yCoord * d3, vec32.zCoord * d3).expand(f9,
			    f9, f9));
	    int i;
	    for (i = 0; i < list.size(); ++i) {
		final Entity entity = (Entity) list.get(i);
		if (entity.canBeCollidedWith()) {
		    final float f10 = entity.getCollisionBorderSize();
		    final AxisAlignedBB axisalignedbb = entity.boundingBox
			    .expand(f10, f10, f10);
		    if (axisalignedbb.isVecInside(vec3))
			flag = true;
		}
	    }
	    if (flag)
		return par1ItemStack;
	    else {
		if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
		    i = movingobjectposition.blockX;
		    int j = movingobjectposition.blockY;
		    final int k = movingobjectposition.blockZ;
		    if (par2World.getBlockId(i, j, k) == Block.snow.blockID)
			--j;
		    final EntityMechanicalHorse entityboat = new EntityMechanicalHorse(
			    par2World);
		    entityboat.rotationYaw = ((MathHelper
			    .floor_double(par3EntityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) - 1) * 90;
		    if (!par2World.getCollidingBoundingBoxes(entityboat,
			    entityboat.boundingBox.expand(-0.1D, -0.1D, -0.1D))
			    .isEmpty())
			return par1ItemStack;
		    if (!par2World.isRemote)
			par2World.spawnEntityInWorld(entityboat);
		    if (!par3EntityPlayer.capabilities.isCreativeMode)
			--par1ItemStack.stackSize;
		}
		return par1ItemStack;
	    }
	}
    }
}
