package com.tpddl.test;

import java.net.MalformedURLException;



public class SecondTest {

	public static void main(String[] args) throws MalformedURLException {
		 Command.getDriver();
		
		 
		 // UI Automator Expression "attribute("value")"
		 Command.click(Constants.UI_AUTOMATOR, "text(\"Preference\")");
		 Command.delay();
		 Command.click(Constants.UI_AUTOMATOR, "text(\"3. Preference dependencies\")");
		 
		 Command.delay();
		 Command.close();
	}

}
