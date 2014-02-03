/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.Steampunkery;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Toolbelt extends ItemBase {
    public Toolbelt(final int id) {
	super(id);
	// TODO Auto-generated constructor stub
    }

    @Override
    public ItemStack onItemRightClick(final ItemStack par1ItemStack,
	    final World par2World, final EntityPlayer par3EntityPlayer)// , int
								       // par2,
								       // int
								       // par3,
								       // int
								       // par4)
    {
	if (!par2World.isRemote)
	    return par1ItemStack;
	else {
	    par3EntityPlayer.openGui(Steampunkery.instance, 100, par2World, 0,
		    0, 0);
	    // displayGUIToolbelt(par1ItemStack);
	    return par1ItemStack;
	}

    }
}
