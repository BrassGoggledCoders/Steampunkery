package com.warlordjones.steampunkery.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySkySquid extends EntityLiving {
    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;

    /**
     * appears to be rotation in radians; we already have pitch & yaw, so this
     * completes the triumvirate.
     */
    public float squidRotation;

    /** previous squidRotation in radians. */
    public float prevSquidRotation;

    /** angle of the tentacles in radians */
    public float tentacleAngle;

    /** the last calculated angle of the tentacles in radians */
    public float prevTentacleAngle;
    private float randomMotionSpeed;

    /** change in squidRotation in radians. */
    private float rotationVelocity;
    private float field_70871_bB;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntitySkySquid(World par1World) {
	super(par1World);
	this.setSize(0.95F, 0.95F);
	this.rotationVelocity = 0.2F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
		.setAttribute(10.0D);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound() {
	return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound() {
	return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound() {
	return null;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
	return 0.4F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId() {
	return 0;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they
     * walk on. used for spiders and wolves to prevent them from trampling crops
     */
    protected boolean canTriggerWalking() {
	return false;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity
     * has recently been hit by a player. @param par2 - Level of Looting used to
     * kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2) {
	int j = this.rand.nextInt(3 + par2) + 1;

	for (int k = 0; k < j; ++k) {
	    this.entityDropItem(new ItemStack(Item.dyePowder, 1, 0), 0.0F);
	}
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    public void onLivingUpdate() {
	super.onLivingUpdate();
	this.prevSquidPitch = this.squidPitch;
	this.prevSquidYaw = this.squidYaw;
	this.prevSquidRotation = this.squidRotation;
	this.prevTentacleAngle = this.tentacleAngle;
	this.squidRotation += this.rotationVelocity;

	if (this.squidRotation > ((float) Math.PI * 2F)) {
	    this.squidRotation -= ((float) Math.PI * 2F);

	    if (this.rand.nextInt(10) == 0) {
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
	    }
	}
	float f;

	if (this.squidRotation < (float) Math.PI) {
	    f = this.squidRotation / (float) Math.PI;
	    this.tentacleAngle = MathHelper.sin(f * f * (float) Math.PI)
		    * (float) Math.PI * 0.25F;

	    if ((double) f > 0.75D) {
		this.randomMotionSpeed = 1.0F;
		this.field_70871_bB = 1.0F;
	    } else {
		this.field_70871_bB *= 0.8F;
	    }
	} else {
	    this.tentacleAngle = 0.0F;
	    this.randomMotionSpeed *= 0.9F;
	    this.field_70871_bB *= 0.99F;
	}

	if (!this.worldObj.isRemote) {
	    this.motionX = (double) (this.randomMotionVecX * this.randomMotionSpeed);
	    this.motionY = (double) (this.randomMotionVecY * this.randomMotionSpeed);
	    this.motionZ = (double) (this.randomMotionVecZ * this.randomMotionSpeed);
	}

	f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ
		* this.motionZ);
	this.renderYawOffset += (-((float) Math.atan2(this.motionX,
		this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.1F;
	this.rotationYaw = this.renderYawOffset;
	this.squidYaw += (float) Math.PI * this.field_70871_bB * 1.5F;
	this.squidPitch += (-((float) Math.atan2((double) f, this.motionY))
		* 180.0F / (float) Math.PI - this.squidPitch) * 0.1F;
    }

    /**
     * Moves the entity based on the specified heading. Args: strafe, forward
     */
    public void moveEntityWithHeading(float par1, float par2) {
	this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    protected void updateEntityActionState() {
	++this.entityAge;

	if (this.entityAge > 100) {
	    this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
	}
    }
}
