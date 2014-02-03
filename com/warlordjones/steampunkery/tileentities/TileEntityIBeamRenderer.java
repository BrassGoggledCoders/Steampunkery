/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.tileentities;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.tileentities.models.ModelIBeam;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class TileEntityIBeamRenderer extends TileEntitySpecialRenderer {
    private static final ResourceLocation ibeamTextures = new ResourceLocation(
	    SteamConstants.prefix + "/textures/blocks/ibeam.png");
    private final ModelIBeam model;

    public TileEntityIBeamRenderer() {
	model = new ModelIBeam();
    }

    @Override
    public void renderTileEntityAt(final TileEntity te, final double x,
	    final double y, final double z, final float scale) {
	GL11.glPushMatrix();
	bindTexture(TileEntityIBeamRenderer.ibeamTextures);
	adjustRotatePivotViaMeta(te.worldObj, te.xCoord, te.yCoord, te.zCoord);// rotation
									       // 1
	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	// adjustRotatePivotViaMeta(te.worldObj, te.xCoord, te.yCoord,
	// te.zCoord);//comment line "rotation 1" and uncomment this line if it
	// doesnt work.
	model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	GL11.glPopMatrix();
    }

    private void adjustRotatePivotViaMeta(final World world, final int x,
	    final int y, final int z) {
	final int meta = world.getBlockMetadata(x, y, z);
	GL11.glRotatef(meta * -90, 0.0F, 0.0F, 1.0F);
    }
}
