package com.warlordjones.steampunkery.blocks.cryo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityCryoPlayer;

public class CryoPlayerBlock extends BlockContainer {

    public CryoPlayerBlock(int par1, Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("cryo_player");
	setCreativeTab(Steampunkery.steampunkeryTab);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	// TODO Auto-generated method stub
	return new TileEntityCryoPlayer();
    }

}
