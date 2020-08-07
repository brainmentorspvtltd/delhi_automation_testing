package com.brainmentors.testngapp.testngdemos.groups;

import org.testng.annotations.Test;

public class CurrentAccount {
	@Test
	public void test4() {
		System.out.println("Current Account Test4");
	}
	@Test(groups = {"mygroup"})
	public void test5() {
		System.out.println("Current Account Test5");
	}
	@Test
	public void test6() {
		System.out.println("Current Account Test6");
	}
}
