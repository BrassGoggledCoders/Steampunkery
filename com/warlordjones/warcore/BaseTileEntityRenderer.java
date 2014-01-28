package com.warlordjones.warcore;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentities.TileEntityTeslaCoil;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BaseTileEntityRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation Textures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/alloy_blocks3.png");

    public BaseTileEntityRenderer() {

    }

    public void renderAModelAt(final TileEntityTeslaCoil tile, final double d,
	    final double d1, final double d2, final float f) {
	bindTexture(BaseTileEntityRenderer.Textures);
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

    @Override
    public void renderTileEntityAt(final TileEntity tileentity, final double d,
	    final double d1, final double d2, final float f) {
	renderAModelAt((TileEntityTeslaCoil) tileentity, d, d1, d2, f); // where
									// to
									// render
    }
}
