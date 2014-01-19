package com.warlordjones.steampunkery;

import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.steampunkery.entity.EntitySkySquid;
import com.warlordjones.steampunkery.items.SteamItems;
import com.warlordjones.steampunkery.util.DependencyNotLoadedException;
import com.warlordjones.steampunkery.util.SteamLog;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

import morph.api.Ability;

public class ModCompat {
    public static void buildcraftCompat() {
    }

    public static void loadModCompatLayer() {
	try {
	    if (!Loader.isModLoaded("warcore"))
		throw new DependencyNotLoadedException("WarCore Required!");
	} catch (final DependencyNotLoadedException ex) {
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.WARNING,
		    "Steampunkery: WarCore not Loaded! Prepare for Bad Stuff!");
	    SteamLog.log(Level.SEVERE,
		    "Steampunkery: WarCore is a required Depedency of my other mods");
	    SteamLog.log(
		    Level.SEVERE,
		    "Steampunkery: DO NOT post this crash log - it will be ignored - read my thread");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "!!!");
	    SteamLog.log(Level.INFO, "Steampunkery: BadStuff Go!");
	    // SteamLog.log(Level.INFO,"WorldEater Virus MKIII loading...please wait...");
	    throw new RuntimeException("WarCore wasn't loaded...");
	}
	if (Loader.isModLoaded("Morph")) {
	    ModCompat.morphCompat();
	    SteamLog.log(Level.INFO,
		    "Steampunkery: Morph Detected - Compat Loading");
	} else
	    SteamLog.log(Level.INFO,
		    "Steampunkery: Morph not found - Compat not loading");
	if (Loader.isModLoaded("BuildCraft|Transport")) {
	    ModCompat.buildcraftCompat();
	    SteamLog.log(Level.INFO, "Buildcraft Detected - Compat Loading");
	} else
	    SteamLog.log(Level.INFO,
		    "Buildcraft not found - Compat not loading");
	if (Loader.isModLoaded("Thaumcraft")) {
	    RecipeHandler.altfleshblock = true;
	    SteamLog.log(Level.INFO,
		    "Steampunkery: Thaumcraft Detected - Compat Loading");
	} else {
	    SteamLog.log(Level.INFO,
		    "Steampunkery: Thaumcraft not found - Compat not Loading");
	}
	if (Loader.isModLoaded("ThermalExpansion")) {
	    SteamLog.log(Level.INFO,
		    "ThermalExpansion Detected - Compat Loading");
	    // Steel
	    final NBTTagCompound toSend = new NBTTagCompound();
	    toSend.setInteger("energy", 700);
	    toSend.setCompoundTag("primaryInput", new NBTTagCompound());
	    toSend.setCompoundTag("secondaryInput", new NBTTagCompound());
	    toSend.setCompoundTag("primaryOutput", new NBTTagCompound());
	    new ItemStack(Item.coal).writeToNBT(toSend
		    .getCompoundTag("primaryInput"));
	    new ItemStack(Item.ingotIron).writeToNBT(toSend
		    .getCompoundTag("secondaryInput"));
	    new ItemStack(SteamItems.alloy_ingots, 3, 1).writeToNBT(toSend
		    .getCompoundTag("primaryOutput"));
	    FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe",
		    toSend);
	    // Brass
	    final NBTTagCompound toSend1 = new NBTTagCompound();
	    toSend1.setInteger("energy", 700);
	    toSend1.setCompoundTag("primaryInput", new NBTTagCompound());
	    toSend1.setCompoundTag("secondaryInput", new NBTTagCompound());
	    toSend1.setCompoundTag("primaryOutput", new NBTTagCompound());
	    new ItemStack(Item.coal).writeToNBT(toSend1
		    .getCompoundTag("primaryInput"));
	    new ItemStack(Item.ingotIron).writeToNBT(toSend1
		    .getCompoundTag("secondaryInput"));
	    new ItemStack(SteamItems.alloy_ingots, 3, 1).writeToNBT(toSend1
		    .getCompoundTag("primaryOutput"));
	    FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe",
		    toSend1);
	    // Bronze
	    final NBTTagCompound toSend2 = new NBTTagCompound();
	    toSend2.setInteger("energy", 700);
	    toSend2.setCompoundTag("primaryInput", new NBTTagCompound());
	    toSend2.setCompoundTag("secondaryInput", new NBTTagCompound());
	    toSend2.setCompoundTag("primaryOutput", new NBTTagCompound());
	    new ItemStack(Item.coal).writeToNBT(toSend2
		    .getCompoundTag("primaryInput"));
	    new ItemStack(Item.ingotIron).writeToNBT(toSend2
		    .getCompoundTag("secondaryInput"));
	    new ItemStack(SteamItems.alloy_ingots, 3, 1).writeToNBT(toSend2
		    .getCompoundTag("primaryOutput"));
	    FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe",
		    toSend2);
	} else
	    SteamLog.log(Level.INFO,
		    "ThemalExpansion Not Detected - Compat not Loading");
	if (Loader.isModLoaded("GalacticraftCore")) {
	    SteamLog.log(
		    Level.WARNING,
		    "Using Galacticraft and Steampunkery together is not reccomended. Steampunkery provides it's own planetary system.");
	} else {
	    SteamLog.log(
		    Level.INFO,
		    "Galacticraft not Loaded. Glad you find WarCorp's version of the Solar System sufficient!");
	}
    }

    public static void morphCompat() {
	// SkySquid Abilities
	Ability.mapAbilities(EntitySkySquid.class,
		Ability.getNewAbilityFly(true));
	// Golem Abilities
	// Ability.mapAbilities(EntityFleshGolem.class, Ability.ge);
	// Api.blacklistEntity(EntityIBoat.class);
    }

    public static void setupOreDict() {
	// Ores
	OreDictionary.registerOre("oreAluminum", new ItemStack(
		SteamBlocks.ore_blocks, 1, 0));
	OreDictionary.registerOre("oreAluminium", new ItemStack(
		SteamBlocks.ore_blocks, 1, 0));
	OreDictionary.registerOre("oreCopper", new ItemStack(
		SteamBlocks.ore_blocks, 1, 1));
	OreDictionary.registerOre("oreTin", new ItemStack(
		SteamBlocks.ore_blocks, 1, 2));
	OreDictionary.registerOre("oreZinc", new ItemStack(
		SteamBlocks.ore_blocks, 1, 3));
	// Metal Blocks
	OreDictionary.registerOre("blockAluminum", new ItemStack(
		SteamBlocks.metal_blocks, 1, 0));
	OreDictionary.registerOre("blockAluminium", new ItemStack(
		SteamBlocks.metal_blocks, 1, 0));
	OreDictionary.registerOre("blockCopper", new ItemStack(
		SteamBlocks.metal_blocks, 1, 1));
	OreDictionary.registerOre("blockTin", new ItemStack(
		SteamBlocks.metal_blocks, 1, 2));
	OreDictionary.registerOre("blockZinc", new ItemStack(
		SteamBlocks.metal_blocks, 1, 3));
	// Ingots
	OreDictionary.registerOre("ingotAluminum", new ItemStack(
		SteamItems.metal_ingots, 1, 0));
	OreDictionary.registerOre("ingotAluminium", new ItemStack(
		SteamItems.metal_ingots, 1, 0));
	OreDictionary.registerOre("ingotCopper", new ItemStack(
		SteamItems.metal_ingots, 1, 1));
	OreDictionary.registerOre("ingotTin", new ItemStack(
		SteamItems.metal_ingots, 1, 2));
	OreDictionary.registerOre("ingotZinc", new ItemStack(
		SteamItems.metal_ingots, 1, 3));
	OreDictionary.registerOre("ingotBrass", new ItemStack(
		SteamItems.alloy_ingots, 1, 0));
	OreDictionary.registerOre("ingotBronze", new ItemStack(
		SteamItems.alloy_ingots, 1, 1));
	OreDictionary.registerOre("ingotSteel", new ItemStack(
		SteamItems.alloy_ingots, 1, 2));
	// Nuggets
	OreDictionary.registerOre("nuggetAluminum", new ItemStack(
		SteamItems.metal_nuggets, 1, 0));
	OreDictionary.registerOre("nuggetAluminium", new ItemStack(
		SteamItems.metal_nuggets, 1, 0));
	OreDictionary.registerOre("nuggetCopper", new ItemStack(
		SteamItems.metal_nuggets, 1, 1));
	OreDictionary.registerOre("nuggetTin", new ItemStack(
		SteamItems.metal_nuggets, 1, 2));
	OreDictionary.registerOre("nuggetZinc", new ItemStack(
		SteamItems.metal_nuggets, 1, 3));
	OreDictionary.registerOre("nuggetBrass", new ItemStack(
		SteamItems.alloy_nuggets, 1, 0));
	OreDictionary.registerOre("nuggetBronze", new ItemStack(
		SteamItems.alloy_nuggets, 1, 1));
	OreDictionary.registerOre("nuggetSteel", new ItemStack(
		SteamItems.alloy_nuggets, 1, 2));
	// Dust
	OreDictionary.registerOre("dustAluminum", new ItemStack(
		SteamItems.metal_dusts, 1, 0));
	OreDictionary.registerOre("dustAluminium", new ItemStack(
		SteamItems.metal_dusts, 1, 0));
	OreDictionary.registerOre("dustCopper", new ItemStack(
		SteamItems.metal_dusts, 1, 1));
	OreDictionary.registerOre("dustTin", new ItemStack(
		SteamItems.metal_dusts, 1, 2));
	OreDictionary.registerOre("dustZinc", new ItemStack(
		SteamItems.metal_dusts, 1, 3));
	OreDictionary.registerOre("dustBrass", new ItemStack(
		SteamItems.alloy_dusts, 1, 0));
	OreDictionary.registerOre("dustBronze", new ItemStack(
		SteamItems.alloy_dusts, 1, 1));
	OreDictionary.registerOre("dustSteel", new ItemStack(
		SteamItems.alloy_dusts, 1, 2));
    }
}
