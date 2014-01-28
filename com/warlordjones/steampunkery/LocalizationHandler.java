package com.warlordjones.steampunkery;

import com.warlordjones.steampunkery.blocks.SteamBlocks;
import com.warlordjones.steampunkery.items.SteamItems;
import com.warlordjones.warcore.LocalizationHelper;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemStack;

import buildcraft.core.utils.Localization;

public class LocalizationHandler {
    static void LanguageRegistrySetup() {
	LanguageRegistry.instance().loadLocalization("assets/steampunkery/lang/en_US.lang", "en_US", false);
}
}