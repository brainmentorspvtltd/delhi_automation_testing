package com.brainmentors.keyworddriven.keyworddriven.utils;

public interface Validation {
	public static boolean  isEmpty(String str) {
		if(str==null) {
			return true;
		}
		if(str.trim().length()==0) {
			return true;
		}
		return false;
	}

}
