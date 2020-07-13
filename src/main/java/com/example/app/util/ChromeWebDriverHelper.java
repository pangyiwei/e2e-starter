package com.example.app.util;

import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeWebDriverHelper extends WebDriverHelper {
	@Override
	public void setUp() {
		try {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory",
					PropertiesReader.getProperty("download.directory", "src/main/resources/downloads"));

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("start-maximized");
			if (PropertiesReader.getProperty("browser.headless", false))
				options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver",
					PropertiesReader.getProperty("web.driver.path", "src/main/resources/drivers/chromedriver.exe"));

			if (PropertiesReader.getProperty("proxy.enabled", false)) {
				Proxy proxy = new Proxy();
				String proxyUrl = PropertiesReader.getProperty("proxy.url", "http://localhost:8081");
				System.out.println("Proxy through " + proxyUrl);
				proxy.setSslProxy(proxyUrl);
				proxy.setHttpProxy(proxyUrl);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.PROXY, proxy);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.addArguments("--proxy-bypass-list=<-loopback>");
				options.merge(capabilities);
			}
			this.webDriver = new ChromeDriver(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}