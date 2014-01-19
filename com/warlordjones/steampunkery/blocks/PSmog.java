package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PSmog extends Smog {
    public PSmog(int par1, Material par2Material) {
	super(par1, par2Material);
	setUnlocalizedName("p_smog");
    }

    @Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
	    int par4, Entity par5Entity) {
	par5Entity.setInWeb();
	par5Entity.attackEntityFrom(DamageSource.wither, 1);
    }
}
