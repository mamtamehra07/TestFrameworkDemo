package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	public static Properties getProperties() throws Exception {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\hp\\eclipse-workspace\\qa-web\\src\\test\\resources\\config\\config.properties");
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;

	}

	public static String getURL() throws Exception {
		return getProperties().getProperty("url");
	}
	
	public static String getBrowser() throws Exception {
		return getProperties().getProperty("browser");
	}
	
	public static String getUserName() throws Exception {
		return getProperties().getProperty("username");
	}
	
	public static String getPassword() throws Exception {
		return getProperties().getProperty("password");
	}
	

}
