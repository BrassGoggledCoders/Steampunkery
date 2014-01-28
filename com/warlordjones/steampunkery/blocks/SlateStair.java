package com.warlordjones.steampunkery.blocks;

import java.util.List;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class SlateStair extends BlockStairs {
    public static String[] names = new String[] { "smooth", "cobble", "brick" };
    private final static Block block = SteamBlocks.slate;
    static int number_blocks = 3;
    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public SlateStair(final int id, final int par3) {
	super(id, SlateStair.block, par3);
	setUnlocalizedName("slate_stair");
	setCreativeTab(Steampunkery.BlockTab);
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
	for (int var4 = 0; var4 < SlateStair.number_blocks; ++var4)
	    par3List.add(new ItemStack(par1, 1, var4));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister par1IconRegister) {
	icons = new Icon[SlateStair.number_blocks];
	for (int i = 0; i < icons.length; i++)
	    icons[i] = par1IconRegister.registerIcon("steampunkery:"
		    + getUnlocalizedName().substring(5) + i);
    }
}