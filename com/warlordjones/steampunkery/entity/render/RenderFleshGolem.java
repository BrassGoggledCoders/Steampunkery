/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFleshGolem extends RenderLiving {
    private static final ResourceLocation FLESHGOLEM_TEXTURE = new ResourceLocation(
	    "steampunkery:textures/models/mobs/flesh_golem.png");

    public RenderFleshGolem(final ModelBase par1ModelBase, final float par2) {
	super(par1ModelBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
	return RenderFleshGolem.FLESHGOLEM_TEXTURE;
    }
}
