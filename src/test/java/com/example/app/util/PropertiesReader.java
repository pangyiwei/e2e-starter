package com.example.app.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesReader {

	private static final String DEFAULT_PROPERTY_FILE_NAME = "e2e.properties";

    private PropertiesReader() {}

    private static class PropertiesFromFileHolder {
        private static Properties propertiesFromFile;
        static {
            String configFilename = System.getProperty("config.filename");
            if (configFilename == null) {
                configFilename = DEFAULT_PROPERTY_FILE_NAME;
            }

            String configFile = PropertiesReader.class.getClassLoader().getResource(configFilename).getFile();
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream(configFile));
                propertiesFromFile = properties;
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    public static String getProperty(String key) {
        String property = System.getProperty(key);
        if (property != null) {
            return resolveEnvVars(property);
        }
        property = PropertiesFromFileHolder.propertiesFromFile.getProperty(key);
        return resolveEnvVars(property);
    }

    static String resolveEnvVars(String value) {
		if (null == value) {
			return null;
		}
		Pattern p = Pattern.compile("\\$\\{(\\w+)\\}|\\$(\\w+)");
		Matcher m = p.matcher(value);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String envVarName = null == m.group(1) ? m.group(2) : m.group(1);
			String envVarValue = System.getenv(envVarName);
			m.appendReplacement(sb, null == envVarValue ? "" : Matcher.quoteReplacement(envVarValue));
		}
		m.appendTail(sb);
		return sb.toString();
	}

}
