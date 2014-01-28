package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class SteamBlock extends BlockFluidClassic {

    public SteamBlock(final int steam_blockID) {
	super(steam_blockID, SteamBlocks.steam, Material.water);
	SteamBlocks.steam.setBlockID(steam_blockID);
	setCreativeTab(Steampunkery.MiscTab);
    }

    @Override
    public int colorMultiplier(final IBlockAccess iblockaccess, final int x,
	    final int y, final int z) {
	return 0x000000; // HEX color code as indicated by the 0x infront. This
			 // is a greenish color.
    }

    // Use Register Icon as usual to get the block's icon.
    // If you want you can reuse the water texture and change the color of it by
    // doing as I have below:
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(final int side, final int meta) {
	return Block.waterMoving.getIcon(side, meta);
    }
}
