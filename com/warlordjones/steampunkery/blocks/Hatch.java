/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityHatch;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Hatch extends BlockContainer {

    public static boolean isTrapdoorOpen(final int par0) {
	return (par0 & 4) != 0;
    }

    public Hatch(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.BlockTab);
	setBlockBounds(0, 0, 0, 1, 0.7F, 1);
    }

    /**
     * Ray traces through the blocks collision from start vector to end vector
     * returning a ray trace hit. Args: world, x, y, z, startVec, endVec
     */
    @Override
    public MovingObjectPosition collisionRayTrace(final World par1World,
	    final int par2, final int par3, final int par4,
	    final Vec3 par5Vec3, final Vec3 par6Vec3) {
	setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3,
		par6Vec3);
    }

    @Override
    public TileEntity createNewTileEntity(final World world) {
	return new TileEntityHatch();
    }

    @Override
    public int damageDropped(final int par1) {
	return par1;
    }

    // Trapdoor Stuff
    @Override
    public boolean getBlocksMovement(final IBlockAccess par1IBlockAccess,
	    final int par2, final int par3, final int par4) {
	return !Hatch.isTrapdoorOpen(par1IBlockAccess.getBlockMetadata(par2,
		par3, par4));
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this
     * box can change after the pool has been cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World,
	    final int par2, final int par3, final int par4) {
	setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3,
		par4);
    }

    // You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
	return -1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(final World par1World,
	    final int par2, final int par3, final int par4) {
	setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	return super
		.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    } // make it opaque cube, or else you will be able to see trough the world !

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(final World par1World, final int par2,
	    final int par3, final int par4,
	    final EntityPlayer par5EntityPlayer, final int par6,
	    final float par7, final float par8, final float par9) {
	final int i1 = par1World.getBlockMetadata(par2, par3, par4);
	par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 ^ 4, 2);
	par1World.playSoundAtEntity(par5EntityPlayer, SteamConstants.prefix
		+ "door_open.ogg", 1.0F, 1.0F);
	return true;
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    @Override
    public void onBlockClicked(final World par1World, final int par2,
	    final int par3, final int par4, final EntityPlayer par5EntityPlayer) {
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
     * side, hitX, hitY, hitZ, block metadata
     */
    @Override
    public int onBlockPlaced(final World par1World, final int par2,
	    final int par3, final int par4, final int par5, final float par6,
	    final float par7, final float par8, final int par9) {
	int j1 = 0;

	if (par5 == 2)
	    j1 = 0;

	if (par5 == 3)
	    j1 = 1;

	if (par5 == 4)
	    j1 = 2;

	if (par5 == 5)
	    j1 = 3;

	if (par5 != 1 && par5 != 0 && par7 > 0.5F)
	    j1 |= 8;

	return j1;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: x, y, z,
     * neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {
	if (!par1World.isRemote) {
	    final int i1 = par1World.getBlockMetadata(par2, par3, par4);
	    if ((i1 & 3) == 0) {
	    }

	    if ((i1 & 3) == 1) {
	    }

	    if ((i1 & 3) == 2) {
	    }

	    if ((i1 & 3) == 3) {
	    }

	    final boolean flag = par1World.isBlockIndirectlyGettingPowered(
		    par2, par3, par4);

	    if (flag || par5 > 0 && Block.blocksList[par5].canProvidePower())
		onPoweredBlockChange(par1World, par2, par3, par4, flag);
	}
    }

    public void onPoweredBlockChange(final World par1World, final int par2,
	    final int par3, final int par4, final boolean par5) {
	final int l = par1World.getBlockMetadata(par2, par3, par4);
	final boolean flag1 = (l & 4) > 0;

	if (flag1 != par5) {
	    par1World.setBlockMetadataWithNotify(par2, par3, par4, l ^ 4, 2);
	    par1World.playSoundAtEntity((EntityPlayer) null,
		    SteamConstants.prefix + "door_open.ogg", 1.0F, 1.0F);
	}
    }

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y,
     * z
     */
    @Override
    public void setBlockBoundsBasedOnState(final IBlockAccess par1IBlockAccess,
	    final int par2, final int par3, final int par4) {
	setBlockBoundsForBlockRender(par1IBlockAccess.getBlockMetadata(par2,
		par3, par4));
    }

    public void setBlockBoundsForBlockRender(final int par1) {
	final float f = 0.1875F;

	if ((par1 & 8) != 0)
	    setBlockBounds(0.0F, 1.0F - f, 0.0F, 1.0F, 1.0F, 1.0F);
	else
	    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);

	if (Hatch.isTrapdoorOpen(par1)) {
	    if ((par1 & 3) == 0)
		setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);

	    if ((par1 & 3) == 1)
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);

	    if ((par1 & 3) == 2)
		setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	    if ((par1 & 3) == 3)
		setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
	}
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    @Override
    public void setBlockBoundsForItemRender() {
	final float f = 0.1875F;
	setBlockBounds(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
    }
}
