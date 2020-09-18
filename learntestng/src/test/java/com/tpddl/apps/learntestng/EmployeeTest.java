package com.tpddl.apps.learntestng;

import org.junit.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {
	
	@Test
	public void test3() {
		System.out.println("Test3 Called");
		Assert.assertTrue(10>2);
	}

}
