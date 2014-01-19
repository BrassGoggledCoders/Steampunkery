package com.warlordjones.steampunkery.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.gen.dimension.TeleporterEther;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEtherPortal extends BlockBreakable {
    public BlockEtherPortal(final int par1) {
	super(par1, "portal", Material.portal, false);
	setTickRandomly(true);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this
     * box can change after the pool has been cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World,
	    final int par2, final int par3, final int par4) {
	return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass() {
	return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(final World par1World, final int par2, final int par3,
	    final int par4) {
	return 0;
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

    /**
     * Triggered whenever an entity collides with this block (enters into the
     * block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock(final World par1World,
	    final int par2, final int par3, final int par4,
	    final Entity par5Entity) {
	if (par5Entity.ridingEntity == null
		&& par5Entity.riddenByEntity == null
		&& par5Entity instanceof EntityPlayerMP) {
	    final EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
	    if (thePlayer.timeUntilPortal > 0)
		thePlayer.timeUntilPortal = 10;
	    else if (thePlayer.dimension != ConfigSetup.etherID) {
		thePlayer.timeUntilPortal = 10;
		thePlayer.mcServer
			.getConfigurationManager()
			.transferPlayerToDimension(
				thePlayer,
				ConfigSetup.etherID,
				new TeleporterEther(
					thePlayer.mcServer
						.worldServerForDimension(ConfigSetup.etherID)));
	    } else {
		thePlayer.timeUntilPortal = 10;
		thePlayer.mcServer.getConfigurationManager()
			.transferPlayerToDimension(
				thePlayer,
				0,
				new TeleporterEther(thePlayer.mcServer
					.worldServerForDimension(0)));
	    }
	}
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: x, y, z,
     * neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {
	byte b0 = 0;
	byte b1 = 1;
	if (par1World.getBlockId(par2 - 1, par3, par4) == blockID
		|| par1World.getBlockId(par2 + 1, par3, par4) == blockID) {
	    b0 = 1;
	    b1 = 0;
	}
	int i1;
	for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == blockID; --i1)
	    ;
	if (par1World.getBlockId(par2, i1 - 1, par4) != Block.obsidian.blockID)
	    par1World.setBlockToAir(par2, par3, par4);
	else {
	    int j1;
	    for (j1 = 1; j1 < 4
		    && par1World.getBlockId(par2, i1 + j1, par4) == blockID; ++j1)
		;
	    if (j1 == 3
		    && par1World.getBlockId(par2, i1 + j1, par4) == SteamBlocks.brass_block.blockID) {
		final boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == blockID
			|| par1World.getBlockId(par2 + 1, par3, par4) == blockID;
		final boolean flag1 = par1World
			.getBlockId(par2, par3, par4 - 1) == blockID
			|| par1World.getBlockId(par2, par3, par4 + 1) == blockID;
		if (flag && flag1)
		    par1World.setBlockToAir(par2, par3, par4);
		else if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != SteamBlocks.brass_block.blockID || par1World
			.getBlockId(par2 - b0, par3, par4 - b1) != blockID)
			&& (par1World.getBlockId(par2 - b0, par3, par4 - b1) != Block.obsidian.blockID || par1World
				.getBlockId(par2 + b0, par3, par4 + b1) != blockID))
		    par1World.setBlockToAir(par2, par3, par4);
	    } else
		par1World.setBlockToAir(par2, par3, par4);
	}
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(final Random par1Random) {
	return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(final World par1World, final int par2,
	    final int par3, final int par4, final Random par5Random) {
	if (par5Random.nextInt(100) == 0)
	    par1World.playSound(par2 + 0.5D, par3 + 0.5D, par4 + 0.5D,
		    "portal.portal", 0.5F,
		    par5Random.nextFloat() * 0.4F + 0.8F, false);
	for (int l = 0; l < 4; ++l) {
	    double d0 = par2 + par5Random.nextFloat();
	    final double d1 = par3 + par5Random.nextFloat();
	    double d2 = par4 + par5Random.nextFloat();
	    double d3 = 0.0D;
	    double d4 = 0.0D;
	    double d5 = 0.0D;
	    final int i1 = par5Random.nextInt(2) * 2 - 1;
	    d3 = (par5Random.nextFloat() - 0.5D) * 0.5D;
	    d4 = (par5Random.nextFloat() - 0.5D) * 0.5D;
	    d5 = (par5Random.nextFloat() - 0.5D) * 0.5D;
	    if (par1World.getBlockId(par2 - 1, par3, par4) != blockID
		    && par1World.getBlockId(par2 + 1, par3, par4) != blockID) {
		d0 = par2 + 0.5D + 0.25D * i1;
		d3 = par5Random.nextFloat() * 2.0F * i1;
	    } else {
		d2 = par4 + 0.5D + 0.25D * i1;
		d5 = par5Random.nextFloat() * 2.0F * i1;
	    }
	    par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
	}
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
	float f;
	float f1;
	if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != blockID
		&& par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != blockID) {
	    f = 0.125F;
	    f1 = 0.5F;
	    setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	} else {
	    f = 0.5F;
	    f1 = 0.125F;
	    setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess,
	    final int par2, final int par3, final int par4, final int par5) {
	if (par1IBlockAccess.getBlockId(par2, par3, par4) == blockID)
	    return false;
	else {
	    final boolean flag = par1IBlockAccess.getBlockId(par2 - 1, par3,
		    par4) == blockID
		    && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != blockID;
	    final boolean flag1 = par1IBlockAccess.getBlockId(par2 + 1, par3,
		    par4) == blockID
		    && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != blockID;
	    final boolean flag2 = par1IBlockAccess.getBlockId(par2, par3,
		    par4 - 1) == blockID
		    && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != blockID;
	    final boolean flag3 = par1IBlockAccess.getBlockId(par2, par3,
		    par4 + 1) == blockID
		    && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != blockID;
	    final boolean flag4 = flag || flag1;
	    final boolean flag5 = flag2 || flag3;
	    return flag4 && par5 == 4 ? true : flag4 && par5 == 5 ? true
		    : flag5 && par5 == 2 ? true : flag5 && par5 == 3;
	}
    }

    /**
     * Checks to see if this location is valid to create a portal and will
     * return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(final World par1World, int par2,
	    final int par3, int par4) {
	byte b0 = 0;
	byte b1 = 0;
	if (par1World.getBlockId(par2 - 1, par3, par4) == SteamBlocks.brass_block.blockID
		|| par1World.getBlockId(par2 + 1, par3, par4) == SteamBlocks.brass_block.blockID)
	    b0 = 1;
	if (par1World.getBlockId(par2, par3, par4 - 1) == SteamBlocks.brass_block.blockID
		|| par1World.getBlockId(par2, par3, par4 + 1) == SteamBlocks.brass_block.blockID)
	    b1 = 1;
	if (b0 == b1)
	    return false;
	else {
	    if (par1World.isAirBlock(par2 - b0, par3, par4 - b1)) {
		par2 -= b0;
		par4 -= b1;
	    }
	    int l;
	    int i1;
	    for (l = -1; l <= 2; ++l)
		for (i1 = -1; i1 <= 3; ++i1) {
		    final boolean flag = l == -1 || l == 2 || i1 == -1
			    || i1 == 3;
		    if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
			final int j1 = par1World.getBlockId(par2 + b0 * l, par3
				+ i1, par4 + b1 * l);
			final boolean isAirBlock = par1World.isAirBlock(par2
				+ b0 * l, par3 + i1, par4 + b1 * l);
			if (flag) {
			    if (j1 != SteamBlocks.brass_block.blockID)
				return false;
			} else if (!isAirBlock && j1 != Block.fire.blockID)
			    return false;
		    }
		}
	    for (l = 0; l < 2; ++l)
		for (i1 = 0; i1 < 3; ++i1)
		    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l,
			    SteamBlocks.ether_portal.blockID, 0, 2);
	    return true;
	}
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(final World par1World, final int par2,
	    final int par3, final int par4, final Random par5Random) {
	super.updateTick(par1World, par2, par3, par4, par5Random);
	if (par1World.provider.isSurfaceWorld()
		&& par5Random.nextInt(2000) < par1World.difficultySetting) {
	    int l;
	    for (l = par3; !par1World.doesBlockHaveSolidTopSurface(par2, l,
		    par4) && l > 0; --l)
		;
	    if (l > 0 && !par1World.isBlockNormalCube(par2, l + 1, par4)) {
		final Entity entity = ItemMonsterPlacer.spawnCreature(
			par1World, 57, par2 + 0.5D, l + 1.1D, par4 + 0.5D);
		if (entity != null)
		    entity.timeUntilPortal = entity.getPortalCooldown();
	    }
	}
    }
}
