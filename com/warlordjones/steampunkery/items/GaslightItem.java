/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.items;

import com.warlordjones.steampunkery.blocks.SteamBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GaslightItem extends ItemBase {
    public GaslightItem(final int id) {
	super(id);
    }

    @Override
    public boolean onItemUse(final ItemStack par1ItemStack,
	    final EntityPlayer par2EntityPlayer, final World par3World,
	    final int par4, final int par5, final int par6, final int par7,
	    final float par8, final float par9, final float par10) {
	par3World.setBlock(par4, par5, par6, SteamBlocks.gaslight.blockID);
	par3World.setBlock(par4, par5 + 1, par6, SteamBlocks.gaslight.blockID);
	par3World.notifyBlocksOfNeighborChange(par4, par5, par6,
		SteamBlocks.gaslight.blockID);
	par3World.notifyBlocksOfNeighborChange(par4, par5 + 1, par6,
		SteamBlocks.gaslight.blockID);
	--par1ItemStack.stackSize;
	return true;
    }
}
