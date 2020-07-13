package com.example.app.element.search;

import com.example.app.element.PageCommon;
import com.example.app.util.WebDriverHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageCommon {

    public SearchPage(WebDriverHelper helper) {
        super(helper, "Search Page");
    }

    public WebElement getSearchInput() {
        final By locator = By.name("q");
        visibilityOfElementLocated(locator);
        return getWebElement(locator);
    }

    public WebElement getSearchForm() {
        final By locator = By.name("f");
        visibilityOfElementLocated(locator);
        return getWebElement(locator);
    }

    public WebElement getResultStatsText() {
        final By locator = By.id("result-stats");
        visibilityOfElementLocated(locator);
        return getWebElement(locator);
    }
}