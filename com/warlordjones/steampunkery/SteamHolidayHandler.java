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
