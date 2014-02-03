/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityIbeam;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class IBeamBlock extends BlockContainer {

    public IBeamBlock(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("ibeam");
	setCreativeTab(Steampunkery.BlockTab);
	// setRequiresSelfNotify();

    }

    @Override
    public TileEntity createNewTileEntity(final World var1) {
	return new TileEntityIbeam();

    }

    @Override
    public int damageDropped(final int par1) {
	return par1;
    }

    // You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
	return -1;
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    @Override
    public void onBlockPlacedBy(final World world, final int x, final int y,
	    final int z, final EntityLivingBase player,
	    final ItemStack par6ItemStack) {
	final int dir = MathHelper
		.floor_double(player.rotationYaw * 4F / 360F + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon(SteamConstants.modid + ":"
		+ getUnlocalizedName().substring(5));
    }

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }
}
