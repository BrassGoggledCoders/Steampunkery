package com.warlordjones.warcore;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigSetup {
    public static boolean extragrassdrops, extragrassplants;
    public static boolean extraloot;
    public static boolean extramobdrops;
    public static boolean flatbedrock;

    // public static final boolean enable_extraloot_default = true;
    // public static final String enable_extraloot_name =
    // "Enable extra Dungeon loot?";
    static void SetupConfiguration(final File configFile) {
	// Configuration Code
	final Configuration config = new Configuration(configFile);
	config.load();
	ConfigSetup.extraloot = config.get("booleans",
		"Enable extra Dungeon loot?", true).getBoolean(true);
	ConfigSetup.extragrassdrops = config.get("booleans",
		"Enable extra Tall Grass drops?", true).getBoolean(true);
	ConfigSetup.extragrassplants = config.get("booleans",
		"Enable extra Bonemeal Plants?", true).getBoolean(true);
	ConfigSetup.flatbedrock = config.get("booleans",
		"Enable 1 layer thick bedrock in nether and overworld?", true)
		.getBoolean(true);
	ConfigSetup.extramobdrops = config.get("booleans",
		"Enable extra mob drops??", true).getBoolean(true);
	config.save();
    }
}
