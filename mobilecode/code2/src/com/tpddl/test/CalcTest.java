package com.tpddl.test;

import static com.tpddl.helpers.Command.*;

import java.net.MalformedURLException;

import com.tpddl.utils.Constants;
public class CalcTest {

	public static void main(String[] args) throws MalformedURLException {
			getDriver();
		 click(Constants.ID, "com.google.android.calculator:id/digit_9");
		 click(Constants.ID, "com.google.android.calculator:id/digit_7");
		 click(Constants.ID, "com.google.android.calculator:id/op_add");
		 click(Constants.ID, "com.google.android.calculator:id/digit_1");
		 click(Constants.ID, "com.google.android.calculator:id/digit_2");
		 delay();
		 close();
		 

	}

}
