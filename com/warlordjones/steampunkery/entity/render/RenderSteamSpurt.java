package com.warlordjones.steampunkery.entity.render;

import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ResourceLocation;

public class RenderSteamSpurt extends RenderFireball {
    private static final ResourceLocation STEAMSPURT_TEXTURE = new ResourceLocation(
	    "steampunkery:textures/models/mobs/flesh_golem.png");

    public RenderSteamSpurt(float par1) {
	super(par1);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected ResourceLocation getFireballTextures(
	    EntityFireball par1EntityFireball) {
	return STEAMSPURT_TEXTURE;
    }
}
