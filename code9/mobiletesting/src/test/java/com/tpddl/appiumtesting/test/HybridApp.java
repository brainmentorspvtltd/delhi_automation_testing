package com.tpddl.appiumtesting.test;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
public class HybridApp {

	public static void main(String[] args) throws MalformedURLException {
		 AndroidDriver<AndroidElement> driver= Command.getDriver();
		Set<String> contextNames = driver.getContextHandles();
		for(String c : contextNames) {
			System.out.println(c);
		}
		Command.typeValue(Constants.ID, "com.androidsample.generalstore:id/nameField", "ram");
		Command.click(Constants.ID, "com.androidsample.generalstore:id/btnLetsShop");
		Command.click(Constants.UI_AUTOMATOR, "text(\"ADD TO CART\")",0);
		Command.click(Constants.ID, "com.androidsample.generalstore:id/appbar_btn_cart");
		Command.click(Constants.ID, "com.androidsample.generalstore:id/btnProceed");
		Command.delay();
		System.out.println("Again Context ");
		 contextNames = driver.getContextHandles();
		 String lastName = "";
		 int count =0;
		for(String c : contextNames) {
			count++;
			if(count==2) {
			lastName = c;
			}
			
			//System.out.println(lastName);
		}
		System.out.println("LAST NAME IS "+lastName);
		//driver.context(lastName);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("BMW CARS");

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		

		driver.context("NATIVE_APP");
		
	}

}
