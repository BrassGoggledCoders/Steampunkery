/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gui.player;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiSteamCustomPlayerInventory extends GuiContainer {
    /**
     * Normally I use '(ModInfo.MOD_ID, "textures/...")', but it can be done
     * this way as well
     */
    private static final ResourceLocation iconLocation = new ResourceLocation

    ("steampunkery:textures/gui/custom_inventory.png");

    /**
     * Copied straight out of vanilla - renders the player model on screen
     */
    public static void drawPlayerModel(final int par0, final int par1,
	    final int par2, final float par3, final float par4,
	    final EntityLivingBase

	    par5EntityLivingBase) {
	GL11.glEnable(GL11.GL_COLOR_MATERIAL);
	GL11.glPushMatrix();
	GL11.glTranslatef(par0, par1, 50.0F);
	GL11.glScalef(-par2, par2, par2);
	GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	final float f2 = par5EntityLivingBase.renderYawOffset;
	final float f3 = par5EntityLivingBase.rotationYaw;
	final float f4 = par5EntityLivingBase.rotationPitch;
	final float f5 = par5EntityLivingBase.prevRotationYawHead;
	final float f6 = par5EntityLivingBase.rotationYawHead;
	GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
	RenderHelper.enableStandardItemLighting();
	GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
	GL11.glRotatef(-((float) Math.atan(par4 / 40.0F)) * 20.0F, 1.0F, 0.0F,
		0.0F);
	par5EntityLivingBase.renderYawOffset = (float) Math.atan(par3 / 40.0F) * 20.0F;
	par5EntityLivingBase.rotationYaw = (float) Math.atan(par3 / 40.0F) * 40.0F;
	par5EntityLivingBase.rotationPitch = -((float) Math.atan(par4 / 40.0F)) * 20.0F;
	par5EntityLivingBase.rotationYawHead = par5EntityLivingBase.rotationYaw;
	par5EntityLivingBase.prevRotationYawHead = par5EntityLivingBase.rotationYaw;
	GL11.glTranslatef(0.0F, par5EntityLivingBase.yOffset, 0.0F);
	RenderManager.instance.playerViewY = 180.0F;
	RenderManager.instance.renderEntityWithPosYaw(par5EntityLivingBase,
		0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
	par5EntityLivingBase.renderYawOffset = f2;
	par5EntityLivingBase.rotationYaw = f3;
	par5EntityLivingBase.rotationPitch = f4;
	par5EntityLivingBase.prevRotationYawHead = f5;
	par5EntityLivingBase.rotationYawHead = f6;
	GL11.glPopMatrix();
	RenderHelper.disableStandardItemLighting();
	GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	GL11.glDisable(GL11.GL_TEXTURE_2D);
	OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    /**
     * Could use IInventory type to be more generic, but this way will save an
     * import...
     */
    private final SteamCustomPlayerInventory inventory;

    /**
     * x size of the inventory window in pixels. Defined as float, passed as int
     */
    private float xSize_lo;

    /**
     * y size of the inventory window in pixels. Defined as float, passed as
     * int.
     */
    private float ySize_lo;

    public GuiSteamCustomPlayerInventory(final EntityPlayer player,
	    final InventoryPlayer inventoryPlayer,
	    final SteamCustomPlayerInventory

	    inventoryCustom) {
	super(new ContainerSteamCustomPlayer(player, inventoryPlayer,
		inventoryCustom));
	inventory = inventoryCustom;
	// if you need the player for something later on, store it in a local
	// variable here as well
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(final int par1, final int par2, final float par3) {
	super.drawScreen(par1, par2, par3);
	xSize_lo = par1;
	ySize_lo = par2;
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the
     * items)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(final float par1,
	    final int par2, final int par3) {
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	mc.getTextureManager().bindTexture(
		GuiSteamCustomPlayerInventory.iconLocation);
	final int k = (width - xSize) / 2;
	final int l = (height - ySize) / 2;
	drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	GuiSteamCustomPlayerInventory.drawPlayerModel(k + 51, l + 75, 30, k
		+ 51 - xSize_lo, l + 75 - 50 - ySize_lo,

	mc.thePlayer);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(final int par1,
	    final int par2) {
	// This method will simply draw inventory names on the screen - you
	// could do without it entirely
	// if that's not important to you, since we are overriding the default
	// inventory rather than
	// creating a specific type of inventory

	final String s = inventory.isInvNameLocalized() ? inventory
		.getInvName() : I18n.getString(inventory.getInvName());

	// with the name "Custom Inventory", the 'Cu' will be drawn in the first
	// slot
	fontRenderer.drawString(s, xSize - fontRenderer.getStringWidth(s), 12,
		4210752);
	// this just adds "Inventory" above the player's inventory below
	fontRenderer.drawString(I18n.getString("container.inventory"), 80,
		ySize - 96, 4210752);
    }
}