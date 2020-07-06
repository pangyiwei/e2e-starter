package com.example.app.element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.app.util.AppUrlBuilder;
import com.example.app.util.ChromeWebDriverHelper;
import com.example.app.util.WebDriverHelper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PageCommonTest {
    
    private WebDriverHelper helper;
    private PageCommon pageCommon;

    @BeforeAll
    public void setUp() throws FileNotFoundException, IOException {
        String baseUrl = new AppUrlBuilder().build();
        helper = new ChromeWebDriverHelper();
        helper.setUp();
        helper.setWebDriverWait(5);
        pageCommon = new PageCommon(helper);
        helper.navigateTo(baseUrl);
    }

    @AfterAll
    public void tearDown() {
        helper.tearDown();
        System.out.println("All PageCommonTests Completed");
    }

    @Test
    public void canNavigateToImagesPage() {
        pageCommon.getImagesLink().click();
        String imageText = pageCommon.getBelowLogoImagesText().getText();
        assertEquals("images", imageText);
        System.out.println("canNavigateToImagesPage() Completed");
    }
}