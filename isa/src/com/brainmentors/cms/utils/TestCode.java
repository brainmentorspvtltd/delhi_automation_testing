package com.brainmentors.cms.utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double price = 9000.20;
		Locale locale = new Locale("hi", "IN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		String amount= nf.format(price);
		System.out.println(amount);
		Date date = new Date();
		System.out.println(date);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		String d = df.format(date);
		System.out.println(d);
		
		
		

	}

}
