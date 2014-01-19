package com.warlordjones.steampunkery;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

import com.warlordjones.steampunkery.util.SteamUpdateChecker;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class SteamPlayerHandler implements IConnectionHandler {
    private boolean givenCoal = false;

    @Override
    public void clientLoggedIn(final NetHandler clientHandler,
	    final INetworkManager manager, final Packet1Login login) {
	// TODO Auto-generated method stub
    }

    @Override
    public void connectionClosed(final INetworkManager manager) {
	// TODO Auto-generated method stub
    }

    @Override
    public void connectionOpened(final NetHandler netClientHandler,
	    final MinecraftServer server, final INetworkManager manager) {
	// TODO Auto-generated method stub
    }

    @Override
    public void connectionOpened(final NetHandler netClientHandler,
	    final String server, final int port, final INetworkManager manager) {
	// TODO Auto-generated method stub
    }

    @Override
    public String connectionReceived(final NetLoginHandler netHandler,
	    final INetworkManager manager) {
	// TODO Auto-generated method stub
	return null;
    }

    public void giveCoal(final EntityPlayer player, final ItemStack item) {
	if (!givenCoal) {
	    player.inventory.addItemStackToInventory(new ItemStack(Item.coal,
		    64));
	    givenCoal = true;
	}
    }

    @Override
    public void playerLoggedIn(final Player player,
	    final NetHandler netHandler, final INetworkManager manager) {
	// Update Checker
	if (ConfigSetup.update_checker_B) {
	    try {
		if (SteamUpdateChecker.isSteamUpdateAvailable())
		    netHandler
			    .getPlayer()
			    .sendChatToPlayer(
				    ChatMessageComponent
					    .createFromText("["
						    + EnumChatFormatting.RED
						    + "Steampunkery"
						    + EnumChatFormatting.RESET
						    + "] An Update is available for this mod. Check http://brassgoggles.co.uk/forum/index.php/topic,41565 for more info."));
		else
		    netHandler.getPlayer().sendChatToPlayer(
			    ChatMessageComponent.createFromText("["
				    + EnumChatFormatting.RED + "Steampunkery"
				    + EnumChatFormatting.RESET
				    + "] Mod Up to Date"));
	    } catch (final MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (final IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	final Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
	if (calendar.get(2) + 1 == 12 && calendar.get(5) == 25) {
	    {
		if (!givenCoal) {
		    giveCoal((EntityPlayer) player, new ItemStack(Item.coal));
		    netHandler
			    .getPlayer()
			    .sendChatToPlayer(
				    ChatMessageComponent
					    .createFromText("["
						    + EnumChatFormatting.RED
						    + "Steampunkery"
						    + EnumChatFormatting.RESET
						    + "] Us Steampunk types probably like coal in our stockings!"));
		} else
		    return;
	    }
	    givenCoal = true;
	} else
	    return;
    }
}
