package com.example.app.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is for page elements that are common through out pages. E.g. AppBars,
 * etc
 */
public class PageCommon extends Page{

    public PageCommon(WebDriver driver, String url) {
        super(driver, url);
    }

    public void clickImagesLink() {
        final By locator = By.linkText("Images");
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Should not be here. Only here for illustration. Should have a image search page.
    public WebElement getBelowLogoImagesText() {
        final By locator = By.cssSelector(".logo-subtext > span");
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}