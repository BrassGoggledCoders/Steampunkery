package com.warlordjones.steampunkery.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.entity.EntityMechanicalHorse;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelMechanicalHorse extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer mouthTop;
    private ModelRenderer mouthBottom;
    private ModelRenderer horseLeftEar;
    private ModelRenderer horseRightEar;
    private ModelRenderer field_110703_f;
    private ModelRenderer field_110704_g;
    private ModelRenderer neck;
    private ModelRenderer field_110717_i;
    private ModelRenderer mane;
    private ModelRenderer body;
    private ModelRenderer tailBase;
    private ModelRenderer tailMiddle;
    private ModelRenderer tailTip;
    private ModelRenderer backLeftLeg;
    private ModelRenderer backLeftShin;
    private ModelRenderer backLeftHoof;
    private ModelRenderer backRightLeg;
    private ModelRenderer backRightShin;
    private ModelRenderer backRightHoof;
    private ModelRenderer frontRightLeg;
    private ModelRenderer frontLeftShin;
    private ModelRenderer frontLeftHoof;
    private ModelRenderer field_110684_D;
    private ModelRenderer frontRightShin;
    private ModelRenderer frontRightHoof;
    private ModelRenderer field_110687_G;
    private ModelRenderer field_110695_H;
    private ModelRenderer field_110696_I;
    private ModelRenderer field_110697_J;
    private ModelRenderer field_110698_K;
    private ModelRenderer field_110691_L;
    private ModelRenderer field_110692_M;
    private ModelRenderer field_110693_N;
    private ModelRenderer field_110694_O;
    private ModelRenderer field_110700_P;
    private ModelRenderer field_110699_Q;
    private ModelRenderer field_110702_R;
    private ModelRenderer field_110701_S;

    public ModelMechanicalHorse() {
	this.textureWidth = 128;
	this.textureHeight = 128;
	this.body = new ModelRenderer(this, 0, 34);
	this.body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24);
	this.body.setRotationPoint(0.0F, 11.0F, 9.0F);
	this.tailBase = new ModelRenderer(this, 44, 0);
	this.tailBase.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
	this.tailBase.setRotationPoint(0.0F, 3.0F, 14.0F);
	this.func_110682_a(this.tailBase, -1.134464F, 0.0F, 0.0F);
	this.tailMiddle = new ModelRenderer(this, 38, 7);
	this.tailMiddle.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7);
	this.tailMiddle.setRotationPoint(0.0F, 3.0F, 14.0F);
	this.func_110682_a(this.tailMiddle, -1.134464F, 0.0F, 0.0F);
	this.tailTip = new ModelRenderer(this, 24, 3);
	this.tailTip.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7);
	this.tailTip.setRotationPoint(0.0F, 3.0F, 14.0F);
	this.func_110682_a(this.tailTip, -1.40215F, 0.0F, 0.0F);
	this.backLeftLeg = new ModelRenderer(this, 78, 29);
	this.backLeftLeg.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5);
	this.backLeftLeg.setRotationPoint(4.0F, 9.0F, 11.0F);
	this.backLeftShin = new ModelRenderer(this, 78, 43);
	this.backLeftShin.addBox(-2.0F, 0.0F, -1.5F, 3, 5, 3);
	this.backLeftShin.setRotationPoint(4.0F, 16.0F, 11.0F);
	this.backLeftHoof = new ModelRenderer(this, 78, 51);
	this.backLeftHoof.addBox(-2.5F, 5.1F, -2.0F, 4, 3, 4);
	this.backLeftHoof.setRotationPoint(4.0F, 16.0F, 11.0F);
	this.backRightLeg = new ModelRenderer(this, 96, 29);
	this.backRightLeg.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5);
	this.backRightLeg.setRotationPoint(-4.0F, 9.0F, 11.0F);
	this.backRightShin = new ModelRenderer(this, 96, 43);
	this.backRightShin.addBox(-1.0F, 0.0F, -1.5F, 3, 5, 3);
	this.backRightShin.setRotationPoint(-4.0F, 16.0F, 11.0F);
	this.backRightHoof = new ModelRenderer(this, 96, 51);
	this.backRightHoof.addBox(-1.5F, 5.1F, -2.0F, 4, 3, 4);
	this.backRightHoof.setRotationPoint(-4.0F, 16.0F, 11.0F);
	this.frontRightLeg = new ModelRenderer(this, 44, 29);
	this.frontRightLeg.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4);
	this.frontRightLeg.setRotationPoint(4.0F, 9.0F, -8.0F);
	this.frontLeftShin = new ModelRenderer(this, 44, 41);
	this.frontLeftShin.addBox(-1.9F, 0.0F, -1.6F, 3, 5, 3);
	this.frontLeftShin.setRotationPoint(4.0F, 16.0F, -8.0F);
	this.frontLeftHoof = new ModelRenderer(this, 44, 51);
	this.frontLeftHoof.addBox(-2.4F, 5.1F, -2.1F, 4, 3, 4);
	this.frontLeftHoof.setRotationPoint(4.0F, 16.0F, -8.0F);
	this.field_110684_D = new ModelRenderer(this, 60, 29);
	this.field_110684_D.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4);
	this.field_110684_D.setRotationPoint(-4.0F, 9.0F, -8.0F);
	this.frontRightShin = new ModelRenderer(this, 60, 41);
	this.frontRightShin.addBox(-1.1F, 0.0F, -1.6F, 3, 5, 3);
	this.frontRightShin.setRotationPoint(-4.0F, 16.0F, -8.0F);
	this.frontRightHoof = new ModelRenderer(this, 60, 51);
	this.frontRightHoof.addBox(-1.6F, 5.1F, -2.1F, 4, 3, 4);
	this.frontRightHoof.setRotationPoint(-4.0F, 16.0F, -8.0F);
	this.head = new ModelRenderer(this, 0, 0);
	this.head.addBox(-2.5F, -10.0F, -1.5F, 5, 5, 7);
	this.head.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.head, 0.5235988F, 0.0F, 0.0F);
	this.mouthTop = new ModelRenderer(this, 24, 18);
	this.mouthTop.addBox(-2.0F, -10.0F, -7.0F, 4, 3, 6);
	this.mouthTop.setRotationPoint(0.0F, 3.95F, -10.0F);
	this.func_110682_a(this.mouthTop, 0.5235988F, 0.0F, 0.0F);
	this.mouthBottom = new ModelRenderer(this, 24, 27);
	this.mouthBottom.addBox(-2.0F, -7.0F, -6.5F, 4, 2, 5);
	this.mouthBottom.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.mouthBottom, 0.5235988F, 0.0F, 0.0F);
	this.head.addChild(this.mouthTop);
	this.head.addChild(this.mouthBottom);
	this.horseLeftEar = new ModelRenderer(this, 0, 0);
	this.horseLeftEar.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1);
	this.horseLeftEar.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.horseLeftEar, 0.5235988F, 0.0F, 0.0F);
	this.horseRightEar = new ModelRenderer(this, 0, 0);
	this.horseRightEar.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1);
	this.horseRightEar.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.horseRightEar, 0.5235988F, 0.0F, 0.0F);
	this.field_110703_f = new ModelRenderer(this, 0, 12);
	this.field_110703_f.addBox(-2.0F, -16.0F, 4.0F, 2, 7, 1);
	this.field_110703_f.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.field_110703_f, 0.5235988F, 0.0F, 0.2617994F);
	this.field_110704_g = new ModelRenderer(this, 0, 12);
	this.field_110704_g.addBox(0.0F, -16.0F, 4.0F, 2, 7, 1);
	this.field_110704_g.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.field_110704_g, 0.5235988F, 0.0F, -0.2617994F);
	this.neck = new ModelRenderer(this, 0, 12);
	this.neck.addBox(-2.05F, -9.8F, -2.0F, 4, 14, 8);
	this.neck.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.neck, 0.5235988F, 0.0F, 0.0F);
	this.field_110687_G = new ModelRenderer(this, 0, 34);
	this.field_110687_G.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
	this.field_110687_G.setRotationPoint(-7.5F, 3.0F, 10.0F);
	this.func_110682_a(this.field_110687_G, 0.0F, ((float) Math.PI / 2F),
		0.0F);
	this.field_110695_H = new ModelRenderer(this, 0, 47);
	this.field_110695_H.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
	this.field_110695_H.setRotationPoint(4.5F, 3.0F, 10.0F);
	this.func_110682_a(this.field_110695_H, 0.0F, ((float) Math.PI / 2F),
		0.0F);
	this.field_110696_I = new ModelRenderer(this, 80, 0);
	this.field_110696_I.addBox(-5.0F, 0.0F, -3.0F, 10, 1, 8);
	this.field_110696_I.setRotationPoint(0.0F, 2.0F, 2.0F);
	this.field_110697_J = new ModelRenderer(this, 106, 9);
	this.field_110697_J.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2);
	this.field_110697_J.setRotationPoint(0.0F, 2.0F, 2.0F);
	this.field_110698_K = new ModelRenderer(this, 80, 9);
	this.field_110698_K.addBox(-4.0F, -1.0F, 3.0F, 8, 1, 2);
	this.field_110698_K.setRotationPoint(0.0F, 2.0F, 2.0F);
	this.field_110692_M = new ModelRenderer(this, 74, 0);
	this.field_110692_M.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
	this.field_110692_M.setRotationPoint(5.0F, 3.0F, 2.0F);
	this.field_110691_L = new ModelRenderer(this, 70, 0);
	this.field_110691_L.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
	this.field_110691_L.setRotationPoint(5.0F, 3.0F, 2.0F);
	this.field_110694_O = new ModelRenderer(this, 74, 4);
	this.field_110694_O.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
	this.field_110694_O.setRotationPoint(-5.0F, 3.0F, 2.0F);
	this.field_110693_N = new ModelRenderer(this, 80, 0);
	this.field_110693_N.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
	this.field_110693_N.setRotationPoint(-5.0F, 3.0F, 2.0F);
	this.field_110700_P = new ModelRenderer(this, 74, 13);
	this.field_110700_P.addBox(1.5F, -8.0F, -4.0F, 1, 2, 2);
	this.field_110700_P.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.field_110700_P, 0.5235988F, 0.0F, 0.0F);
	this.field_110699_Q = new ModelRenderer(this, 74, 13);
	this.field_110699_Q.addBox(-2.5F, -8.0F, -4.0F, 1, 2, 2);
	this.field_110699_Q.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.field_110699_Q, 0.5235988F, 0.0F, 0.0F);
	this.field_110702_R = new ModelRenderer(this, 44, 10);
	this.field_110702_R.addBox(2.6F, -6.0F, -6.0F, 0, 3, 16);
	this.field_110702_R.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.field_110701_S = new ModelRenderer(this, 44, 5);
	this.field_110701_S.addBox(-2.6F, -6.0F, -6.0F, 0, 3, 16);
	this.field_110701_S.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.mane = new ModelRenderer(this, 58, 0);
	this.mane.addBox(-1.0F, -11.5F, 5.0F, 2, 16, 4);
	this.mane.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.mane, 0.5235988F, 0.0F, 0.0F);
	this.field_110717_i = new ModelRenderer(this, 80, 12);
	this.field_110717_i.addBox(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
	this.field_110717_i.setRotationPoint(0.0F, 4.0F, -10.0F);
	this.func_110682_a(this.field_110717_i, 0.5235988F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4,
	    float par5, float par6, float par7) {
	EntityMechanicalHorse entitymechhorse = (EntityMechanicalHorse) par1Entity;
	int i = entitymechhorse.getHorseType();
	boolean flag3 = i == 1 || i == 2;
	boolean flag4 = entitymechhorse.riddenByEntity != null;
	    GL11.glPushMatrix();
	    GL11.glScalef(1, 0.5F + 1 * 0.5F, 1);
	    GL11.glTranslatef(0.0F, 0.95F * (1.0F - 1), 0.0F);
	this.backLeftLeg.render(par7);
	this.backLeftShin.render(par7);
	this.backLeftHoof.render(par7);
	this.backRightLeg.render(par7);
	this.backRightShin.render(par7);
	this.backRightHoof.render(par7);
	this.frontRightLeg.render(par7);
	this.frontLeftShin.render(par7);
	this.frontLeftHoof.render(par7);
	this.field_110684_D.render(par7);
	this.frontRightShin.render(par7);
	this.frontRightHoof.render(par7);
	    GL11.glPopMatrix();
	    GL11.glPushMatrix();
	    GL11.glScalef(1, 1, 1);
	    GL11.glTranslatef(0.0F, 1.35F * (1.0F - 1), 0.0F);

	this.body.render(par7);
	this.tailBase.render(par7);
	this.tailMiddle.render(par7);
	this.tailTip.render(par7);
	this.neck.render(par7);
	this.mane.render(par7);
	if (flag3) {
	    this.field_110703_f.render(par7);
	    this.field_110704_g.render(par7);
	} else {
	    this.horseLeftEar.render(par7);
	    this.horseRightEar.render(par7);
	}

	this.head.render(par7);
    }

    private void func_110682_a(ModelRenderer par1ModelRenderer, float par2,
	    float par3, float par4) {
	par1ModelRenderer.rotateAngleX = par2;
	par1ModelRenderer.rotateAngleY = par3;
	par1ModelRenderer.rotateAngleZ = par4;
    }

    private float func_110683_a(float par1, float par2, float par3) {
	float f3;

	for (f3 = par2 - par1; f3 < -180.0F; f3 += 360.0F) {
	    ;
	}

	while (f3 >= 180.0F) {
	    f3 -= 360.0F;
	}

	return par1 + par3 * f3;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third
     * float params here are the same second and third as in the
     * setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase par1EntityLivingBase,
	    float par2, float par3, float par4) {
	
    }
}
