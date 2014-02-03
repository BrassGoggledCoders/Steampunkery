/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import java.util.List;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class SlateSlab extends BlockHalfSlab {
    public static String[] names = new String[] { "smooth", "cobble", "brick" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    protected final boolean isDoubleSlab;
    int number_blocks = 3;

    public SlateSlab(final int id, final boolean par2,
	    final Material par3Material) {
	super(id, par2, Material.anvil);
	isDoubleSlab = par2;
	setUnlocalizedName("slate_slab");
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public int damageDropped(final int par1) {
	return par1;
    }

    @Override
    public String getFullSlabName(final int i) {
	return "slate";
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