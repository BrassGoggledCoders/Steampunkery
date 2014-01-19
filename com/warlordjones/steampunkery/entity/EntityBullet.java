package com.warlordjones.steampunkery.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {
    public EntityBullet(World par1World) {
	super(par1World);
    }

    public EntityBullet(World par1World, EntityPlayer par3EntityPlayer) {
	super(par1World, par3EntityPlayer);
    }

    public EntityBullet(World par1World, double par2, double par4, double par6) {
	super(par1World, par2, par4, par6);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingobjectposition) {
	if (!this.worldObj.isRemote) {
	    if (movingobjectposition.entityHit != null) {
		movingobjectposition.entityHit.attackEntityFrom(
			DamageSource.cactus, 4F);
	    }
	    this.worldObj.createExplosion(this, this.posX, this.posY,
		    this.posZ, (float) 0.3F, true);
	    this.setDead();
	}
    }

    protected float getGravityVelocity() {
	return 0.01F;
    }

    @Override
    protected float func_70182_d() {
	return 2.5F;
    }
}
