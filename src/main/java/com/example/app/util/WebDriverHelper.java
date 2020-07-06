package com.example.app.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;

public abstract class WebDriverHelper {
	@Getter
	protected WebDriver webDriver;

	@Getter
	protected WebDriverWait webDriverWait;

	public abstract void setUp();

	public void tearDown() {
		this.webDriver.close();
		this.webDriver.quit();
	}

	public void setWebDriverWait(long timeOutInSeconds) {
		this.webDriverWait = new WebDriverWait(this.webDriver, timeOutInSeconds);
	}

	public void maximizeWindow() {
		this.webDriver.manage().window().maximize();
	}

	public void navigateTo(String url) {
		this.webDriver.navigate().to(url);
	}
}
