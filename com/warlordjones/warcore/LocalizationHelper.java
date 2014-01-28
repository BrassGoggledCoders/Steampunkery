package com.warlordjones.warcore;

public class LocalizationHelper {
public static boolean isXMLLanguageFile(String fileName)
{
    return fileName.endsWith(".xml");
}
public static String getLocaleFromFileName(String fileName)
{
    return fileName.substring(fileName.indexOf("/")+1, fileName.lastIndexOf("."));
}
}
