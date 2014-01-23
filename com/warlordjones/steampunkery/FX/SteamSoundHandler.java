package com.warlordjones.steampunkery.FX;

import java.util.logging.Level;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.util.SteamLog;

public class SteamSoundHandler {
@ForgeSubscribe
public void onSound(SoundLoadEvent event)
{
    event.manager.addSound(SteamConstants.prefix + "door_open.ogg");
    event.manager.addSound(SteamConstants.prefix + "door_close.ogg");
}
}
