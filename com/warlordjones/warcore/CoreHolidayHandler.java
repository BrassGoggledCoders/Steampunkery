package com.warlordjones.warcore;

import java.util.Calendar;
import java.util.Date;

import cpw.mods.fml.common.FMLLog;

public class CoreHolidayHandler {
    public static boolean isChristmas;
    public static boolean isChristmasDay;

    // public static boolean = false;
    public static void handleHolidays() {
	final Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
	if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
	    FMLLog.info("Happy birthday, ez!");
	} else if (calendar.get(2) + 1 == 9 && calendar.get(5) == 19)
	    FMLLog.info("Happy Birthday warlordjones!");
	else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
	    FMLLog.info("Happy birthday, Notch!");
	} else if (calendar.get(2) + 1 == 10) // && calendar.get(5) == 31)
	{
	    FMLLog.info("OOoooOOOoooo! Spooky!");
	} else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 4)
	    throw new NullPointerException("TROLL!");
	else if (calendar.get(2) + 1 == 12) // && calendar.get(5) == 24)
	{
	    FMLLog.info("Merry X-mas!");
	} else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 25)
	    ;// FMLLog.info("Merry X-mas!");
	     // final boolean isChristmasDay = true;
	     // else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
	     // FMLLog.info("Happy new year!");
	     // final boolean isNewYear = true;
	     // }

    }
}
