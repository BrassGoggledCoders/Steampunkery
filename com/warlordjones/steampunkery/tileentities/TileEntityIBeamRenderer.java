package com.warlordjones.steampunkery.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentities.models.ModelIBeam;

public class TileEntityIBeamRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/ibeam.png");
    private ModelIBeam model;

    public TileEntityIBeamRenderer() {
	model = new ModelIBeam();
    }

    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
	int meta = world.getBlockMetadata(x, y, z);
	GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z,
	    float scale) {
	GL11.glPushMatrix();
	this.bindTexture(ibeamTextures);
	adjustRotatePivotViaMeta(te.worldObj, te.xCoord, te.yCoord, te.zCoord);// rotation
									       // 1
	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	// adjustRotatePivotViaMeta(te.worldObj, te.xCoord, te.yCoord,
	// te.zCoord);//comment line "rotation 1" and uncomment this line if it
	// doesnt work.
	model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	GL11.glPopMatrix();
    }
}
