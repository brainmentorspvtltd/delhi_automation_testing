package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class GestureDemo {

	@Test
	public void longPress() throws MalformedURLException {
		Command.getDriver();
		// Long Press 
		/*
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"Expandable Lists\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"1. Custom Adapter\")");
		Command.longPress(Command.XPATH, "//android.widget.TextView[@text='People Names']");
		String text = Command.getText(Command.XPATH,  "//android.widget.TextView[@text='Sample menu']");
		System.out.println("Text of Popup Is "+text);
		*/
		// Swipe Code
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"Date Widgets\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"2. Inline\")");
		Command.swipe();
		Command.delay();
		Command.close();
		
	}
	
}
