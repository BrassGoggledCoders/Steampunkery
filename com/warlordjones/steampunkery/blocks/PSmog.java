package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PSmog extends Smog {
    public PSmog(final int par1, final Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("p_smog");
    }

    @Override
    public void onEntityCollidedWithBlock(final World par1World,
	    final int par2, final int par3, final int par4,
	    final Entity par5Entity) {
	par5Entity.setInWeb();
	par5Entity.attackEntityFrom(DamageSource.wither, 1);
    }
}
