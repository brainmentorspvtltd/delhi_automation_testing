package com.brainmentors.uploaddemo.fileuploaddemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadTestCode {

	public static void main(String[] args) throws Exception {
		String url = "https://the-internet.herokuapp.com/upload";
		System.setProperty("webdriver.chrome.driver", "/Users/amit/Documents/tpddl-automation/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.findElements(By.className("box")).get(0).click();
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
		//Thread.sleep(3000);
		//ScreenShotDemo.takeScreenShot(driver);
		//((JavascriptExecutor)driver).executeScript("document.querySelector('#file-upload').click();");
		//driver.findElement(By.id("file-upload")).click();
		String path = "/Users/amit/Downloads/winter.jpg";
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("file-upload"))).click().build().perform();
		//driver.findElement(By.id("file-upload")).click();
		//System.in.read();
		try {
			RobotForMac.upload(path);
			//FileUploadBySikuli.uploadIt(path);
			System.out.println("Uploaded.....");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in File Upload ");
			e.printStackTrace();
			return ;
		}
		System.out.println("Done...");
		
	}

}
