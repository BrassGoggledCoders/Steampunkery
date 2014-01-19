package com.warlordjones.steampunkery.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.warlordjones.steampunkery.SteamExtendedPlayer;
import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Goggles extends ItemArmor {
    public Goggles(final int par1,
	    final EnumArmorMaterial par2EnumArmorMaterial, final int par3,
	    final int par4, final String type) {
	super(par1, EnumArmorMaterial.CHAIN, 0, 0);
	setMaxStackSize(1);
	setMaxDamage(0);
	setUnlocalizedName("goggles");
	setCreativeTab(Steampunkery.steampunkeryTab);
	setHasSubtypes(false);
    }

    @Override
    public String getArmorTexture(final ItemStack stack, final Entity entity,
	    final int slot, final int layer) {
	return "steampunkery:textures/models/armor/goggles.png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	itemIcon = reg.registerIcon("steampunkery:goggles");
    }
}
