package com.example.app.util.webdriver;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.app.util.PropertiesReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitWebDriverHelper {
    private HtmlUnitWebDriverHelper() {
    }

    private static Boolean proxyEnabled;
    private static String proxyUrl;

    static {
        proxyEnabled = Boolean.parseBoolean(PropertiesReader.getProperty("proxy.enabled"));
        proxyUrl = PropertiesReader.getProperty("proxy.url");

    }

    public static WebDriver getWebDriver() throws URISyntaxException {
        HtmlUnitDriver webDriver = new HtmlUnitDriver(true);
        if (proxyEnabled) {
            URI uri = new URI(proxyUrl);
            webDriver.setAcceptSslCertificates(true);
            webDriver.setProxy(uri.getHost(), uri.getPort());
        }
        return webDriver;
    }
}
