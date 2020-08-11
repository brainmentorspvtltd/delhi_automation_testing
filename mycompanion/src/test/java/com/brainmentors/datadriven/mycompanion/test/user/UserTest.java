package com.brainmentors.datadriven.mycompanion.test.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.brainmentors.datadriven.mycompanion.models.User;
import com.brainmentors.datadriven.mycompanion.utils.Constants;
import com.brainmentors.datadriven.mycompanion.utils.ExcelReader;
import com.brainmentors.datadriven.mycompanion.utils.PropertyReader;

public class UserTest {
	
	// Data Mapping
	@DataProvider(name = "userdata")
	public Object[][] getUserData(){
		List<User> users = ExcelReader.readUserXLS();
		int cols = Integer.valueOf(PropertyReader.getValue(Constants.USER_XLS_COLS));
		Object object[][] = new Object[users.size()][cols];
		for(int i = 0 ; i<object.length; i++) { // Row (4)
			for(int j = 0; j<object[i].length; j++) { // Col (3)
				if(j==0) {
					object[i][j]= users.get(i).getUserid();
				}
				else
				if(j==1) {
					object[i][j]= users.get(i).getPassword();
				}
				if(j==2) {
					object[i][j]= users.get(i).getCode();
				}
				
			}
		}
		return object;
	}
	
	WebDriver driver;
//	@BeforeClass
//	public void start() {
//		System.setProperty(PropertyReader.getValue(Constants.DRIVER_NAME), PropertyReader.getValue(Constants.DRIVER_PATH));
//		driver = new ChromeDriver();
//	}
	
	@Test(dataProvider = "userdata")
	public void testLogin(String userid, String password, String code) {
		
		//System.out.println("TEST LOGIN "+userid + " "+password+ " "+code);
		System.setProperty(PropertyReader.getValue(Constants.DRIVER_NAME), PropertyReader.getValue(Constants.DRIVER_PATH));
		driver = new ChromeDriver();
		driver.get(Constants.URL);
		WebElement userTxt = driver.findElement(By.id("username"));
		userTxt.sendKeys(userid);
		WebElement passwordTxt = driver.findElement(By.id("Password"));
		passwordTxt.sendKeys(password);
		WebElement codeTxt = driver.findElement(By.id("TxtImgVer"));
		codeTxt.sendKeys(code);
		WebElement loginBt = driver.findElement(By.id("login_Click"));
		loginBt.click();
		try {
		List<WebElement> cards = driver.findElements(By.className("card"));
		WebElement date1 = driver.findElement(By.id("SCStartDate"));
		date1.sendKeys("10/08/2020");
		}
		catch(Exception e) {
			System.out.println("Invalid Userid or Password");
		}
//		Assert.assertTrue(cards!=null && cards.size()==5);
		
//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.close();
	}
//	@AfterClass
//	public void end() {
//		driver.close();
//	}

}
