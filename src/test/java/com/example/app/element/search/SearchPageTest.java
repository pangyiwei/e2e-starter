package com.example.app.element.search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.app.util.webdriver.WebDriverFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

@TestInstance(Lifecycle.PER_CLASS)
public class SearchPageTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeAll
    public void setUp() {
        driver = WebDriverFactory.getWebDriver();
        searchPage = new SearchPage(driver);
        searchPage.navigateTo();
    }

    @AfterAll
    public void complete() {
        System.out.println("All SearchPageTests Completed");
    }

    @Test
    public void canPerformSearch() {
        searchPage.getSearchInput().sendKeys("Test");
        searchPage.submitSearchForm();
        String resultStatText = searchPage.getResultStatsText();
        assertTrue(resultStatText.contains("results"));
        System.out.println("canPerformSearch() Completed");
    }
}