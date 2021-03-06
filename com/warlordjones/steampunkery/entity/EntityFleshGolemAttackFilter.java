/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

final class EntityFleshGolemAttackFilter implements IEntitySelector {
    /**
     * Return whether the specified entity is applicable to this filter.
     */
    @Override
    public boolean isEntityApplicable(final Entity par1Entity) {
	return par1Entity instanceof EntityLivingBase
		&& ((EntityLivingBase) par1Entity).getEntityName() != "Zombie"
		&& ((EntityLivingBase) par1Entity).getEntityName() != "Player";
    }
}
