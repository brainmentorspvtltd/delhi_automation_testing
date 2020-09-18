package com.tpddl.apps.learntestng;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest{
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Suite Before Call");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Suite After Call");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("APP TEST BEFORE TEST CALLED....");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("AppTest Before Class Callled....");
	}
	@BeforeMethod
	public void start() {
		System.out.println("Before Method Called...");
	}
	@Test(enabled =  false)
	public void testLogin() {
		// Appium Code
		System.out.println("Test Login called..");
		Assert.assertEquals(10, 10);
	}
	@Test
	public void collectData() {
		System.out.println("######Data Collect....");
	}
	
	@Test(groups = {"mygroup"})
	public void anotherMethod() {
		System.out.println("Another Group Method");
	
	}
	
	@DataProvider(name = "mydata")
	public Object [][] getUserData(){
		return new Object [][] {
			{"amit","amit"},{"ram","222"},{"shyam","333"}
		};
	}
	
	@Test(dataProvider = "mydata")
	public void testUserLogin(String userid, String password) {
		System.out.println("USER ID is "+userid+" PASSWORD IS "+password);
		Assert.assertEquals(userid, password);
	}
	
	
	@Parameters("source")
	//@Test(dependsOnMethods = {"collectData"})
	@Test(timeOut = 2000,threadPoolSize = 3,invocationCount = 10)
	//@Test(timeOut = 2000)
	//@Test(expectedExceptions = ArithmeticException.class)
	//@Ignore
	public void testRegister(String source) {
		// Appium Code
		System.out.println("........Test Register called.."+source);
		if(source.equalsIgnoreCase("xls")) {
			System.out.println("Read XLS");
		}
		else
		if(source.equalsIgnoreCase("db")) {
			System.out.println("Read DB");
		}
		Assert.assertEquals(10, 10);
	}
	@AfterMethod
	public void stop() {
		System.out.println("After Method Called...");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AppTest After Class Callled....");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("APP TEST After TEST CALLED....");
	}
	
}