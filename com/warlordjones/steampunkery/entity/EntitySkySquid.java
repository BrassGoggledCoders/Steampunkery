/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySkySquid extends EntityLiving {
    public float prevSquidPitch;
    /** previous squidRotation in radians. */
    public float prevSquidRotation;
    public float prevSquidYaw;
    /** the last calculated angle of the tentacles in radians */
    public float prevTentacleAngle;

    public float squidPitch;

    /**
     * appears to be rotation in radians; we already have pitch & yaw, so this
     * completes the triumvirate.
     */
    public float squidRotation;

    public float squidYaw;

    /** angle of the tentacles in radians */
    public float tentacleAngle;
    private float field_70871_bB;

    private float randomMotionSpeed;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    /** change in squidRotation in radians. */
    private float rotationVelocity;

    public EntitySkySquid(final World par1World) {
	super(par1World);
	setSize(0.95F, 0.95F);
	rotationVelocity = 0.2F / (rand.nextFloat() + 1.0F) * 0.2F;
    }

    /**
     * Moves the entity based on the specified heading. Args: strafe, forward
     */
    @Override
    public void moveEntityWithHeading(final float par1, final float par2) {
	moveEntity(motionX, motionY, motionZ);
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
	super.onLivingUpdate();
	prevSquidPitch = squidPitch;
	prevSquidYaw = squidYaw;
	prevSquidRotation = squidRotation;
	prevTentacleAngle = tentacleAngle;
	squidRotation += rotationVelocity;

	if (squidRotation > (float) Math.PI * 2F) {
	    squidRotation -= (float) Math.PI * 2F;

	    if (rand.nextInt(10) == 0)
		rotationVelocity = 1.0F / (rand.nextFloat() + 1.0F) * 0.2F;
	}
	float f;

	if (squidRotation < (float) Math.PI) {
	    f = squidRotation / (float) Math.PI;
	    tentacleAngle = MathHelper.sin(f * f * (float) Math.PI)
		    * (float) Math.PI * 0.25F;

	    if (f > 0.75D) {
		randomMotionSpeed = 1.0F;
		field_70871_bB = 1.0F;
	    } else
		field_70871_bB *= 0.8F;
	} else {
	    tentacleAngle = 0.0F;
	    randomMotionSpeed *= 0.9F;
	    field_70871_bB *= 0.99F;
	}

	if (!worldObj.isRemote) {
	    motionX = randomMotionVecX * randomMotionSpeed;
	    motionY = randomMotionVecY * randomMotionSpeed;
	    motionZ = randomMotionVecZ * randomMotionSpeed;
	}

	f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
	renderYawOffset += (-((float) Math.atan2(motionX, motionZ)) * 180.0F
		/ (float) Math.PI - renderYawOffset) * 0.1F;
	rotationYaw = renderYawOffset;
	squidYaw += (float) Math.PI * field_70871_bB * 1.5F;
	squidPitch += (-((float) Math.atan2(f, motionY)) * 180.0F
		/ (float) Math.PI - squidPitch) * 0.1F;
    }

    @Override
    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(
		10.0D);
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they
     * walk on. used for spiders and wolves to prevent them from trampling crops
     */
    @Override
    protected boolean canTriggerWalking() {
	return false;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity
     * has recently been hit by a player. @param par2 - Level of Looting used to
     * kill this mob.
     */
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
	final int j = rand.nextInt(3 + par2) + 1;

	for (int k = 0; k < j; ++k)
	    entityDropItem(new ItemStack(Item.dyePowder, 1, 0), 0.0F);
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
	return null;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected int getDropItemId() {
	return 0;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
	return null;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
	return null;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
	return 0.4F;
    }

    @Override
    protected void updateEntityActionState() {
	++entityAge;

	if (entityAge > 100)
	    randomMotionVecX = randomMotionVecY = randomMotionVecZ = 0.0F;
    }
}
