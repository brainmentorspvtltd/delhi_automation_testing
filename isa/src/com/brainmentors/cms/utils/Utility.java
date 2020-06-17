package com.brainmentors.cms.utils;

public final class Utility {
	private Utility(){
		
	}
	public static String initCap(String str){
		if(str.length()==1) {
			return str.toUpperCase();
		}
		
		char firstChar = str.charAt(0);
		return String.valueOf(firstChar).toUpperCase() + str.substring(1).toLowerCase();
	}
	public static String titleCase(String str) {
		String sentence = "";
		String words [] = str.split(" ");
		for(String word : words) {
			String result = initCap(word);
			sentence = sentence + result + " ";
					
		}
		return sentence.trim();
		
	}
}
