package com.warlordjones.steampunkery.tileentitities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;

import com.warlordjones.steampunkery.blocks.TeslaCoil;

public class TileEntityTeslaCoil extends TileEntity {
    public void updateEntity() {
	if (TeslaCoil.isPowered) {
	    this.zapPlayers();
	    this.worldObj.spawnParticle("portal", this.xCoord,
		    this.yCoord + 0.1, this.zCoord, 0F, -0.5F, 0F);
	    this.worldObj.spawnParticle("portal", this.xCoord,
		    this.yCoord + 0.1, this.zCoord, 0.5F, -0.5F, 0F);
	    this.worldObj.spawnParticle("portal", this.xCoord,
		    this.yCoord + 0.1, this.zCoord, -0.5F, -0.5F, 0F);
	    this.worldObj.spawnParticle("portal", this.xCoord,
		    this.yCoord + 0.1, this.zCoord, 0F, -0.5F, 0.5F);
	    this.worldObj.spawnParticle("portal", this.xCoord,
		    this.yCoord + 0.1, this.zCoord, 0F, -0.5F, -0.5F);
	}
    }

    public void zapPlayers() {
	AxisAlignedBB axisalignedbb = AxisAlignedBB.getAABBPool().getAABB(
		(double) this.xCoord, (double) this.yCoord,
		(double) this.zCoord, (double) (this.xCoord + 10),
		(double) (this.yCoord + 10), (double) (this.zCoord + 10));
	axisalignedbb.maxY = (double) this.worldObj.getHeight();
	List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class,
		axisalignedbb);
	Iterator iterator = list.iterator();
	EntityPlayer entityplayer;
	while (iterator.hasNext()) {
	    entityplayer = (EntityPlayer) iterator.next();
	    entityplayer.attackEntityFrom(DamageSource.wither, 3F);
	}
    }
}
