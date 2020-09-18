package com.tpddl.apps.learntestng;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomReport implements ITestListener {
	static int count = 0;
	static int  failCount = 0;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		count++;
		System.out.println(result.getName()+" SuccessFully Ended..."+count);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		failCount++;
		System.out.println(result.getName()+" Failed... "+failCount);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}
