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
