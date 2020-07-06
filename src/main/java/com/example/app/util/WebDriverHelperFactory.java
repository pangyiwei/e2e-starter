package com.example.app.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WebDriverHelperFactory {
    public static WebDriverHelper getWebDriverHelper() throws FileNotFoundException, IOException {
        String webDriverType = PropertiesReader.getProperty("web.driver.type", "chromedriver");
        if (webDriverType.equalsIgnoreCase(WebDriverTypes.CHROME_DRIVER)) {
            return new ChromeWebDriverHelper();
        } else if (webDriverType.equalsIgnoreCase(WebDriverTypes.HTML_UNIT)) {
            return new HtmlUnitWebDriverHelper();
        }
        return null;
    }
}