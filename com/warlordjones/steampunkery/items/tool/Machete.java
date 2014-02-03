/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items.tool;

import com.warlordjones.steampunkery.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class Machete extends ItemBase {
    public float efficiencyOnProperMaterial = 8.0F;

    public Machete(final int id) {
	super(id);
	// TODO Auto-generated constructor stub
    }

    @Override
    public float getStrVsBlock(final ItemStack par1ItemStack,
	    final Block par2Block) {
	return par2Block != null
		&& (par2Block.blockMaterial == Material.wood
			|| par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? efficiencyOnProperMaterial
		: super.getStrVsBlock(par1ItemStack, par2Block);
    }
}
