package com.example.app.util;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitWebDriverHelper extends WebDriverHelper {

    @Override
    public void setUp() {
        this.webDriver = new HtmlUnitDriver(true);
    }
    
}