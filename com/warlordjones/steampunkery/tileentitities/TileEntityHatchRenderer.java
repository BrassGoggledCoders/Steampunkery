package com.warlordjones.steampunkery.tileentitities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentitities.models.ModelHatch;
import com.warlordjones.steampunkery.tileentitities.models.ModelIBeam;

public class TileEntityHatchRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/ibeam.png");
    private ModelHatch model;

    public TileEntityHatchRenderer() {
	model = new ModelHatch();
    }

    public void renderAModelAt(TileEntityHatch tileentity, double d,
	    double d1, double d2, float f) {
	bindTexture(ibeamTextures);
	GL11.glPushMatrix(); // start
	GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
		(float) d2 + 0.5F); // size
	GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); // change the first 0 in like 90 to
					     // make it rotate 90 degrees.
	GL11.glScalef(1.0F, -1F, -1F);
	model.render(0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F); 
	GL11.glPopMatrix(); // end
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1,
	    double d2, float f) {
	renderAModelAt((TileEntityHatch) tileentity, d, d1, d2, f); // where
									 // to
									 // render
    }
}
