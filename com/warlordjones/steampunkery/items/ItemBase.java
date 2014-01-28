package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(final int id) {
	super(id);
	setCreativeTab(Steampunkery.ItemTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	itemIcon = reg.registerIcon("steampunkery" + ":"
		+ this.getUnlocalizedName().substring(5));
    }
}
