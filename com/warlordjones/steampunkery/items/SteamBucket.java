package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.Steampunkery;

import net.minecraft.item.ItemBucket;

public class SteamBucket extends ItemBucket{

    public SteamBucket(int par1, int par2) {
	super(par1, par2);
	setUnlocalizedName("steam_bucket");
	setCreativeTab(Steampunkery.ItemTab);
    }

}
