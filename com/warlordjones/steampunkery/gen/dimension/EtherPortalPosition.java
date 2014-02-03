/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen.dimension;

import net.minecraft.util.ChunkCoordinates;

public class EtherPortalPosition extends ChunkCoordinates {
    public long lastUpdateTime;
    final TeleporterEther teleporterInstance;

    public EtherPortalPosition(final TeleporterEther etherTeleporter,
	    final int par2, final int par3, final int par4, final long par5) {
	super(par2, par3, par4);
	teleporterInstance = etherTeleporter;
	lastUpdateTime = par5;
    }
}