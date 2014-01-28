package com.warlordjones.steampunkery.entity.model;

import com.warlordjones.steampunkery.entity.EntityMechanicalHorse;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelMechanicalHorse extends ModelBase {
    private final ModelRenderer backLeftHoof;
    private final ModelRenderer backLeftLeg;
    private final ModelRenderer backLeftShin;
    private final ModelRenderer backRightHoof;
    private final ModelRenderer backRightLeg;
    private final ModelRenderer backRightShin;
    private final ModelRenderer body;
    private final ModelRenderer field_110684_D;
    private final ModelRenderer field_110687_G;
    private final ModelRenderer field_110691_L;
    private final ModelRenderer field_110692_M;
    private final ModelRenderer field_110693_N;
    private final ModelRenderer field_110694_O;
    private final ModelRenderer field_110695_H;
    private final ModelRenderer field_110696_I;
    private final ModelRenderer field_110697_J;
    private final ModelRenderer field_110698_K;
    private final ModelRenderer field_110699_Q;
    private final ModelRenderer field_110700_P;
    private final ModelRenderer field_110701_S;
    private final ModelRenderer field_110702_R;
    private final ModelRenderer field_110703_f;
    private final ModelRenderer field_110704_g;
    private final ModelRenderer field_110717_i;
    private final ModelRenderer frontLeftHoof;
    private final ModelRenderer frontLeftShin;
    private final ModelRenderer frontRightHoof;
    private final ModelRenderer frontRightLeg;
    private final ModelRenderer frontRightShin;
    private final ModelRenderer head;
    private final ModelRenderer horseLeftEar;
    private final ModelRenderer horseRightEar;
    private final ModelRenderer mane;
    private final ModelRenderer mouthBottom;
    private final ModelRenderer mouthTop;
    private final ModelRenderer neck;
    private final ModelRenderer tailBase;
    private final ModelRenderer tailMiddle;
    private final ModelRenderer tailTip;

    public ModelMechanicalHorse() {
	textureWidth = 128;
	textureHeight = 128;
	body = new ModelRenderer(this, 0, 34);
	body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24);
	body.setRotationPoint(0.0F, 11.0F, 9.0F);
	tailBase = new ModelRenderer(this, 44, 0);
	tailBase.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
	tailBase.setRotationPoint(0.0F, 3.0F, 14.0F);
	func_110682_a(tailBase, -1.134464F, 0.0F, 0.0F);
	tailMiddle = new ModelRenderer(this, 38, 7);
	tailMiddle.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7);
	tailMiddle.setRotationPoint(0.0F, 3.0F, 14.0F);
	func_110682_a(tailMiddle, -1.134464F, 0.0F, 0.0F);
	tailTip = new ModelRenderer(this, 24, 3);
	tailTip.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7);
	tailTip.setRotationPoint(0.0F, 3.0F, 14.0F);
	func_110682_a(tailTip, -1.40215F, 0.0F, 0.0F);
	backLeftLeg = new ModelRenderer(this, 78, 29);
	backLeftLeg.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5);
	backLeftLeg.setRotationPoint(4.0F, 9.0F, 11.0F);
	backLeftShin = new ModelRenderer(this, 78, 43);
	backLeftShin.addBox(-2.0F, 0.0F, -1.5F, 3, 5, 3);
	backLeftShin.setRotationPoint(4.0F, 16.0F, 11.0F);
	backLeftHoof = new ModelRenderer(this, 78, 51);
	backLeftHoof.addBox(-2.5F, 5.1F, -2.0F, 4, 3, 4);
	backLeftHoof.setRotationPoint(4.0F, 16.0F, 11.0F);
	backRightLeg = new ModelRenderer(this, 96, 29);
	backRightLeg.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5);
	backRightLeg.setRotationPoint(-4.0F, 9.0F, 11.0F);
	backRightShin = new ModelRenderer(this, 96, 43);
	backRightShin.addBox(-1.0F, 0.0F, -1.5F, 3, 5, 3);
	backRightShin.setRotationPoint(-4.0F, 16.0F, 11.0F);
	backRightHoof = new ModelRenderer(this, 96, 51);
	backRightHoof.addBox(-1.5F, 5.1F, -2.0F, 4, 3, 4);
	backRightHoof.setRotationPoint(-4.0F, 16.0F, 11.0F);
	frontRightLeg = new ModelRenderer(this, 44, 29);
	frontRightLeg.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4);
	frontRightLeg.setRotationPoint(4.0F, 9.0F, -8.0F);
	frontLeftShin = new ModelRenderer(this, 44, 41);
	frontLeftShin.addBox(-1.9F, 0.0F, -1.6F, 3, 5, 3);
	frontLeftShin.setRotationPoint(4.0F, 16.0F, -8.0F);
	frontLeftHoof = new ModelRenderer(this, 44, 51);
	frontLeftHoof.addBox(-2.4F, 5.1F, -2.1F, 4, 3, 4);
	frontLeftHoof.setRotationPoint(4.0F, 16.0F, -8.0F);
	field_110684_D = new ModelRenderer(this, 60, 29);
	field_110684_D.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4);
	field_110684_D.setRotationPoint(-4.0F, 9.0F, -8.0F);
	frontRightShin = new ModelRenderer(this, 60, 41);
	frontRightShin.addBox(-1.1F, 0.0F, -1.6F, 3, 5, 3);
	frontRightShin.setRotationPoint(-4.0F, 16.0F, -8.0F);
	frontRightHoof = new ModelRenderer(this, 60, 51);
	frontRightHoof.addBox(-1.6F, 5.1F, -2.1F, 4, 3, 4);
	frontRightHoof.setRotationPoint(-4.0F, 16.0F, -8.0F);
	head = new ModelRenderer(this, 0, 0);
	head.addBox(-2.5F, -10.0F, -1.5F, 5, 5, 7);
	head.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(head, 0.5235988F, 0.0F, 0.0F);
	mouthTop = new ModelRenderer(this, 24, 18);
	mouthTop.addBox(-2.0F, -10.0F, -7.0F, 4, 3, 6);
	mouthTop.setRotationPoint(0.0F, 3.95F, -10.0F);
	func_110682_a(mouthTop, 0.5235988F, 0.0F, 0.0F);
	mouthBottom = new ModelRenderer(this, 24, 27);
	mouthBottom.addBox(-2.0F, -7.0F, -6.5F, 4, 2, 5);
	mouthBottom.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(mouthBottom, 0.5235988F, 0.0F, 0.0F);
	head.addChild(mouthTop);
	head.addChild(mouthBottom);
	horseLeftEar = new ModelRenderer(this, 0, 0);
	horseLeftEar.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1);
	horseLeftEar.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(horseLeftEar, 0.5235988F, 0.0F, 0.0F);
	horseRightEar = new ModelRenderer(this, 0, 0);
	horseRightEar.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1);
	horseRightEar.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(horseRightEar, 0.5235988F, 0.0F, 0.0F);
	field_110703_f = new ModelRenderer(this, 0, 12);
	field_110703_f.addBox(-2.0F, -16.0F, 4.0F, 2, 7, 1);
	field_110703_f.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(field_110703_f, 0.5235988F, 0.0F, 0.2617994F);
	field_110704_g = new ModelRenderer(this, 0, 12);
	field_110704_g.addBox(0.0F, -16.0F, 4.0F, 2, 7, 1);
	field_110704_g.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(field_110704_g, 0.5235988F, 0.0F, -0.2617994F);
	neck = new ModelRenderer(this, 0, 12);
	neck.addBox(-2.05F, -9.8F, -2.0F, 4, 14, 8);
	neck.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(neck, 0.5235988F, 0.0F, 0.0F);
	field_110687_G = new ModelRenderer(this, 0, 34);
	field_110687_G.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
	field_110687_G.setRotationPoint(-7.5F, 3.0F, 10.0F);
	func_110682_a(field_110687_G, 0.0F, (float) Math.PI / 2F, 0.0F);
	field_110695_H = new ModelRenderer(this, 0, 47);
	field_110695_H.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
	field_110695_H.setRotationPoint(4.5F, 3.0F, 10.0F);
	func_110682_a(field_110695_H, 0.0F, (float) Math.PI / 2F, 0.0F);
	field_110696_I = new ModelRenderer(this, 80, 0);
	field_110696_I.addBox(-5.0F, 0.0F, -3.0F, 10, 1, 8);
	field_110696_I.setRotationPoint(0.0F, 2.0F, 2.0F);
	field_110697_J = new ModelRenderer(this, 106, 9);
	field_110697_J.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2);
	field_110697_J.setRotationPoint(0.0F, 2.0F, 2.0F);
	field_110698_K = new ModelRenderer(this, 80, 9);
	field_110698_K.addBox(-4.0F, -1.0F, 3.0F, 8, 1, 2);
	field_110698_K.setRotationPoint(0.0F, 2.0F, 2.0F);
	field_110692_M = new ModelRenderer(this, 74, 0);
	field_110692_M.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
	field_110692_M.setRotationPoint(5.0F, 3.0F, 2.0F);
	field_110691_L = new ModelRenderer(this, 70, 0);
	field_110691_L.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
	field_110691_L.setRotationPoint(5.0F, 3.0F, 2.0F);
	field_110694_O = new ModelRenderer(this, 74, 4);
	field_110694_O.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
	field_110694_O.setRotationPoint(-5.0F, 3.0F, 2.0F);
	field_110693_N = new ModelRenderer(this, 80, 0);
	field_110693_N.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
	field_110693_N.setRotationPoint(-5.0F, 3.0F, 2.0F);
	field_110700_P = new ModelRenderer(this, 74, 13);
	field_110700_P.addBox(1.5F, -8.0F, -4.0F, 1, 2, 2);
	field_110700_P.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(field_110700_P, 0.5235988F, 0.0F, 0.0F);
	field_110699_Q = new ModelRenderer(this, 74, 13);
	field_110699_Q.addBox(-2.5F, -8.0F, -4.0F, 1, 2, 2);
	field_110699_Q.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(field_110699_Q, 0.5235988F, 0.0F, 0.0F);
	field_110702_R = new ModelRenderer(this, 44, 10);
	field_110702_R.addBox(2.6F, -6.0F, -6.0F, 0, 3, 16);
	field_110702_R.setRotationPoint(0.0F, 4.0F, -10.0F);
	field_110701_S = new ModelRenderer(this, 44, 5);
	field_110701_S.addBox(-2.6F, -6.0F, -6.0F, 0, 3, 16);
	field_110701_S.setRotationPoint(0.0F, 4.0F, -10.0F);
	mane = new ModelRenderer(this, 58, 0);
	mane.addBox(-1.0F, -11.5F, 5.0F, 2, 16, 4);
	mane.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(mane, 0.5235988F, 0.0F, 0.0F);
	field_110717_i = new ModelRenderer(this, 80, 12);
	field_110717_i.addBox(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
	field_110717_i.setRotationPoint(0.0F, 4.0F, -10.0F);
	func_110682_a(field_110717_i, 0.5235988F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(final Entity par1Entity, final float par2,
	    final float par3, final float par4, final float par5,
	    final float par6, final float par7) {
	final EntityMechanicalHorse entitymechhorse = (EntityMechanicalHorse) par1Entity;
	final int i = entitymechhorse.getHorseType();
	final boolean flag3 = i == 1 || i == 2;
	GL11.glPushMatrix();
	GL11.glScalef(1, 0.5F + 1 * 0.5F, 1);
	GL11.glTranslatef(0.0F, 0.95F * (1.0F - 1), 0.0F);
	backLeftLeg.render(par7);
	backLeftShin.render(par7);
	backLeftHoof.render(par7);
	backRightLeg.render(par7);
	backRightShin.render(par7);
	backRightHoof.render(par7);
	frontRightLeg.render(par7);
	frontLeftShin.render(par7);
	frontLeftHoof.render(par7);
	field_110684_D.render(par7);
	frontRightShin.render(par7);
	frontRightHoof.render(par7);
	GL11.glPopMatrix();
	GL11.glPushMatrix();
	GL11.glScalef(1, 1, 1);
	GL11.glTranslatef(0.0F, 1.35F * (1.0F - 1), 0.0F);

	body.render(par7);
	tailBase.render(par7);
	tailMiddle.render(par7);
	tailTip.render(par7);
	neck.render(par7);
	mane.render(par7);
	if (flag3) {
	    field_110703_f.render(par7);
	    field_110704_g.render(par7);
	} else {
	    horseLeftEar.render(par7);
	    horseRightEar.render(par7);
	}

	head.render(par7);
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

    }

    private void func_110682_a(final ModelRenderer par1ModelRenderer,
	    final float par2, final float par3, final float par4) {
	par1ModelRenderer.rotateAngleX = par2;
	par1ModelRenderer.rotateAngleY = par3;
	par1ModelRenderer.rotateAngleZ = par4;
    }
}
