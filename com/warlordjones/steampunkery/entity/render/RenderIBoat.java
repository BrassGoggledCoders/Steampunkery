package com.warlordjones.steampunkery.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.entity.EntityIBoat;
import com.warlordjones.steampunkery.entity.model.ModelIBoat;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIBoat extends Render {
    private static final ResourceLocation boatTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/models/mobs/iboat.png");
    /** instance of ModelIBoat for rendering */
    protected ModelBase modelBoat;

    public RenderIBoat(final ModelBase par1ModelBase, final float par2) {
	shadowSize = 0.5F;
	modelBoat = new ModelIBoat();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method,
     * always casting down its argument and then handing it off to a worker
     * function which does the actual work. In all probabilty, the class Render
     * is generic (Render<T extends Entity) and this method has signature public
     * void doRender(T entity, double d, double d1, double d2, float f, float
     * f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(final Entity par1Entity, final double par2,
	    final double par4, final double par6, final float par8,
	    final float par9) {
	renderBoat((EntityIBoat) par1Entity, par2, par4, par6, par8, par9);
    }

    /**
     * The render method used in RenderBoat that renders the boat model.
     */
    public void renderBoat(final EntityIBoat par1EntityBoat, final double par2,
	    final double par4, final double par6, final float par8,
	    final float par9) {
	GL11.glPushMatrix();
	GL11.glTranslatef((float) par2, (float) par4, (float) par6);
	GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
	final float f2 = par1EntityBoat.getTimeSinceHit() - par9;
	float f3 = par1EntityBoat.getDamageTaken() - par9;
	if (f3 < 0.0F)
	    f3 = 0.0F;
	if (f2 > 0.0F)
	    GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F
		    * par1EntityBoat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
	final float f4 = 0.75F;
	GL11.glScalef(f4, f4, f4);
	GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
	bindEntityTexture(par1EntityBoat);
	GL11.glScalef(-1.0F, -1.0F, 1.0F);
	modelBoat
		.render(par1EntityBoat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	GL11.glPopMatrix();
    }

    protected ResourceLocation getBoatTextures(final EntityIBoat par1Entity) {
	return RenderIBoat.boatTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called
     * unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
	return getBoatTextures((EntityIBoat) par1Entity);
    }
}
