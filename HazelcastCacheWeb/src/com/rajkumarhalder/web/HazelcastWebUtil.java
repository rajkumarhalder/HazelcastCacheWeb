package com.rajkumarhalder.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HazelcastWebUtil {
	
	public static void setsystemvariableFromPropFile(String propFile) {

		Properties prop=null;
		InputStream inputStream=null;

		try {
			prop=new Properties();
			inputStream=new FileInputStream(propFile);
			prop.load(inputStream);
			
			for (String propertyName : prop.stringPropertyNames()) {
				
				System.setProperty(propertyName, prop.getProperty(propertyName));
				
			}

		}
		catch(Exception exp) {

			exp.printStackTrace();

		}
		finally {
			if(null!=inputStream)
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}

	}

}
