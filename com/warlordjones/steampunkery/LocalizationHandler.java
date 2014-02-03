/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
    static void LanguageRegistrySetup() {
	LanguageRegistry.instance().loadLocalization(
		"assets/steampunkery/lang/en_US.lang", "en_US", false);
    }
}