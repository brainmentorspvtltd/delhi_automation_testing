package com.tpddl.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstTest {

	public static void main(String[] args) throws MalformedURLException {
		String serverURL = "http://127.0.0.1:4723/wd/hub";
		String apkLocation = "/Users/amit/Documents/tpddl-appium/apk/calc.apk";
		// c:\\apk\\calc.apk
		DesiredCapabilities dc  = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "uiautomator2");
		dc.setCapability(MobileCapabilityType.APP, apkLocation);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(serverURL),dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		AndroidElement bt = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		bt.click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		//driver.findElementById("com.google.android.calculator:id/op_add");
		
	}

}
