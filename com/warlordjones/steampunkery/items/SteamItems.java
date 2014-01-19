package com.warlordjones.steampunkery.items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.items.tool.CraftingTool;
import com.warlordjones.steampunkery.items.tool.Machete;
import com.warlordjones.steampunkery.items.tool.PipeWrench;
import com.warlordjones.steampunkery.items.tool.SteamSword;
import com.warlordjones.steampunkery.items.tool.Telescope;
import com.warlordjones.warcore.RegistryUtils;

public class SteamItems {
    public static Item brass_parts, steel_parts;
    public static Item bullet, musket;
    // Armour Section
    // public static Item wandererHelmet;
    // public static Item wandererChestplate;
    // public static Item wandererLeggings;
    // public static Item wandererBoots;
    public static Item goggles;
    public static Item hammer;
    public static Item thread_tap;
    public static Item drawplate;
    public static Item iboat;
    public static Item machete;
    // Item Section
    public static Item metal_ingots, alloy_ingots;
    public static Item metal_plates, alloy_plates;
    public static Item metal_nuggets, alloy_nuggets;
    public static Item metal_dusts, alloy_dusts;
    public static Item pipe_wrench;
    // public static Item item_base;
    public static Item steamsword, steampick, steamaxe, steamshovel;
    public static Item toolbelt;
    public static Item respirator;
    public static Item clockwork_minecart;
    public static Item mechanical_horse;
    public static Item organs;
    public static Item net;
    public static Item vanilla_dusts;
    public static Item vanilla_plates;
    // Material Section
    // Materials
    public static EnumToolMaterial steamTools = EnumHelper.addToolMaterial(
	    "Steam-Powered", 2, -1, 8.0F, 4F, 0);
    public static Item telescope;

    public static void RegisterItems() {
	// Int Items
	// item_base = new ItemBase(ConfigSetup.item_baseID);
	SteamItems.metal_ingots = new MetalIngots(ConfigSetup.metal_ingotsID);
	SteamItems.alloy_ingots = new AlloyIngots(ConfigSetup.alloy_ingotsID);
	SteamItems.metal_plates = new MetalPlates(ConfigSetup.metal_platesID);
	SteamItems.alloy_plates = new AlloyPlates(ConfigSetup.alloy_platesID);
	SteamItems.telescope = new Telescope(ConfigSetup.telescopeID);
	SteamItems.brass_parts = new BrassParts(ConfigSetup.brass_partsID);
	steel_parts = new SteelParts(ConfigSetup.steel_partsID);
	// guns
	SteamItems.bullet = new ItemBase(ConfigSetup.bulletID).setCreativeTab(
		Steampunkery.steampunkeryTab).setUnlocalizedName("bullet");
	SteamItems.musket = new Musket(ConfigSetup.musketID).setCreativeTab(
		Steampunkery.steampunkeryTab).setUnlocalizedName("musket");
	SteamItems.machete = new Machete(ConfigSetup.macheteID)
		.setUnlocalizedName("machete");
	SteamItems.iboat = new IBoat(ConfigSetup.iboatID)
		.setUnlocalizedName("iboat");
	toolbelt = new Toolbelt(ConfigSetup.toolbeltID)
		.setUnlocalizedName("toolbelt");
	respirator = new Respirator(ConfigSetup.respiratorID);
	mechanical_horse = new MechanicalHorse(ConfigSetup.mechanical_horseID)
		.setUnlocalizedName("mechanical_horse");
	hammer = new CraftingTool(ConfigSetup.hammerID)
		.setUnlocalizedName("hammer");
	thread_tap = new CraftingTool(ConfigSetup.thread_tapID)
		.setUnlocalizedName("thread_tap");
	drawplate = new CraftingTool(ConfigSetup.drawplateID)
		.setUnlocalizedName("drawplate");
	organs = new Organs(ConfigSetup.organsID);
	net = new Net(ConfigSetup.netID);
	metal_nuggets = new MetalNuggets(ConfigSetup.metal_nuggetsID);
	alloy_nuggets = new AlloyNuggets(ConfigSetup.alloy_nuggetsID);
	metal_dusts = new MetalDusts(ConfigSetup.metal_dustsID);
	alloy_dusts = new AlloyDusts(ConfigSetup.alloy_dustsID);
	vanilla_dusts = new VanillaDusts(ConfigSetup.vanilla_dustsID);
	vanilla_plates = new VanillaPlates(ConfigSetup.vanilla_platesID);

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
	clockwork_minecart = new ClockworkMinecart(
		ConfigSetup.clockwork_minecartID, 0)
		.setUnlocalizedName("clockwork_minecart");
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
	RegistryUtils.addItem(pipe_wrench, "Pipe Wrench");
	RegistryUtils.addItem(toolbelt, "Toolbelt");
	RegistryUtils.addItem(respirator, "Respirator");
	RegistryUtils.addItem(clockwork_minecart, "Clockwork Minecart");
	RegistryUtils.addItem(mechanical_horse, "Mechanical Horse");
	RegistryUtils.addItem(steamsword, "Steam-Powered Sword");
	RegistryUtils.addItem(hammer, "Hammer");
	RegistryUtils.addItem(thread_tap, "Thread Tap");
	RegistryUtils.addItem(drawplate, "Drawplate");
	RegistryUtils.addItem(organs, "Organs");
	RegistryUtils.addItem(net, "Net");
	RegistryUtils.addItem(metal_nuggets, "Metal Nuggets");
	RegistryUtils.addItem(alloy_nuggets, "Alloy Nuggets");
	RegistryUtils.addItem(metal_dusts, "Metal Powders");
	RegistryUtils.addItem(alloy_dusts, "Alloy Powders");
	RegistryUtils.addItem(vanilla_dusts, "Vanilla Powders");
	RegistryUtils.addItem(vanilla_plates, "Vanilla Plates");
    }
}
