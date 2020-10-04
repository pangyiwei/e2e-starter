package com.example.app.element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.app.util.GlobalProperties;
import com.example.app.util.webdriver.WebDriverFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

@TestInstance(Lifecycle.PER_CLASS)
public class PageCommonTest {
    
    private WebDriver driver;
    private PageCommon pageCommon;

    @BeforeAll
    public void setUp() {
        this.driver = WebDriverFactory.getWebDriver();
        pageCommon = new PageCommon(driver, GlobalProperties.appBaseUrl);
        pageCommon.navigateTo();
    }

    @AfterAll
    public void complete() {
        System.out.println("All PageCommonTests Completed");
    }

    @Test
    public void canNavigateToImagesPage() {
        pageCommon.clickImagesLink();;
        String imageText = pageCommon.getBelowLogoImagesText().getText();
        assertEquals("images", imageText);
        System.out.println("canNavigateToImagesPage() Completed");
    }
}