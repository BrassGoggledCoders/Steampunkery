package com.warlordjones.steampunkery.gen.biome;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.SpawnListEntry;

import com.warlordjones.steampunkery.entity.EntitySkySquid;

public class BiomeGenDenseJungle extends BiomeGenJungle {
    public BiomeGenDenseJungle(final int par1) {
	super(par1);
	setBiomeName("Dense Jungle");
	this.setMinMaxHeight(0.1F, 0.2F);
	theBiomeDecorator.treesPerChunk = 999;
	theBiomeDecorator.grassPerChunk = 200;
	theBiomeDecorator.flowersPerChunk = 10;
	// theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
	spawnableMonsterList
		.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
	spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10,
		4, 4));
	spawnableCreatureList.add(new SpawnListEntry(EntitySkySquid.class, 70,
		1, 7));
    }
}
