/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.items.tool.*;
import com.warlordjones.warcore.RegistryUtils;

import cpw.mods.fml.common.Loader;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class SteamItems {
    public static Item brass_parts, steel_parts;
    public static Item bullet, musket;
    public static Item clockwork_minecart;
    public static Item drawplate;
    // Armour Section
    // public static Item wandererHelmet;
    // public static Item wandererChestplate;
    // public static Item wandererLeggings;
    // public static Item wandererBoots;
    public static Item goggles;
    public static Item hammer;
    public static Item iboat;
    public static Item machete;
    public static Item mechanical_horse;
    public static Item metal_dusts, alloy_dusts;
    // Item Section
    public static Item metal_ingots, alloy_ingots;
    public static Item metal_nuggets, alloy_nuggets;
    public static Item metal_plates, alloy_plates;
    public static Item net;
    public static Item organs;
    public static Item pipe_wrench;
    public static Item respirator;
    public static Item spirit_focus;
    public static Item steam_bucket;
    // public static Item item_base;
    public static Item steamsword, steampick, steamaxe, steamshovel;
    // Material Section
    // Materials
    public static EnumToolMaterial steamTools = EnumHelper.addToolMaterial(
	    "Steam-Powered", 2, -1, 8.0F, 4F, 0);
    public static Item telescope;
    public static Item thread_tap;
    public static Item toolbelt;
    public static Item vanilla_dusts;
    public static Item vanilla_plates;

    public static void RegisterItems() {
	// Int Items
	// item_base = new ItemBase(ConfigSetup.item_baseID);
	SteamItems.metal_ingots = new MetalIngots(ConfigSetup.metal_ingotsID);
	SteamItems.alloy_ingots = new AlloyIngots(ConfigSetup.alloy_ingotsID);
	SteamItems.metal_plates = new MetalPlates(ConfigSetup.metal_platesID);
	SteamItems.alloy_plates = new AlloyPlates(ConfigSetup.alloy_platesID);
	SteamItems.telescope = new Telescope(ConfigSetup.telescopeID);
	SteamItems.brass_parts = new BrassParts(ConfigSetup.brass_partsID);
	SteamItems.steel_parts = new SteelParts(ConfigSetup.steel_partsID);
	// guns
	SteamItems.bullet = new ItemBase(ConfigSetup.bulletID).setCreativeTab(
		Steampunkery.ItemTab).setUnlocalizedName("bullet");
	SteamItems.musket = new Musket(ConfigSetup.musketID).setCreativeTab(
		Steampunkery.ItemTab).setUnlocalizedName("musket");
	SteamItems.machete = new Machete(ConfigSetup.macheteID)
		.setUnlocalizedName("machete");
	SteamItems.iboat = new IBoat(ConfigSetup.iboatID)
		.setUnlocalizedName("iboat");
	SteamItems.toolbelt = new Toolbelt(ConfigSetup.toolbeltID)
		.setUnlocalizedName("toolbelt");
	SteamItems.respirator = new Respirator(ConfigSetup.respiratorID);
	SteamItems.mechanical_horse = new MechanicalHorse(
		ConfigSetup.mechanical_horseID)
		.setUnlocalizedName("mechanical_horse");
	SteamItems.hammer = new CraftingTool(ConfigSetup.hammerID)
		.setUnlocalizedName("hammer");
	SteamItems.thread_tap = new CraftingTool(ConfigSetup.thread_tapID)
		.setUnlocalizedName("thread_tap");
	SteamItems.drawplate = new CraftingTool(ConfigSetup.drawplateID)
		.setUnlocalizedName("drawplate");
	SteamItems.organs = new Organs(ConfigSetup.organsID);
	SteamItems.net = new Net(ConfigSetup.netID);
	SteamItems.metal_nuggets = new MetalNuggets(ConfigSetup.metal_nuggetsID);
	SteamItems.alloy_nuggets = new AlloyNuggets(ConfigSetup.alloy_nuggetsID);
	SteamItems.metal_dusts = new MetalDusts(ConfigSetup.metal_dustsID);
	SteamItems.alloy_dusts = new AlloyDusts(ConfigSetup.alloy_dustsID);
	SteamItems.vanilla_dusts = new VanillaDusts(ConfigSetup.vanilla_dustsID);
	SteamItems.vanilla_plates = new VanillaPlates(
		ConfigSetup.vanilla_platesID);
	if (Loader.isModLoaded("thaumcraft"))
	    SteamItems.spirit_focus = new SpiritFocus(
		    ConfigSetup.spirit_focusID);

	// steamtools
	// TODO - Add config ids
	SteamItems.steamsword = new SteamSword(5001, SteamItems.steamTools)
		.setUnlocalizedName("steam_sword");

	// Tool Class Setup
	// TODO - Submethod dis
	MinecraftForge.setToolClass(SteamItems.steamsword, "sword",
		SteamItems.steamTools.getHarvestLevel());
	MinecraftForge.setToolClass(SteamItems.steampick, "pickaxe",
		SteamItems.steamTools.getHarvestLevel());
	MinecraftForge.setToolClass(SteamItems.steamaxe, "axe",
		SteamItems.steamTools.getHarvestLevel());
	MinecraftForge.setToolClass(SteamItems.steamshovel, "shovel",
		SteamItems.steamTools.getHarvestLevel());
	// Int Armour
	// wandererHelmet = new WandererArmour(wandererHelmetID,
	// EnumArmorMaterial.CLOTH, 0, 0, "Wanderer");
	// wandererChestplate = new WandererArmour(wandererChestplateID,
	// EnumArmorMaterial.CLOTH, 0, 1, "Wanderer");
	// wandererLeggings = new WandererArmour(wandererLeggingsID,
	// EnumArmorMaterial.CLOTH, 0, 2, "Wanderer");
	// wandererBoots = new WandererArmour(wandererBootsID,
	// EnumArmorMaterial.CLOTH, 0, 3, "Wanderer");
	SteamItems.goggles = new Goggles(ConfigSetup.gogglesID,
		EnumArmorMaterial.CHAIN, 0, 0, "Goggles");
	SteamItems.pipe_wrench = new PipeWrench(ConfigSetup.pipe_wrenchID)
		.setUnlocalizedName("pipe_wrench");
	SteamItems.clockwork_minecart = new ClockworkMinecart(
		ConfigSetup.clockwork_minecartID, 0)
		.setUnlocalizedName("clockwork_minecart");
	SteamItems.steam_bucket = new SteamBucket(ConfigSetup.steam_bucketID, 1);

	RegistryUtils.addItem(SteamItems.metal_ingots, "Metal Ingot");
	RegistryUtils.addItem(SteamItems.alloy_ingots, "Alloy Ingots");
	RegistryUtils.addItem(SteamItems.metal_plates, "Metal Plates");
	RegistryUtils.addItem(SteamItems.alloy_plates, "Alloy Plates");
	RegistryUtils.addItem(SteamItems.telescope, "Telescope");
	RegistryUtils.addItem(SteamItems.brass_parts, "Brass Parts");
	RegistryUtils.addItem(SteamItems.steel_parts, "Steel Parts");
	RegistryUtils.addItem(SteamItems.goggles, "Goggles");
	RegistryUtils.addItem(SteamItems.bullet, "Bullet");
	RegistryUtils.addItem(SteamItems.musket, "Musket");
	RegistryUtils.addItem(SteamItems.machete, "Machete");
	RegistryUtils.addItem(SteamItems.iboat, "Canvas Boat");
	RegistryUtils.addItem(SteamItems.pipe_wrench, "Pipe Wrench");
	RegistryUtils.addItem(SteamItems.toolbelt, "Toolbelt");
	RegistryUtils.addItem(SteamItems.respirator, "Respirator");
	RegistryUtils.addItem(SteamItems.clockwork_minecart,
		"Clockwork Minecart");
	RegistryUtils.addItem(SteamItems.mechanical_horse, "Mechanical Horse");
	RegistryUtils.addItem(SteamItems.steamsword, "Steam-Powered Sword");
	RegistryUtils.addItem(SteamItems.hammer, "Hammer");
	RegistryUtils.addItem(SteamItems.thread_tap, "Thread Tap");
	RegistryUtils.addItem(SteamItems.drawplate, "Drawplate");
	RegistryUtils.addItem(SteamItems.organs, "Organs");
	RegistryUtils.addItem(SteamItems.net, "Net");
	RegistryUtils.addItem(SteamItems.metal_nuggets, "Metal Nuggets");
	RegistryUtils.addItem(SteamItems.alloy_nuggets, "Alloy Nuggets");
	RegistryUtils.addItem(SteamItems.metal_dusts, "Metal Powders");
	RegistryUtils.addItem(SteamItems.alloy_dusts, "Alloy Powders");
	RegistryUtils.addItem(SteamItems.vanilla_dusts, "Vanilla Powders");
	RegistryUtils.addItem(SteamItems.vanilla_plates, "Vanilla Plates");
	RegistryUtils.addItem(SteamItems.steam_bucket, "Bucket of Steam");
    }
}
