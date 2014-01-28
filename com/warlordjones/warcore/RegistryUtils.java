package com.warlordjones.warcore;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RegistryUtils {
    public static void addBlock(final Block id, final String name) {
	GameRegistry.registerBlock(id, name);
	// LanguageRegistry.addName(id, name);
	if (id.getUnlocalizedName() == null)
	    id.setUnlocalizedName("broken");

    }

    public static void addBlocks() {

    }

    public static void addItem(final Item id, final String name) {
	GameRegistry.registerItem(id, name);
	LanguageRegistry.addName(id, name);
	if (id.getUnlocalizedName() == null)
	    id.setUnlocalizedName("broken");
    }

    public static void addMetaBlocks(final Block id, final Class item) {
	GameRegistry.registerBlock(id, item, "steampunkery:"
		+ id.getUnlocalizedName().substring(5));
    }
}
