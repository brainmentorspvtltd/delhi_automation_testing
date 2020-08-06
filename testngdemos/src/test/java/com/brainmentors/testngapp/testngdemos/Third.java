package com.brainmentors.testngapp.testngdemos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Third {
	@BeforeClass
	public void start() {
		System.out.println("START::I am Running for this class Third only");
	}
	@AfterClass
	public void stop() {
		System.out.println("STOP::I am Running for this class Third only");
	}
	
	@Test(dataProvider = "givemedata",dataProviderClass = AppTest.class)
	public void test4(int id , String name, double salary) {
		System.out.println("ID "+id+" Name "+name+" Salary "+salary);
		System.out.println("Test4 "+AppTest.x);
	}

}
