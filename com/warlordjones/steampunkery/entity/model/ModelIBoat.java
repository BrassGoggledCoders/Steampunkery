package com.warlordjones.steampunkery.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelIBoat extends ModelBase {
    public ModelRenderer[] boatSides = new ModelRenderer[5];

    public ModelIBoat() {
	boatSides[0] = new ModelRenderer(this, 0, 8);
	boatSides[1] = new ModelRenderer(this, 0, 0);
	boatSides[2] = new ModelRenderer(this, 0, 0);
	boatSides[3] = new ModelRenderer(this, 0, 0);
	boatSides[4] = new ModelRenderer(this, 0, 0);
	final byte b0 = 24;
	final byte b1 = 6;
	final byte b2 = 20;
	final byte b3 = 4;
	boatSides[0].addBox(-b0 / 2, -b2 / 2 + 2, -3.0F, b0, b2 - 4, 4, 0.0F);
	boatSides[0].setRotationPoint(0.0F, b3, 0.0F);
	boatSides[1].addBox(-b0 / 2 + 2, -b1 - 1, -1.0F, b0 - 4, b1, 2, 0.0F);
	boatSides[1].setRotationPoint(-b0 / 2 + 1, b3, 0.0F);
	boatSides[2].addBox(-b0 / 2 + 2, -b1 - 1, -1.0F, b0 - 4, b1, 2, 0.0F);
	boatSides[2].setRotationPoint(b0 / 2 - 1, b3, 0.0F);
	boatSides[3].addBox(-b0 / 2 + 2, -b1 - 1, -1.0F, b0 - 4, b1, 2, 0.0F);
	boatSides[3].setRotationPoint(0.0F, b3, -b2 / 2 + 1);
	boatSides[4].addBox(-b0 / 2 + 2, -b1 - 1, -1.0F, b0 - 4, b1, 2, 0.0F);
	boatSides[4].setRotationPoint(0.0F, b3, b2 / 2 - 1);
	boatSides[0].rotateAngleX = (float) Math.PI / 2F;
	boatSides[1].rotateAngleY = (float) Math.PI * 3F / 2F;
	boatSides[2].rotateAngleY = (float) Math.PI / 2F;
	boatSides[3].rotateAngleY = (float) Math.PI;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(final Entity par1Entity, final float par2,
	    final float par3, final float par4, final float par5,
	    final float par6, final float par7) {
	for (int i = 0; i < 5; ++i)
	    boatSides[i].render(par7);
    }
}
