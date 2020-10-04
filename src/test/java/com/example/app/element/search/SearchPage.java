package com.example.app.element.search;

import com.example.app.element.PageCommon;
import com.example.app.util.GlobalProperties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageCommon {

    public SearchPage(WebDriver driver) {
        super(driver, GlobalProperties.appBaseUrl);
    }

    public WebElement getSearchInput() {
        final By locator = By.name("q");
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void submitSearchForm() {
        final By locator = By.name("f");
        WebElement form =  new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        form.submit();
    }

    public String getResultStatsText() {
        final By locator = By.id("result-stats");
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}