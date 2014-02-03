/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.entity.EntityFleshGolem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SoulPumpkin extends BlockBase {
    @SideOnly(Side.CLIENT)
    private Icon soulpumpkinIconFront;
    @SideOnly(Side.CLIENT)
    private Icon soulpumpkinIconTop;

    public SoulPumpkin(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setTickRandomly(true);
	setUnlocalizedName("soul_pumpkin");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
    @Override
    public Icon getIcon(final int par1, final int par2) {
	return par1 == 1 ? soulpumpkinIconTop : par1 == 0 ? soulpumpkinIconTop
		: par1 != par2 ? blockIcon : soulpumpkinIconFront;
    }

    @Override
    public void onBlockAdded(final World par1World, final int par2,
	    final int par3, final int par4) {
	super.onBlockAdded(par1World, par2, par3, par4);
	if (par1World.getBlockId(par2, par3 - 1, par4) == SteamBlocks.flesh_block.blockID
		&& par1World.getBlockId(par2, par3 - 2, par4) == SteamBlocks.flesh_block.blockID)
	    if (!par1World.isRemote) {
		par1World.setBlock(par2, par3, par4, 0, 0, 2);
		par1World.setBlock(par2, par3 - 1, par4, 0, 0, 2);
		par1World.setBlock(par2, par3 - 2, par4, 0, 0, 2);
		final EntityFleshGolem entityfleshgolem = new EntityFleshGolem(
			par1World);
		entityfleshgolem.setLocationAndAngles(par2 + 0.5D,
			par3 - 1.95D, par4 + 0.5D, 0.0F, 0.0F);
		par1World.spawnEntityInWorld(entityfleshgolem);
		par1World.notifyBlockChange(par2, par3, par4, 0);
		par1World.notifyBlockChange(par2, par3 - 1, par4, 0);
		par1World.notifyBlockChange(par2, par3 - 2, par4, 0);
	    }
    }

    @Override
    public void onBlockPlacedBy(final World par1World, final int par2,
	    final int par3, final int par4,
	    final EntityLivingBase par5EntityLivingBase,
	    final ItemStack par6ItemStack) {
	super.onBlockAdded(par1World, par2, par3, par4);
	setDefaultDirection(par1World, par2, par3, par4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(final IconRegister par1IconRegister) {
	blockIcon = par1IconRegister.registerIcon("steampunkery:"
		+ "soul_pumpkin_side");
	soulpumpkinIconFront = par1IconRegister.registerIcon("steampunkery:"
		+ "soul_pumpkin_face");
	soulpumpkinIconTop = par1IconRegister.registerIcon("steampunkery:"
		+ "soul_pumpkin_top");
    }

    private void setDefaultDirection(final World world, final int x,
	    final int y, final int z) {
	if (!world.isRemote) {
	    final int l = world.getBlockId(x, y, z - 1);
	    final int il = world.getBlockId(x, y, z + 1);
	    final int jl = world.getBlockId(x - 1, y, z);
	    final int kl = world.getBlockId(x + 1, y, z);
	    byte b0 = 3;
	    if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[il])
		b0 = 3;
	    if (Block.opaqueCubeLookup[il] && !Block.opaqueCubeLookup[l])
		b0 = 2;
	    if (Block.opaqueCubeLookup[kl] && !Block.opaqueCubeLookup[jl])
		b0 = 5;
	    if (Block.opaqueCubeLookup[jl] && !Block.opaqueCubeLookup[kl])
		b0 = 5;
	    world.setBlockMetadataWithNotify(x, y, z, b0, 2);
	}
    }
}
