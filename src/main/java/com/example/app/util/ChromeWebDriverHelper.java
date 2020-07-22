package com.example.app.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriverHelper extends WebDriverHelper {
	@Override
	public void setUp() {
		try {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);

			Path downloadFilePath = Paths.get(System.getProperty("user.dir") + "/"
					+ Properties.DOWNLOAD_DIRECTORY);
			chromePrefs.put("download.default_directory", downloadFilePath.toString());

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("start-maximized");

			Boolean headless = Properties.BROWSER_HEADLESS;
			options.setHeadless(headless);

			Path webDriverPath = Paths.get(System.getProperty("user.dir") + "/"
                    + Properties.WEB_DRIVER_PATH);
            System.setProperty("webdriver.chrome.driver", webDriverPath.toString());

			if (Properties.PROXY_ENABLED) {
				Proxy proxy = new Proxy();
				String proxyUrl = Properties.PROXY_URL;
				System.out.println("Proxy through " + proxyUrl);
				proxy.setSslProxy(proxyUrl);
				proxy.setHttpProxy(proxyUrl);
				options.setProxy(proxy);
				options.setAcceptInsecureCerts(true);
				options.addArguments("--proxy-bypass-list=<-loopback>");
			}
			this.webDriver = new ChromeDriver(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}