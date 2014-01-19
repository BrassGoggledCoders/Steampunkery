package com.warlordjones.steampunkery.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreBlocks extends Block {
    public static String[] names = new String[] { "aluminum", "copper", "tin",
	    "zinc" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    int number_blocks = 4;

    public OreBlocks(final int id) {
	super(id, Material.rock);
	setUnlocalizedName("ore_blocks");
	setCreativeTab(Steampunkery.steampunkeryTab);
    }

    @Override
    public int damageDropped(final int par1) {
	return par1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(final int par1, final int par2) {
	return icons[par2];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final int par1,
	    final CreativeTabs par2CreativeTabs, final List par3List) {
	for (int var4 = 0; var4 < number_blocks; ++var4)
	    par3List.add(new ItemStack(par1, 1, var4));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister par1IconRegister) {
	icons = new Icon[number_blocks];
	for (int i = 0; i < icons.length; i++)
	    icons[i] = par1IconRegister.registerIcon("steampunkery:"
		    + getUnlocalizedName().substring(5) + i);
    }
}