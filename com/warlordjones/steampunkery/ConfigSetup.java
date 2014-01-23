package com.warlordjones.steampunkery;

import java.io.File;
import java.util.logging.Level;

import com.warlordjones.steampunkery.util.SteamLog;

import net.minecraftforge.common.Configuration;

public class ConfigSetup {

    public static int netID;
    public static int organsID;
    // Block ID's
    public static int metal_blocksID, alloy_blocksID, ore_blocksID;
    public static int asteroid_blockID, asteroid_ironID;
    public static int brass_partsID, steel_partsID;
    public static int bulletID;
    public static int cloudy_etherID, smogID;
    public static int eldritch_metalID;
    public static int flesh_blockID, soul_pumpkinID;
    public static int gaslampID, gaslightID, gaslight_frameID, lightning_rodID;
    public static int gogglesID;
    public static int hot_mudID;
    public static int iboatID;
    public static int item_baseID;
    public static int macheteID;
    public static int mercury_dirtID;
    public static int psmogID;
    public static int deeps_blockID;
    public static int ibeamID;
    public static int sky_railID;
    public static int deep_carpetID;
    public static int cryo_playerID;
    public static int brass_plaqueID;
    public static int bolted_steelID;
    // Item ID's
    public static int metal_ingotsID, alloy_ingotsID;
    public static int metal_itemblocksID, alloy_itemblocksID, ore_itemblocksID;
    public static int metal_platesID, alloy_platesID;
    public static int meteorID;
    public static int musketID;
    public static int pipe_wrenchID;
    public static int portalID;
    public static int slateID, slate_cobbleID, slate_brickID, slate_slabID,
	    slate_stairID;
    public static int gun_barrelID, tank_trackID, engine_blockID;
    public static int telescopeID;
    public static int respiratorID;
    public static int toolbeltID;
    public static int clockwork_minecartID;
    public static int deep_carpet_itemblocksID;
    public static int hammerID;
    public static int thread_tapID;
    public static int drawplateID;
    public static int metal_nuggetsID, alloy_nuggetsID;
    public static int metal_dustsID, alloy_dustsID;
    public static int vanilla_dustsID;
    // Armour ID's
    public static int wandererHelmetID;
    public static int wandererChestplateID;
    public static int wandererLeggingsID;
    public static int wandererBootsID;

    // Booleans
    public static boolean scalded_lands_B;
    public static boolean dense_jungle_B;
    public static boolean debug_mode_B;
    public static boolean update_checker_B;
    public static boolean structureddeepsentrance_B;
    public static boolean world_gen_B;
    // Biome ID's
    public static int ether_biomeID;
    public static int deeps_biomeID;
    public static int dense_jungleID;
    public static int scalded_landsID;
    // Dimension ID's
    public static int etherID;
    public static int deepsID;
    public static int tesla_coilID;
    public static int mechanical_horseID;
    public static int dense_jungle_MID;
    public static int tankID;
    public static int bombID;
    public static int vanilla_platesID;
    public static int hatchID;
    public static boolean retrogen_B;
    public static boolean aluminum_ore_B;
    public static boolean copper_ore_B;
    public static boolean tin_ore_B;
    public static boolean zinc_ore_B;
    public static int aluminum_ore_chance;
    public static int copper_ore_chance;
    public static int tin_ore_chance;
    public static int zinc_ore_chance;
    public static int aluminum_ore_veinsize;
    public static int copper_ore_veinsize;
    public static int tin_ore_veinsize;
    public static int zinc_ore_veinsize;
    public static int conveyorID;

