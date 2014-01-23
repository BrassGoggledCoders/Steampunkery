package com.warlordjones.steampunkery.tileentities;

import com.warlordjones.steampunkery.SteamConstants;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {

	GameRegistry.registerTileEntity(TileEntityTeslaCoil.class,
		SteamConstants.prefix + "tile.tesla_coil");
	GameRegistry.registerTileEntity(TileEntityIbeam.class, SteamConstants.prefix + "tile.i_beam");
	GameRegistry.registerTileEntity(TileEntityGaslight.class,
		SteamConstants.prefix + "tile.gaslight");
	GameRegistry.registerTileEntity(TileEntityBrassPlaque.class,
		SteamConstants.prefix + "tile.plaque");
	GameRegistry.registerTileEntity(TileEntityHatch.class, SteamConstants.prefix + "tile.hatch");
	GameRegistry.registerTileEntity(TileEntityConveyor.class, SteamConstants.prefix + "tile.conveyor_belt");
    }
}
