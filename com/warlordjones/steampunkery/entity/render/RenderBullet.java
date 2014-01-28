package com.warlordjones.steampunkery.entity.render;

import com.warlordjones.steampunkery.entity.EntityBullet;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends RenderSnowball {
    private static final ResourceLocation arrowTextures = new ResourceLocation(
	    "steampunkery:textures/items/bullet.png");

    public RenderBullet(final Item par1Item) {
	super(par1Item);
    }

    protected ResourceLocation getArrowTextures(final EntityBullet par1Entity) {
	return RenderBullet.arrowTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called
     * unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
	return getArrowTextures((EntityBullet) par1Entity);
    }
}