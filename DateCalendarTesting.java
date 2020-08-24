package com.brainmentors.keyworddriven.keyworddriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brainmentors.keyworddriven.keyworddriven.utils.Constants;
import com.brainmentors.keyworddriven.keyworddriven.utils.PropertyReader;

public class DateCalendarTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty(PropertyReader.getValue(Constants.DRIVER_NAME), PropertyReader.getValue(Constants.DRIVER_PATH));
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = driver.findElement(By.id("datepicker"));
		ele.click();
		int day = 15;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-datepicker-calendar")));
		WebElement table  = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Rows are "+rows.size());
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell : cells) {
				System.out.println("Cell are "+cell.getText());
				if(cell.getText().equals(String.valueOf(day))) {
					System.out.println("Cell MATCH ");
					cell.click();
				}
			}
		}
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("datepicker"))));
//		
//		
		//wait.until(ExpectedConditions.elementToBeClickable(ele));
		//ele.click();
	}

}
