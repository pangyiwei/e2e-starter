package com.example.app.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AppUrlBuilder {
    private String url;
	
	public AppUrlBuilder() throws FileNotFoundException, IOException {
		this.url = PropertiesReader.getProperty("app.base.url", "http://localhost:8080");
	}
	
	public AppUrlBuilder addPath(String path) {
		url = url + "/" + path;
		return this;
	}
	
	public String build() {
		return url;
	}
}