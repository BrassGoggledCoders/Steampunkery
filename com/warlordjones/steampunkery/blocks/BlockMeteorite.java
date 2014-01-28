package com.warlordjones.steampunkery.blocks;

import java.util.Random;

import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.steampunkery.entity.EntityMeteoritePrimed;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockMeteorite extends BlockSand {
    public static boolean fallInstantly = true;
    /** Entity position X */
    public double posX;
    /** Entity position Y */
    public double posY;
    /** Entity position Z */
    public double posZ;
    public World worldObj;

    public BlockMeteorite(final int par1, final Material par2Material) {
	super(par1, Material.rock);
	setCreativeTab(Steampunkery.BlockTab);
    }

    @Override
    public void onFinishFalling(final World par1World, final int par2,
	    final int par3, final int par4, final int par5) {
	if (!par1World.isRemote) {
	    // par1World.setBlock(par2, par3 - 1, par4, 0, 0, 2);
	    // par1World.notifyBlockChange(par2, par3 - 1, par4, 0);
	    final EntityMeteoritePrimed entitytntprimed = new EntityMeteoritePrimed(
		    par1World);
	    entitytntprimed.setLocationAndAngles(par2 + 0.5D, par3,
		    par4 + 0.5D, 0.0F, 0.0F);
	    par1World.spawnEntityInWorld(entitytntprimed);
	    entitytntprimed.setInWeb();
	    // entitytntprimed.setVelocity(10, 10, 10);
	}
    }

    @Override
    public int quantityDropped(final Random par1Random) {
	return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	blockIcon = reg.registerIcon("steampunkery" + ":"
		+ getUnlocalizedName().substring(5));
    }
}
