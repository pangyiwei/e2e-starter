package com.example.app.element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.app.util.Properties;
import com.example.app.util.WebDriverHelper;
import com.example.app.util.WebDriverHelperFactory;

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
    public void setUp() {
        helper = WebDriverHelperFactory.getWebDriverHelper();
        helper.setWebDriverWait(5);
        pageCommon = new PageCommon(helper);
        helper.navigateTo(Properties.APP_BASE_URL);
    }

    @AfterAll
    public void complete() {
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