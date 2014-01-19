package com.warlordjones.steampunkery;

import net.minecraftforge.common.MinecraftForge;

import com.warlordjones.steampunkery.blocks.SteamBlocks;

public class SteamForge {
    static void MinecraftForgeSetup() {
	// Harvest Level
	MinecraftForge.setBlockHarvestLevel(SteamBlocks.metal_blocks,
		"pickaxe", 1);
	MinecraftForge.setBlockHarvestLevel(SteamBlocks.alloy_blocks,
		"pickaxe", 1);
	MinecraftForge.setBlockHarvestLevel(SteamBlocks.gaslamp, "any", 0);
	// OreDict
	// Ingots
    }
}
