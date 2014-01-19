package com.warlordjones.steampunkery.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.warlordjones.steampunkery.SteamConstants;

public class SteamUpdateChecker {
    public static boolean isSteamUpdateAvailable() throws IOException,
	    MalformedURLException {
	final BufferedReader versionFile = new BufferedReader(
		new InputStreamReader(
			new URL(SteamConstants.update_location).openStream()));
	final String curVersion = versionFile.readLine();
	versionFile.close(); // YOU DONT NEED THE READER ANYMORE
	if (!curVersion.contains(SteamConstants.version))
	    return true;
	return false;
    }
}
