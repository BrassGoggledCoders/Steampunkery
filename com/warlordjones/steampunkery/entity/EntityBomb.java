package com.warlordjones.steampunkery.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.blocks.Bomb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityBomb extends Entity {
    public int blockID;
    public int metadata;

    /** How long the block has been falling for. */
    public int fallTime;
    public boolean shouldDropItem;

    /** Maximum amount of damage dealt to entities hit by falling block */
    private int fallHurtMax;

    /** Actual damage dealt to entities hit by falling block */
    private float fallHurtAmount;
    public NBTTagCompound fallingBlockTileEntityData;

    public EntityBomb(World par1World) {
	super(par1World);
	this.shouldDropItem = true;
	this.fallHurtMax = 40;
	this.fallHurtAmount = 2.0F;
    }

    public EntityBomb(World par1World, double par2, double par4, double par6,
	    int par8) {
	this(par1World, par2, par4, par6, par8, 0);
    }

    public EntityBomb(World par1World, double par2, double par4, double par6,
	    int par8, int par9) {
	super(par1World);
	this.shouldDropItem = true;
	this.fallHurtMax = 40;
	this.fallHurtAmount = 2.0F;
	this.blockID = par8;
	this.metadata = par9;
	this.preventEntitySpawning = true;
	this.setSize(0.98F, 0.98F);
	this.yOffset = this.height / 2.0F;
	this.setPosition(par2, par4, par6);
	this.motionX = 0.0D;
	this.motionY = 0.0D;
	this.motionZ = 0.0D;
	this.prevPosX = par2;
	this.prevPosY = par4;
	this.prevPosZ = par6;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they
     * walk on. used for spiders and wolves to prevent them from trampling crops
     */
    protected boolean canTriggerWalking() {
	return false;
    }

    protected void entityInit() {
    }

    /**
     * Returns true if other Entities should be prevented from moving through
     * this Entity.
     */
    public boolean canBeCollidedWith() {
	return !this.isDead;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
	if (this.blockID == 0) {
	    this.setDead();
	} else {
	    this.prevPosX = this.posX;
	    this.prevPosY = this.posY;
	    this.prevPosZ = this.posZ;
	    ++this.fallTime;
	    this.motionY -= 0.03999999910593033D;
	    this.moveEntity(this.motionX, this.motionY, this.motionZ);
	    this.motionX *= 0.9800000190734863D;
	    this.motionY *= 0.9800000190734863D;
	    this.motionZ *= 0.9800000190734863D;

	    if (!this.worldObj.isRemote) {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if (this.fallTime == 1) {
		    if (this.worldObj.getBlockId(i, j, k) != this.blockID) {
			this.setDead();
			return;
		    }

		    this.worldObj.setBlockToAir(i, j, k);
		}

		if (this.onGround) {
		    this.motionX *= 0.699999988079071D;
		    this.motionZ *= 0.699999988079071D;
		    this.motionY *= -0.5D;
		    if (Block.blocksList[this.blockID] instanceof Bomb) {
			((Bomb) Block.blocksList[this.blockID])
				.onFinishFalling(this.worldObj, i, j, k,
					this.metadata);
			this.worldObj.createExplosion(this, this.posX,
				this.posY, this.posZ, 10, true);
			this.setDead();
		    }
		}
	    }
	}
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
	par1NBTTagCompound.setByte("Tile", (byte) this.blockID);
	par1NBTTagCompound.setInteger("TileID", this.blockID);
	par1NBTTagCompound.setByte("Data", (byte) this.metadata);
	par1NBTTagCompound.setByte("Time", (byte) this.fallTime);
	par1NBTTagCompound.setBoolean("DropItem", this.shouldDropItem);
	par1NBTTagCompound.setFloat("FallHurtAmount", this.fallHurtAmount);
	par1NBTTagCompound.setInteger("FallHurtMax", this.fallHurtMax);

	if (this.fallingBlockTileEntityData != null) {
	    par1NBTTagCompound.setCompoundTag("TileEntityData",
		    this.fallingBlockTileEntityData);
	}
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
	if (par1NBTTagCompound.hasKey("TileID")) {
	    this.blockID = par1NBTTagCompound.getInteger("TileID");
	} else {
	    this.blockID = par1NBTTagCompound.getByte("Tile") & 255;
	}

	this.metadata = par1NBTTagCompound.getByte("Data") & 255;
	this.fallTime = par1NBTTagCompound.getByte("Time") & 255;

	if (par1NBTTagCompound.hasKey("HurtEntities")) {
	    this.fallHurtAmount = par1NBTTagCompound.getFloat("FallHurtAmount");
	    this.fallHurtMax = par1NBTTagCompound.getInteger("FallHurtMax");
	}

	if (par1NBTTagCompound.hasKey("DropItem")) {
	    this.shouldDropItem = par1NBTTagCompound.getBoolean("DropItem");
	}

	if (par1NBTTagCompound.hasKey("TileEntityData")) {
	    this.fallingBlockTileEntityData = par1NBTTagCompound
		    .getCompoundTag("TileEntityData");
	}

	if (this.blockID == 0) {
	    this.blockID = Block.sand.blockID;
	}
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
	return 0.0F;
    }

    @SideOnly(Side.CLIENT)
    public World getWorld() {
	return this.worldObj;
    }

    @SideOnly(Side.CLIENT)
    /**
     * Return whether this entity should be rendered as on fire.
     */
    public boolean canRenderOnFire() {
	return false;
    }
}
