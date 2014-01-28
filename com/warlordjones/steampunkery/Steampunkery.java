package com.warlordjones.steampunkery;

import java.util.logging.Level;

import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.steampunkery.entity.EntitySetup;
import com.warlordjones.steampunkery.gen.GenerationHandler;
import com.warlordjones.steampunkery.gui.SteamGUIHandler;
import com.warlordjones.steampunkery.items.SteamItems;
import com.warlordjones.steampunkery.tileentities.TileEntityHandler;
import com.warlordjones.steampunkery.util.SteamLog;
import com.warlordjones.warcore.BucketHandler;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

//@formatter: off
@Mod(modid = SteamConstants.modid, name = SteamConstants.name, version = SteamConstants.version, acceptedMinecraftVersions = "1.6.4, 1.6.2, 1.6.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Steampunkery {
    // Instance
    @Instance(SteamConstants.modid)
    public static Steampunkery instance;

    @SidedProxy(clientSide = "com.warlordjones.steampunkery.SteamClientProxy", serverSide = "com.warlordjones.steampunkery.SteamCommonProxy")
    public static SteamCommonProxy proxy;

    public static CreativeTabs BlockTab = new CreativeTabs(
	    "steampunkery_block_tab") {
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(SteamBlocks.alloy_blocks, 1, 0);
	}
    };

    public static CreativeTabs ItemTab = new CreativeTabs(
	    "steampunkery_item_tab") {
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(SteamItems.hammer, 1, 0);
	}
    };

    // Tab
    public static CreativeTabs MiscTab = new CreativeTabs(
	    "steampunkery_misc_tab") {
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(SteamItems.goggles, 1, 0);
	}
    };

    @EventHandler
    public void load(final FMLInitializationEvent event) {
	RecipeHandler.RegisterRecipes();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Recipes Setup");
    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
	// Here be Dragons
	ModCompat.loadModCompatLayer();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Mod Compat layer loaded");
	ModCompat.setupOreDict();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Registered Things in OreDict");
    }

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
	// Logger.getLogger("Steampunkery").log(Level.INFO, "Logger Loaded");
	SteamLog.log(Level.INFO, "Logger Loaded");
	ConfigSetup.SetupConfiguration(event.getSuggestedConfigurationFile());
	if (ConfigSetup.debug_mode_B = false)
	    SteamLog.log(Level.INFO,
		    "Debug is set to false. Enjoy a less spammy console");
	else
	    SteamLog.log(Level.INFO,
		    "Debug is set to true. Console spam incoming!");
	SteamItems.RegisterItems();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Items Registered");
	SteamBlocks.RegisterBlocks();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Blocks Registered");
	SteamForge.MinecraftForgeSetup();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Misc Forge thingies Setup");
	EntitySetup.registerEntities();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Entities Setup");
	EntitySetup.addEntitySpawns();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Entity Spawns Setup");
	LocalizationHandler.LanguageRegistrySetup();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Names Setup");
	TileEntityHandler.registerTileEntities();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "TileEntities Setup");
	GenerationHandler.registerGenerators();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Generators Registered");
	GenerationHandler.initBiomes();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Biomes Initialized");
	GenerationHandler.registerDimensions();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Dimensions Initialized");
	Steampunkery.proxy.registerRenderThings();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "RenderThingies registered");
	NetworkRegistry.instance().registerConnectionHandler(
		new SteamPlayerHandler());
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Connection Hanlder handled");
	NetworkRegistry.instance().registerGuiHandler(Steampunkery.instance,
		new SteamGUIHandler());
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "GUI Handler Setup");
	new DamageSourceZap("steampunkery.zap");
	MinecraftForge.EVENT_BUS.register(new SteamEventHandler());
	SteamKeyBindRegistry.init();
	FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("steam", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(SteamItems.steam_bucket), new ItemStack(Item.bucketEmpty));
	BucketHandler.INSTANCE.buckets.put(SteamBlocks.steam_block, SteamItems.steam_bucket);
	MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    }

    @EventHandler
    public void ServerStart(final FMLServerStartingEvent event) {
	Steampunkery.proxy.registerTickHandlers();
	if (ConfigSetup.debug_mode_B = true)
	    SteamLog.log(Level.INFO, "Tick Handlers Registered");
	if (FMLCommonHandler.instance().getEffectiveSide().isClient())
	    SteamKeyBindRegistry.init();
    }

}