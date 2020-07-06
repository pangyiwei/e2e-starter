package com.example.app.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesReader {

	private static final String ACTIVE_PROFILES_KEY = "e2e.profiles.active";
	private static final String FILE_SUFFIX = ".properties";
	private static final String FILE_PREFIX = "e2e";
	
	public static String getProperty(String property, String fallbackValue) throws FileNotFoundException, IOException {
		String value = getPropertyFromJVMArgs(property);
		if (value != null) {
			return value;
		}
		value = getPropertyFromFile(property);
		if (value != null) {
			return value;
		}
		return fallbackValue;
	}
	
	public static Boolean getProperty(String property, Boolean fallbackValue) throws FileNotFoundException, IOException {
		String result = getProperty(property, fallbackValue.toString());
		return Boolean.parseBoolean(result);
	}
	
	public static Integer getProperty(String property, Integer fallbackValue) throws FileNotFoundException, IOException {
		String result = getProperty(property, fallbackValue.toString());
		return Integer.valueOf(result);
	}
	
	static List<String> getActivePropertyFilenames() throws FileNotFoundException, IOException {
		List<String> filenames = new ArrayList<String>();
		filenames.add(FILE_PREFIX + FILE_SUFFIX);
		String mainPropertyFilename = PropertiesReader.class.getClassLoader().getResource(filenames.get(0)).getFile();
		
		Properties appProps = new Properties();
		appProps.load(new FileInputStream(mainPropertyFilename));
		String activeProfiles = appProps.getProperty(ACTIVE_PROFILES_KEY);
		List<String> preprocessed = Arrays.asList(activeProfiles.split(","));
		
		for (String profileKey : preprocessed) {
			filenames.add(FILE_PREFIX + "-" + profileKey.trim().toLowerCase() + FILE_SUFFIX);
		}
		return filenames;
	}

	static String getPropertyFromFile(String property) throws FileNotFoundException, IOException {
		List<String> activeFilenames = getActivePropertyFilenames();
		
		for (String activeFilename : activeFilenames) {
			String filename = PropertiesReader.class.getClassLoader().getResource(activeFilename).getFile();
			Properties appProps = new Properties();
			appProps.load(new FileInputStream(filename));
			
			if (appProps.getProperty(property) != null) {
				return appProps.getProperty(property);
			}
		}
		return null;
	}
	
	static String getPropertyFromJVMArgs(String property) {
		return System.getProperty(property);
	}

}
