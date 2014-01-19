package com.warlordjones.steampunkery.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMechanicalHorse extends RenderLiving {
    private static final ResourceLocation MECH_HORSE_TEXTURE = new ResourceLocation(
	    "steampunkery:textures/models/mobs/mechanical_horse.png");

    public RenderMechanicalHorse(final ModelBase par1ModelBase, final float par2) {
	super(par1ModelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
	return RenderMechanicalHorse.MECH_HORSE_TEXTURE;
    }
}
