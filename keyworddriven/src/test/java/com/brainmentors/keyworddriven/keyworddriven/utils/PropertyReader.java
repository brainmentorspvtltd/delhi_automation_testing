package com.brainmentors.keyworddriven.keyworddriven.utils;

import java.util.ResourceBundle;

public interface PropertyReader {
ResourceBundle rb = ResourceBundle.getBundle(Constants.CONFIG);
public static String getValue(String key) {
	return rb.getString(key);
}
}
