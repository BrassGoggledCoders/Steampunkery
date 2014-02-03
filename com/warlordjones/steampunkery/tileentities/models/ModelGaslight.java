/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.tileentities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

//Model code generated by MCModeller. All animation, AI,
//and special features are yours to program. Also keep in
//mind that some of these class names may have changed since
//wrote this. Make sure to check for compatibility with the
//latest version of the Minecraft Coder Pack before attempting
//to use this code.

public class ModelGaslight extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer light;
    public ModelRenderer side;
    public ModelRenderer side1;
    public ModelRenderer side2;
    public ModelRenderer side3;
    public ModelRenderer top;
    public ModelRenderer top2;
    public ModelRenderer top3;

    public ModelGaslight() {
	base = new ModelRenderer(this, 0, 0);
	base.addBox(-4.0F, 15.0F, -4.0F, 8, 2, 8, 0);

	side = new ModelRenderer(this, 0, 0);
	side.addBox(-4.0F, 7.0F, 2.0F, 2, 8, 2, 0);

	side1 = new ModelRenderer(this, 0, 0);
	side1.addBox(2.0F, 7.0F, 2.0F, 2, 8, 2, 0);

	side2 = new ModelRenderer(this, 0, 0);
	side2.addBox(-4.0F, 7.0F, -4.0F, 2, 8, 2, 0);

	side3 = new ModelRenderer(this, 0, 0);
	side3.addBox(2.0F, 7.0F, -4.0F, 2, 8, 2, 0);

	top = new ModelRenderer(this, 0, 0);
	top.addBox(-6.0F, 5.0F, -6.0F, 12, 2, 12, 0);

	top2 = new ModelRenderer(this, 0, 0);
	top2.addBox(-4.0F, 3.0F, -4.0F, 8, 2, 8, 0);

	top3 = new ModelRenderer(this, 0, 0);
	top3.addBox(-2.0F, 0.5F, -2.0F, 4, 3, 4, 0);

	light = new ModelRenderer(this, 0, 0);
	light.addBox(-1.0F, 11.0F, -1.0F, 2, 4, 2, 0);
    }

    public void render(final float f, final float f1, final float f2,
	    final float f3, final float f4, final float f5) {
	this.setRotationAngles(f, f1, f2, f3, f4, f5);
	base.render(f5);
	side.render(f5);
	side1.render(f5);
	side2.render(f5);
	side3.render(f5);
	top.render(f5);
	top2.render(f5);
	top3.render(f5);
	light.render(f5);
    }

    public void renderModel(final float f, final float f1, final float f2,
	    final float f3, final float f4, final float f5) {
	this.setRotationAngles(f, f1, f2, f3, f4, f5);
	base.render(f5);
	side.render(f5);
	side1.render(f5);
	side2.render(f5);
	side3.render(f5);
	top.render(f5);
	top2.render(f5);
	top3.render(f5);
	light.render(f5);
    }

    // Method you're going to want to override:
    public void setRotationAngles(final float f, final float f1,
	    final float f2, final float f3, final float f4, final float f5) {
    }

}
