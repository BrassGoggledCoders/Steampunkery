/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.util;

import java.util.EnumSet;
import java.util.logging.Level;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.items.SteamItems;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class IGuiOverlayScheduledTickHandler implements ITickHandler,
	IScheduledTickHandler {
    protected static final ResourceLocation gogglesBlurTexPath = new ResourceLocation(
	    "steampunkery" + ":" + "/textures/misc/gogglesblur.png");
    private final Minecraft mc;

    public IGuiOverlayScheduledTickHandler() {
	mc = Minecraft.getMinecraft();
    }

    @Override
    public String getLabel() {
	return "tickhandler";
    }

    @Override
    public int nextTickSpacing() {
	// TODO Auto-generated method stub
	return 5;
    }

    @Override
    public void tickEnd(final EnumSet<TickType> type, final Object... tickData) {
	// setup render
	if (Minecraft.getMinecraft().theWorld != null
		&& Minecraft.getMinecraft().thePlayer != null) {
	    final ScaledResolution res = new ScaledResolution(mc.gameSettings,
		    mc.displayWidth, mc.displayHeight);
	    final int width = res.getScaledWidth();
	    final int height = res.getScaledHeight();
	    mc.entityRenderer.setupOverlayRendering();
	    final ItemStack itemStack = mc.thePlayer.inventory
		    .armorItemInSlot(3);
	    if (Minecraft.getMinecraft().currentScreen == null
		    && itemStack != null
		    && itemStack.itemID == SteamItems.goggles.itemID
		    && mc.gameSettings.thirdPersonView == 0)
		renderGogglesBlur(width, height);
	    // else
	    // if(Minecraft.getMinecraft().currentScreen==null&&mc.gameSettings.thirdPersonView==0&&)
	    // renderGogglesBlur(
	    // width,height);
	    else
		return;
	} else
	    return;
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Tick...");
    }

    @Override
    public EnumSet<TickType> ticks() {
	return EnumSet.of(TickType.RENDER);
    }

    @Override
    public void tickStart(final EnumSet<TickType> type,
	    final Object... tickData) {
    }

    protected void renderGogglesBlur(final int par1, final int par2) {
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glDepthMask(false);
	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	GL11.glDisable(GL11.GL_ALPHA_TEST);
	mc.getTextureManager().bindTexture(
		IGuiOverlayScheduledTickHandler.gogglesBlurTexPath);
	final Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	tessellator.addVertexWithUV(0.0D, par2, -90.0D, 0.0D, 1.0D);
	tessellator.addVertexWithUV(par1, par2, -90.0D, 1.0D, 1.0D);
	tessellator.addVertexWithUV(par1, 0.0D, -90.0D, 1.0D, 0.0D);
	tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
	tessellator.draw();
	GL11.glDepthMask(true);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	GL11.glEnable(GL11.GL_ALPHA_TEST);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}