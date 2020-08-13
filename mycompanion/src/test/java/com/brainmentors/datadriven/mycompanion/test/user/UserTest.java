package com.brainmentors.datadriven.mycompanion.test.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	
	@Test
	public void test1() {
		Assert.assertEquals(10, 10);
	}
	@Test
	public void test2() {
		Assert.assertEquals(100, 10);
	}
	
	WebDriver driver;
//	@BeforeClass
//	public void start() {
//		System.setProperty(PropertyReader.getValue(Constants.DRIVER_NAME), PropertyReader.getValue(Constants.DRIVER_PATH));
//		driver = new ChromeDriver();
//	}
	
	//@Test(dataProvider = "userdata")
	//public void testLogin(String userid, String password, String code) {
	//@Test
	public void testLogin() {
		//System.out.println("TEST LOGIN "+userid + " "+password+ " "+code);
		System.setProperty(PropertyReader.getValue(Constants.DRIVER_NAME), PropertyReader.getValue(Constants.DRIVER_PATH));
		driver = new ChromeDriver();
		driver.get(Constants.URL);
		WebElement userTxt = driver.findElement(By.id("username"));
		userTxt.sendKeys("companion");
		WebElement passwordTxt = driver.findElement(By.id("Password"));
		passwordTxt.sendKeys("companion");
		WebElement codeTxt = driver.findElement(By.id("TxtImgVer"));
		codeTxt.sendKeys("11");
		WebElement loginBt = driver.findElement(By.id("login_Click"));
		loginBt.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("heading"))));
		String text  = driver.findElement(By.id("heading")).getText();
		Assert.assertTrue(text.contains("MY"));
		/*
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("card"))));
		List<WebElement> cards = driver.findElements(By.className("card"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('card')[0].click();");
		//cards.get(0).click();
		System.out.println("Card Clicked");
		 //10 sec
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SCStartDate")));
		WebElement date1 = driver.findElement(By.id("SCStartDate"));
		date1.click();
		Actions actions=new Actions(driver);
		//Actions actions=new Actions(driver);
		actions.click(date1);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[3]/td[6]"))));
		driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[3]/td[6]")).click();
		//date1.sendKeys("10/08/2020");
		System.out.println("PICK DATE");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SCStartTime")));
		WebElement time1 = driver.findElement(By.id("SCStartTime"));
		time1.click();
		actions.click(time1);
		Thread.sleep(3000);
		//actions.keyDown(time, Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dtp-date-view")));
		System.out.println("POP UP SHOW");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"h-23\"]"))));
		
		actions.click(driver.findElement(By.xpath("//*[@id=\"h-23\"]")));
		//driver.findElement(By.xpath("//*[@id=\"th-10\"]")).click();
		driver.findElements(By.className("dtp-btn-ok")).get(0).click();
		// //*[@id="th-10"]
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Thread.sleep(3000);
		}
		catch(Exception e) {
			System.out.println("Invalid Userid or Password "+e);
			e.printStackTrace();
		}
//		Assert.assertTrue(cards!=null && cards.size()==5);
		
//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		*/
		driver.close();
	}
//	@AfterClass
//	public void end() {
//		driver.close();
//	}

}
