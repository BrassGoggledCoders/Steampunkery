/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity.render;

import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ResourceLocation;

public class RenderSteamSpurt extends RenderFireball {
    private static final ResourceLocation STEAMSPURT_TEXTURE = new ResourceLocation(
	    "steampunkery:textures/models/mobs/flesh_golem.png");

    public RenderSteamSpurt(final float par1) {
	super(par1);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected ResourceLocation getFireballTextures(
	    final EntityFireball par1EntityFireball) {
	return RenderSteamSpurt.STEAMSPURT_TEXTURE;
    }
}
