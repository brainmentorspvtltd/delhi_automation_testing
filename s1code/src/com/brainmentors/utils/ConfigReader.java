package com.brainmentors.utils;

import java.util.ResourceBundle;

public interface ConfigReader {
	 static ResourceBundle rb= ResourceBundle.getBundle("config");
	 static String getValue(String key){
		return rb.getString(key);
	 }
}
