package com.M42.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {

	public static String getValueForKey(String key) throws Throwable {
		Properties conpro = new Properties();
		//load file
		conpro.load(new FileInputStream("C:\\Users\\Bandi.Ujjinesh\\M42_Dev\\Mubadula_M42\\propertyfile\\file.property"));
		return conpro.getProperty(key);
		}
}
