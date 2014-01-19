package com.warlordjones.steampunkery;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

import com.warlordjones.steampunkery.blocks.AlloyBlocks;
import com.warlordjones.steampunkery.blocks.MetalBlocks;
import com.warlordjones.steampunkery.blocks.OreBlocks;
import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.steampunkery.items.AlloyIngots;
import com.warlordjones.steampunkery.items.MetalIngots;
import com.warlordjones.steampunkery.items.SteamItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {
    public static boolean altfleshblock = false;

    static void RegisterRecipes() {
	// Recipes
	for (int meta = 0; meta < MetalBlocks.names.length; ++meta) {
	    CraftingManager.getInstance().addRecipe(
		    new ItemStack(SteamBlocks.metal_blocks.blockID, 1, meta),
		    new Object[] {
			    "###",
			    "###",
			    "###",
			    '#',
			    new ItemStack(SteamItems.metal_ingots.itemID, 1,
				    meta) });
	    CraftingManager.getInstance().addShapelessRecipe(
		    new ItemStack(SteamItems.metal_ingots.itemID, 9, meta),
		    new Object[] { new ItemStack(
			    SteamBlocks.metal_blocks.blockID, 1, meta) });
	}
	for (int meta = 0; meta < AlloyBlocks.names.length; ++meta) {
	    CraftingManager.getInstance().addRecipe(
		    new ItemStack(SteamBlocks.alloy_blocks.blockID, 1, meta),
		    new Object[] {
			    "###",
			    "###",
			    "###",
			    '#',
			    new ItemStack(SteamItems.alloy_ingots.itemID, 1,
				    meta) });
	    CraftingManager.getInstance().addShapelessRecipe(
		    new ItemStack(SteamItems.alloy_ingots.itemID, 9, meta),
		    new Object[] { new ItemStack(
			    SteamBlocks.alloy_blocks.blockID, 1, meta) });
	}
	for (int meta = 0; meta < MetalIngots.names.length; ++meta)
	    CraftingManager.getInstance().addShapelessRecipe(
		    new ItemStack(SteamItems.metal_plates.itemID, 2, meta),
		    new Object[] {
			    new ItemStack(SteamItems.metal_ingots.itemID, 1,
				    meta),
			    new ItemStack(SteamItems.hammer, 1,
				    OreDictionary.WILDCARD_VALUE) });
	for (int meta = 0; meta < AlloyIngots.names.length; ++meta)
	    CraftingManager.getInstance().addShapelessRecipe(
		    new ItemStack(SteamItems.alloy_plates.itemID, 2, meta),
		    new Object[] {
			    new ItemStack(SteamItems.alloy_ingots.itemID, 1,
				    meta),
			    new ItemStack(SteamItems.hammer, 1,
				    OreDictionary.WILDCARD_VALUE) });
	// Parts Crafting
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 0),
		" B ", "BBB", " B ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 0));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 1),
		" B ", "B B", " B ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 0));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 2),
		"WWW", "WWW", "WWW", 'W', new ItemStack(SteamItems.brass_parts,
			1, 7));
	GameRegistry.addShapelessRecipe(new ItemStack(SteamItems.brass_parts,
		1, 3), new ItemStack(SteamItems.alloy_ingots, 1, 0),
		new ItemStack(SteamItems.thread_tap, 1,
			OreDictionary.WILDCARD_VALUE));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 4),
		"BBB", "B B", "BBB", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 0));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 5),
		"BBB", " T ", " T ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 0), 'T', new ItemStack(
			SteamItems.brass_parts, 1, 3));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 6),
		"BBB", "B B", "BBB", 'B', new ItemStack(
			SteamItems.alloy_plates, 1, 0));
	GameRegistry.addShapelessRecipe(new ItemStack(SteamItems.brass_parts,
		2, 7), new ItemStack(SteamItems.alloy_ingots, 1, 0),
		new ItemStack(SteamItems.drawplate, 1,
			OreDictionary.WILDCARD_VALUE));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 8),
		" B ", "BBB", " B ", 'B', new ItemStack(
			SteamItems.alloy_plates, 1, 0));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 9),
		"BBB", " T ", " T ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 0), 'T', new ItemStack(
			SteamItems.brass_parts, 1, 3));
	GameRegistry.addRecipe(new ItemStack(SteamItems.brass_parts, 1, 10),
		"BBB", " B ", " B ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 0));

	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 0),
		" B ", "BBB", " B ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 2));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 1),
		" B ", "B B", " B ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 2));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 2),
		"WWW", "WWW", "WWW", 'W', new ItemStack(SteamItems.steel_parts,
			1, 7));
	GameRegistry.addShapelessRecipe(new ItemStack(SteamItems.steel_parts,
		1, 3), new ItemStack(SteamItems.alloy_ingots, 1, 2),
		new ItemStack(SteamItems.thread_tap, 1,
			OreDictionary.WILDCARD_VALUE));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 4),
		"BBB", "B B", "BBB", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 2));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 5),
		"BBB", " T ", " T ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 2), 'T', new ItemStack(
			SteamItems.steel_parts, 1, 3));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 6),
		"BBB", "B B", "BBB", 'B', new ItemStack(
			SteamItems.alloy_plates, 1, 2));
	GameRegistry.addShapelessRecipe(new ItemStack(SteamItems.steel_parts,
		2, 7), new ItemStack(SteamItems.alloy_ingots, 1, 2),
		new ItemStack(SteamItems.drawplate, 1,
			OreDictionary.WILDCARD_VALUE));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 8),
		" B ", "BBB", " B ", 'B', new ItemStack(
			SteamItems.alloy_plates, 1, 2));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 9),
		"BBB", " T ", " T ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 2), 'T', new ItemStack(
			SteamItems.steel_parts, 1, 3));
	GameRegistry.addRecipe(new ItemStack(SteamItems.steel_parts, 1, 10),
		"BBB", " B ", " B ", 'B', new ItemStack(
			SteamItems.alloy_ingots, 1, 2));
	// End Parts
	GameRegistry.addRecipe(new ItemStack(SteamItems.iboat, 1), "   ",
		"S S", "WSW", 'W', new ItemStack(Block.cloth), 'S',
		new ItemStack(Item.stick));
	GameRegistry.addRecipe(new ItemStack(SteamItems.goggles, 1), "lll",
		"gbg", "   ", 'l', new ItemStack(Item.leather), 'g',
		new ItemStack(Block.glass), 'b', new ItemStack(
			SteamItems.alloy_ingots, 1, 0));

	GameRegistry.addRecipe(new ItemStack(SteamBlocks.gaslamp, 4), " b ",
		"rgr", " b ", 'b',
		new ItemStack(SteamItems.alloy_ingots, 1, 0), 'r',
		new ItemStack(Item.redstone), 'g', new ItemStack(
			Block.glowStone));
	GameRegistry.addRecipe(new ItemStack(SteamBlocks.lightning_rod, 3),
		"c  ", "c  ", "c  ", 'c', new ItemStack(
			SteamItems.metal_ingots, 1, 1));
	GameRegistry.addRecipe(new ItemStack(SteamBlocks.lightning_rod, 3),
		" c ", " c ", " c ", 'c', new ItemStack(
			SteamItems.metal_ingots, 1, 1));
	GameRegistry.addRecipe(new ItemStack(SteamBlocks.lightning_rod, 3),
		"  c", "  c", "  c", 'c', new ItemStack(
			SteamItems.metal_ingots, 1, 1));
	if (altfleshblock = true) {
	    GameRegistry.addShapelessRecipe(new ItemStack(
		    SteamBlocks.flesh_block), new ItemStack(Item.rottenFlesh,
		    0, 4));
	} else {
	    GameRegistry.addShapelessRecipe(new ItemStack(
		    SteamBlocks.flesh_block), new ItemStack(Item.rottenFlesh,
		    0, 9));
	}

	GameRegistry.addShapelessRecipe(
		new ItemStack(SteamBlocks.soul_pumpkin), new ItemStack(
			Block.pumpkin), new ItemStack(Block.slowSand));
	// Smelting
	for (int meta = 0; meta < OreBlocks.names.length; ++meta)
	    FurnaceRecipes.smelting().addSmelting(
		    SteamBlocks.ore_blocks.blockID, meta,
		    new ItemStack(SteamItems.metal_ingots, 1, meta), 0.5F);
	GameRegistry.addSmelting(ConfigSetup.asteroid_ironID, new ItemStack(
		Item.ingotIron, 4, 4), 0.5F);
	GameRegistry.addSmelting(ConfigSetup.slate_cobbleID, new ItemStack(
		ConfigSetup.slateID, 1, 1), 1F);
    }
}
