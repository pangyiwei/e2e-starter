package com.example.app.element;

import java.util.List;

import com.example.app.util.WebDriverHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lombok.Getter;

/**
 * This forms the base of all pages to give them access to the the Web Driver helper.
 */
public class PageBase {
    @Getter
    protected WebDriverHelper helper;

    public PageBase(WebDriverHelper helper) {
        this.helper = helper;
    }

    public WebElement getWebElement(By locator) {
        return this.helper.getWebDriver().findElement(locator);
    }

    public List<WebElement> getWebElements(By locator) {
        return this.helper.getWebDriver().findElements(locator);
    }

    public void visibilityOfElementLocated(By locator) {
        this.helper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void visibilityOfAllElementsLocatedBy(By locator) {
        this.helper.getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void textToBePresentInElementValue(By locator, String value) {
        this.helper.getWebDriverWait().until(ExpectedConditions.textToBePresentInElementValue(locator, value));
    }

    public void elementToBeClickable(By locator) {
        this.helper.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void presenceOfElementLocated(By locator) {
        this.helper.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void presenceOfAllElementsLocatedBy(By locator) {
        this.helper.getWebDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}