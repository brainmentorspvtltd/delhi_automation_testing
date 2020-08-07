package com.brainmentors.testngapp.testngdemos;

import java.util.InputMismatchException;

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
import org.testng.annotations.Test;

import com.brainmentors.testngapp.models.Emp;

//@Ignore
public class AppTest{
	
	public static int x ;
	private static Emp emp ;
	@BeforeSuite
	public void begin() {
		 x= 100;
		 emp =new Emp();
		 emp.setId(1001);
		 emp.setName("Ram");
		 emp.setSalary(9999);
		System.out.println("Before Suite "+x);
	}
	
	@Test
	//@Parameters("env")
	public void testParameter() {
		System.out.println("Param ::::::::::::::====> ");
	}
	
	@DataProvider(name = "givemedata")
	public static Object[][]giveMeData() {
		System.out.println("Data Provider called...");
		Object obj[][] = {
				{emp.getId(), emp.getName(), emp.getSalary()},{102,"Shyam",8888}
		};
		return obj;
	}
	
	@BeforeMethod
	public void beforeAllMethods() {
		System.out.println("Before Test Method");
	}
	
	@AfterMethod
	public void afterAllMethods() {
		System.out.println("After Test Method");
	}
	
	@BeforeTest
	public void appTestStart() {
		System.out.println("This is for Test Start");
	}
	@AfterTest
	public void appTestStop() {
		System.out.println("This is for Test Stop");
	}
	
	@Test(dependsOnMethods = {"dependent"})
	public void test6() {
		System.out.println("100 == 100");
		Assert.assertEquals(100, 100);
	}
	@Test
	public void dependent() {
		System.out.println("I am the dependent method");
	}
	
	@Test(expectedExceptions = {ArithmeticException.class,InputMismatchException.class})
	public void test5() {
		
		System.out.println("Test 5 $$$$$$$$$$$$$$$$$$$$$$$$$");
		int x = 10/0;
	}
	
	@AfterSuite
	public void end() {
		 x= 0;
		System.out.println("After Suite "+x);
	}
	
	@BeforeClass
	public void start() {
		System.out.println("START:::I am Running for this class App only");
	}
	@AfterClass
	public void stop() {
		System.out.println("STOP :::I am Running for this class App only");
	}
	
	@Test(dataProvider = "givemedata")
	//@Test(enabled = false)
	//@Ignore
	public void test1(int id , String name , double salary) {
		System.out.println("Test1 Run "+x);
		System.out.println("Id "+id+" Name "+name+" Salary "+salary);
		Assert.assertTrue(20==20);
	}
	@Test
	public void test2() {
		System.out.println("Test2 Run  "+x);
		Assert.assertTrue(30>=30);
	}
}