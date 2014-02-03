/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;

public class DamageSourceZap extends DamageSource {
    protected DamageSourceZap(final String par1Str) {
	super(par1Str);
	// TODO Auto-generated constructor stub
    }

    @Override
    public ChatMessageComponent getDeathMessage(
	    final EntityLivingBase par1EntityLivingBase) {
	return ChatMessageComponent.createFromText(par1EntityLivingBase
		.getEntityName() + "was electrocuted");

    }
}
