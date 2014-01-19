package com.warlordjones.steampunkery.entity;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

final class EntityFleshGolemAttackFilter implements IEntitySelector {
    /**
     * Return whether the specified entity is applicable to this filter.
     */
    public boolean isEntityApplicable(Entity par1Entity) {
	return par1Entity instanceof EntityLivingBase
		&& ((EntityLivingBase) par1Entity).getEntityName() != "Zombie"
		&& ((EntityLivingBase) par1Entity).getEntityName() != "Player";
    }
}
