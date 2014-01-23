package com.warlordjones.steampunkery.entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorseGroupData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMechanicalHorse extends EntityCreature
{
    private static final Attribute horseJumpStrength = (new RangedAttribute("horse.jumpStrength", 0.7D, 0.0D, 2.0D)).func_111117_a("Jump Strength").setShouldWatch(true);
    private static final String[] horseTextures = new String[] {"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
    protected float jumpPower;
    private boolean field_110294_bI;
    private float headLean;
    private float prevHeadLean;
    private float rearingAmount;
    private float prevRearingAmount;
    private float mouthOpenness;
    private float prevMouthOpenness;
    private int field_110285_bP;
    private String field_110286_bQ;
    private String[] field_110280_bR = new String[3];

    public EntityMechanicalHorse(World par1World)
    {
        super(par1World);
        this.setSize(0.9F, 1F);
        this.isImmuneToFire = false;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
        this.tasks.addTask(6, new EntityAIWander(this, 0.7D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
        this.dataWatcher.addObject(19, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(20, Integer.valueOf(0));
        this.dataWatcher.addObject(21, String.valueOf(""));
        this.dataWatcher.addObject(22, Integer.valueOf(0));
    }

    public void setHorseType(int par1)
    {
        this.dataWatcher.updateObject(19, Byte.valueOf((byte)par1));
        this.func_110230_cF();
    }

    /**
     * returns the horse type
     */
    public int getHorseType()
    {
        return this.dataWatcher.getWatchableObjectByte(19);
    }

    public void setHorseVariant(int par1)
    {
        this.dataWatcher.updateObject(20, Integer.valueOf(par1));
        this.func_110230_cF();
    }

    public int getHorseVariant()
    {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    /**
     * Gets the username of the entity.
     */
    public String getEntityName()
    {
	return "mechanical_horse";
    }

    private boolean getHorseWatchableBoolean(int par1)
    {
        return (this.dataWatcher.getWatchableObjectInt(16) & par1) != 0;
    }

    private void setHorseWatchableBoolean(int par1, boolean par2)
    {
        int j = this.dataWatcher.getWatchableObjectInt(16);

        if (par2)
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j | par1));
        }
        else
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j & ~par1));
        }
    }

    public boolean isTame()
    {
        return true;
    }
    public String getOwnerName()
    {
        return this.dataWatcher.getWatchableObjectString(21);
    }

    public void setOwnerName(String par1Str)
    {
        this.dataWatcher.updateObject(21, par1Str);
    }
    public boolean isHorseJumping()
    {
        return this.isJumping;
    }

    public void setHorseTamed(boolean par1)
    {
        this.setHorseWatchableBoolean(2, par1);
    }

    public void setHorseJumping(boolean par1)
    {
        this.isJumping = par1;
    }

    public boolean allowLeashing()
    {
        return super.allowLeashing();
    }

    public int func_110241_cb()
    {
        return this.dataWatcher.getWatchableObjectInt(22);
    }
    public boolean func_110205_ce()
    {
        return this.getHorseWatchableBoolean(16);
    }

    public void func_110236_r(int par1)
    {
        this.dataWatcher.updateObject(22, Integer.valueOf(par1));
        this.func_110230_cF();
    }

    public void func_110242_l(boolean par1)
    {
        this.setHorseWatchableBoolean(16, par1);
    }

    public void setChested(boolean par1)
    {
        this.setHorseWatchableBoolean(8, par1);
    }

    public void setHorseSaddled(boolean par1)
    {
        this.setHorseWatchableBoolean(4, par1);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        Entity entity = par1DamageSource.getEntity();
        return this.riddenByEntity != null && this.riddenByEntity.equals(entity) ? false : super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return this.riddenByEntity == null;
    }

    public boolean prepareChunkForSpawn()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(i, j);
        return true;
    }
    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {
        if (par1 > 1.0F)
        {
            this.playSound("mob.horse.land", 0.4F, 1.0F);
        }

        int i = MathHelper.ceiling_float_int(par1 * 0.5F - 3.0F);

        if (i > 0)
        {
            this.attackEntityFrom(DamageSource.fall, (float)i);

            if (this.riddenByEntity != null)
            {
                this.riddenByEntity.attackEntityFrom(DamageSource.fall, (float)i);
            }

            int j = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.2D - (double)this.prevRotationYaw), MathHelper.floor_double(this.posZ));

            if (j > 0)
            {
                StepSound stepsound = Block.blocksList[j].stepSound;
                this.worldObj.playSoundAtEntity(this, stepsound.getStepSound(), stepsound.getVolume() * 0.5F, stepsound.getPitch() * 0.75F);
            }
        }
    }
    public double getHorseJumpStrength()
    {
        return this.getEntityAttribute(horseJumpStrength).getAttributeValue();
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        int i = this.getHorseType();
        return i == 3 ? "mob.horse.zombie.death" : (i == 4 ? "mob.horse.skeleton.death" : (i != 1 && i != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        boolean flag = this.rand.nextInt(4) == 0;
        int i = this.getHorseType();
        return i == 4 ? Item.bone.itemID : (i == 3 ? (flag ? 0 : Item.rottenFlesh.itemID) : Item.leather.itemID);
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        int i = this.getHorseType();
        return i == 3 ? "mob.horse.zombie.hit" : (i == 4 ? "mob.horse.skeleton.hit" : (i != 1 && i != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        int i = this.getHorseType();
        return i == 3 ? "mob.horse.zombie.idle" : (i == 4 ? "mob.horse.skeleton.idle" : (i != 1 && i != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
    }

    protected String getAngrySoundName()
    {
        int i = this.getHorseType();
        return i != 3 && i != 4 ? (i != 1 && i != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        StepSound stepsound = Block.blocksList[par4].stepSound;

        if (this.worldObj.getBlockId(par1, par2 + 1, par3) == Block.snow.blockID)
        {
            stepsound = Block.snow.stepSound;
        }

        if (!Block.blocksList[par4].blockMaterial.isLiquid())
        {
            int i1 = this.getHorseType();

            if (this.riddenByEntity != null && i1 != 1 && i1 != 2)
            {
                ++this.field_110285_bP;

                if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0)
                {
                    this.playSound("mob.horse.gallop", stepsound.getVolume() * 0.15F, stepsound.getPitch());

                    if (i1 == 0 && this.rand.nextInt(10) == 0)
                    {
                        this.playSound("mob.horse.breathe", stepsound.getVolume() * 0.6F, stepsound.getPitch());
                    }
                }
                else if (this.field_110285_bP <= 5)
                {
                    this.playSound("mob.horse.wood", stepsound.getVolume() * 0.15F, stepsound.getPitch());
                }
            }
            else if (stepsound == Block.soundWoodFootstep)
            {
                this.playSound("mob.horse.soft", stepsound.getVolume() * 0.15F, stepsound.getPitch());
            }
            else
            {
                this.playSound("mob.horse.wood", stepsound.getVolume() * 0.15F, stepsound.getPitch());
            }
        }
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().func_111150_b(horseJumpStrength);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(53.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.22499999403953552D);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 6;
    }

    public int getMaxTemper()
    {
        return 100;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.8F;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 400;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110239_cn()
    {
        return this.getHorseType() == 0 || this.func_110241_cb() > 0;
    }

    private void func_110230_cF()
    {
        this.field_110286_bQ = null;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
	return false;
    }

    private void func_110237_h(EntityPlayer par1EntityPlayer)
    {
        par1EntityPlayer.rotationYaw = this.rotationYaw;
        par1EntityPlayer.rotationPitch = this.rotationPitch;

        if (!this.worldObj.isRemote)
        {
            par1EntityPlayer.mountEntity(this);
        }
    }

    public boolean func_110259_cr()
    {
        return this.getHorseType() == 3;
    }

    public boolean func_110229_cs()
    {
        int i = this.getHorseType();
        return i == 2 || i == 1;
    }

    /**
     * Dead and sleeping entities cannot move
     */
    protected boolean isMovementBlocked()
    {
        return this.riddenByEntity != null;
    }
    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        if (!this.worldObj.isRemote)
        {
            
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {

        super.onLivingUpdate();

        if (!this.worldObj.isRemote)
        {
            
            }
        }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.worldObj.isRemote && this.dataWatcher.hasChanges())
        {
            this.dataWatcher.func_111144_e();
            this.func_110230_cF();
        }
    }
    private boolean func_110200_cJ()
    {
        return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && this.getHealth() >= this.getMaxHealth();
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float par1, float par2)
    {
        if (this.riddenByEntity != null)
        {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;

            if (par2 <= 0.0F)
            {
                par2 *= 0.25F;
                this.field_110285_bP = 0;
            }

            if (this.onGround && this.jumpPower == 0.0F && !this.field_110294_bI)
            {
                par1 = 0.0F;
                par2 = 0.0F;
            }

            if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround)
            {
                this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;

                if (this.isPotionActive(Potion.jump))
                {
                    this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                }

                this.setHorseJumping(true);
                this.isAirBorne = true;

                if (par2 > 0.0F)
                {
                    float f2 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
                    float f3 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
                    this.motionX += (double)(-0.4F * f2 * this.jumpPower);
                    this.motionZ += (double)(0.4F * f3 * this.jumpPower);
                    this.playSound("mob.horse.jump", 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote)
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(par1, par2);
            }

            if (this.onGround)
            {
                this.jumpPower = 0.0F;
                this.setHorseJumping(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d0 = this.posX - this.prevPosX;
            double d1 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

            if (f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(par1, par2);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Type", this.getHorseType());
        par1NBTTagCompound.setInteger("Variant", this.getHorseVariant());
        par1NBTTagCompound.setBoolean("Tame", this.isTame());
        par1NBTTagCompound.setString("OwnerName", this.getOwnerName());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        }
    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
    {
        Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);
        boolean flag = false;
        int i = 0;
        int j;

        if (par1EntityLivingData1 instanceof EntityHorseGroupData)
        {
            j = ((EntityHorseGroupData)par1EntityLivingData1).field_111107_a;
            i = ((EntityHorseGroupData)par1EntityLivingData1).field_111106_b & 255 | this.rand.nextInt(5) << 8;
        }
        else
        {
            if (this.rand.nextInt(10) == 0)
            {
                j = 1;
            }
            else
            {
                int k = this.rand.nextInt(7);
                int l = this.rand.nextInt(5);
                j = 0;
                i = k | l << 8;
            }

            par1EntityLivingData1 = new EntityHorseGroupData(j, i);
        }

        this.setHorseType(j);
        this.setHorseVariant(i);

        if (j != 4 && j != 3)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute((double)this.func_110267_cL());

            if (j == 0)
            {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(this.func_110203_cN());
            }
            else
            {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.17499999701976776D);
            }
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(15.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.20000000298023224D);
        }

        if (j != 2 && j != 1)
        {
            this.getEntityAttribute(horseJumpStrength).setAttribute(this.func_110245_cM());
        }
        else
        {
            this.getEntityAttribute(horseJumpStrength).setAttribute(0.5D);
        }

        this.setHealth(this.getMaxHealth());
        return (EntityLivingData)par1EntityLivingData1;
    }
    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    public void setJumpPower(int par1)
    {
            if (par1 < 0)
            {
                par1 = 0;
            }
            else
            {
                this.field_110294_bI = true;
            }

            if (par1 >= 90)
            {
                this.jumpPower = 1.0F;
            }
            else
            {
                this.jumpPower = 0.4F + 0.4F * (float)par1 / 90.0F;
            }
        }

    @SideOnly(Side.CLIENT)

    /**
     * "Spawns particles for the horse entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
     */
    protected void spawnHorseParticles(boolean par1)
    {
        String s = par1 ? "heart" : "smoke";

        for (int i = 0; i < 7; ++i)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(s, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 7)
        {
            this.spawnHorseParticles(true);
        }
        else if (par1 == 6)
        {
            this.spawnHorseParticles(false);
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public void updateRiderPosition()
    {
        super.updateRiderPosition();

        if (this.prevRearingAmount > 0.0F)
        {
            float f = MathHelper.sin(this.renderYawOffset * (float)Math.PI / 180.0F);
            float f1 = MathHelper.cos(this.renderYawOffset * (float)Math.PI / 180.0F);
            float f2 = 0.7F * this.prevRearingAmount;
            float f3 = 0.15F * this.prevRearingAmount;
            this.riddenByEntity.setPosition(this.posX + (double)(f2 * f), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double)f3, this.posZ - (double)(f2 * f1));

            if (this.riddenByEntity instanceof EntityLivingBase)
            {
                ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
            }
        }
    }

    private float func_110267_cL()
    {
        return 15.0F + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
    }

    private double func_110245_cM()
    {
        return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
    }

    private double func_110203_cN()
    {
        return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
    }

    public static boolean func_110211_v(int par0)
    {
        return par0 == Item.horseArmorIron.itemID || par0 == Item.horseArmorGold.itemID || par0 == Item.horseArmorDiamond.itemID;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder()
    {
        return false;
    }
}
