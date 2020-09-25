package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

public class Five {
	
	@Test
	@Ignore
	public void one() throws MalformedURLException {
		Command.getDriver();
		
		 
		 // UI Automator Expression "attribute("value")"
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		 
		 List list = Command.getList(Constants.CLASS, "android.widget.TextView");
		 System.out.println(list.size());
		 Command.delay();
		 Command.close();
	}
	
	@Test
	@Ignore
	public void second() throws MalformedURLException {
		Command.getDriver();
		Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		Command.scroll("TextSwitcher");
		Command.click(Constants.UI_AUTOMATOR, "text(\"TextSwitcher\")");
		
	}

	@Test
	@Ignore
	public void two() throws MalformedURLException {
		Command.getDriver();
		
		 
		 // UI Automator Expression "attribute("value")"
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		 Command.scroll("Rating Bar");
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Rating Bar\")");
		 Command.delay();
		 Command.ratingBar("");
		 Command.close();
	}
	
	@Test
	//@Ignore
	public void three() throws MalformedURLException {
		Command.getDriver();
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Views\")");
		
		Command.click(Constants.UI_AUTOMATOR, "text(\"Date Widgets\")");
		
		Command.click(Constants.UI_AUTOMATOR, "text(\"2. Inline\")");
		
		Command.XpathContentWise("");
		Command.close();
		
		
	}

}
