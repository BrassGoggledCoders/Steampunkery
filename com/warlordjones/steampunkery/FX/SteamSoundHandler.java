/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.FX;

import com.warlordjones.steampunkery.SteamConstants;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SteamSoundHandler {
    @ForgeSubscribe
    public void onSound(final SoundLoadEvent event) {
	event.manager.addSound(SteamConstants.prefix + "door_open.ogg");
	event.manager.addSound(SteamConstants.prefix + "door_close.ogg");
    }
}
