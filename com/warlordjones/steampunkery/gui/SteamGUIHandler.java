package com.warlordjones.steampunkery.gui;

import com.warlordjones.steampunkery.SteamExtendedPlayer;
import com.warlordjones.steampunkery.gui.player.ContainerSteamCustomPlayer;
import com.warlordjones.steampunkery.gui.player.GuiSteamCustomPlayerInventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class SteamGUIHandler implements IGuiHandler {

	/** Custom GUI indices: */
	public static final int GUI_CUSTOM_INV = 0;

	// And now in CommonProxy, the class I registered as my GuiHandler:
	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
	if (guiId == GUI_CUSTOM_INV)
	return new ContainerSteamCustomPlayer(player, player.inventory, SteamExtendedPlayer.get(player).inventory);
	else
	return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
	if (guiId == GUI_CUSTOM_INV)
	return new GuiSteamCustomPlayerInventory(player, player.inventory, SteamExtendedPlayer.get(player).inventory);
	else
	return null;
	}
}
