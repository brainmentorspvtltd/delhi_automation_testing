package com.brainmentors.grid.gridtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void gridTest() {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		dc.setCapability(ChromeOptions.CAPABILITY, co);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		URL ubuntuNodeMachine = null;
		try {
			 ubuntuNodeMachine = new URL("http://192.168.1.8:5555/wd/hub");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(ubuntuNodeMachine, dc);
		String URL = "http://202.54.216.12:1000/companion/LoginPage.aspx";
		driver.get(URL);
		WebElement userTxt = driver.findElement(By.id("username"));
		userTxt.sendKeys("companion");
		WebElement passwordTxt = driver.findElement(By.id("Password"));
		String type = passwordTxt.getAttribute("type");
		//Assert.assertEquals(type ,"password");
		passwordTxt.sendKeys("companion");
		WebElement codeTxt = driver.findElement(By.id("TxtImgVer"));
		codeTxt.sendKeys("11");
		WebElement loginBt = driver.findElement(By.id("login_Click"));
		loginBt.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
