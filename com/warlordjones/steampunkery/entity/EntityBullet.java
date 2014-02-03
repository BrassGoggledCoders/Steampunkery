/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {
    public EntityBullet(final World par1World) {
	super(par1World);
    }

    public EntityBullet(final World par1World, final double par2,
	    final double par4, final double par6) {
	super(par1World, par2, par4, par6);
    }

    public EntityBullet(final World par1World,
	    final EntityPlayer par3EntityPlayer) {
	super(par1World, par3EntityPlayer);
    }

    @Override
    protected float func_70182_d() {
	return 2.5F;
    }

    @Override
    protected float getGravityVelocity() {
	return 0.01F;
    }

    @Override
    protected void onImpact(final MovingObjectPosition movingobjectposition) {
	if (!worldObj.isRemote) {
	    if (movingobjectposition.entityHit != null)
		movingobjectposition.entityHit.attackEntityFrom(
			DamageSource.cactus, 4F);
	    worldObj.createExplosion(this, posX, posY, posZ, 0.3F, true);
	    setDead();
	}
    }
}
