package com.warlordjones.steampunkery.blocks;

import java.util.Random;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class LightningRod extends Block {
    public static boolean strike = false;

    public LightningRod(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setTickRandomly(true);
	setUnlocalizedName("lightning_rod");
	setCreativeTab(Steampunkery.BlockTab);
    }

    /**
     * Return whether an adjacent block can connect to a wall.
     */
    public boolean canConnectWallTo(final IBlockAccess par1IBlockAccess,
	    final int par2, final int par3, final int par4) {
	final int l = par1IBlockAccess.getBlockId(par2, par3, par4);
	if (l != blockID) {
	    final Block block = Block.blocksList[l];
	    return block != null && block.blockMaterial.isOpaque()
		    && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin
		    : false;
	} else
	    return true;
    }

    // ** public TileEntity createNewTileEntity(World par1World)
    // {
    // return new TileEntityLightningRod();
    /**
     * Determines the damage on the item the block drops. Used in cloth and
     * wood.
     */
    @Override
    public int damageDropped(final int par1) {
	return par1;
    }

    // else
    // return;
    // }
    @Override
    public boolean getBlocksMovement(final IBlockAccess par1IBlockAccess,
	    final int par2, final int par3, final int par4) {
	return false;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this
     * box can change after the pool has been cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World,
	    final int par2, final int par3, final int par4) {
	setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	maxY = 1.5D;
	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3,
		par4);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube() {
	return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon("steampunkery" + ":" + "metal_blocks1");
    }

    /**
     * If this block doesn't render as an ordinary block it will return False
     * (examples: signs, buttons, stairs, etc)
     */
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
	final boolean flag = canConnectWallTo(par1IBlockAccess, par2, par3,
		par4 - 1);
	final boolean flag1 = canConnectWallTo(par1IBlockAccess, par2, par3,
		par4 + 1);
	final boolean flag2 = canConnectWallTo(par1IBlockAccess, par2 - 1,
		par3, par4);
	final boolean flag3 = canConnectWallTo(par1IBlockAccess, par2 + 1,
		par3, par4);
	float f = 0.25F;
	float f1 = 0.75F;
	float f2 = 0.25F;
	float f3 = 0.75F;
	float f4 = 1.0F;
	if (flag)
	    f2 = 0.0F;
	if (flag1)
	    f3 = 1.0F;
	if (flag2)
	    f = 0.0F;
	if (flag3)
	    f1 = 1.0F;
	if (flag && flag1 && !flag2 && !flag3) {
	    f4 = 0.8125F;
	    f = 0.3125F;
	    f1 = 0.6875F;
	} else if (!flag && !flag1 && flag2 && flag3) {
	    f4 = 0.8125F;
	    f2 = 0.3125F;
	    f3 = 0.6875F;
	}
	setBlockBounds(f, 0.0F, f2, f1, f4, f3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess,
	    final int par2, final int par3, final int par4, final int par5) {
	return par5 == 0 ? super.shouldSideBeRendered(par1IBlockAccess, par2,
		par3, par4, par5) : true;
    }

    // }
    public void updateTick(final World par1World, final int par2,
	    final int par3, final int par4, final Random par5Random,
	    final WorldInfo par6WorldInfo) {
	par1World.isThundering();
	if (true) {
	    final EntityLightningBolt entitylightning = new EntityLightningBolt(
		    par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F);
	    par1World.spawnEntityInWorld(entitylightning);
	}
    }
}
