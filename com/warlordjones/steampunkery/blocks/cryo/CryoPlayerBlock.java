package com.warlordjones.steampunkery.blocks.cryo;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityCryoPlayer;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CryoPlayerBlock extends BlockContainer {

    public CryoPlayerBlock(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("cryo_player");
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public TileEntity createNewTileEntity(final World world) {
	// TODO Auto-generated method stub
	return new TileEntityCryoPlayer();
    }

}
