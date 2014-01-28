package com.warlordjones.steampunkery.items;

import java.util.List;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Net extends ItemBase {
    public static Entity creature_name;
    public static final String[] names = new String[] { "0", "1" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    int number_plates = 2;

    public Net(final int id) {
	super(id);
	setHasSubtypes(true);
	setCreativeTab(Steampunkery.ItemTab);
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
	return super.getUnlocalizedName() + "." + Net.names[i];
    }

    @Override
    public boolean itemInteractionForEntity(final ItemStack par1ItemStack,
	    final EntityPlayer par2EntityPlayer,
	    final EntityLivingBase par3EntityLivingBase) {
	par3EntityLivingBase.setDead();
	creature_name = par3EntityLivingBase;
	par1ItemStack.setItemDamage(1);
	return true;
    }

    @Override
    public boolean onItemUse(final ItemStack par1ItemStack,
	    final EntityPlayer par2EntityPlayer, final World par3World,
	    final int par4, final int par5, final int par6, final int par7,
	    final float par8, final float par9, final float par10) {
	if (par3World.isRemote)
	    return true;
	else {
	    par3World.spawnEntityInWorld(Net.creature_name);
	    par1ItemStack.setItemDamage(0);
	    return true;
	}
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister par1IconRegister) {
	icons = new Icon[number_plates];
	for (int i = 0; i < icons.length; i++)
	    icons[i] = par1IconRegister.registerIcon("steampunkery:"
		    + this.getUnlocalizedName().substring(5) + i);
    }
}
