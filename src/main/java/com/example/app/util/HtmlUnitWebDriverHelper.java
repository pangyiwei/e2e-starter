package com.example.app.util;

import java.net.URI;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitWebDriverHelper extends WebDriverHelper {

    @Override
    public void setUp() {
        try {
            HtmlUnitDriver webDriver = new HtmlUnitDriver(true);
			if (Properties.PROXY_ENABLED) {
			    String proxyUrl = Properties.PROXY_URL;
			    URI uri = new URI(proxyUrl);
                webDriver.setAcceptSslCertificates(true);
                webDriver.setProxy(uri.getHost(), uri.getPort());
			}
            this.webDriver = webDriver;
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}