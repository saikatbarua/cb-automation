package automation.framework;

import java.io.FileInputStream;
import java.util.Properties;

public class FrameworkSetting {
	
	public static String baseDir = System.getProperty("user.dir");
	public static String fileSeparator = System.getProperty("file.separator");
	public static String configFilePath = baseDir + fileSeparator + "config.properties";
			
	public static String browserName = null;
	public static String url = null;
<<<<<<< HEAD

	public static int maxTimeout;
=======
	
	public static String testerName = null;
	
	public static int maxTimeout = 0;
	
>>>>>>> meherbranch1
	public static Properties prop;
	
	public static void initProperties() {
		
		try {
			
			prop = new Properties();
			prop.load(new FileInputStream(configFilePath));
			browserName = getProperty("browser");
			url = getProperty("url");
<<<<<<< HEAD
			maxTimeout = Integer.parseInt(getProperty("maxWaitInSeconds").trim()); //Converts String "60" to integer 60
=======
			testerName = getProperty("testerName");
			maxTimeout = getPropertyForInt("maxWaitInSeconds");
>>>>>>> meherbranch1
					
		} catch (Exception FrameowrkInitationException) {
			// Enter log information
		}
		
	}
	
	public static String getProperty(String propertyName) {
		
		String propertyValue = prop.getProperty(propertyName);
		
		return propertyValue.trim();
		
	}
	
<<<<<<< HEAD
=======
	public static int getPropertyForInt(String propertyName) {
		String propertyValue = prop.getProperty(propertyName);
		int maxTime = Integer.parseInt(propertyValue);
		return maxTime;
		
	}
	
>>>>>>> meherbranch1
}
