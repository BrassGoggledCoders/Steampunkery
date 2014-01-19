package com.warlordjones.steampunkery;

import com.warlordjones.steampunkery.gui.player.SteamCustomPlayerInventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class SteamExtendedPlayer implements IExtendedEntityProperties
{
    public SteamCustomPlayerInventory inventory;

    public SteamExtendedPlayer(EntityPlayer player)
    {
	
    }
/*
Here I create a constant EXT_PROP_NAME for this class of properties. You need a unique name for every instance of IExtendedEntityProperties you make, and doing it at the top of each class as a constant makes
it very easy to organize and avoid typos. It's easiest to keep the same constant name in every class, as it will be distinguished by the class name: ExtendedPlayer.EXT_PROP_NAME vs. ExtendedEntity.EXT_PROP_NAME

Note that a single entity can have multiple extended properties, so each property should have a unique name. Try to come up with something more unique than the tutorial example.
*/
public final static String EXT_PROP_NAME = "SteamExtendedPlayer";

@Override
public void saveNBTData(NBTTagCompound compound) {
    // TODO Auto-generated method stub
    
}

@Override
public void loadNBTData(NBTTagCompound compound) {
    // TODO Auto-generated method stub
    
}

@Override
public void init(Entity entity, World world) {
    // TODO Auto-generated method stub
    
}

public static void register(EntityPlayer entity) {
    entity.registerExtendedProperties(SteamExtendedPlayer.EXT_PROP_NAME, new SteamExtendedPlayer(entity));
    
}

public static final SteamExtendedPlayer get(EntityPlayer player)
{
return (SteamExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
}

}