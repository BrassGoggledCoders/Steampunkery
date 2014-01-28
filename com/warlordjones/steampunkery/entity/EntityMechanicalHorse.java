package com.warlordjones.steampunkery.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityHorseGroupData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMechanicalHorse extends EntityCreature {
    private static final Attribute horseJumpStrength = new RangedAttribute(
	    "horse.jumpStrength", 0.7D, 0.0D, 2.0D).func_111117_a(
	    "Jump Strength").setShouldWatch(true);

    public static boolean func_110211_v(final int par0) {
	return par0 == Item.horseArmorIron.itemID
		|| par0 == Item.horseArmorGold.itemID
		|| par0 == Item.horseArmorDiamond.itemID;
    }

    private int field_110285_bP;
    private boolean field_110294_bI;
    private float prevRearingAmount;
    protected float jumpPower;

    public EntityMechanicalHorse(final World par1World) {
	super(par1World);
	setSize(0.9F, 1F);
	isImmuneToFire = false;
	getNavigator().setAvoidsWater(true);
	tasks.addTask(0, new EntityAISwimming(this));
	tasks.addTask(1, new EntityAIPanic(this, 1.2D));
	tasks.addTask(6, new EntityAIWander(this, 0.7D));
	tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class,
		6.0F));
	tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    public boolean allowLeashing() {
	return super.allowLeashing();
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(final DamageSource par1DamageSource,
	    final float par2) {
	final Entity entity = par1DamageSource.getEntity();
	return riddenByEntity != null && riddenByEntity.equals(entity) ? false
		: super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Returns true if this entity should push and be pushed by other entities
     * when colliding.
     */
    @Override
    public boolean canBePushed() {
	return riddenByEntity == null;
    }

    public boolean func_110205_ce() {
	return getHorseWatchableBoolean(16);
    }

    public boolean func_110229_cs() {
	final int i = getHorseType();
	return i == 2 || i == 1;
    }

    public void func_110236_r(final int par1) {
	dataWatcher.updateObject(22, Integer.valueOf(par1));
	func_110230_cF();
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110239_cn() {
	return getHorseType() == 0 || func_110241_cb() > 0;
    }

    public int func_110241_cb() {
	return dataWatcher.getWatchableObjectInt(22);
    }

    public void func_110242_l(final boolean par1) {
	setHorseWatchableBoolean(16, par1);
    }

    public boolean func_110259_cr() {
	return getHorseType() == 3;
    }

    /**
     * Gets the username of the entity.
     */
    @Override
    public String getEntityName() {
	return "mechanical_horse";
    }

    public double getHorseJumpStrength() {
	return getEntityAttribute(EntityMechanicalHorse.horseJumpStrength)
		.getAttributeValue();
    }

    /**
     * returns the horse type
     */
    public int getHorseType() {
	return dataWatcher.getWatchableObjectByte(19);
    }

    public int getHorseVariant() {
	return dataWatcher.getWatchableObjectInt(20);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk() {
	return 6;
    }

    public int getMaxTemper() {
	return 100;
    }

    public String getOwnerName() {
	return dataWatcher.getWatchableObjectString(21);
    }

    /**
     * Get number of ticks, at least during which the living entity will be
     * silent.
     */
    @Override
    public int getTalkInterval() {
	return 400;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
	if (par1 == 7)
	    spawnHorseParticles(true);
	else if (par1 == 6)
	    spawnHorseParticles(false);
	else
	    super.handleHealthUpdate(par1);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     */
    @Override
    public boolean interact(final EntityPlayer par1EntityPlayer) {
	return false;
    }

    public boolean isHorseJumping() {
	return isJumping;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean isOnLadder() {
	return false;
    }

    public boolean isTame() {
	return true;
    }

    /**
     * Moves the entity based on the specified heading. Args: strafe, forward
     */
    @Override
    public void moveEntityWithHeading(float par1, float par2) {
	if (riddenByEntity != null) {
	    prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw;
	    rotationPitch = riddenByEntity.rotationPitch * 0.5F;
	    setRotation(rotationYaw, rotationPitch);
	    rotationYawHead = renderYawOffset = rotationYaw;
	    par1 = ((EntityLivingBase) riddenByEntity).moveStrafing * 0.5F;
	    par2 = ((EntityLivingBase) riddenByEntity).moveForward;

	    if (par2 <= 0.0F) {
		par2 *= 0.25F;
		field_110285_bP = 0;
	    }

	    if (onGround && jumpPower == 0.0F && !field_110294_bI) {
		par1 = 0.0F;
		par2 = 0.0F;
	    }

	    if (jumpPower > 0.0F && !isHorseJumping() && onGround) {
		motionY = getHorseJumpStrength() * jumpPower;

		if (this.isPotionActive(Potion.jump))
		    motionY += (getActivePotionEffect(Potion.jump)
			    .getAmplifier() + 1) * 0.1F;

		setHorseJumping(true);
		isAirBorne = true;

		if (par2 > 0.0F) {
		    final float f2 = MathHelper.sin(rotationYaw
			    * (float) Math.PI / 180.0F);
		    final float f3 = MathHelper.cos(rotationYaw
			    * (float) Math.PI / 180.0F);
		    motionX += -0.4F * f2 * jumpPower;
		    motionZ += 0.4F * f3 * jumpPower;
		    playSound("mob.horse.jump", 0.4F, 1.0F);
		}

		jumpPower = 0.0F;
	    }

	    stepHeight = 1.0F;
	    jumpMovementFactor = getAIMoveSpeed() * 0.1F;

	    if (!worldObj.isRemote) {
		setAIMoveSpeed((float) getEntityAttribute(
			SharedMonsterAttributes.movementSpeed)
			.getAttributeValue());
		super.moveEntityWithHeading(par1, par2);
	    }

	    if (onGround) {
		jumpPower = 0.0F;
		setHorseJumping(false);
	    }

	    prevLimbSwingAmount = limbSwingAmount;
	    final double d0 = posX - prevPosX;
	    final double d1 = posZ - prevPosZ;
	    float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

	    if (f4 > 1.0F)
		f4 = 1.0F;

	    limbSwingAmount += (f4 - limbSwingAmount) * 0.4F;
	    limbSwing += limbSwingAmount;
	} else {
	    stepHeight = 0.5F;
	    jumpMovementFactor = 0.02F;
	    super.moveEntityWithHeading(par1, par2);
	}
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(final DamageSource par1DamageSource) {
	super.onDeath(par1DamageSource);

	if (!worldObj.isRemote) {

	}
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {

	super.onLivingUpdate();

	if (!worldObj.isRemote) {

	}
    }

    @Override
    public EntityLivingData onSpawnWithEgg(
	    final EntityLivingData par1EntityLivingData) {
	Object par1EntityLivingData1 = super
		.onSpawnWithEgg(par1EntityLivingData);
	int i = 0;
	int j;

	if (par1EntityLivingData1 instanceof EntityHorseGroupData) {
	    j = ((EntityHorseGroupData) par1EntityLivingData1).field_111107_a;
	    i = ((EntityHorseGroupData) par1EntityLivingData1).field_111106_b
		    & 255 | rand.nextInt(5) << 8;
	} else {
	    if (rand.nextInt(10) == 0)
		j = 1;
	    else {
		final int k = rand.nextInt(7);
		final int l = rand.nextInt(5);
		j = 0;
		i = k | l << 8;
	    }

	    par1EntityLivingData1 = new EntityHorseGroupData(j, i);
	}

	setHorseType(j);
	setHorseVariant(i);

	if (j != 4 && j != 3) {
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(
		    func_110267_cL());

	    if (j == 0)
		getEntityAttribute(SharedMonsterAttributes.movementSpeed)
			.setAttribute(func_110203_cN());
	    else
		getEntityAttribute(SharedMonsterAttributes.movementSpeed)
			.setAttribute(0.17499999701976776D);
	} else {
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(
		    15.0D);
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		    .setAttribute(0.20000000298023224D);
	}

	if (j != 2 && j != 1)
	    getEntityAttribute(EntityMechanicalHorse.horseJumpStrength)
		    .setAttribute(func_110245_cM());
	else
	    getEntityAttribute(EntityMechanicalHorse.horseJumpStrength)
		    .setAttribute(0.5D);

	setHealth(getMaxHealth());
	return (EntityLivingData) par1EntityLivingData1;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
	super.onUpdate();

	if (worldObj.isRemote && dataWatcher.hasChanges()) {
	    dataWatcher.func_111144_e();
	    func_110230_cF();
	}
    }

    public boolean prepareChunkForSpawn() {
	final int i = MathHelper.floor_double(posX);
	final int j = MathHelper.floor_double(posZ);
	worldObj.getBiomeGenForCoords(i, j);
	return true;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
	super.readEntityFromNBT(par1NBTTagCompound);
    }

    public void setChested(final boolean par1) {
	setHorseWatchableBoolean(8, par1);
    }

    public void setHorseJumping(final boolean par1) {
	isJumping = par1;
    }

    public void setHorseSaddled(final boolean par1) {
	setHorseWatchableBoolean(4, par1);
    }

    public void setHorseTamed(final boolean par1) {
	setHorseWatchableBoolean(2, par1);
    }

    public void setHorseType(final int par1) {
	dataWatcher.updateObject(19, Byte.valueOf((byte) par1));
	func_110230_cF();
    }

    public void setHorseVariant(final int par1) {
	dataWatcher.updateObject(20, Integer.valueOf(par1));
	func_110230_cF();
    }

    public void setJumpPower(int par1) {
	if (par1 < 0)
	    par1 = 0;
	else
	    field_110294_bI = true;

	if (par1 >= 90)
	    jumpPower = 1.0F;
	else
	    jumpPower = 0.4F + 0.4F * par1 / 90.0F;
    }

    public void setOwnerName(final String par1Str) {
	dataWatcher.updateObject(21, par1Str);
    }

    @Override
    public void updateRiderPosition() {
	super.updateRiderPosition();

	if (prevRearingAmount > 0.0F) {
	    final float f = MathHelper.sin(renderYawOffset * (float) Math.PI
		    / 180.0F);
	    final float f1 = MathHelper.cos(renderYawOffset * (float) Math.PI
		    / 180.0F);
	    final float f2 = 0.7F * prevRearingAmount;
	    final float f3 = 0.15F * prevRearingAmount;
	    riddenByEntity.setPosition(posX + f2 * f, posY
		    + getMountedYOffset() + riddenByEntity.getYOffset() + f3,
		    posZ - f2 * f1);

	    if (riddenByEntity instanceof EntityLivingBase)
		((EntityLivingBase) riddenByEntity).renderYawOffset = renderYawOffset;
	}
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
	super.writeEntityToNBT(par1NBTTagCompound);
	par1NBTTagCompound.setInteger("Type", getHorseType());
	par1NBTTagCompound.setInteger("Variant", getHorseVariant());
	par1NBTTagCompound.setBoolean("Tame", isTame());
	par1NBTTagCompound.setString("OwnerName", getOwnerName());
    }

    private double func_110203_cN() {
	return (0.44999998807907104D + rand.nextDouble() * 0.3D
		+ rand.nextDouble() * 0.3D + rand.nextDouble() * 0.3D) * 0.25D;
    }

    private void func_110230_cF() {
    }

    private double func_110245_cM() {
	return 0.4000000059604645D + rand.nextDouble() * 0.2D
		+ rand.nextDouble() * 0.2D + rand.nextDouble() * 0.2D;
    }

    private float func_110267_cL() {
	return 15.0F + rand.nextInt(8) + rand.nextInt(9);
    }

    private boolean getHorseWatchableBoolean(final int par1) {
	return (dataWatcher.getWatchableObjectInt(16) & par1) != 0;
    }

    private void setHorseWatchableBoolean(final int par1, final boolean par2) {
	final int j = dataWatcher.getWatchableObjectInt(16);

	if (par2)
	    dataWatcher.updateObject(16, Integer.valueOf(j | par1));
	else
	    dataWatcher.updateObject(16, Integer.valueOf(j & ~par1));
    }

    @Override
    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	getAttributeMap()
		.func_111150_b(EntityMechanicalHorse.horseJumpStrength);
	getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(
		53.0D);
	getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(
		0.22499999403953552D);
    }

    @Override
    protected void entityInit() {
	super.entityInit();
	dataWatcher.addObject(16, Integer.valueOf(0));
	dataWatcher.addObject(19, Byte.valueOf((byte) 0));
	dataWatcher.addObject(20, Integer.valueOf(0));
	dataWatcher.addObject(21, String.valueOf(""));
	dataWatcher.addObject(22, Integer.valueOf(0));
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    @Override
    protected void fall(final float par1) {
	if (par1 > 1.0F)
	    playSound("mob.horse.land", 0.4F, 1.0F);

	final int i = MathHelper.ceiling_float_int(par1 * 0.5F - 3.0F);

	if (i > 0) {
	    attackEntityFrom(DamageSource.fall, i);

	    if (riddenByEntity != null)
		riddenByEntity.attackEntityFrom(DamageSource.fall, i);

	    final int j = worldObj.getBlockId(MathHelper.floor_double(posX),
		    MathHelper.floor_double(posY - 0.2D - prevRotationYaw),
		    MathHelper.floor_double(posZ));

	    if (j > 0) {
		final StepSound stepsound = Block.blocksList[j].stepSound;
		worldObj.playSoundAtEntity(this, stepsound.getStepSound(),
			stepsound.getVolume() * 0.5F,
			stepsound.getPitch() * 0.75F);
	    }
	}
    }

    protected String getAngrySoundName() {
	final int i = getHorseType();
	return i != 3 && i != 4 ? i != 1 && i != 2 ? "mob.horse.angry"
		: "mob.horse.donkey.angry" : null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
	final int i = getHorseType();
	return i == 3 ? "mob.horse.zombie.death"
		: i == 4 ? "mob.horse.skeleton.death"
			: i != 1 && i != 2 ? "mob.horse.death"
				: "mob.horse.donkey.death";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected int getDropItemId() {
	final boolean flag = rand.nextInt(4) == 0;
	final int i = getHorseType();
	return i == 4 ? Item.bone.itemID : i == 3 ? flag ? 0
		: Item.rottenFlesh.itemID : Item.leather.itemID;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
	final int i = getHorseType();
	return i == 3 ? "mob.horse.zombie.hit"
		: i == 4 ? "mob.horse.skeleton.hit"
			: i != 1 && i != 2 ? "mob.horse.hit"
				: "mob.horse.donkey.hit";
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
	final int i = getHorseType();
	return i == 3 ? "mob.horse.zombie.idle"
		: i == 4 ? "mob.horse.skeleton.idle"
			: i != 1 && i != 2 ? "mob.horse.idle"
				: "mob.horse.donkey.idle";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
	return 0.8F;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    protected boolean isAIEnabled() {
	return true;
    }

    /**
     * Dead and sleeping entities cannot move
     */
    @Override
    protected boolean isMovementBlocked() {
	return riddenByEntity != null;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    @Override
    protected void playStepSound(final int par1, final int par2,
	    final int par3, final int par4) {
	StepSound stepsound = Block.blocksList[par4].stepSound;

	if (worldObj.getBlockId(par1, par2 + 1, par3) == Block.snow.blockID)
	    stepsound = Block.snow.stepSound;

	if (!Block.blocksList[par4].blockMaterial.isLiquid()) {
	    final int i1 = getHorseType();

	    if (riddenByEntity != null && i1 != 1 && i1 != 2) {
		++field_110285_bP;

		if (field_110285_bP > 5 && field_110285_bP % 3 == 0) {
		    playSound("mob.horse.gallop",
			    stepsound.getVolume() * 0.15F, stepsound.getPitch());

		    if (i1 == 0 && rand.nextInt(10) == 0)
			playSound("mob.horse.breathe",
				stepsound.getVolume() * 0.6F,
				stepsound.getPitch());
		} else if (field_110285_bP <= 5)
		    playSound("mob.horse.wood", stepsound.getVolume() * 0.15F,
			    stepsound.getPitch());
	    } else if (stepsound == Block.soundWoodFootstep)
		playSound("mob.horse.soft", stepsound.getVolume() * 0.15F,
			stepsound.getPitch());
	    else
		playSound("mob.horse.wood", stepsound.getVolume() * 0.15F,
			stepsound.getPitch());
	}
    }

    @SideOnly(Side.CLIENT)
    /**
     * "Spawns particles for the horse entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
     */
    protected void spawnHorseParticles(final boolean par1) {
	final String s = par1 ? "heart" : "smoke";

	for (int i = 0; i < 7; ++i) {
	    final double d0 = rand.nextGaussian() * 0.02D;
	    final double d1 = rand.nextGaussian() * 0.02D;
	    final double d2 = rand.nextGaussian() * 0.02D;
	    worldObj.spawnParticle(s, posX + rand.nextFloat() * width * 2.0F
		    - width, posY + 0.5D + rand.nextFloat() * height, posZ
		    + rand.nextFloat() * width * 2.0F - width, d0, d1, d2);
	}
    }
}
