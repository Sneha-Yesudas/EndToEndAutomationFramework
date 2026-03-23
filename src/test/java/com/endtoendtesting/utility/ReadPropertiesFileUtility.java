package com.endtoendtesting.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.endtoendtesting.enums.Env;

public class ReadPropertiesFileUtility {

	public static String readProperty(String property,Env environment) {

		File file = new File(System.getProperty("user.dir") + "\\Configuration\\"+environment+".properties");
		FileReader reader;
		Properties properties = null;
		
		
		try {
			 reader = new FileReader(file);
			 properties = new Properties();
			 properties.load(reader);
			 
			

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
         return properties.getProperty(property);
	}

}
