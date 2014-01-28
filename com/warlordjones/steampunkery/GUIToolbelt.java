package com.warlordjones.steampunkery;

import com.warlordjones.steampunkery.items.Toolbelt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GUIToolbelt extends GuiScreen {
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation(
	    SteamConstants.prefix + "textures/gui/toolbelt.png");

    public GUIToolbelt(final InventoryPlayer par1InventoryPlayer,
	    final Toolbelt toolbelt, final int par3, final int par4,
	    final int par5) {
	super();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the
     * items)
     */
    protected void drawGuiContainerBackgroundLayer(final float par1,
	    final int par2, final int par3) {
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	mc.getTextureManager()
		.bindTexture(GUIToolbelt.craftingTableGuiTextures);
	final int k = (width - height) / 2;
	final int l = (height - width) / 2;
	drawTexturedModalRect(k, l, 0, 0, height, width);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    protected void drawGuiContainerForegroundLayer(final int par1,
	    final int par2) {
	fontRenderer.drawString(I18n.getString("container.crafting"), 28, 6,
		4210752);
	fontRenderer.drawString(I18n.getString("container.inventory"), 8,
		width - 96 + 2, 4210752);
    }
}
