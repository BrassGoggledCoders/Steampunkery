/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.tileentities.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelCryoPlayer extends ModelBase {
    /** Records whether the model should be rendered aiming a bow. */
    public boolean aimedBow;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedCloak;
    public ModelRenderer bipedEars;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedRightLeg;

    /**
     * Records whether the model should be rendered holding an item in the left
     * hand, and if that item is a block.
     */
    public int heldItemLeft;

    /**
     * Records whether the model should be rendered holding an item in the right
     * hand, and if that item is a block.
     */
    public int heldItemRight;
    public ModelRenderer ice;

    public boolean isSneak;

    public ModelCryoPlayer() {
	this(0.0F);
    }

    public ModelCryoPlayer(final float par1) {
	this(par1, 0.0F, 64, 32);
    }

    public ModelCryoPlayer(final float par1, final float par2, final int par3,
	    final int par4) {
	textureWidth = par3;
	textureHeight = par4;
	bipedCloak = new ModelRenderer(this, 0, 0);
	bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1);
	bipedEars = new ModelRenderer(this, 24, 0);
	bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1);
	bipedHead = new ModelRenderer(this, 0, 0);
	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1);
	bipedHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
	bipedHeadwear = new ModelRenderer(this, 32, 0);
	bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F);
	bipedHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
	bipedBody = new ModelRenderer(this, 16, 16);
	bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
	bipedBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
	bipedRightArm = new ModelRenderer(this, 40, 16);
	bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
	bipedRightArm.setRotationPoint(-5.0F, 2.0F + par2, 0.0F);
	bipedLeftArm = new ModelRenderer(this, 40, 16);
	bipedLeftArm.mirror = true;
	bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
	bipedLeftArm.setRotationPoint(5.0F, 2.0F + par2, 0.0F);
	bipedRightLeg = new ModelRenderer(this, 0, 16);
	bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
	bipedRightLeg.setRotationPoint(-1.9F, 12.0F + par2, 0.0F);
	bipedLeftLeg = new ModelRenderer(this, 0, 16);
	bipedLeftLeg.mirror = true;
	bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
	bipedLeftLeg.setRotationPoint(1.9F, 12.0F + par2, 0.0F);
	// this.ice.addBox(-2.0F, 0.0F, -2.0F, 7, 15, 10);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(final Entity par1Entity, final float par2,
	    final float par3, final float par4, final float par5,
	    final float par6, final float par7) {
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

	if (isChild) {
	    final float f6 = 2.0F;
	    GL11.glPushMatrix();
	    GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
	    GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
	    bipedHead.render(par7);
	    GL11.glPopMatrix();
	    GL11.glPushMatrix();
	    GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	    GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
	    bipedBody.render(par7);
	    bipedRightArm.render(par7);
	    bipedLeftArm.render(par7);
	    bipedRightLeg.render(par7);
	    bipedLeftLeg.render(par7);
	    bipedHeadwear.render(par7);
	    GL11.glPopMatrix();
	} else {
	    bipedHead.render(par7);
	    bipedBody.render(par7);
	    bipedRightArm.render(par7);
	    bipedLeftArm.render(par7);
	    bipedRightLeg.render(par7);
	    bipedLeftLeg.render(par7);
	    bipedHeadwear.render(par7);
	}
    }

    /**
     * Renders the cloak of the current biped (in most cases, it's a player)
     */
    public void renderCloak(final float par1) {
	bipedCloak.render(par1);
    }

    /**
     * renders the ears (specifically, deadmau5's)
     */
    public void renderEars(final float par1) {
	bipedEars.rotateAngleY = bipedHead.rotateAngleY;
	bipedEars.rotateAngleX = bipedHead.rotateAngleX;
	bipedEars.rotationPointX = 0.0F;
	bipedEars.rotationPointY = 0.0F;
	bipedEars.render(par1);
    }

    public void renderModel(final float par2, final float par3,
	    final float par4, final float par5, final float par6,
	    final float par7) {
	// this.setRotationAngles(par2, par3, par4, par5, par6, par7);

	if (isChild) {
	    final float f6 = 2.0F;
	    GL11.glPushMatrix();
	    GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
	    GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
	    bipedHead.render(par7);
	    GL11.glPopMatrix();
	    GL11.glPushMatrix();
	    GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	    GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
	    bipedBody.render(par7);
	    bipedRightArm.render(par7);
	    bipedLeftArm.render(par7);
	    bipedRightLeg.render(par7);
	    bipedLeftLeg.render(par7);
	    bipedHeadwear.render(par7);
	    GL11.glPopMatrix();
	} else {
	    bipedHead.render(par7);
	    bipedBody.render(par7);
	    bipedRightArm.render(par7);
	    bipedLeftArm.render(par7);
	    bipedRightLeg.render(par7);
	    bipedLeftLeg.render(par7);
	    bipedHeadwear.render(par7);
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
	bipedHead.rotateAngleY = par4 / (180F / (float) Math.PI);
	bipedHead.rotateAngleX = par5 / (180F / (float) Math.PI);
	bipedHeadwear.rotateAngleY = bipedHead.rotateAngleY;
	bipedHeadwear.rotateAngleX = bipedHead.rotateAngleX;
	bipedRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F
		+ (float) Math.PI)
		* 2.0F * par2 * 0.5F;
	bipedLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F
		* par2 * 0.5F;
	bipedRightArm.rotateAngleZ = 0.0F;
	bipedLeftArm.rotateAngleZ = 0.0F;
	bipedRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F
		* par2;
	bipedLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F
		+ (float) Math.PI)
		* 1.4F * par2;
	bipedRightLeg.rotateAngleY = 0.0F;
	bipedLeftLeg.rotateAngleY = 0.0F;

	if (isRiding) {
	    bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
	    bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
	    bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
	    bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
	    bipedRightLeg.rotateAngleY = (float) Math.PI / 10F;
	    bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
	}

	if (heldItemLeft != 0)
	    bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F
		    - (float) Math.PI / 10F * heldItemLeft;

	if (heldItemRight != 0)
	    bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F
		    - (float) Math.PI / 10F * heldItemRight;

	bipedRightArm.rotateAngleY = 0.0F;
	bipedLeftArm.rotateAngleY = 0.0F;
	float f6;
	float f7;

	if (onGround > -9990.0F) {
	    f6 = onGround;
	    bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6)
		    * (float) Math.PI * 2.0F) * 0.2F;
	    bipedRightArm.rotationPointZ = MathHelper
		    .sin(bipedBody.rotateAngleY) * 5.0F;
	    bipedRightArm.rotationPointX = -MathHelper
		    .cos(bipedBody.rotateAngleY) * 5.0F;
	    bipedLeftArm.rotationPointZ = -MathHelper
		    .sin(bipedBody.rotateAngleY) * 5.0F;
	    bipedLeftArm.rotationPointX = MathHelper
		    .cos(bipedBody.rotateAngleY) * 5.0F;
	    bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
	    bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
	    bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
	    f6 = 1.0F - onGround;
	    f6 *= f6;
	    f6 *= f6;
	    f6 = 1.0F - f6;
	    f7 = MathHelper.sin(f6 * (float) Math.PI);
	    final float f8 = MathHelper.sin(onGround * (float) Math.PI)
		    * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
	    bipedRightArm.rotateAngleX = (float) (bipedRightArm.rotateAngleX - (f7 * 1.2D + f8));
	    bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
	    bipedRightArm.rotateAngleZ = MathHelper.sin(onGround
		    * (float) Math.PI)
		    * -0.4F;
	}

	if (isSneak) {
	    bipedBody.rotateAngleX = 0.5F;
	    bipedRightArm.rotateAngleX += 0.4F;
	    bipedLeftArm.rotateAngleX += 0.4F;
	    bipedRightLeg.rotationPointZ = 4.0F;
	    bipedLeftLeg.rotationPointZ = 4.0F;
	    bipedRightLeg.rotationPointY = 9.0F;
	    bipedLeftLeg.rotationPointY = 9.0F;
	    bipedHead.rotationPointY = 1.0F;
	    bipedHeadwear.rotationPointY = 1.0F;
	} else {
	    bipedBody.rotateAngleX = 0.0F;
	    bipedRightLeg.rotationPointZ = 0.1F;
	    bipedLeftLeg.rotationPointZ = 0.1F;
	    bipedRightLeg.rotationPointY = 12.0F;
	    bipedLeftLeg.rotationPointY = 12.0F;
	    bipedHead.rotationPointY = 0.0F;
	    bipedHeadwear.rotationPointY = 0.0F;
	}

	bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
	bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

	if (aimedBow) {
	    f6 = 0.0F;
	    f7 = 0.0F;
	    bipedRightArm.rotateAngleZ = 0.0F;
	    bipedLeftArm.rotateAngleZ = 0.0F;
	    bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F)
		    + bipedHead.rotateAngleY;
	    bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F
		    + bipedHead.rotateAngleY + 0.4F;
	    bipedRightArm.rotateAngleX = -((float) Math.PI / 2F)
		    + bipedHead.rotateAngleX;
	    bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F)
		    + bipedHead.rotateAngleX;
	    bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
	    bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
	    bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	    bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	    bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
	    bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
	}
    }
}
