package com.tpddl.appiumtesting.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.utils.Constants;

import io.appium.java_client.android.AndroidElement;

public class CarPoolAppTest {
	
	@Test
	public void loginFlow() throws MalformedURLException {
		Command.getDriver();
		Command.click(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/signInBtn");
		Command.typeValue(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/loginUserName", "abhishek.bhatt");
		Command.typeValue(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/loginpassword", "Sep@2020");
		Command.click(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/btnLogin");
		//Command.click(Constants.UI_AUTOMATOR, "text(\"Cancel Pool (Owner)\")");
		//Command.clickByIndex(Constants.UI_AUTOMATOR, "text(\"CANCEL\")",0);
		Command.back();
		Command.back();
		Command.click(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/btnFindARide");
		AndroidElement ele =Command.getElement(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/poolList");
		Command.nestedElementClick(Command.XPATH, "//android.widget.RelativeLayout[1]", ele);
		//		Command.back();
//		Command.back();
		Command.delay();
		//Command.back();
//		Command.click(Constants.ID, "com.example.sandeeppathak.carpoolnew:id/btnOfferARide");
//		Command.getXpathContentWise("OFFICE-OFFICE").click();
		//Command.delay();
		//Command.close();
	}

}
