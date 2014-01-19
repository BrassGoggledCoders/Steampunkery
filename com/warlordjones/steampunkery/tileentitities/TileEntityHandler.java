package com.warlordjones.steampunkery.tileentitities;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {

	GameRegistry.registerTileEntity(TileEntityTeslaCoil.class,
		"tile.tesla_coil");
	GameRegistry.registerTileEntity(TileEntityIbeam.class, "tile.i_beam");
	GameRegistry.registerTileEntity(TileEntityGaslight.class,
		"tile.gaslight");
	GameRegistry.registerTileEntity(TileEntityBrassPlaque.class,
		"tile.plaque");
	GameRegistry.registerTileEntity(TileEntityHatch.class, "tile.hatch");
    }
}
