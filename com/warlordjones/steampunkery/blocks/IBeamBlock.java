package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityIbeam;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IBeamBlock extends BlockContainer {

    public IBeamBlock(int par1, Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("ibeam");
	setCreativeTab(Steampunkery.steampunkeryTab);
	// setRequiresSelfNotify();

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.modid + ":"
		+ getUnlocalizedName().substring(5));
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
	    EntityLivingBase player, ItemStack par6ItemStack) {
	int dir = MathHelper
		.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    }

    // You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
	return -1;
    }

    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    public boolean renderAsNormalBlock() {
	return false;
    }

    public int damageDropped(int par1) {
	return par1;
    }

    public TileEntity createNewTileEntity(World var1) {
	return new TileEntityIbeam();

    }
}
