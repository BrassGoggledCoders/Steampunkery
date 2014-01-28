package com.warlordjones.steampunkery;

import java.io.*;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class SteamPacketHandler implements IPacketHandler {
    public static final byte EXTENDED_PROPERTIES = 1, OPEN_SERVER_GUI = 0;

    // Here's the method we used in the last step to send the packet:
    /**
     * Sends a packet to the server telling it to open gui for player
     */
    public static final void sendOpenGuiPacket(final int guiId) {
	final ByteArrayOutputStream bos = new ByteArrayOutputStream();
	final DataOutputStream outputStream = new DataOutputStream(bos);

	try {
	    outputStream.writeByte(SteamPacketHandler.OPEN_SERVER_GUI);
	    outputStream.writeInt(guiId);
	} catch (final Exception ex) {
	    ex.printStackTrace();
	}

	PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(
		"Steampunkery", bos.toByteArray()));
    }

    @Override
    public void onPacketData(final INetworkManager manager,
	    final Packet250CustomPayload packet, final Player player) {
	// Now, our onPacketData method needs some changes:
	// Adding this code will allow us to easily distinguish between various
	// CustomPayload packets
	final DataInputStream inputStream = new DataInputStream(
		new ByteArrayInputStream(packet.data));
	byte packetType;
	try {
	    // Read the packet type
	    packetType = inputStream.readByte();
	} catch (final IOException e) {
	    e.printStackTrace();
	    return;
	}

	// Now we check which channel, in case you have more than one registered
	if (packet.channel.equals("Steampunkery"))
	    // Handle each case appropriately:
	    switch (packetType) {
	    case EXTENDED_PROPERTIES:
		handleExtendedProperties(packet, player, inputStream);
		break;
	    case OPEN_SERVER_GUI:
		handleOpenGuiPacket(packet, (EntityPlayer) player, inputStream);
		break;
	    default:
		System.out.println("[PACKET][WARNING] Unknown packet type "
			+ packetType);
	    }

    }

    private void handleExtendedProperties(final Packet250CustomPayload packet,
	    final Player player, final DataInputStream inputStream) {
	// TODO Auto-generated method stub

    }

    private void handleOpenGuiPacket(final Packet250CustomPayload packet,
	    final EntityPlayer player, final DataInputStream inputStream) {
	int guiID;
	// inputStream is already open, so we don't need to do anything other
	// than continue reading from it:
	try {
	    guiID = inputStream.readInt();
	} catch (final IOException e) {
	    e.printStackTrace();
	    return;
	}
	// Now we can open the server gui element, which will automatically open
	// the client element as well
	player.openGui(Steampunkery.instance, guiID, player.worldObj,
		(int) player.posX, (int) player.posY, (int) player.posZ);
    }
}