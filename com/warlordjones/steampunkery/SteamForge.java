package com.warlordjones.steampunkery;

import com.warlordjones.steampunkery.blocks.SteamBlocks;

import net.minecraftforge.common.MinecraftForge;

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
