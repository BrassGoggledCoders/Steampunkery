package com.warlordjones.steampunkery;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class SteamConstants {
    public static final String modid = "steampunkery";
    public static final String name = "Steampunkery";
    public static final String prefix = "steampunkery:";
    public static final String thread_location = "http://brassgoggles.co.uk/forum/index.php/topic,41565.msg876399.html#msg876399";
    public static final String update_location = "http://pastebin.com/raw.php?i=YMsgLFhu";
    public static final String version = "Alpha v5";

    public static void setupMeta(final FMLPreInitializationEvent event) {
	// Hardcode mcmod.info
	// FIXME: Broken
	/*
	 * event.getModMetadata().version = SteamConstants.version;
	 * event.getModMetadata().name = SteamConstants.name;
	 * event.getModMetadata().modId = SteamConstants.modid;
	 * event.getModMetadata().description = "- Conquer the Skies! -";
	 * event.getModMetadata().authorList.add("warlordjones");
	 * event.getModMetadata().logoFile = "/steampunkery/logo.png";
	 * event.getModMetadata().credits =
	 * "Thanks to everyone on BrassGoggles for the inspiration!! Thanks to the creators of my 3d modelling tool MCModler and to raptorfarian for the epic dino models."
	 * ; event.getModMetadata().url = SteamConstants.thread_location;
	 * event.getModMetadata().updateUrl = SteamConstants.update_location;
	 * SteamLog.log(Level.FINE,
	 * "Steampunkery mcmod.info Hardcoding Complete.");
	 */
    }
}
