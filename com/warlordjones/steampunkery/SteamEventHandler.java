package com.warlordjones.steampunkery;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class SteamEventHandler {
    @ForgeSubscribe
    public void onEntityConstructing(EntityConstructing event)
    {
    /*
    Be sure to check if the entity being constructed is the correct type for the extended properties you're about to add! The null check may not be necessary - I only use it to make sure properties are only registered once per entity
    */
    if (event.entity instanceof EntityPlayer && SteamExtendedPlayer.get((EntityPlayer) event.entity) == null)
    // This is how extended properties are registered using our convenient method from earlier
    SteamExtendedPlayer.register((EntityPlayer) event.entity);
    // That will call the constructor as well as cause the init() method
    // to be called automatically

    // If you didn't make the two convenient methods from earlier, your code would be
    // much uglier:
    if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(SteamExtendedPlayer.EXT_PROP_NAME) == null)
    event.entity.registerExtendedProperties(SteamExtendedPlayer.EXT_PROP_NAME, new SteamExtendedPlayer((EntityPlayer) event.entity));
    }
}
