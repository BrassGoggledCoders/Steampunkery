package com.warlordjones.steampunkery;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
    static void LanguageRegistrySetup() {
	LanguageRegistry.instance().loadLocalization("assets/steampunkery/lang/en_US.lang", "en_US", false);
}
}