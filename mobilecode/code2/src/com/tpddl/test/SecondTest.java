package com.tpddl.test;

import java.net.MalformedURLException;

import com.tpddl.helpers.Command;
import com.tpddl.utils.Constants;



public class SecondTest {

	public static void main(String[] args) throws MalformedURLException {
		 Command.getDriver();
		
		 
		 // UI Automator Expression "attribute("value")"
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Preference\")");
		// Command.delay();
		 Command.click(Constants.UI_AUTOMATOR, "text(\"3. Preference dependencies\")");
		 
		 Command.click(Constants.ID, "android:id/checkbox");
		 
		 // xpath expression "(//android.widget.RelativeLayout[2])"
		 Command.click(Constants.XPATH,"(//android.widget.RelativeLayout)[2]");
		 
		 Command.typeValue(Constants.ID, "android:id/edit", "amit-wifi");
		 
		 Command.click(Constants.ID, "android:id/button1");
		 
		// Command.delay();
		 Command.close();
	}

}
