package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

	public String getProperty(String propertiesFilePath, String property) {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(propertiesFilePath);
			prop.load(input);
			System.out.println(prop.getProperty(property));
			return prop.getProperty(property);
		} catch (FileNotFoundException e) {
			System.out.println("File not found at path : " + propertiesFilePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO exception : " + propertiesFilePath + " while finding property " + property);
			e.printStackTrace();
		}
		return "";
	}
	
	
	
}
