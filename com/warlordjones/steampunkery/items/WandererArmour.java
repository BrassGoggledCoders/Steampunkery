package com.warlordjones.steampunkery.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class WandererArmour extends ItemArmor {
    private String iconPath = "steampunkery:";
    private String texturePath = "steampunkery:";

    public WandererArmour(final int par1,
	    final EnumArmorMaterial par2EnumArmorMaterial, final int par3,
	    final int par4, final String type) {
	super(par1, par2EnumArmorMaterial, par3, par4);
	setMaxStackSize(1);
	// this.setCreativeTab(Steampunkery.steampunkeryTab);
	SetArmourType(type.toLowerCase(), par4);
    }

    public String getArmourTexture(final ItemStack stack, final Entity entity,
	    final int slot, final int layer) {
	return texturePath;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IconRegister reg) {
	itemIcon = reg.registerIcon(iconPath);
    }

    // 0 = helm 1 = chest 2= legs 3=boots
    private void SetArmourType(final String type, final int par4) {
	switch (par4) {
	case 0:
	    setUnlocalizedName(type + "Cap");
	    texturePath += type + "_layer_1.png";
	    iconPath += type + "_helmet";
	    break;
	case 1:
	    setUnlocalizedName(type + "Tunic");
	    texturePath += type + "_layer_1.png";
	    iconPath += type + "_chestplate";
	    break;
	case 2:
	    setUnlocalizedName(type + "Leggings");
	    texturePath += type + "_layer_2.png";
	    iconPath += type + "_leggings";
	    break;
	case 3:
	    setUnlocalizedName(type + "Boots");
	    texturePath += type + "_layer_1.png";
	    iconPath += type + "_boots";
	    break;
	}
    }
}
