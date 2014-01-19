package com.warlordjones.steampunkery;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;

public class DamageSourceZap extends DamageSource {
    protected DamageSourceZap(String par1Str) {
	super(par1Str);
	// TODO Auto-generated constructor stub
    }

    public ChatMessageComponent getDeathMessage(
	    EntityLivingBase par1EntityLivingBase) {
	return ChatMessageComponent.createFromText(par1EntityLivingBase
		.getEntityName() + "was electrocuted");

    }
}
