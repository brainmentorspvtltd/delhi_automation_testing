package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class DateTimeHandle {
	
	@Test
	public void testDateTime() throws MalformedURLException {
		Command.getDriver();
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"Date Widgets\")");
		Command.click(Constants.UI_AUTOMATOR, "text(\"1. Dialog\")");
		//Command.calendar(Constants.ID, "io.appium.android.apis:id/pickDate", 3, "25 December 2020", Constants.ID, "android:id/prev", "android:id/next", Constants.ID, "android:id/button1");
		//Command.clockControl(Command.ID, "io.appium.android.apis:id/pickTime", Command.ID, "android:id/hours", "6", "15", Command.ID, "android:id/button1");
		Command.spinnerClock(Command.ID, "io.appium.android.apis:id/pickTimeSpinner",Command.XPATH,"//android.widget.NumberPicker",0,Command.XPATH,"//android.widget.Button",5);
		//Command.click(Command.ID, "io.appium.android.apis:id/pickTimeSpinner");
		
		Command.delay();
		//Command.close();
		
		
	}

}
