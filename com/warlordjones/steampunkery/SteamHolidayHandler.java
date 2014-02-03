/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery;

import com.warlordjones.warcore.CoreHolidayHandler;

public class SteamHolidayHandler extends CoreHolidayHandler {
    public static boolean giveCoal;

    public static void handleChristmas() {
    }

    public static void handleChristmasDay() {
	SteamHolidayHandler.giveCoal = true;
    }

    public static void handleSteamyHolidays() {
	if (CoreHolidayHandler.isChristmas) {
	    SteamHolidayHandler.handleChristmas();
	    if (CoreHolidayHandler.isChristmasDay)
		SteamHolidayHandler.handleChristmasDay();
	}
    }
}
