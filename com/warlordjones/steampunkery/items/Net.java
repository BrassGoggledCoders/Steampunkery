package com.warlordjones.steampunkery.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Net extends ItemBase {
    public static Entity creature_name;
    public static final String[] names = new String[] { "0", "1" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    int number_plates = 2;

    public Net(final int id) {
	super(id);
	setHasSubtypes(true);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setUnlocalizedName("net");
    }

    @Override
    public Icon getIconFromDamage(final int par1) {
	return icons[par1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(final int par1,
	    final CreativeTabs par2CreativeTabs, final List par3List) {
	for (int x = 0; x < number_plates; x++)
	    par3List.add(new ItemStack(this, 1, x));
    }

    @Override
    public String getUnlocalizedName(final ItemStack par1ItemStack) {
	final int i = MathHelper
		.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	return super.getUnlocalizedName() + "." + names[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister par1IconRegister) {
	icons = new Icon[number_plates];
	for (int i = 0; i < icons.length; i++)
	    icons[i] = par1IconRegister.registerIcon("steampunkery:"
		    + this.getUnlocalizedName().substring(5) + i);
    }

    public boolean itemInteractionForEntity(ItemStack par1ItemStack,
	    EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
	par3EntityLivingBase.setDead();
	this.creature_name = par3EntityLivingBase;
	par1ItemStack.setItemDamage(1);
	return true;
    }

    public boolean onItemUse(ItemStack par1ItemStack,
	    EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
	    int par6, int par7, float par8, float par9, float par10) {
	if (par3World.isRemote) {
	    return true;
	} else {
	    par3World.spawnEntityInWorld(creature_name);
	    par1ItemStack.setItemDamage(0);
	    return true;
	}
    }
}
