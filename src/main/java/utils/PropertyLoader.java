package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	private static final String FRAMEWORK_PROP_FILE = "/framework_settings/settings.properties";
	
	public static String loadFrameworkProperty(String id) {
		
		Properties props = new Properties();
		
		try {
			props.load(PropertyLoader.class.getResourceAsStream(FRAMEWORK_PROP_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Cannot read framework settings file - settings.properties");
		}

		String value = new String();

		if (id != null) {
			value = props.getProperty(id);
		}
		
		return value;

	}
	
	public static String loadMessagesProperty(String id, String language) {

		Properties props = new Properties();

		try {
			if(!language.equals("en")){
				props.load(PropertyLoader.class.getResourceAsStream("/" + language.toUpperCase() + "_" + loadFrameworkProperty("application.messages.file")));
			} else {
				props.load(PropertyLoader.class.getResourceAsStream("/" + loadFrameworkProperty("application.messages.file")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (id != null) {
			value = props.getProperty(id);
		}

		return value;

	}
	
}
