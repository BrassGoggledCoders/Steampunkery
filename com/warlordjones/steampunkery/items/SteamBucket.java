/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.Steampunkery;

import net.minecraft.item.ItemBucket;

public class SteamBucket extends ItemBucket {

    public SteamBucket(final int par1, final int par2) {
	super(par1, par2);
	setUnlocalizedName("steam_bucket");
	setCreativeTab(Steampunkery.ItemTab);
    }

}
