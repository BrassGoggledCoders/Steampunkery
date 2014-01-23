package com.warlordjones.steampunkery.blocks;

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

import com.warlordjones.steampunkery.SteamConstants;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.tileentities.TileEntityHatch;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Hatch extends BlockContainer{

    public Hatch(int par1, Material par2Material) {
	super(par1, par2Material);
	setCreativeTab(Steampunkery.steampunkeryTab);
	setBlockBounds(0, 0, 0, 1, 0.7F,1);
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
    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityHatch();
    }
//Trapdoor Stuff
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return !isTrapdoorOpen(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
    @SideOnly(Side.CLIENT)
    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.setBlockBoundsForBlockRender(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.1875F;
        this.setBlockBounds(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
    }

    public void setBlockBoundsForBlockRender(int par1)
    {
        float f = 0.1875F;

        if ((par1 & 8) != 0)
        {
            this.setBlockBounds(0.0F, 1.0F - f, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
        }

        if (isTrapdoorOpen(par1))
        {
            if ((par1 & 3) == 0)
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }

            if ((par1 & 3) == 1)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }

            if ((par1 & 3) == 2)
            {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if ((par1 & 3) == 3)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
            int i1 = par1World.getBlockMetadata(par2, par3, par4);
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 ^ 4, 2);
            par1World.playSoundAtEntity(par5EntityPlayer, SteamConstants.prefix + "door_open.ogg", 1.0F, 1.0F);
            return true;
    }

    public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        boolean flag1 = (l & 4) > 0;

        if (flag1 != par5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l ^ 4, 2);
            par1World.playSoundAtEntity((EntityPlayer) null, SteamConstants.prefix + "door_open.ogg", 1.0F, 1.0F);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            int i1 = par1World.getBlockMetadata(par2, par3, par4);
            int j1 = par2;
            int k1 = par4;

            if ((i1 & 3) == 0)
            {
                k1 = par4 + 1;
            }

            if ((i1 & 3) == 1)
            {
                --k1;
            }

            if ((i1 & 3) == 2)
            {
                j1 = par2 + 1;
            }

            if ((i1 & 3) == 3)
            {
                --j1;
            }

            boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);

            if (flag || par5 > 0 && Block.blocksList[par5].canProvidePower())
            {
                this.onPoweredBlockChange(par1World, par2, par3, par4, flag);
            }
        }
    }

    /**
     * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
     * x, y, z, startVec, endVec
     */
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int j1 = 0;

        if (par5 == 2)
        {
            j1 = 0;
        }

        if (par5 == 3)
        {
            j1 = 1;
        }

        if (par5 == 4)
        {
            j1 = 2;
        }

        if (par5 == 5)
        {
            j1 = 3;
        }

        if (par5 != 1 && par5 != 0 && par7 > 0.5F)
        {
            j1 |= 8;
        }

        return j1;
    }

    public static boolean isTrapdoorOpen(int par0)
    {
        return (par0 & 4) != 0;
    }
}
