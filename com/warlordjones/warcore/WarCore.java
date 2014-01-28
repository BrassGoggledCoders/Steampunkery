package com.warlordjones.warcore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "warcore", name = "War Core", version = "2.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WarCore {
    // Instance
    @Instance("warcore")
    public static WarCore instance;

    @EventHandler
    public void load(final FMLLoadEvent event) {
    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
    }

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
	CoreHolidayHandler.handleHolidays();
	ConfigSetup.SetupConfiguration(event.getSuggestedConfigurationFile());
	if (ConfigSetup.extraloot) {
	    // ExtraVanilla.addChestLoot();
	}
	if (ConfigSetup.extragrassdrops)
	    ExtraVanilla.addGrassLoot();
	if (ConfigSetup.extragrassplants) {
	    // ExtraVanilla.addGrassPlants();
	}
	if (ConfigSetup.flatbedrock)
	    GameRegistry.registerWorldGenerator(new WorldGenFlatBedrock());
	if (ConfigSetup.extramobdrops)
	    MinecraftForge.EVENT_BUS.register(new ExtraLivingDropsEvents());

    }

    @EventHandler
    public void ServerStart(final FMLServerStartingEvent event) {
    }
}