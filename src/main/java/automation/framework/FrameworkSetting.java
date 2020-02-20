package automation.framework;

import java.io.FileInputStream;
import java.util.Properties;

public class FrameworkSetting {
	
	public static String baseDir = System.getProperty("user.dir");
	public static String fileSeparator = System.getProperty("file.separator");
	public static String configFilePath = baseDir + fileSeparator + "config.properties";
			
	public static String browserName = null;
	public static String url = null;
	
	public static String testerName = null;
	
	public static int maxTimeout = 0;
	
	public static Properties prop;
	
	public static void initProperties() {
		
		try {
			
			prop = new Properties();
			prop.load(new FileInputStream(configFilePath));
			browserName = getProperty("browser");
			url = getProperty("url");
			testerName = getProperty("testerName");
			maxTimeout = getPropertyForInt("maxWaitInSeconds");
					
		} catch (Exception FrameowrkInitationException) {
			// Enter log information
		}
		
	}
	
	public static String getProperty(String propertyName) {
		
		String propertyValue = prop.getProperty(propertyName);
		
		return propertyValue.trim();
		
	}
	
	public static int getPropertyForInt(String propertyName) {
		String propertyValue = prop.getProperty(propertyName);
		int maxTime = Integer.parseInt(propertyValue);
		return maxTime;
		
	}
	
}
