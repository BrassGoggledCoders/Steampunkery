/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.warlordjones.steampunkery.SteamConstants;

import cpw.mods.fml.common.FMLLog;

public class SteamLog {
    private static Logger logger = Logger.getLogger(SteamConstants.name);

    public static void init() {
	SteamLog.logger.setParent(FMLLog.getLogger());
    }

    public static void log(final Level logLevel, final String message) {
	SteamLog.logger.log(logLevel, message);
    }
}