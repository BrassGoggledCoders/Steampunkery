package com.warlordjones.steampunkery.gen.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

import com.warlordjones.steampunkery.blocks.SteamBlocks;

public class BiomeGenScalded extends BiomeGenBase {
    public BiomeGenScalded(final int par1) {
	super(par1);
	topBlock = (byte) SteamBlocks.hot_mud.blockID;// SteamBlocks.hot_mud.blockID;
	theBiomeDecorator.treesPerChunk = -999;
	fillerBlock = (byte) Block.dirt.blockID;
	setColor(16421912);
	setBiomeName("Scalded Lands");
	setDisableRain();
	setTemperatureRainfall(2.0F, 0.0F);
	setMinMaxHeight(0.1F, 0.2F);

    }
}
