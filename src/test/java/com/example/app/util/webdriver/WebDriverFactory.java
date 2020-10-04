package com.example.app.util.webdriver;

import java.net.URISyntaxException;

import com.example.app.util.PropertiesReader;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private WebDriverFactory() {
    }

    private static class WebDriverHolder {
        private static WebDriver webDriver;
        static {
            String webDriverType = PropertiesReader.getProperty("web.driver.type");
            if (WebDriverType.CHROMEDRIVER.is(webDriverType)) {
                webDriver = ChromeWebDriverHelper.getWebDriver();
            } else if (WebDriverType.HTMLUNIT.is(webDriverType)) {
                try {
                    webDriver = HtmlUnitWebDriverHelper.getWebDriver();
                } catch (URISyntaxException e) {
                    throw new Error(e);
                }
            }
            Runtime.getRuntime().addShutdownHook(new Thread(() -> webDriver.quit()));
        }
    }

    public static WebDriver getWebDriver() {
        return WebDriverHolder.webDriver;
    }
}