package com.tpddl.apps.learntestng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {
	@BeforeClass
	public void beforeClass() {
		System.out.println("UserTest Before Class Called....");
	}
	@Test(groups = {"mygroup"})
	public void profile() {
		System.out.println("Profile in Mygroup");
		
		Assert.assertTrue(10==10);
	}
	@AfterClass
	public void afterClass() {
		System.out.println("UserTest After Class Called....");
	}
}
