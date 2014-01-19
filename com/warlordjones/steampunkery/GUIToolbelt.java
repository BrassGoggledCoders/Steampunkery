package com.warlordjones.steampunkery;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.items.Toolbelt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIToolbelt extends GuiScreen {
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation(
	    SteamConstants.prefix + "textures/gui/toolbelt.png");

    public GUIToolbelt(InventoryPlayer par1InventoryPlayer, Toolbelt toolbelt,
	    int par3, int par4, int par5) {
	super();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	this.fontRenderer.drawString(I18n.getString("container.crafting"), 28,
		6, 4210752);
	this.fontRenderer.drawString(I18n.getString("container.inventory"), 8,
		this.width - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the
     * items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
	    int par3) {
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
	int k = (this.width - this.height) / 2;
	int l = (this.height - this.width) / 2;
	this.drawTexturedModalRect(k, l, 0, 0, this.height, this.width);
    }
}
