package com.warlordjones.steampunkery.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

//Model code generated by MCModeller. All animation, AI,
//and special features are yours to program. Also keep in
//mind that some of these class names may have changed since
//wrote this. Make sure to check for compatibility with the
//latest version of the Minecraft Coder Pack before attempting
//to use this code.

public class ModelMusket extends ModelBase {
    public ModelRenderer stock;
    public ModelRenderer barrel;
    public ModelRenderer pin;
    public ModelRenderer sight;

    public ModelMusket() {
	stock = new ModelRenderer(this, 0, 0);
	stock.addBox(-1.0F, -0.0F, -0.0F, 2, 2, 10, 0);

	barrel = new ModelRenderer(this, 0, 0);
	barrel.addBox(-0.5F, -0.5F, -7.5F, 1, 1, 15, 0);

	pin = new ModelRenderer(this, 0, 0);
	pin.addBox(-0.5F, -1.5F, 7.0F, 1, 2, 1, 0);

	sight = new ModelRenderer(this, 0, 0);
	sight.addBox(-0.0F, -1.5F, -7.5F, 0, 1, 1, 0);

    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
	this.setRotationAngles(f, f1, f2, f3, f4, f5);
	stock.render(f5);
	barrel.render(f5);
	pin.render(f5);
	sight.render(f5);
    }

    public void renderModel(float f, float f1, float f2, float f3, float f4,
	    float f5) {
	this.setRotationAngles(f, f1, f2, f3, f4, f5);
	stock.render(f5);
	barrel.render(f5);
	pin.render(f5);
	sight.render(f5);
    }

    // Method you're going to want to override:
    public void setRotationAngles(float f, float f1, float f2, float f3,
	    float f4, float f5) {
    }

}
