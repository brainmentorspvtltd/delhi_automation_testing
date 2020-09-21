package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class MultiControls {

	@Test
	public void testControls() throws MalformedURLException {
		Command.getDriver();
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"Controls\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"1. Light Theme\")");
		Command.typeValue(Constants.ID, "io.appium.android.apis:id/edit", "Amit");
		Command.hideKeyboard();
		Command.click(Constants.ID, "io.appium.android.apis:id/check1");
		Command.click(Constants.ID, "io.appium.android.apis:id/radio1");
		Command.click(Constants.ID, "io.appium.android.apis:id/star");
		Command.click(Constants.ID, "io.appium.android.apis:id/toggle1");
		Command.spinner(Constants.ID, "io.appium.android.apis:id/spinner1", Constants.UI_AUTOMATOR, "text(\"Earth\")");
		Command.delay();
		Command.close();
		//Command.click(Constants.ID, "io.appium.android.apis:id/spinner1");
		//Command.click(Constants.UI_AUTOMATOR, "text(\"Earth\")");
		
		
		
		
	}
}
