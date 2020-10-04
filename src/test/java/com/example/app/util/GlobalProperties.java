package com.example.app.util;

public class GlobalProperties {
    public static String appBaseUrl;

    static {
        appBaseUrl = PropertiesReader.getProperty("app.base.url");
    }
}
