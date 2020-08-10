package com.brainmentors.testngapp.testngdemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSecond {
	@Test(threadPoolSize = 3, invocationCount = 12,timeOut = 9000)
	//@Test(timeOut = 4000)
	public void test3() {
		System.out.println("Test3 Call...........");
		Assert.assertEquals(10, 10);
	}

}
