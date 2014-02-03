/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gen.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEther extends BiomeGenBase {
    public BiomeGenEther(final int par1) {
	super(par1);
	setColor(16711680);
	setBiomeName("The Ether");
	setDisableRain();
	setMinMaxHeight(0F, 0F);
	spawnableMonsterList.clear();
	spawnableCreatureList.clear();
	spawnableWaterCreatureList.clear();
	spawnableCaveCreatureList.clear();
    }
}
