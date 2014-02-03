/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.gui;

import com.warlordjones.steampunkery.SteamExtendedPlayer;
import com.warlordjones.steampunkery.gui.player.ContainerSteamCustomPlayer;
import com.warlordjones.steampunkery.gui.player.GuiSteamCustomPlayerInventory;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SteamGUIHandler implements IGuiHandler {

    /** Custom GUI indices: */
    public static final int GUI_CUSTOM_INV = 0;

    @Override
    public Object getClientGuiElement(final int guiId,
	    final EntityPlayer player, final World world, final int x,
	    final int y, final int z) {
	if (guiId == SteamGUIHandler.GUI_CUSTOM_INV)
	    return new GuiSteamCustomPlayerInventory(player, player.inventory,
		    SteamExtendedPlayer.get(player).inventory);
	else
	    return null;
    }

    // And now in CommonProxy, the class I registered as my GuiHandler:
    @Override
    public Object getServerGuiElement(final int guiId,
	    final EntityPlayer player, final World world, final int x,
	    final int y, final int z) {
	if (guiId == SteamGUIHandler.GUI_CUSTOM_INV)
	    return new ContainerSteamCustomPlayer(player, player.inventory,
		    SteamExtendedPlayer.get(player).inventory);
	else
	    return null;
    }
}
