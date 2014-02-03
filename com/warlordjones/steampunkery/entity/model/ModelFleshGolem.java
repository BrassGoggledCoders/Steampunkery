/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelFleshGolem extends ModelBase {
    /** The body model for the iron golem. */
    public ModelRenderer fleshGolemBody;
    /** The head model for the iron golem. */
    public ModelRenderer fleshGolemHead;
    /** The left arm model for the iron golem. */
    public ModelRenderer fleshGolemLeftArm;
    /** The left leg model for the Iron Golem. */
    public ModelRenderer fleshGolemLeftLeg;
    /** The right arm model for the iron golem. */
    public ModelRenderer fleshGolemRightArm;
    /** The right leg model for the Iron Golem. */
    public ModelRenderer fleshGolemRightLeg;

    public ModelFleshGolem() {
	this(0.0F);
    }

    public ModelFleshGolem(final float par1) {
	this(par1, -7.0F);
    }

    public ModelFleshGolem(final float par1, final float par2) {
	final short short1 = 128;
	final short short2 = 128;
	fleshGolemHead = new ModelRenderer(this).setTextureSize(short1, short2);
	fleshGolemHead.setRotationPoint(0.0F, 0.0F + par2, -2.0F);
	fleshGolemHead.setTextureOffset(0, 0).addBox(-5.0F, 1F, -7.0F, 8, 8, 8,
		par1);
	// this.fleshGolemHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F,
	// -7.5F, 2, 4, 2, par1);
	fleshGolemBody = new ModelRenderer(this).setTextureSize(short1, short2);
	fleshGolemBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
	fleshGolemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18,
		12, 11, par1);
	fleshGolemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9,
		5, 6, par1 + 0.5F);
	fleshGolemRightArm = new ModelRenderer(this).setTextureSize(short1,
		short2);
	fleshGolemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
	fleshGolemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F,
		-3.0F, 4, 30, 6, par1);
	fleshGolemLeftArm = new ModelRenderer(this).setTextureSize(short1,
		short2);
	fleshGolemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
	fleshGolemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F,
		4, 30, 6, par1);
	fleshGolemLeftLeg = new ModelRenderer(this, 0, 22).setTextureSize(
		short1, short2);
	fleshGolemLeftLeg.setRotationPoint(-4.0F, 18.0F + par2, 0.0F);
	fleshGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F,
		6, 16, 5, par1);
	fleshGolemRightLeg = new ModelRenderer(this, 0, 22).setTextureSize(
		short1, short2);
	fleshGolemRightLeg.mirror = true;
	fleshGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F,
		18.0F + par2, 0.0F);
	fleshGolemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, par1);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(final Entity par1Entity, final float par2,
	    final float par3, final float par4, final float par5,
	    final float par6, final float par7) {
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	fleshGolemHead.render(par7);
	fleshGolemBody.render(par7);
	fleshGolemLeftLeg.render(par7);
	fleshGolemRightLeg.render(par7);
	fleshGolemRightArm.render(par7);
	fleshGolemLeftArm.render(par7);
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third
     * float params here are the same second and third as in the
     * setRotationAngles method.
     */
    @Override
    public void setLivingAnimations(
	    final EntityLivingBase par1EntityLivingBase, final float par2,
	    final float par3, final float par4) {
	final com.warlordjones.steampunkery.entity.EntityFleshGolem entityfleshgolem = (com.warlordjones.steampunkery.entity.EntityFleshGolem) par1EntityLivingBase;
	final int i = entityfleshgolem.getAttackTimer();
	if (i > 0) {
	    fleshGolemRightArm.rotateAngleX = -2.0F + 1.5F
		    * func_78172_a(i - par4, 10.0F);
	    fleshGolemLeftArm.rotateAngleX = -2.0F + 1.5F
		    * func_78172_a(i - par4, 10.0F);
	} else {
	    fleshGolemRightArm.rotateAngleX = (-0.2F + 1.5F * func_78172_a(
		    par2, 13.0F)) * par3;
	    fleshGolemLeftArm.rotateAngleX = (-0.2F - 1.5F * func_78172_a(par2,
		    13.0F)) * par3;
	}
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
	fleshGolemHead.rotateAngleY = par4 / (180F / (float) Math.PI);
	fleshGolemHead.rotateAngleX = par5 / (180F / (float) Math.PI);
	fleshGolemLeftLeg.rotateAngleX = -1.5F * func_78172_a(par1, 13.0F)
		* par2;
	fleshGolemRightLeg.rotateAngleX = 1.5F * func_78172_a(par1, 13.0F)
		* par2;
	fleshGolemLeftLeg.rotateAngleY = 0.0F;
	fleshGolemRightLeg.rotateAngleY = 0.0F;
    }

    private float func_78172_a(final float par1, final float par2) {
	return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F)
		/ (par2 * 0.25F);
    }
}
