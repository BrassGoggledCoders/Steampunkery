package com.warlordjones.steampunkery.gen.dimension;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.gen.GenerationHandler;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDeeps extends WorldProvider {
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
	return "The Deeps";
    }

    @Override
    public String getWelcomeMessage() {
	return "Digging down to the Deeps";
    }

    @Override
    public boolean getWorldHasVoidParticles() {
	return true;
    }

    @Override
    public void registerWorldChunkManager() {
	worldChunkMgr = new WorldChunkManagerHell(GenerationHandler.deeps,
		0.1F, 0.0F);
	dimensionId = ConfigSetup.deepsID;
    }
}
