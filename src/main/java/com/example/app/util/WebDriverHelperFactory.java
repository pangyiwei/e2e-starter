package com.example.app.util;

public class WebDriverHelperFactory {
    private WebDriverHelperFactory() {}

    private static class WebDriverHelperFactoryHolder {
        private static WebDriverHelper webDriverHelper;
        static {
            if (Properties.WEB_DRIVER_TYPE.equalsIgnoreCase(WebDriverTypes.CHROME_DRIVER)) {
                webDriverHelper = new ChromeWebDriverHelper();
            } else if (Properties.WEB_DRIVER_TYPE.equalsIgnoreCase(WebDriverTypes.HTML_UNIT)) {
                webDriverHelper =  new HtmlUnitWebDriverHelper();
            }
            webDriverHelper.setUp();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> webDriverHelper.tearDown()));
        }
    }
    public static WebDriverHelper getWebDriverHelper() {
        return WebDriverHelperFactoryHolder.webDriverHelper;
    }
}