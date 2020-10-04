package com.example.app.element;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver driver;
    protected String url;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }
    public void navigateTo() {
        driver.get(url);
    }
}
