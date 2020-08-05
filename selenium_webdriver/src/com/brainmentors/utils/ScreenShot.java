package com.brainmentors.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface ScreenShot {
public static void takeScreenShot(WebDriver driver) throws Exception {
	final int EOF = -1;
	TakesScreenshot screenShot = (TakesScreenshot) driver;
	File inputFile = screenShot.getScreenshotAs(OutputType.FILE);
	Date date = new Date();
	String desPath = "/Users/amit/Documents/screenshots/shot"+date.getTime()+".jpg";
	FileInputStream fs = new FileInputStream(inputFile);
	BufferedInputStream bs = new BufferedInputStream(fs);
	FileOutputStream fo = new FileOutputStream(desPath);
	BufferedOutputStream bo = new BufferedOutputStream(fo);
	int singleRead = bs.read();
	while(singleRead!=EOF) {
		bo.write(singleRead);
		 singleRead = bs.read();
	}
	bo.close();
	fo.close();
	bs.close();
	fs.close();
	System.out.println("Screen Shot Saved....");
	String result = MailSender.sendMail(desPath)?"Mail Send It":"Not Send It";
	System.out.println("Result "+result);
	
	
	
}
}
