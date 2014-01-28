package com.warlordjones.steampunkery.tileentities;

import java.util.Iterator;
import java.util.List;

import com.warlordjones.steampunkery.blocks.TeslaCoil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;

public class TileEntityTeslaCoil extends TileEntity {
    @Override
    public void updateEntity() {
	if (TeslaCoil.isPowered) {
	    zapPlayers();
	    worldObj.spawnParticle("portal", xCoord, yCoord + 0.1, zCoord, 0F,
		    -0.5F, 0F);
	    worldObj.spawnParticle("portal", xCoord, yCoord + 0.1, zCoord,
		    0.5F, -0.5F, 0F);
	    worldObj.spawnParticle("portal", xCoord, yCoord + 0.1, zCoord,
		    -0.5F, -0.5F, 0F);
	    worldObj.spawnParticle("portal", xCoord, yCoord + 0.1, zCoord, 0F,
		    -0.5F, 0.5F);
	    worldObj.spawnParticle("portal", xCoord, yCoord + 0.1, zCoord, 0F,
		    -0.5F, -0.5F);
	}
    }

    public void zapPlayers() {
	final AxisAlignedBB axisalignedbb = AxisAlignedBB.getAABBPool()
		.getAABB(xCoord, yCoord, zCoord, xCoord + 10, yCoord + 10,
			zCoord + 10);
	axisalignedbb.maxY = worldObj.getHeight();
	final List list = worldObj.getEntitiesWithinAABB(EntityPlayer.class,
		axisalignedbb);
	final Iterator iterator = list.iterator();
	EntityPlayer entityplayer;
	while (iterator.hasNext()) {
	    entityplayer = (EntityPlayer) iterator.next();
	    entityplayer.attackEntityFrom(DamageSource.wither, 3F);
	}
    }
}
