package com.tpddl.appiumtesting.test;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;
import com.tpddl.appiumtesting.utils.ExceptionPrinter;
import com.tpddl.appiumtesting.utils.Mail;
import com.tpddl.appiumtesting.utils.ScreenShot;

public class GestureDemo {
	
	Logger logger = Logger.getLogger(GestureDemo.class);

	@Test
	public void longPress() throws IOException { 
		logger.info("Test Started SuccessFully...");
		logger.debug("I am in Test");
		Command.getDriver();
		logger.debug("After Driver Load..");
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
		ScreenShot.takeScreenShot();
		Command.click(Constants.UI_AUTOMATOR, "text(\"Date Widgets\")");
		ScreenShot.takeScreenShot();
		Command.click(Constants.UI_AUTOMATOR, "text(\"2. Inline\")");
		ScreenShot.takeScreenShot();
		Command.swipe();
		ScreenShot.takeScreenShot();
		
		try {
			Mail.sendMail(ScreenShot.getFilePath(), "testmail.appium@gmail.com", "Hello this is a Appium ScreenShot for Testing Purpose...");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ExceptionPrinter.printStackTraceOnLogFile(e, logger);
			//logger.error(e);
		}
		Command.delay();
		Command.close();
		logger.debug("Test Ends");
		logger.info("Test Ended SuccessFully...");
		
	}
	
}
