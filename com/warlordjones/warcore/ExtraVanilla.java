package com.warlordjones.warcore;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;

public class ExtraVanilla {

    public static void addChestLoot() {
	// Bonus
	// Dungeon
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.blazeRod),
			100, 1, 5));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.blazePowder),
			100, 1, 10));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.emptyMap),
			100, 1, 2));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.slimeBall),
			100, 1, 5));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.cake), 100,
			1, 5));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.cookie), 100,
			1, 10));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.skull), 100,
			1, 1));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.emerald),
			100, 1, 3));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.eyeOfEnder),
			100, 1, 5));
	// ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new
	// WeightedRandomChestContent(new ItemStack(Item.), 100, 1, 5));
	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
		new WeightedRandomChestContent(new ItemStack(Item.netherStar),
			100, 1, 1));

    }

    public static void addDungeonMobs() {
	DungeonHooks.addDungeonMob("Creeper", 100);
	DungeonHooks.addDungeonMob("Silverfish", 100);
	DungeonHooks.addDungeonMob("Enderman", 100);
	DungeonHooks.addDungeonMob("Cave Spider", 100);
	DungeonHooks.addDungeonMob("Slime", 100);
	DungeonHooks.addDungeonMob("Witch", 100);
    }

    public static void addGrassLoot() {
	MinecraftForge.addGrassSeed(new ItemStack(Item.melonSeeds), 50);
	MinecraftForge.addGrassSeed(new ItemStack(Item.pumpkinSeeds), 50);
	MinecraftForge.addGrassSeed(new ItemStack(Item.bone), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.egg), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.carrot), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.potato), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.poisonousPotato), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.wheat), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.stick), 10);
	MinecraftForge.addGrassSeed(new ItemStack(Item.skull), 5);
	MinecraftForge.addGrassSeed(new ItemStack(Item.goldNugget), 5);
	MinecraftForge.addGrassSeed(new ItemStack(Item.flint), 10);
    }

    public static void addGrassPlants() {
	MinecraftForge.addGrassPlant(Block.pumpkin, 0, 50);
	MinecraftForge.addGrassPlant(Block.melon, 0, 50);
	MinecraftForge.addGrassPlant(Block.reed, 0, 100);
	MinecraftForge.addGrassPlant(Block.leaves, 0, 10);
	MinecraftForge.addGrassPlant(Block.leaves, 1, 10);
	MinecraftForge.addGrassPlant(Block.leaves, 2, 10);
	MinecraftForge.addGrassPlant(Block.leaves, 3, 10);
    }

}
