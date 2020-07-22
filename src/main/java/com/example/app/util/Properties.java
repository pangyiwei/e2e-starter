package com.example.app.util;

public class Properties {
    public static String APP_BASE_URL;
    public static Boolean PROXY_ENABLED;
    public static String PROXY_URL;
    public static String WEB_DRIVER_TYPE;
    public static String WEB_DRIVER_PATH;
    public static String DOWNLOAD_DIRECTORY;
    public static Boolean BROWSER_HEADLESS;

    static {
        try {
            APP_BASE_URL = PropertiesReader.getProperty("app.base.url", "http://localhost:8080");
            PROXY_ENABLED = PropertiesReader.getProperty("proxy.enabled", false);
            PROXY_URL = PropertiesReader.getProperty("proxy.url", "http://127.0.0.1:8081");
            WEB_DRIVER_TYPE = PropertiesReader.getProperty("web.driver.type", WebDriverTypes.CHROME_DRIVER);
            WEB_DRIVER_PATH = PropertiesReader.getProperty("web.driver.path", "src/main/resources/drivers/chromedriver.exe");
            DOWNLOAD_DIRECTORY = PropertiesReader.getProperty("download.directory", "src/main/resources/downloads");
            BROWSER_HEADLESS = PropertiesReader.getProperty("browser.headless", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}