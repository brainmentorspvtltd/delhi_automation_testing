package com.brainmentors.testngapp.testngdemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSecond {
	@Test
	public void test3() {
		System.out.println("Test3 Call");
		Assert.assertEquals(10, 10);
	}

}
