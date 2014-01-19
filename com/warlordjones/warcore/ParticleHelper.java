package com.warlordjones.warcore;

import net.minecraft.world.World;

public class ParticleHelper {
    public static void spawnSmokeStream(final World worldObj, final int posX,
	    final int posY, final int posZ, final int direction,
	    final int direction1, final int direction2) {
	worldObj.spawnParticle("smoke", posX, posY + 0.5D, posZ, direction,
		direction1, direction2);
	worldObj.spawnParticle("smoke", posX, posY + 0.5D, posZ, direction,
		direction1, direction2);
    }
}
