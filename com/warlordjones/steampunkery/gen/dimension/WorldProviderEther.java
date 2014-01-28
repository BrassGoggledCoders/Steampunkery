package com.warlordjones.steampunkery.gen.dimension;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.gen.GenerationHandler;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderEther extends WorldProvider {
    @Override
    public IChunkProvider createChunkGenerator() {
	return new ChunkProviderEther(worldObj, worldObj.getSeed(), true);
    }

    @Override
    public String getDepartMessage() {
	return "Leaving the Ether";
    }

    @Override
    public String getDimensionName() {
	return "Ether";
    }

    public int getSpawnFuzz() {
	return 0;
    }

    @Override
    public String getWelcomeMessage() {
	return "Flying up to the Ether";
    }

    @Override
    public boolean getWorldHasVoidParticles() {
	return false;
    }

    @Override
    public void registerWorldChunkManager() {
	worldChunkMgr = new WorldChunkManagerHell(
		GenerationHandler.ether_biome, 0.1F, 0.0F);
	dimensionId = ConfigSetup.etherID;
    }
}
