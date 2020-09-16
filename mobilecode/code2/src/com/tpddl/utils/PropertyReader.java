package com.tpddl.utils;

import java.util.ResourceBundle;

public class PropertyReader {
	
	static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	public static String getValue(String key) {
		return rb.getString(key);
	}
	public static int getIntValue(String key) {
		return Integer.parseInt(rb.getString(key));
	}

}
