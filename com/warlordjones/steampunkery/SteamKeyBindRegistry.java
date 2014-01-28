package com.warlordjones.steampunkery;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

public class SteamKeyBindRegistry {
    /** Key index for easy handling */
    public static final int CUSTOM_INV = 0;

    /**
     * Maps Keyboard values to Tutorial KeyBinding index values (e.g. CUSTOM_INV
     * returns KEY_O)
     */
    public static final Map<Integer, Integer> tutKeyMap = new HashMap<Integer, Integer>();

    /** Key descriptions */
    private static final String[] desc = { "[Steampunkery] Custom Player Inventory Key" };

    /** Default key values */
    private static final int[] keyValues = { Keyboard.KEY_O };

    /**
     * This will initialize all key bindings; I like to pass in a Configuration
     * object, but I won't be showing that here. Check the tutorial provided in
     * the prerequisites section for more advanced KeyBinding methods,
     * specifically my posts therein.
     */
    public static void init() {
	final KeyBinding[] key = new KeyBinding[SteamKeyBindRegistry.desc.length];
	final boolean[] repeat = new boolean[SteamKeyBindRegistry.desc.length];

	for (int i = 0; i < SteamKeyBindRegistry.desc.length; ++i) {
	    key[i] = new KeyBinding(SteamKeyBindRegistry.desc[i],
		    SteamKeyBindRegistry.keyValues[i]);
	    repeat[i] = false;
	    SteamKeyBindRegistry.tutKeyMap.put(key[i].keyCode, i);
	}

	KeyBindingRegistry.registerKeyBinding(new SteamKeyHandler(key, repeat));
    }
}