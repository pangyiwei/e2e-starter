package com.example.app.element.search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.app.util.AppUrlBuilder;
import com.example.app.util.WebDriverHelper;
import com.example.app.util.WebDriverHelperFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SearchPageTest {

    private WebDriverHelper helper;
    private SearchPage searchPage;

    @BeforeAll
    public void setUp() throws FileNotFoundException, IOException {
        String baseUrl = new AppUrlBuilder().build();
        helper = WebDriverHelperFactory.getWebDriverHelper();
        helper.setUp();
        helper.setWebDriverWait(5);
        searchPage = new SearchPage(helper);
        helper.navigateTo(baseUrl);
    }

    @AfterAll
    public void tearDown() {
        helper.tearDown();
        System.out.println("All SearchPageTests Completed");
    }

    @Test
    public void canPerformSearch() {
        searchPage.getSearchInput().sendKeys("Test");
        searchPage.getSearchForm().submit();
        String resultStatText = searchPage.getResultStatsText().getText();
        assertTrue(resultStatText.contains("results"));
        System.out.println("canPerformSearch() Completed");
    }
}