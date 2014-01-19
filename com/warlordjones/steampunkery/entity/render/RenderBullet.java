package com.warlordjones.steampunkery.entity.render;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.warlordjones.steampunkery.entity.EntityBullet;

public class RenderBullet extends RenderSnowball {
    public RenderBullet(Item par1Item) {
	super(par1Item);
    }

    private static final ResourceLocation arrowTextures = new ResourceLocation(
	    "steampunkery:textures/items/bullet.png");

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