package com.warlordjones.steampunkery;

import net.minecraft.item.ItemStack;

import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.steampunkery.items.SteamItems;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
    static void LanguageRegistrySetup() {
	// Items
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_ingots, 1, 0),
		"Aluminum Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_ingots, 1, 1),
		"Copper Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_ingots, 1, 2),
		"Tin Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_ingots, 1, 3),
		"Zinc Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_ingots, 1, 0),
		"Brass Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_ingots, 1, 1),
		"Bronze Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_ingots, 1, 2),
		"Steel Ingot");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_plates, 1, 0),
		"Aluminum Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_plates, 1, 1),
		"Copper Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_plates, 1, 2),
		"Tin Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_plates, 1, 3),
		"Zinc Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_plates, 1, 0),
		"Brass Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_plates, 1, 1),
		"Bronze Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_plates, 1, 2),
		"Steel Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_dusts, 1, 0),
		"Brass Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_dusts, 1, 1),
		"Bronze Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_dusts, 1, 2),
		"Steel Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_dusts, 1, 0),
		"Aluminum Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_dusts, 1, 1),
		"Copper Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_dusts, 1, 2),
		"Tin Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_dusts, 1, 3),
		"Zinc Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_nuggets, 1, 0),
		"Brass Nugget");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_nuggets, 1, 1),
		"Bronze Nugget");
	LanguageRegistry.addName(new ItemStack(SteamItems.alloy_nuggets, 1, 2),
		"Steel Nugget");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_nuggets, 1, 0),
		"Aluminum Nugget");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_nuggets, 1, 1),
		"Copper Nugget");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_nuggets, 1, 2),
		"Tin Nugget");
	LanguageRegistry.addName(new ItemStack(SteamItems.metal_nuggets, 1, 3),
		"Zinc Nugget");
	LanguageRegistry.addName(SteamItems.goggles, "Goggles");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 0),
		"Brass Gears");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 1),
		"Brass Sprockets");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 2),
		"Brass Springs");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 3),
		"Brass Threads");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 4),
		"Brass Nuts");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 5),
		"Brass Bolts");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 6),
		"Brass Washers");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 7),
		"Brass Wire");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 8),
		"Brass Ball Bearings");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 9),
		"Brass Screws");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 10),
		"Brass Nails");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 11),
		"Brass Cogs");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 0),
		"Brass Gears");
	LanguageRegistry.addName(new ItemStack(SteamItems.brass_parts, 1, 1),
		"Brass Sprockets");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 0),
		"Steel Gears");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 1),
		"Steel Sprockets");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 2),
		"Steel Springs");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 3),
		"Steel Threads");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 4),
		"Steel Nuts");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 5),
		"Steel Bolts");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 6),
		"Steel Washers");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 7),
		"Steel Wire");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 8),
		"Steel Ball Bearings");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 9),
		"Steel Screws");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 10),
		"Steel Nails");
	LanguageRegistry.addName(new ItemStack(SteamItems.steel_parts, 1, 11),
		"Steel Cogs");
	LanguageRegistry.addName(new ItemStack(SteamItems.organs, 1, 0),
		"Heart");
	LanguageRegistry.addName(new ItemStack(SteamItems.organs, 1, 1),
		"Brain");
	LanguageRegistry.addName(new ItemStack(SteamItems.organs, 1, 2),
		"Liver");
	LanguageRegistry.addName(new ItemStack(SteamItems.organs, 1, 3),
		"Gribbly Bit");

	LanguageRegistry.addName(new ItemStack(SteamItems.hammer), "Hammer");
	LanguageRegistry.addName(new ItemStack(SteamItems.thread_tap),
		"Thread Tap");
	LanguageRegistry.addName(new ItemStack(SteamItems.drawplate),
		"Drawplate");
	LanguageRegistry.addName(SteamItems.telescope, "Telescope");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_dusts, 1, 0),"Coal Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_dusts, 1, 1),"Iron Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_dusts, 1, 2),"Gold Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_dusts, 1, 3),"Emerald Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_dusts, 1, 4),"Diamond Dust");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_plates, 1, 0),"Iron Plate");
	LanguageRegistry.addName(new ItemStack(SteamItems.vanilla_plates, 1, 1),"Gold Plate");
	// Blocks
	LanguageRegistry.addName(new ItemStack(SteamBlocks.metal_blocks, 1, 0),
		"Aluminum Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.metal_blocks, 1, 1),
		"Copper Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.metal_blocks, 1, 2),
		"Tin Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.metal_blocks, 1, 3),
		"Zinc Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.alloy_blocks, 1, 0),
		"Brass Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.alloy_blocks, 1, 1),
		"Bronze Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.alloy_blocks, 1, 2),
		"Steel Block");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.deep_carpet, 1, 0),
		"Red Velvet Carpet");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.deep_carpet, 1, 1),
		"Green Velvet Carpet");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.deep_carpet, 1, 2),
		"Gold Velvet Carpet");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.slate_slab, 1, 0),
		"Slate Slab");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.slate_slab, 1, 1),
		"Slate Cobble Slab");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.slate_slab, 1, 2),
		"Slate Brick Slab");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.slate_stair, 1, 0),
		"Slate Stair");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.slate_stair, 1, 1),
		"Slate Cobble Stair");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.slate_stair, 1, 2),
		"Slate Brick Stair");
	/*
	 * LanguageRegistry.addName(new ItemStack(SteamBlocks.special_steel, 1,
	 * 0), "Rusty Steel Block"); LanguageRegistry.addName(new
	 * ItemStack(SteamBlocks.special_steel, 1, 1),
	 * "Hazard-Striped Steel Block"); LanguageRegistry.addName(new
	 * ItemStack(SteamBlocks.special_steel, 1, 2),
	 * "Diamond-Tread Steel Block"); LanguageRegistry.addName(new
	 * ItemStack(SteamBlocks.special_steel, 1, 3), "Steel Mesh");
	 * LanguageRegistry.addName(new ItemStack(SteamBlocks.special_steel, 1,
	 * 0), "Corrugated Steel Block");
	 */
	LanguageRegistry.addName(new ItemStack(SteamBlocks.ore_blocks, 1, 0),
		"Aluminum Ore");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.ore_blocks, 1, 1),
		"Copper Ore");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.ore_blocks, 1, 2),
		"Tin Ore");
	LanguageRegistry.addName(new ItemStack(SteamBlocks.ore_blocks, 1, 3),
		"Zinc Ore");
	// LanguageRegistry.addName(wandererHelmet, "Wanderer Mask");
	// LanguageRegistry.addName(wandererChestplate, "Wanderer Tunic");
	// LanguageRegistry.addName(wandererLeggings, "Wanderer Leggings");
	// LanguageRegistry.addName(wandererBoots, "Wanderer Boots");
	// TabName
	LanguageRegistry.instance().addStringLocalization(
		"itemGroup.steampunkery_tab", "Steampunkery Tab");
	LanguageRegistry.instance().addStringLocalization(
		"entity.fleshgolem.name", "en_US", "Flesh Golem");
	LanguageRegistry.instance().addStringLocalization(
		"death.attack.steampunkery.zap", "en_US", "Electrocution!");
    }
}
