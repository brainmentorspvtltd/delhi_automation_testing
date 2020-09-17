package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class PreferenceTest {
	
	@Test
	public void testPref() throws MalformedURLException {
		Command.getDriver();
		
		 
		 // UI Automator Expression "attribute("value")"
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Preference\")");
		// Command.delay();
		 Command.click(Constants.UI_AUTOMATOR, "text(\"3. Preference dependencies\")");
		 
		 Command.click(Constants.ID, "android:id/checkbox");
		 String text = Command.getText(Constants.UI_AUTOMATOR, "text(\"WiFi settings\")");
		 System.out.println("TEXT IS :: "+text);
		 // xpath expression "(//android.widget.RelativeLayout[2])"
		 Command.click(Constants.XPATH,"(//android.widget.RelativeLayout)[2]");
		 
		 Command.typeValue(Constants.ID, "android:id/edit", "amit-wifi");
		 
		 Command.click(Constants.ID, "android:id/button1");
		 
		 
		 Assert.assertTrue(text.contains("WiFi"));
		 
		// Command.delay();
		 Command.close();
	}
	
	@Test
	public void secondTest() throws MalformedURLException {
		Command.getDriver();
		
		 
		 // UI Automator Expression "attribute("value")"
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Preference\")");
		// Command.delay();
		 Command.click(Constants.UI_AUTOMATOR, "text(\"3. Preference dependencies\")");
		 
		 Command.click(Constants.ID, "android:id/checkbox");
		 String text = Command.getText(Constants.UI_AUTOMATOR, "text(\"WiFi settings\")");
		 System.out.println("TEXT IS :: "+text);
		 // xpath expression "(//android.widget.RelativeLayout[2])"
		 Command.click(Constants.XPATH,"(//android.widget.RelativeLayout)[2]");
		 
		 Command.typeValue(Constants.ID, "android:id/edit", "amit-wifi");
		 
		 Command.click(Constants.ID, "android:id/button1");
		 
		 
		 Assert.assertTrue(text.contains("ABCD"));
		 
		// Command.delay();
		 Command.close();
	}

}
