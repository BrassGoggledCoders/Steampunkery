package com.warlordjones.steampunkery.gen.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDeeps extends BiomeGenBase {
    public BiomeGenDeeps(final int par1) {
	super(par1);
	setColor(16711680);
	setBiomeName("The Deeps");
	setDisableRain();
	setMinMaxHeight(Float.MIN_VALUE, Float.MAX_VALUE);
    }
}
