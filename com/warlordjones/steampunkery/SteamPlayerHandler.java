package com.warlordjones.steampunkery;

import java.io.IOException;
import java.net.MalformedURLException;

import com.warlordjones.steampunkery.util.SteamUpdateChecker;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class SteamPlayerHandler implements IConnectionHandler {

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

    @Override
    public void playerLoggedIn(final Player player,
	    final NetHandler netHandler, final INetworkManager manager) {
	// Update Checker
	if (ConfigSetup.update_checker_B)
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
		e.printStackTrace();
	    } catch (final IOException e) {
		e.printStackTrace();
	    }
    }
}
