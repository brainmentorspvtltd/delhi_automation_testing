package com.brainmentors.testngapp.testngdemos.groups;

import org.testng.annotations.Test;

public class SavingAccount {
	@Test(groups = {"mygroup","x"})
	public void test1() {
		System.out.println("Saving Account Test1");
	}
	@Test(groups = {"x"})
	public void test2() {
		System.out.println("Saving Account Test2");
	}
	@Test
	public void test3() {
		System.out.println("Saving Account Test3");
	}

}
