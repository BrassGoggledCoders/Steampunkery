package com.warlordjones.steampunkery.entity.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelSkySquid extends ModelBase {
    /** The squid's body */
    ModelRenderer squidBody;

    /** The squid's tentacles */
    ModelRenderer[] squidTentacles = new ModelRenderer[8];

    public ModelSkySquid() {
	final byte b0 = -16;
	squidBody = new ModelRenderer(this, 0, 0);
	squidBody.addBox(-6.0F, -8.0F, -6.0F, 12, 16, 12);
	squidBody.rotationPointY += 24 + b0;

	for (int i = 0; i < squidTentacles.length; ++i) {
	    squidTentacles[i] = new ModelRenderer(this, 48, 0);
	    double d0 = i * Math.PI * 2.0D / squidTentacles.length;
	    final float f = (float) Math.cos(d0) * 5.0F;
	    final float f1 = (float) Math.sin(d0) * 5.0F;
	    squidTentacles[i].addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2);
	    squidTentacles[i].rotationPointX = f;
	    squidTentacles[i].rotationPointZ = f1;
	    squidTentacles[i].rotationPointY = 31 + b0;
	    d0 = i * Math.PI * -2.0D / squidTentacles.length + Math.PI / 2D;
	    squidTentacles[i].rotateAngleY = (float) d0;
	}
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(final Entity par1Entity, final float par2,
	    final float par3, final float par4, final float par5,
	    final float par6, final float par7) {
	setRotationAngles(par2, 0.3F, par4, par5, par6, par7, par1Entity);
	squidBody.render(par7);

	for (final ModelRenderer squidTentacle : squidTentacles)
	    squidTentacle.render(par7);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are
     * used for animating the movement of arms and legs, where par1 represents
     * the time(so that arms and legs swing back and forth) and par2 represents
     * how "far" arms and legs can swing at most.
     */
    @Override
    public void setRotationAngles(final float par1, final float par2,
	    final float par3, final float par4, final float par5,
	    final float par6, final Entity par7Entity) {
	final ModelRenderer[] amodelrenderer = squidTentacles;
	final int i = amodelrenderer.length;

	for (int j = 0; j < i; ++j) {
	    final ModelRenderer modelrenderer = amodelrenderer[j];
	    modelrenderer.rotateAngleX = par3;
	}
    }
}
