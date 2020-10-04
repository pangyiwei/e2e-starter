package com.example.app.util.webdriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import com.example.app.util.PropertiesReader;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriverHelper {
	private ChromeWebDriverHelper() {
	}

	private static String downloadDirectory;
	private static Boolean browserHeadless;
	private static String webDriverPath;
	private static Boolean proxyEnabled;
	private static String proxyUrl;

	static {
		downloadDirectory = PropertiesReader.getProperty("download.directory");
		browserHeadless = Boolean.parseBoolean(PropertiesReader.getProperty("browser.headless"));
		webDriverPath = PropertiesReader.getProperty("web.driver.path");
		proxyEnabled = Boolean.parseBoolean(PropertiesReader.getProperty("proxy.enabled"));
		proxyUrl = PropertiesReader.getProperty("proxy.url");
	}

	public static WebDriver getWebDriver() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);

		Path downloadFilePath = Paths.get(System.getProperty("user.dir") + "/" + downloadDirectory);
		chromePrefs.put("download.default_directory", downloadFilePath.toString());

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("start-maximized");
		options.setHeadless(browserHeadless);

		Path path = Paths.get(System.getProperty("user.dir") + "/" + webDriverPath);
		System.setProperty("webdriver.chrome.driver", path.toString());

		if (proxyEnabled) {
			Proxy proxy = new Proxy();
			System.out.println("Proxy through " + proxyUrl);
			proxy.setSslProxy(proxyUrl);
			proxy.setHttpProxy(proxyUrl);
			options.setProxy(proxy);
			options.setAcceptInsecureCerts(true);
			options.addArguments("--proxy-bypass-list=<-loopback>");
		}
		System.out.println("Init ChromeDriver complete");
		return new ChromeDriver(options);
	}
}