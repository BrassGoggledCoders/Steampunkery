package com.warlordjones.steampunkery.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.blocks.Hatch;
import com.warlordjones.steampunkery.tileentities.models.ModelHatch;

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
	GL11.glTranslatef((float) d + 0.5F, (float) d1,
		(float) d2 + 0.5F); // size
	GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); // change the first 0 in like 90 to
	adjustRotatePivotViaMeta(tileentity.worldObj, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);// rotation
	if(Hatch.isTrapdoorOpen(0))
	{
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

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1,
	    double d2, float f) {
	renderAModelAt((TileEntityHatch) tileentity, d, d1, d2, f); // where
									 // to
									 // render
    }
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
 	int meta = world.getBlockMetadata(x, y, z);
 	GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
     }
}
