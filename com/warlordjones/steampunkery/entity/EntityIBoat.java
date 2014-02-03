/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity;

import java.util.List;

import com.warlordjones.steampunkery.items.SteamItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityIBoat extends Entity {
    private double boatPitch;
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatYaw;
    private double boatZ;
    private boolean field_70279_a;
    private double speedMultiplier;
    @SideOnly(Side.CLIENT)
    private double velocityX;
    @SideOnly(Side.CLIENT)
    private double velocityY;
    @SideOnly(Side.CLIENT)
    private double velocityZ;

    public EntityIBoat(final World par1World) {
	super(par1World);
	field_70279_a = true;
	speedMultiplier = 0.5D;
	preventEntitySpawning = true;
	setSize(1.5F, 0.6F);
	yOffset = height / 2.0F;
    }

    public EntityIBoat(final World par1World, final double par2,
	    final double par4, final double par6) {
	this(par1World);
	setPosition(par2, par4 + yOffset, par6);
	motionX = 0.0D;
	motionY = 0.0D;
	motionZ = 0.0D;
	prevPosX = par2;
	prevPosY = par4;
	prevPosZ = par6;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(final DamageSource par1DamageSource,
	    final float par2) {
	if (isEntityInvulnerable())
	    return false;
	else if (!worldObj.isRemote && !isDead) {
	    setForwardDirection(-getForwardDirection());
	    setTimeSinceHit(10);
	    setDamageTaken(getDamageTaken() + par2 * 10.0F);
	    setBeenAttacked();
	    final boolean flag = par1DamageSource.getEntity() instanceof EntityPlayer
		    && ((EntityPlayer) par1DamageSource.getEntity()).capabilities.isCreativeMode;
	    if (flag || getDamageTaken() > 20.0F) {
		if (riddenByEntity != null)
		    riddenByEntity.mountEntity(this);
		if (!flag)
		    dropItemWithOffset(SteamItems.iboat.itemID, 1, 0.0F);
		setDead();
	    }
	    return true;
	} else
	    return true;
    }

    /**
     * Returns true if other Entities should be prevented from moving through
     * this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
	return !isDead;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities
     * when colliding.
     */
    @Override
    public boolean canBePushed() {
	return true;
    }

    @SideOnly(Side.CLIENT)
    public void func_70270_d(final boolean par1) {
	field_70279_a = par1;
    }

    /**
     * returns the bounding box for this entity
     */
    @Override
    public AxisAlignedBB getBoundingBox() {
	return boundingBox;
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and
     * blocks. This enables the entity to be pushable on contact, like boats or
     * minecarts.
     */
    @Override
    public AxisAlignedBB getCollisionBox(final Entity par1Entity) {
	return par1Entity.boundingBox;
    }

    /**
     * Gets the damage taken from the last hit.
     */
    public float getDamageTaken() {
	return dataWatcher.getWatchableObjectFloat(19);
    }

    /**
     * Gets the forward direction of the entity.
     */
    public int getForwardDirection() {
	return dataWatcher.getWatchableObjectInt(18);
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding
     * this one.
     */
    @Override
    public double getMountedYOffset() {
	return height * 0.0D - 0.30000001192092896D;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
	return 0.0F;
    }

    /**
     * Gets the time since the last hit.
     */
    public int getTimeSinceHit() {
	return dataWatcher.getWatchableObjectInt(17);
    }

    /**
     * First layer of player interaction
     */
    @Override
    public boolean interactFirst(final EntityPlayer par1EntityPlayer) {
	if (riddenByEntity != null && riddenByEntity instanceof EntityPlayer
		&& riddenByEntity != par1EntityPlayer)
	    return true;
	else {
	    if (!worldObj.isRemote)
		par1EntityPlayer.mountEntity(this);
	    return true;
	}
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
	super.onUpdate();
	if (getTimeSinceHit() > 0)
	    setTimeSinceHit(getTimeSinceHit() - 1);
	if (getDamageTaken() > 0.0F)
	    setDamageTaken(getDamageTaken() - 1.0F);
	prevPosX = posX;
	prevPosY = posY;
	prevPosZ = posZ;
	final byte b0 = 5;
	double d0 = 0.0D;
	for (int i = 0; i < b0; ++i) {
	    final double d1 = boundingBox.minY
		    + (boundingBox.maxY - boundingBox.minY) * (i + 0) / b0
		    - 0.125D;
	    final double d2 = boundingBox.minY
		    + (boundingBox.maxY - boundingBox.minY) * (i + 1) / b0
		    - 0.125D;
	    final AxisAlignedBB axisalignedbb = AxisAlignedBB.getAABBPool()
		    .getAABB(boundingBox.minX, d1, boundingBox.minZ,
			    boundingBox.maxX, d2, boundingBox.maxZ);
	    if (worldObj.isAABBInMaterial(axisalignedbb, Material.water))
		d0 += 1.0D / b0;
	}
	final double d3 = Math.sqrt(motionX * motionX + motionZ * motionZ);
	double d4;
	double d5;
	if (d3 > 0.26249999999999996D) {
	    d4 = Math.cos(rotationYaw * Math.PI / 180.0D);
	    d5 = Math.sin(rotationYaw * Math.PI / 180.0D);
	    for (int j = 0; j < 1.0D + d3 * 60.0D; ++j) {
		final double d6 = rand.nextFloat() * 2.0F - 1.0F;
		final double d7 = (rand.nextInt(2) * 2 - 1) * 0.7D;
		double d8;
		double d9;
		if (rand.nextBoolean()) {
		    d8 = posX - d4 * d6 * 0.8D + d5 * d7;
		    d9 = posZ - d5 * d6 * 0.8D - d4 * d7;
		    worldObj.spawnParticle("splash", d8, posY - 0.125D, d9,
			    motionX, motionY, motionZ);
		} else {
		    d8 = posX + d4 + d5 * d6 * 0.7D;
		    d9 = posZ + d5 - d4 * d6 * 0.7D;
		    worldObj.spawnParticle("splash", d8, posY - 0.125D, d9,
			    motionX, motionY, motionZ);
		}
	    }
	}
	double d10;
	double d11;
	if (worldObj.isRemote && field_70279_a) {
	    if (boatPosRotationIncrements > 0) {
		d4 = posX + (boatX - posX) / boatPosRotationIncrements;
		d5 = posY + (boatY - posY) / boatPosRotationIncrements;
		d11 = posZ + (boatZ - posZ) / boatPosRotationIncrements;
		d10 = MathHelper.wrapAngleTo180_double(boatYaw - rotationYaw);
		rotationYaw = (float) (rotationYaw + d10
			/ boatPosRotationIncrements);
		rotationPitch = (float) (rotationPitch + (boatPitch - rotationPitch)
			/ boatPosRotationIncrements);
		--boatPosRotationIncrements;
		setPosition(d4, d5, d11);
		setRotation(rotationYaw, rotationPitch);
	    } else {
		d4 = posX + motionX;
		d5 = posY + motionY;
		d11 = posZ + motionZ;
		setPosition(d4, d5, d11);
		if (onGround) {
		    motionX *= 0.5D;
		    motionY *= 0.5D;
		    motionZ *= 0.5D;
		}
		motionX *= 0.9900000095367432D;
		motionY *= 0.949999988079071D;
		motionZ *= 0.9900000095367432D;
	    }
	} else {
	    if (d0 < 1.0D) {
		d4 = d0 * 2.0D - 1.0D;
		motionY += 0.03999999910593033D * d4;
	    } else {
		if (motionY < 0.0D)
		    motionY /= 2.0D;
		motionY += 0.007000000216066837D;
	    }
	    if (riddenByEntity != null
		    && riddenByEntity instanceof EntityLivingBase) {
		d4 = ((EntityLivingBase) riddenByEntity).moveForward;
		if (d4 > 0.0D) {
		    d5 = -Math.sin(riddenByEntity.rotationYaw * (float) Math.PI
			    / 180.0F);
		    d11 = Math.cos(riddenByEntity.rotationYaw * (float) Math.PI
			    / 180.0F);
		    motionX += d5 * speedMultiplier * 0.05000000074505806D;
		    motionZ += d11 * speedMultiplier * 0.05000000074505806D;
		}
	    }
	    d4 = Math.sqrt(motionX * motionX + motionZ * motionZ);
	    if (d4 > 0.35D) {
		d5 = 0.35D / d4;
		motionX *= d5;
		motionZ *= d5;
		d4 = 0.35D;
	    }
	    if (d4 > d3 && speedMultiplier < 0.35D) {
		speedMultiplier += (0.35D - speedMultiplier) / 35.0D;
		if (speedMultiplier > 0.35D)
		    speedMultiplier = 0.35D;
	    } else {
		speedMultiplier -= (speedMultiplier - 0.07D) / 35.0D;
		if (speedMultiplier < 0.07D)
		    speedMultiplier = 0.07D;
	    }
	    if (onGround) {
		motionX *= 0.5D;
		motionY *= 0.5D;
		motionZ *= 0.5D;
	    }
	    moveEntity(motionX, motionY, motionZ);
	    if (isCollidedHorizontally && d3 > 0.2D) {
		if (!worldObj.isRemote && !isDead) {
		    setDead();
		    dropItemWithOffset(SteamItems.iboat.itemID, 1, 0.0F);
		}
	    } else {
		motionX *= 0.9900000095367432D;
		motionY *= 0.949999988079071D;
		motionZ *= 0.9900000095367432D;
	    }
	    rotationPitch = 0.0F;
	    d5 = rotationYaw;
	    d11 = prevPosX - posX;
	    d10 = prevPosZ - posZ;
	    if (d11 * d11 + d10 * d10 > 0.001D)
		d5 = (float) (Math.atan2(d10, d11) * 180.0D / Math.PI);
	    double d12 = MathHelper.wrapAngleTo180_double(d5 - rotationYaw);
	    if (d12 > 20.0D)
		d12 = 20.0D;
	    if (d12 < -20.0D)
		d12 = -20.0D;
	    rotationYaw = (float) (rotationYaw + d12);
	    setRotation(rotationYaw, rotationPitch);
	    if (!worldObj.isRemote) {
		final List list = worldObj
			.getEntitiesWithinAABBExcludingEntity(this, boundingBox
				.expand(0.20000000298023224D, 0.0D,
					0.20000000298023224D));
		int l;
		if (list != null && !list.isEmpty())
		    for (l = 0; l < list.size(); ++l) {
			final Entity entity = (Entity) list.get(l);
			if (entity != riddenByEntity && entity.canBePushed()
				&& entity instanceof EntityIBoat)
			    entity.applyEntityCollision(this);
		    }
		for (l = 0; l < 4; ++l) {
		    final int i1 = MathHelper.floor_double(posX
			    + (l % 2 - 0.5D) * 0.8D);
		    final int j1 = MathHelper.floor_double(posZ
			    + (l / 2 - 0.5D) * 0.8D);
		    for (int k1 = 0; k1 < 2; ++k1) {
			final int l1 = MathHelper.floor_double(posY) + k1;
			final int i2 = worldObj.getBlockId(i1, l1, j1);
			if (i2 == Block.snow.blockID)
			    worldObj.setBlockToAir(i1, l1, j1);
			else if (i2 == Block.waterlily.blockID)
			    worldObj.destroyBlock(i1, l1, j1, true);
		    }
		}
		if (riddenByEntity != null && riddenByEntity.isDead)
		    riddenByEntity = null;
	    }
	}
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    public void performHurtAnimation() {
	setForwardDirection(-getForwardDirection());
	setTimeSinceHit(10);
	setDamageTaken(getDamageTaken() * 11.0F);
    }

    /**
     * Sets the damage taken from the last hit.
     */
    public void setDamageTaken(final float par1) {
	dataWatcher.updateObject(19, Float.valueOf(par1));
    }

    /**
     * Sets the forward direction of the entity.
     */
    public void setForwardDirection(final int par1) {
	dataWatcher.updateObject(18, Integer.valueOf(par1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX,
     * posY, posZ, yaw, pitch
     */
    public void setPositionAndRotation2(final double par1, final double par3,
	    final double par5, final float par7, final float par8,
	    final int par9) {
	if (field_70279_a)
	    boatPosRotationIncrements = par9 + 5;
	else {
	    final double d3 = par1 - posX;
	    final double d4 = par3 - posY;
	    final double d5 = par5 - posZ;
	    final double d6 = d3 * d3 + d4 * d4 + d5 * d5;
	    if (d6 <= 1.0D)
		return;
	    boatPosRotationIncrements = 3;
	}
	boatX = par1;
	boatY = par3;
	boatZ = par5;
	boatYaw = par7;
	boatPitch = par8;
	motionX = velocityX;
	motionY = velocityY;
	motionZ = velocityZ;
    }

    /**
     * Sets the time to count down from since the last time entity was hit.
     */
    public void setTimeSinceHit(final int par1) {
	dataWatcher.updateObject(17, Integer.valueOf(par1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    public void setVelocity(final double par1, final double par3,
	    final double par5) {
	velocityX = motionX = par1;
	velocityY = motionY = par3;
	velocityZ = motionZ = par5;
    }

    @Override
    public void updateRiderPosition() {
	if (riddenByEntity != null) {
	    final double d0 = Math.cos(rotationYaw * Math.PI / 180.0D) * 0.4D;
	    final double d1 = Math.sin(rotationYaw * Math.PI / 180.0D) * 0.4D;
	    riddenByEntity.setPosition(posX + d0, posY + getMountedYOffset()
		    + riddenByEntity.getYOffset(), posZ + d1);
	}
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they
     * walk on. used for spiders and wolves to prevent them from trampling crops
     */
    @Override
    protected boolean canTriggerWalking() {
	return false;
    }

    @Override
    protected void entityInit() {
	dataWatcher.addObject(17, new Integer(0));
	dataWatcher.addObject(18, new Integer(1));
	dataWatcher.addObject(19, new Float(0.0F));
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    protected void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    protected void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
    }
}
