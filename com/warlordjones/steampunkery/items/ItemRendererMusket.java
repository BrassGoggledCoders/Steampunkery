/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.SteamConstants;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRendererMusket implements IItemRenderer {
    private static final ResourceLocation musketTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/alloy_blocks2.png");
    protected ModelMusket musket_model;

    public ItemRendererMusket() {
	musket_model = new ModelMusket();
    }

    @Override
    public boolean handleRenderType(final ItemStack item,
	    final ItemRenderType type) {
	switch (type) {
	case EQUIPPED: {
	    return true;
	}

	case EQUIPPED_FIRST_PERSON: {
	    return true;
	}

	default: {
	    return false;
	}
	}
    }

    @Override
    public void renderItem(final ItemRenderType type, final ItemStack item,
	    final Object... data) {
	switch (type) {
	case EQUIPPED: {
	    GL11.glPushMatrix();
	    Minecraft.getMinecraft().renderEngine
		    .bindTexture(ItemRendererMusket.musketTextures);
	    GL11.glScalef(1.5F, 1.5F, 1.5F);
	    GL11.glRotatef(-80F, 1F, 0F, 0F);
	    GL11.glRotatef(-120F, 0F, 1F, 0F);
	    GL11.glRotatef(85F, 0F, 0F, 1F);
	    GL11.glTranslatef(0.0F, -0.1F, -0.7F);
	    musket_model.renderModel(0F, 0F, 0F, 0F, 0F, 0.0625F);
	    GL11.glPopMatrix();
	    break;
	}
	case EQUIPPED_FIRST_PERSON: {
	    GL11.glPushMatrix();
	    Minecraft.getMinecraft().renderEngine
		    .bindTexture(ItemRendererMusket.musketTextures);
	    GL11.glScalef(1.5F, 1.5F, 1.5F);
	    GL11.glRotatef(-80F, 1F, 0F, 0F);
	    GL11.glRotatef(-120F, 0F, 1F, 0F);
	    GL11.glRotatef(85F, 0F, 0F, 1F);
	    GL11.glTranslatef(0.0F, -0.1F, -0.7F);
	    musket_model.renderModel(0F, 0F, 0F, 0F, 0F, 0.0625F);
	    GL11.glPopMatrix();
	    break;
	}
	default: {
	    break;
	}
	}

    }

    @Override
    public boolean shouldUseRenderHelper(final ItemRenderType type,
	    final ItemStack item, final ItemRendererHelper helper) {
	return false;
    }

}
