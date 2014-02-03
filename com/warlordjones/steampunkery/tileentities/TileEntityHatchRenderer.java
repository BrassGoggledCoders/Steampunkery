/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.tileentities;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.blocks.Hatch;
import com.warlordjones.steampunkery.tileentities.models.ModelHatch;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class TileEntityHatchRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/ibeam.png");
    private final ModelHatch model;

    public TileEntityHatchRenderer() {
	model = new ModelHatch();
    }

    public void renderAModelAt(final TileEntityHatch tileentity,
	    final double d, final double d1, final double d2, final float f) {
	bindTexture(TileEntityHatchRenderer.ibeamTextures);
	GL11.glPushMatrix(); // start
	GL11.glTranslatef((float) d + 0.5F, (float) d1, (float) d2 + 0.5F); // size
	GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); // change the first 0 in like 90 to
	adjustRotatePivotViaMeta(tileentity.worldObj, tileentity.xCoord,
		tileentity.yCoord, tileentity.zCoord);// rotation
	if (Hatch.isTrapdoorOpen(0)) {
	    model.hatch.rotateAngleX = 1.6F;
	    model.spoke.rotateAngleX = 1.6F;
	    model.spoke1.rotateAngleX = 1.6F;
	    model.spoke2.rotateAngleX = 1.6F;
	    model.spoke3.rotateAngleX = 1.6F;
	    model.center.rotateAngleX = 1.6F;
	    model.hatch.offsetY = -0.6F;
	    model.spoke.offsetY = -0.6F;
	    model.spoke1.offsetY = -0.6F;
	    model.spoke2.offsetY = -0.6F;
	    model.spoke3.offsetY = -0.6F;
	    model.center.offsetY = -0.6F;
	    model.hatch.offsetZ = -0.3F;
	    model.spoke.offsetZ = -0.3F;
	    model.spoke1.offsetZ = -0.3F;
	    model.spoke2.offsetZ = -0.3F;
	    model.spoke3.offsetZ = -0.3F;
	    model.center.offsetZ = -0.3F;
	    GL11.glScalef(1.0F, -1F, -1F);
	}
	model.render(0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F);
	GL11.glPopMatrix(); // end
    }

    @Override
    public void renderTileEntityAt(final TileEntity tileentity, final double d,
	    final double d1, final double d2, final float f) {
	renderAModelAt((TileEntityHatch) tileentity, d, d1, d2, f); // where
								    // to
								    // render
    }

    private void adjustRotatePivotViaMeta(final World world, final int x,
	    final int y, final int z) {
	final int meta = world.getBlockMetadata(x, y, z);
	GL11.glRotatef(meta * -90, 0.0F, 0.0F, 1.0F);
    }
}
