package com.warlordjones.steampunkery.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BrassParts extends Item {
    public static final String[] names = new String[] { "0", "1", "2", "3",
	    "4", "5", "6", "7", "8", "9", "10", "11" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    int number_parts = 12;

    public BrassParts(final int id) {
	super(id);
	setHasSubtypes(true);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setUnlocalizedName("brass_parts");
	setTextureName("/parts/brass_parts");
    }

    @Override
    public Icon getIconFromDamage(final int par1) {
	return icons[par1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(final int par1,
	    final CreativeTabs par2CreativeTabs, final List par3List) {
	for (int x = 0; x < number_parts; x++)
	    par3List.add(new ItemStack(this, 1, x));
    }

    @Override
    public String getUnlocalizedName(final ItemStack par1ItemStack) {
	final int i = MathHelper
		.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	return super.getUnlocalizedName() + "." + BrassParts.names[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister par1IconRegister) {
	icons = new Icon[number_parts];
	for (int i = 0; i < icons.length; i++)
	    icons[i] = par1IconRegister.registerIcon("steampunkery:parts/"
		    + this.getUnlocalizedName().substring(5) + i);
    }
}