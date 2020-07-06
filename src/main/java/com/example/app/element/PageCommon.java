package com.example.app.element;

import com.example.app.util.WebDriverHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lombok.Getter;

/**
 * This is for page elements that are common through out pages. E.g. AppBars,
 * etc
 */
public class PageCommon extends PageBase {
    
    @Getter
    protected String pageName;

    public PageCommon(WebDriverHelper helper) {
        super(helper);
    }

    public PageCommon(WebDriverHelper helper, String pageName) {
        super(helper);
        this.pageName = pageName;
    }

    public WebElement getImagesLink() {
        final By locator = By.linkText("Images");
        visibilityOfElementLocated(locator);
        return getWebElement(locator);
    }

    // Should not be here. Only here for illustration. Should have a image search page.
    public WebElement getBelowLogoImagesText() {
        final By locator = By.cssSelector(".logo-subtext > span");
        visibilityOfElementLocated(locator);
        return getWebElement(locator);
    }
}