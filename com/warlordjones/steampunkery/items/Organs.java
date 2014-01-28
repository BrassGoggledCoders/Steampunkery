package com.warlordjones.steampunkery.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class Organs extends ItemBase {
    public static final String[] names = new String[] { "0", "1", "2", "3" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    int number_organs = 4;

    public Organs(final int id) {
	super(id);
	setHasSubtypes(true);
	setUnlocalizedName("organs");
    }

    @Override
    public Icon getIconFromDamage(final int par1) {
	return icons[par1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(final int par1,
	    final CreativeTabs par2CreativeTabs, final List par3List) {
	for (int x = 0; x < number_organs; x++)
	    par3List.add(new ItemStack(this, 1, x));
    }

    @Override
    public String getUnlocalizedName(final ItemStack par1ItemStack) {
	final int i = MathHelper
		.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	return super.getUnlocalizedName() + "." + Organs.names[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister par1IconRegister) {
	icons = new Icon[number_organs];
	for (int i = 0; i < icons.length; i++)
	    icons[i] = par1IconRegister.registerIcon("steampunkery:"
		    + this.getUnlocalizedName().substring(5) + i);
    }
}