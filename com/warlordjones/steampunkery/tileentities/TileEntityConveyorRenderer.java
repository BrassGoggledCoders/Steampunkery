package com.warlordjones.steampunkery.tileentities;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentities.models.ModelConveyor;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class TileEntityConveyorRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/conveyor_belt.png");
    private final ModelConveyor model; // yup, this refers to the last file. so
				       // you'll
				       // get an error for now. it says what
				       // model it
				       // has to take

    public TileEntityConveyorRenderer() {
	model = new ModelConveyor();
    }

    public void renderAModelAt(final TileEntityConveyor tileentity,
	    final double d, final double d1, final double d2, final float f) {
	bindTexture(TileEntityConveyorRenderer.ibeamTextures);
	GL11.glPushMatrix(); // start
	adjustRotatePivotViaMeta(tileentity.worldObj, tileentity.xCoord,
		tileentity.yCoord, tileentity.zCoord);// rotation
	GL11.glTranslatef((float) d + 0.5F, (float) d1, (float) d2 + 0.5F); // size
	GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
	GL11.glScalef(1.0F, -1F, -1F);
	model.render(0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F);
	GL11.glPopMatrix(); // end
    }

    @Override
    public void renderTileEntityAt(final TileEntity tileentity, final double d,
	    final double d1, final double d2, final float f) {
	renderAModelAt((TileEntityConveyor) tileentity, d, d1, d2, f); // where
								       // to
								       // render
    }

    private void adjustRotatePivotViaMeta(final World world, final int x,
	    final int y, final int z) {
	final int meta = world.getBlockMetadata(x, y, z);
	GL11.glRotatef(meta * -90, 0.0F, 0.0F, 1.0F);
    }
}