    static void SetupConfiguration(final File configFile) {
	// Configuration Code
	final Configuration config = new Configuration(configFile);
	config.load();
	// Blocks
	int block_id = 3000;
	ConfigSetup.metal_blocksID = config.get("Blocks", "Metal Blocks ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.alloy_blocksID = config.get("Blocks", "Alloy Blocks ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.ore_blocksID = config.get("Blocks", "Ore Blocks ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.gaslampID = config.get("Blocks", "Gaslamp ID", block_id)
		.getInt();
	block_id++;
	ConfigSetup.gaslightID = config.get("Blocks", "Gaslight ID", block_id)
		.getInt();
	block_id++;
	ConfigSetup.gaslight_frameID = config.get("Blocks",
		"Gaslight Frame ID", block_id).getInt();
	block_id++;
	ConfigSetup.lightning_rodID = config.get("Blocks", "Lightning Rod ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.flesh_blockID = config.get("Blocks", "Block of Flesh ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.soul_pumpkinID = config.get("Blocks",
		"Ensouled Pumpkin ID", block_id).getInt();
	block_id++;
	ConfigSetup.portalID = config.get("Blocks", "Ether Portal Block ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.asteroid_blockID = config.get("Blocks", "Asteroid Rock ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.asteroid_ironID = config.get("Blocks",
		"Asteroic Iron Ore ID", block_id).getInt();
	block_id++;
	ConfigSetup.meteorID = config.get("Blocks", "Meteor ID", block_id)
		.getInt();
	block_id++;
	ConfigSetup.eldritch_metalID = config.get("Blocks",
		"Eldritch Metal ID", block_id).getInt();
	block_id++;
	ConfigSetup.mercury_dirtID = config.get("Blocks", "Mercurial Dirt ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.slateID = config.get("Blocks", "Slate Block ID", block_id)
		.getInt();
	block_id++;
	ConfigSetup.slate_cobbleID = config.get("Blocks",
		"Slate Cobblestone Block ID", block_id).getInt();
	block_id++;
	ConfigSetup.slate_brickID = config.get("Blocks",
		"Slate Brick Block ID", block_id).getInt();
	block_id++;
	ConfigSetup.slate_slabID = config.get("Blocks", "Slate Slab Block ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.slate_stairID = config.get("Blocks",
		"Slate Stair Block ID", block_id).getInt();
	block_id++;
	ConfigSetup.cloudy_etherID = config.get("Blocks",
		"Cloudy Ether Block ID", block_id).getInt();
	block_id++;
	ConfigSetup.smogID = config.get("Blocks", "Smog Block ID", block_id)
		.getInt();
	block_id++;
	ConfigSetup.psmogID = config.get("Blocks", "Poison Smog Block ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.deeps_blockID = config.get("Blocks", "Deeps Block ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.ibeamID = config.get("Blocks", "I-Beam Block ID", block_id)
		.getInt();
	block_id++;
	ConfigSetup.tesla_coilID = config.get("Blocks", "Tesla Coil Block ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.sky_railID = config.get("Blocks", "Sky Rail Block ID",
		block_id).getInt();
	block_id++;
	ConfigSetup.deep_carpetID = config.get("Blocks",
		"Deep Carpet Block ID", block_id).getInt();
	block_id++;
	ConfigSetup.cryo_playerID = config.get("Blocks",
		"Frozen Player Block ID", block_id).getInt();
	block_id++;
	brass_plaqueID = config
		.get("Blocks", "Brass Plaque Block ID", block_id).getInt();
	block_id++;
	tankID = config.get("Blocks", "Tank Block ID", block_id).getInt();
	block_id++;
	bombID = config.get("Blocks", "Bomb ID", block_id).getInt();
	block_id++;
	bolted_steelID = config.get("Blocks", "Bolted Steel ID", block_id).getInt();
	block_id++;
	gun_barrelID = config.get("Blocks", "Gun Barrel ID", block_id).getInt();
	block_id++;
	tank_trackID = config.get("Blocks", "Tank Track ID", block_id).getInt();
	block_id++;
	engine_blockID = config.get("Blocks", "Engine Block ID", block_id).getInt();
	block_id++;
	hatchID = config.get("Blocks", "Hatch ID", block_id).getInt();
	block_id++;
	conveyorID = config.get("Blocks", "Conveyor Belt ID", block_id).getInt();
	int gen_blocksID = 200;
	ConfigSetup.hot_mudID = config.get("Gen blocks", "Hot Mud ID",
		gen_blocksID).getInt();
	config.addCustomCategoryComment("Gen Blocks",
		"Values MUST be below 265 or the game WILL crash.");
	gen_blocksID++;
	// Items
	int item_id = 3000;
	// item_baseID = config.get("Items", "Base Item ID", item_id).getInt();
	// item_id++;
	ConfigSetup.metal_itemblocksID = config.get("Items",
		"Metal ItemBlocks ID", item_id).getInt();
	item_id++;
	ConfigSetup.alloy_itemblocksID = config.get("Items",
		"Alloy ItemBlocks ID", item_id).getInt();
	item_id++;
	ConfigSetup.ore_itemblocksID = config.get("Items", "Ore ItemBlocks ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.deep_carpet_itemblocksID = config.get("Items",
		"Deep Carpet ItemBlocks ID", item_id).getInt();
	item_id++;
	ConfigSetup.metal_ingotsID = config.get("Items", "Metal Ingots ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.alloy_ingotsID = config.get("Items", "Alloy Ingots ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.metal_platesID = config.get("Items", "Metal Plates ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.alloy_platesID = config.get("Items", "Alloy Plates ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.telescopeID = config.get("Items", "Telescope ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.brass_partsID = config.get("Items", "Brass Parts ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.bulletID = config.get("Items", "Bullet ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.musketID = config.get("Items", "Musket ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.gogglesID = config.get("Items", "Goggles ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.macheteID = config.get("Items", "Machete ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.iboatID = config.get("Items", "Canvas Boat ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.pipe_wrenchID = config.get("Items", "Pipe Wrench ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.toolbeltID = config.get("Items", "Toolbelt ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.respiratorID = config
		.get("Items", "Respirator ID", item_id).getInt();
	item_id++;
	ConfigSetup.clockwork_minecartID = config.get("Items",
		"Clockwork Minecart ID", item_id).getInt();
	item_id++;
	ConfigSetup.mechanical_horseID = config.get("Items",
		"Mechanical Horse ID", item_id).getInt();
	item_id++;
	ConfigSetup.hammerID = config.get("Items", "Hammer ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.thread_tapID = config
		.get("Items", "Thread Tap ID", item_id).getInt();
	item_id++;
	ConfigSetup.drawplateID = config.get("Items", "Drawplate ID", item_id)
		.getInt();
	item_id++;
	ConfigSetup.steel_partsID = config.get("Items", "Steel Parts ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.organsID = config.get("Items", "Organs ID", item_id)
		.getInt();
	item_id++;
	netID = config.get("Items", "Net ID", item_id).getInt();
	item_id++;
	ConfigSetup.metal_nuggetsID = config.get("Items", "Metal Nuggets ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.alloy_nuggetsID = config.get("Items", "Alloy Nuggets ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.metal_dustsID = config.get("Items", "Metal Powders ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.alloy_dustsID = config.get("Items", "Alloy Powders ID",
		item_id).getInt();
	item_id++;
	ConfigSetup.vanilla_dustsID = config.get("Items", "Vanilla Powders ID",
		item_id).getInt();
	item_id++;
	vanilla_platesID = config.get("Items", "Vanilla Plates ID", item_id)
		.getInt();
	// Armour

	ConfigSetup.wandererHelmetID = config.get("Items", "Wanderer Cap ID",
		3500).getInt();
	ConfigSetup.wandererChestplateID = config.get("Items",
		"Wanderer Tunic ID", 3501).getInt();
	ConfigSetup.wandererLeggingsID = config.get("Items",
		"Wanderer Legggings ID", 3502).getInt();
	ConfigSetup.wandererBootsID = config.get("Items", "Wanderer Boots ID",
		3503).getInt();
	// Dimensions
	int dimension_id = -10;
	ConfigSetup.etherID = config
		.get("Dimensions", "Ether ID", dimension_id).getInt();
	dimension_id--;
	ConfigSetup.deepsID = config
		.get("Dimensions", "Deeps ID", dimension_id).getInt();
	// Biomes
	int biome_id = 100;
	ConfigSetup.ether_biomeID = config.get("Biomes", "Ether Biome ID",
		biome_id).getInt();
	biome_id++;
	ConfigSetup.deeps_biomeID = config.get("Biomes", "Deeps Biome ID",
		biome_id).getInt();
	biome_id++;
	ConfigSetup.dense_jungleID = config.get("Biomes",
		"Dense Jungle Biome ID", biome_id).getInt();
	biome_id++;
	ConfigSetup.dense_jungle_MID = config.get("Biomes",
		"Mountainous Dense Jungle Biome ID", biome_id).getInt();
	biome_id++;
	ConfigSetup.scalded_landsID = config.get("Biomes",
		"Scalded Lands Biome ID", biome_id).getInt();
	// Booleans
		// Dimensions
		// config.get("Booleans","Ether Dimension Enabled?",true).getBoolean(true);
		// Debug Mode
		debug_mode_B = config.get("Booleans", "Debug mode enabled?", false)
			.getBoolean(false);
		// Update Checker
		update_checker_B = config.get("Booleans", "Update Checker enabled?",
			true).getBoolean(true);
		//World Gen
		structureddeepsentrance_B = config
			.get("World Gen",
				"If false you can enter the Deeps anywhere at the world bottom. If true you must find a bedrock fissure",
				true).getBoolean(true);
		
		world_gen_B = config
			.get("World Gen",
				"World Generation Enabled? WARNING! Removes access to Deeps Dimension...",
				true).getBoolean(true);
		retrogen_B = config
			.get("World Gen",
				"RetroGeneration Enabled (ONLY works if DragonApi installed anyway)",
				false).getBoolean(false);
		// Biomes
		scalded_lands_B = config.get("World Gen",
				"Scalded Lands Biome Enabled?", true).getBoolean(true);
		dense_jungle_B = config.get("World Gen", "Dense Jungle Biome Enabled?",
				true).getBoolean(true);
		//Ores
		aluminum_ore_B = config.get("World Gen", "Aluminum Ore spawning enabled?", true).getBoolean(true);
		copper_ore_B = config.get("World Gen", "Copper Ore spawning enabled?", true).getBoolean(true);
		tin_ore_B = config.get("World Gen", "Tin Ore spawning enabled?", true).getBoolean(true);
		zinc_ore_B = config.get("World Gen", "Zinc Ore spawning enabled?", true).getBoolean(true);
		aluminum_ore_chance = config.get("World Gen", "Aluminum Ore Rarity", 40).getInt();
		copper_ore_chance = config.get("World Gen", "Copper Ore Rarity", 40).getInt();
		tin_ore_chance = config.get("World Gen", "Tin Ore Rarity", 40).getInt();
		zinc_ore_chance = config.get("World Gen", "Zinc Ore Rarity", 40).getInt();
		aluminum_ore_veinsize = config.get("World Gen", "Aluminum Ore Vein Size", 3).getInt();
		copper_ore_veinsize = config.get("World Gen", "Copper Ore Vein Size", 15).getInt();
		tin_ore_veinsize = config.get("World Gen", "Tin Ore Vein Size", 5).getInt();
		zinc_ore_veinsize = config.get("World Gen", "Zinc Ore Vein Size", 3).getInt();
	config.save();
    }
}
