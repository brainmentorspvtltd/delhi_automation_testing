package com.tpddl.appiumtesting.utils;

import org.apache.poi.ss.formula.functions.T;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class AssertReport<T> implements IAssert<T> {
	private SoftAssert softAssert;
	private String caseName;
	private T actual;
	private T expected;
	public AssertReport(String caseName, T actual , T expected, SoftAssert softAssert) {
		this.caseName= caseName;
		this.actual = actual;
		this.expected= expected;
		this.softAssert = softAssert;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		
		String msg =  actual.equals(expected)?caseName+ " Test Pass ":caseName+" Test Fail";
		System.out.println(msg);
		return msg;
	}

	@Override
	public void doAssert() {
		// TODO Auto-generated method stub
		softAssert.assertTrue(actual.equals(expected));
		
	}

	@Override
	public T getActual() {
		// TODO Auto-generated method stub
		return actual;
	}

	@Override
	public T getExpected() {
		// TODO Auto-generated method stub
		return expected;
	}

}
