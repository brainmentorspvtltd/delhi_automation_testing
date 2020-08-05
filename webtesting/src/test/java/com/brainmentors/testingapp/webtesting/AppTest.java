package com.brainmentors.testingapp.webtesting;

import java.util.ResourceBundle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

class AppTest{
	ResourceBundle rb = ResourceBundle.getBundle("config");
	//@Test
	public void testCase() {
		//System.out.println("TEST NG TEST CASE FIRE");
		System.setProperty(rb.getString("drivername"), rb.getString("driverpath"));
		WebDriver driver = new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter2");
		String title= driver.getTitle();
		
		Assert.assertEquals(title, "....Selenium: Beginners Guide");
		driver.close();
	}
	@Test
	//@Ignore
	public void testCase2() {
		//System.out.println("TEST NG TEST CASE FIRE");
		System.setProperty(rb.getString("drivername"), rb.getString("driverpath"));
		WebDriver driver = new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter2");
		String title= driver.getTitle();
		
		Assert.assertEquals(title, "Selenium: Beginners Guide");
		driver.close();
	}
	@Test
	//@Ignore
	public void testCricAPI() {
		//System.out.println("TEST NG TEST CASE FIRE");
		System.setProperty(rb.getString("drivername"), rb.getString("driverpath"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://cricapi.com/api/playerStats?pid=253802&apikey=A8zoDoPaQgefmB7KunnSuApSgL73");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String object = (String)js.executeScript("return document.body.children[0].innerText");
		System.out.println("Object "+object);
		boolean dob = object.contains("November 5, 1988");
		boolean imgUrl = object.contains("https://www.cricapi.com/playerpic/253802.jpg");
		boolean team = object.contains("Royal Challengers Bangalore");
		Assert.assertTrue(dob && imgUrl && team);
		driver.close();
	}
}