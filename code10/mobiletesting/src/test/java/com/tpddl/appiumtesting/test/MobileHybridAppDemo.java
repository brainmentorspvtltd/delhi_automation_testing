package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileHybridAppDemo {
	
	@Test
	public void testHybrid() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver= Command.getDriver();
		Set<String> contextNames = driver.getContextHandles();
		System.out.println("First Time Context Switcher....");
		for(String contextName: contextNames) {
			System.out.println(contextName);
		}
		Command.typeValue(Constants.ID, "com.androidsample.generalstore:id/nameField", "Amit");
		Command.click(Constants.ID, "com.androidsample.generalstore:id/btnLetsShop");
		Command.click(Constants.UI_AUTOMATOR, "text(\"ADD TO CART\")",0);
		Command.click(Constants.ID, "com.androidsample.generalstore:id/appbar_btn_cart");
		Command.click(Constants.ID, "com.androidsample.generalstore:id/btnProceed");
		Command.delay();
		System.out.println("Now Context Switcher Again....");
		contextNames = driver.getContextHandles();
		int counter = 1;
		String hybridApp = "";
		for(String contextName: contextNames) {
			if(counter == 2) {
				hybridApp = contextName;
			}
			counter++;
			System.out.println(contextName);
		}
		driver.context(hybridApp);
		driver.findElement(By.name("q")).sendKeys("BMW CARS");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
	}

}
