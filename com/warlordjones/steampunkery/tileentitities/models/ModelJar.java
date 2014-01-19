package com.warlordjones.steampunkery.tileentitities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

//Model code generated by MCModeller. All animation, AI,
//and special features are yours to program. Also keep in
//mind that some of these class names may have changed since
//wrote this. Make sure to check for compatibility with the
//latest version of the Minecraft Coder Pack before attempting
//to use this code.

public class ModelJar extends ModelBase {
    public ModelRenderer jar;
    public ModelRenderer lid;
    public ModelRenderer jar1;
    public ModelRenderer jar2;
    public ModelRenderer jar3;
    public ModelRenderer bottom;

    public ModelJar() {
	jar = new ModelRenderer(this, 0, 0);
	jar.addBox(-4.5F, 1.0F, -5.0F, 1, 12, 10, 0);

	lid = new ModelRenderer(this, 0, 0);
	lid.addBox(-4.0F, -1.0F, -4.0F, 8, 2, 8, 0);

	jar1 = new ModelRenderer(this, 0, 0);
	jar1.addBox(3.5F, 1.0F, -4.0F, 1, 12, 8, 0);

	jar2 = new ModelRenderer(this, 0, 0);
	jar2.addBox(-4.0F, 1.0F, 3.0F, 8, 12, 2, 0);

	jar3 = new ModelRenderer(this, 0, 0);
	jar3.addBox(-4.0F, 1.0F, -5.0F, 8, 12, 2, 0);

	bottom = new ModelRenderer(this, 0, 0);
	bottom.addBox(-4.5F, 11.0F, -4.5F, 9, 2, 9, 0);

    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
	this.setRotationAngles(f, f1, f2, f3, f4, f5);
	jar.render(f5);
	lid.render(f5);
	jar1.render(f5);
	jar2.render(f5);
	jar3.render(f5);
	bottom.render(f5);
    }

    public void renderModel(float f, float f1, float f2, float f3, float f4,
	    float f5) {
	this.setRotationAngles(f, f1, f2, f3, f4, f5);
	jar.render(f5);
	lid.render(f5);
	jar1.render(f5);
	jar2.render(f5);
	jar3.render(f5);
	bottom.render(f5);
    }

    // Method you're going to want to override:
    public void setRotationAngles(float f, float f1, float f2, float f3,
	    float f4, float f5) {
    }

}
