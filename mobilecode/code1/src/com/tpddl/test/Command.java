package com.tpddl.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Command implements Constants{
	static AndroidDriver<AndroidElement> driver = null;
	public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException{
		String serverURL = PropertyReader.getValue(SERVER_URL_KEY);
		String apkLocation = PropertyReader.getValue(APK_PATH_KEY);
		//String serverURL = "http://127.0.0.1:4723/wd/hub";
		//String apkLocation = "/Users/amit/Documents/tpddl-appium/apk/calc.apk";
		// c:\\apk\\calc.apk
		DesiredCapabilities dc  = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, ANDROID_TEST_FW);
		dc.setCapability(MobileCapabilityType.APP, apkLocation);
		 driver = new AndroidDriver<>(new URL(serverURL),dc);
		 int time = PropertyReader.getIntValue(IMPLICIT_WAIT_TIME);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void click(String type, String expression) {
		AndroidElement element =  null;
		if(type.equalsIgnoreCase(ID)) {
			element = driver.findElement(By.id(expression));
		}
		else
		if(type.equalsIgnoreCase(CLASS)) {
			element = driver.findElement(By.className(expression));
		}
		else
		if(type.equalsIgnoreCase(UI_AUTOMATOR)) {
			element = driver.findElementByAndroidUIAutomator(expression);
		}
		element.click();
	}
	
	public static void delay() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close() {
		if(driver!=null) {
		driver.quit();
		}
	}
	
}
