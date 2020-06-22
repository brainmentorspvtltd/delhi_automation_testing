package com.brainmentors.cms.utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "Amit";
		String b = "Amit";
		
		String c = new String("Amit");
		System.out.println(a==c);
		System.out.println(a.equals(c));
		ArrayList<String> songs = new ArrayList<>(2);
		songs.add("It's My Life");
		songs.add("Bang Bang");
		songs.add("It's My Life");
		songs.add("Bang Bang");
		System.out.println(songs);
		songs.remove("Bang Bang");
		System.out.println(songs);
		/*
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Day");
		int day = s.nextInt(); // 1-31
		System.out.println("Enter the Month");
		int month = s.nextInt();
		System.out.println("Enter the Year");
		int year = s.nextInt();
		//Date d = new Date(year, month, day);
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, day);
		Date d1 = c.getTime();
		System.out.println("Date is "+d1);
		
		double price = 9000.20;
		Locale locale = new Locale("hi", "IN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		String amount= nf.format(price);
		System.out.println(amount);
		//Date date = new Date();
		//System.out.println(date);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		String d = df.format(d1);
		System.out.println(d);
		*/
		
		

	}

}
