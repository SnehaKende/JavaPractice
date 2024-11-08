package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.environments;

public class PropertiesUtil {

	//utility class to read properties file
	public static String readProperty(String propertyName, environments env) {
		File propFile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");	
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
	}
}
