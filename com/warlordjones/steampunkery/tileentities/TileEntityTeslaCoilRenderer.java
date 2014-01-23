package com.warlordjones.steampunkery.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentities.models.ModelTeslaCoil;

public class TileEntityTeslaCoilRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/tesla_coil.png");
    private ModelTeslaCoil model; // yup, this refers to the last file. so
				  // you'll
				  // get an error for now. it says what model it
				  // has
				  // to take

    public TileEntityTeslaCoilRenderer() {
	model = new ModelTeslaCoil();
    }

    public void renderAModelAt(TileEntityTeslaCoil tile, double d, double d1,
	    double d2, float f) {
	bindTexture(ibeamTextures);
	GL11.glPushMatrix(); // start
	GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
		(float) d2 + 0.5F); // size
	GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); // change the first 0 in like 90 to
					     // make it rotate 90 degrees.
	GL11.glScalef(1.0F, -1F, -1F); // to make your block have a normal
				       // positioning. comment out to see what
				       // happens
	model.renderModel(0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F); // renders
										 // and
										 // 0.0625F
										 // is
										 // exactly
										 // 1/16.
										 // every
										 // block
										 // has
										 // 16
										 // entitys/pixels.
										 // if
										 // you
										 // make
										 // the
										 // number
										 // 1,
										 // every
										 // pixel
										 // will
										 // be
										 // as
										 // big
										 // as
										 // a
										 // block.
										 // make
										 // it
										 // 0.03125
										 // and
										 // your
										 // block
										 // will
										 // be
										 // half
										 // as
										 // big
										 // as
										 // a
										 // normal
										 // one.
	GL11.glPopMatrix(); // end
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1,
	    double d2, float f) {
	renderAModelAt((TileEntityTeslaCoil) tileentity, d, d1, d2, f); // where
									// to
									// render
    }
}
