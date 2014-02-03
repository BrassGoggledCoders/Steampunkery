/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity;

import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.world.World;

public class EntityClockworkAssassin extends EntityGolem {

    public EntityClockworkAssassin(final World par1World) {
	super(par1World);
	setSize(0.4F, 3F);
	// tasks.addTask(1, new EntityAI);
    }

}
