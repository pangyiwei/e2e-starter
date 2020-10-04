package com.example.app.util.webdriver;

import lombok.Getter;

public enum WebDriverType {
    CHROMEDRIVER("chromedriver"), HTMLUNIT("htmlunit");

    private WebDriverType(String type) {
        this.type = type;
    }

    @Getter
    private String type;

    public boolean is(WebDriverType type) {
        return this.equals(type);
    }

    public boolean is(String value) {
        return this.type.equalsIgnoreCase(value);
    }
}
