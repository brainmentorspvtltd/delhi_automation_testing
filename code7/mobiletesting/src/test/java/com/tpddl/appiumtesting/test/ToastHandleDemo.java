package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class ToastHandleDemo {
	
	@Test
	public void testToast() throws MalformedURLException {
		Command.getDriver();
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.scroll("Spinner");
		Command.click(Constants.UI_AUTOMATOR, "text(\"Spinner\")");
		Command.click(Constants.ID, "io.appium.android.apis:id/spinner1");
		Command.click(Constants.UI_AUTOMATOR, "text(\"blue\")");
		String toastText = Command.getText(Command.XPATH, "//android.widget.Toast[1]");
		System.out.println("Toast text "+toastText);
		
		
	}

}
