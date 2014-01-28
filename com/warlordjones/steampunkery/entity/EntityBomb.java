package com.warlordjones.steampunkery.entity;

import com.warlordjones.steampunkery.blocks.Bomb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBomb extends Entity {
    public int blockID;
    public NBTTagCompound fallingBlockTileEntityData;

    /** How long the block has been falling for. */
    public int fallTime;
    public int metadata;

    public boolean shouldDropItem;

    /** Actual damage dealt to entities hit by falling block */
    private float fallHurtAmount;
    /** Maximum amount of damage dealt to entities hit by falling block */
    private int fallHurtMax;

    public EntityBomb(final World par1World) {
	super(par1World);
	shouldDropItem = true;
	fallHurtMax = 40;
	fallHurtAmount = 2.0F;
    }

    public EntityBomb(final World par1World, final double par2,
	    final double par4, final double par6, final int par8) {
	this(par1World, par2, par4, par6, par8, 0);
    }

    public EntityBomb(final World par1World, final double par2,
	    final double par4, final double par6, final int par8, final int par9) {
	super(par1World);
	shouldDropItem = true;
	fallHurtMax = 40;
	fallHurtAmount = 2.0F;
	blockID = par8;
	metadata = par9;
	preventEntitySpawning = true;
	setSize(0.98F, 0.98F);
	yOffset = height / 2.0F;
	setPosition(par2, par4, par6);
	motionX = 0.0D;
	motionY = 0.0D;
	motionZ = 0.0D;
	prevPosX = par2;
	prevPosY = par4;
	prevPosZ = par6;
    }

    /**
     * Returns true if other Entities should be prevented from moving through
     * this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
	return !isDead;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Return whether this entity should be rendered as on fire.
     */
    public boolean canRenderOnFire() {
	return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
	return 0.0F;
    }

    @SideOnly(Side.CLIENT)
    public World getWorld() {
	return worldObj;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
	if (blockID == 0)
	    setDead();
	else {
	    prevPosX = posX;
	    prevPosY = posY;
	    prevPosZ = posZ;
	    ++fallTime;
	    motionY -= 0.03999999910593033D;
	    moveEntity(motionX, motionY, motionZ);
	    motionX *= 0.9800000190734863D;
	    motionY *= 0.9800000190734863D;
	    motionZ *= 0.9800000190734863D;

	    if (!worldObj.isRemote) {
		final int i = MathHelper.floor_double(posX);
		final int j = MathHelper.floor_double(posY);
		final int k = MathHelper.floor_double(posZ);

		if (fallTime == 1) {
		    if (worldObj.getBlockId(i, j, k) != blockID) {
			setDead();
			return;
		    }

		    worldObj.setBlockToAir(i, j, k);
		}

		if (onGround) {
		    motionX *= 0.699999988079071D;
		    motionZ *= 0.699999988079071D;
		    motionY *= -0.5D;
		    if (Block.blocksList[blockID] instanceof Bomb) {
			((Bomb) Block.blocksList[blockID]).onFinishFalling(
				worldObj, i, j, k, metadata);
			worldObj.createExplosion(this, posX, posY, posZ, 10,
				true);
			setDead();
		    }
		}
	    }
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
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    @Override
    protected void fall(final float par1) {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    protected void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
	if (par1NBTTagCompound.hasKey("TileID"))
	    blockID = par1NBTTagCompound.getInteger("TileID");
	else
	    blockID = par1NBTTagCompound.getByte("Tile") & 255;

	metadata = par1NBTTagCompound.getByte("Data") & 255;
	fallTime = par1NBTTagCompound.getByte("Time") & 255;

	if (par1NBTTagCompound.hasKey("HurtEntities")) {
	    fallHurtAmount = par1NBTTagCompound.getFloat("FallHurtAmount");
	    fallHurtMax = par1NBTTagCompound.getInteger("FallHurtMax");
	}

	if (par1NBTTagCompound.hasKey("DropItem"))
	    shouldDropItem = par1NBTTagCompound.getBoolean("DropItem");

	if (par1NBTTagCompound.hasKey("TileEntityData"))
	    fallingBlockTileEntityData = par1NBTTagCompound
		    .getCompoundTag("TileEntityData");

	if (blockID == 0)
	    blockID = Block.sand.blockID;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    protected void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
	par1NBTTagCompound.setByte("Tile", (byte) blockID);
	par1NBTTagCompound.setInteger("TileID", blockID);
	par1NBTTagCompound.setByte("Data", (byte) metadata);
	par1NBTTagCompound.setByte("Time", (byte) fallTime);
	par1NBTTagCompound.setBoolean("DropItem", shouldDropItem);
	par1NBTTagCompound.setFloat("FallHurtAmount", fallHurtAmount);
	par1NBTTagCompound.setInteger("FallHurtMax", fallHurtMax);

	if (fallingBlockTileEntityData != null)
	    par1NBTTagCompound.setCompoundTag("TileEntityData",
		    fallingBlockTileEntityData);
    }
}
