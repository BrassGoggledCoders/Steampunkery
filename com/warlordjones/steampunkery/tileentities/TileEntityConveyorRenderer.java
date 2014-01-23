package com.warlordjones.steampunkery.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentities.models.ModelConveyor;

public class TileEntityConveyorRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/conveyor_belt.png");
    private ModelConveyor model; // yup, this refers to the last file. so you'll
				 // get an error for now. it says what model it
				 // has to take

    public TileEntityConveyorRenderer() {
	model = new ModelConveyor();
    }

    public void renderAModelAt(TileEntityConveyor tileentity, double d,
	    double d1, double d2, float f) {
	bindTexture(ibeamTextures);
	GL11.glPushMatrix(); // start
	GL11.glTranslatef((float) d + 0.5F, (float) d1,
		(float) d2 + 0.5F); // size
	GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
	GL11.glScalef(1.0F, -1F, -1F);
	model.render(0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F); 
	GL11.glPopMatrix(); // end
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1,
	    double d2, float f) {
	renderAModelAt((TileEntityConveyor) tileentity, d, d1, d2, f); // where
								       // to
								       // render
    }
}
