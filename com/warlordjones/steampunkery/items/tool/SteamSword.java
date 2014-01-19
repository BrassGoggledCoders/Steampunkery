package com.warlordjones.steampunkery.items.tool;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SteamSword extends ItemSword {
    /** Reference to the World object. */
    public World worldObj;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;

    /** Entity position X */
    public double posX;

    /** Entity position Y */
    public double posY;

    /** Entity position Z */
    public double posZ;

    public SteamSword(final int par1,
	    final EnumToolMaterial par2EnumToolMaterial) {
	super(par1, par2EnumToolMaterial);
	setCreativeTab(Steampunkery.steampunkeryTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	itemIcon = reg.registerIcon("steampunkery" + ":"
		+ this.getUnlocalizedName().substring(5));
    }
}
