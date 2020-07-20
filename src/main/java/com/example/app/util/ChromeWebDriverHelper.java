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
					+ PropertiesReader.getProperty("download.directory", "src/main/resources/downloads"));
			chromePrefs.put("download.default_directory", downloadFilePath.toString());

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("start-maximized");

			Boolean headless = PropertiesReader.getProperty("browser.headless", false);
			options.setHeadless(headless);

			Path webDriverPath = Paths.get(System.getProperty("user.dir") + "/"
                    + PropertiesReader.getProperty("web.driver.path", "src/main/resources/drivers/chromedriver.exe"));
            System.setProperty("webdriver.chrome.driver", webDriverPath.toString());

			if (PropertiesReader.getProperty("proxy.enabled", false)) {
				Proxy proxy = new Proxy();
				String proxyUrl = PropertiesReader.getProperty("proxy.url", "http://localhost:8081");
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