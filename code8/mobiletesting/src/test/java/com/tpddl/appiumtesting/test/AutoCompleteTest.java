package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class AutoCompleteTest {
	@Test
	public void autoComplete() throws MalformedURLException {
		Command.getDriver();
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"Auto Complete\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"1. Screen Top\")");
		Command.autoComplete(Constants.ID, "io.appium.android.apis:id/edit", "in", 60,400);
		Command.delay();
		Command.close();
		
		
	}

}
