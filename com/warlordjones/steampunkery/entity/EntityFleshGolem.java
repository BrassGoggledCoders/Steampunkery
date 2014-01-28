package com.warlordjones.steampunkery.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFleshGolem extends EntityGolem {
    private static final IEntitySelector attackEntitySelector = new EntityFleshGolemAttackFilter();
    public boolean mindcontrol = false;
    private int attackTimer;

    public EntityFleshGolem(final World par1World) {
	super(par1World);
	setSize(1.4F, 2.9F);
	getNavigator().setAvoidsWater(true);
	tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
	tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
	tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
	tasks.addTask(6, new EntityAIWander(this, 0.6D));
	tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class,
		6.0F));
	tasks.addTask(8, new EntityAILookIdle(this));
	targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	if (mindcontrol = true)
	    targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
		    EntityLiving.class, 0, false, false,
		    EntityFleshGolem.attackEntitySelector));
	else
	    targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
		    EntityMob.class, 0, false, true, IMob.mobSelector));
    }

    @Override
    public boolean attackEntityAsMob(final Entity par1Entity) {
	attackTimer = 10;
	worldObj.setEntityState(this, (byte) 4);
	final boolean flag = par1Entity.attackEntityFrom(
		DamageSource.causeMobDamage(this), 5 + rand.nextInt(15));
	if (flag)
	    par1Entity.motionY += 0.4000000059604645D;
	playSound("mob.irongolem.throw", 1.0F, 1.0F);
	return flag;
    }

    @Override
    public boolean canAttackClass(final Class par1Class) {
	if (mindcontrol = true)
	    return true;
	else
	    return false;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
	return attackTimer;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
	if (par1 == 4) {
	    attackTimer = 10;
	    playSound("mob.irongolem.throw", 1.0F, 1.0F);
	} else
	    super.handleHealthUpdate(par1);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    public boolean isAIEnabled() {
	return true;
    }

    @Override
    public void onDeath(final DamageSource par1DamageSource) {
	super.onDeath(par1DamageSource);
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
	super.onLivingUpdate();
	if (attackTimer > 0)
	    --attackTimer;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
	super.readEntityFromNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
	super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    @Override
    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(
		25.0D);
	getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(
		0.50D);
    }

    /**
     * Decrements the entity's air supply when underwater
     */
    @Override
    protected int decreaseAirSupply(final int par1) {
	return par1;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity
     * has recently been hit by a player. @param par2 - Level of Looting used to
     * kill this mob.
     */
    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
	rand.nextInt(4);
	int k;
	k = 7 + rand.nextInt(3);
	for (int l = 0; l < k; ++l)
	    dropItem(Item.rottenFlesh.itemID, 1);
    }

    @Override
    protected void entityInit() {
	super.entityInit();
	dataWatcher.addObject(16, Byte.valueOf((byte) 0));
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
	return "mob.zombie.death";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
	return "mob.zombie.hit";
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
	return "";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    @Override
    protected void playStepSound(final int par1, final int par2,
	    final int par3, final int par4) {
	playSound("mob.zombie.walk", 1.0F, 1.0F);
    }
}