package com.brainmentors.keyworddriven.keyworddriven.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.brainmentors.keyworddriven.keyworddriven.exceptions.KeywordDrivenException;
import com.brainmentors.keyworddriven.keyworddriven.utils.CommandConstants;
import com.brainmentors.keyworddriven.keyworddriven.utils.Constants;
import com.brainmentors.keyworddriven.keyworddriven.utils.PropertyReader;
import com.brainmentors.keyworddriven.keyworddriven.utils.Validation;

public class Command implements CommandConstants{
	WebDriver driver;
	public void browser(String browserName) {
		if(Validation.isEmpty(browserName)) {
			throw new KeywordDrivenException("Browser Value is Missing in XLS");
		}
		if(browserName.equalsIgnoreCase(Constants.CHROME)) {
		System.setProperty(PropertyReader.getValue(Constants.DRIVER_NAME), PropertyReader.getValue(Constants.DRIVER_PATH));
		driver = new ChromeDriver();
		}
		else
		if(browserName.equalsIgnoreCase(Constants.FIREFOX)) {
			System.setProperty(PropertyReader.getValue(Constants.FF_DRIVER_NAME), PropertyReader.getValue(Constants.FF_DRIVER_PATH));
			driver = new FirefoxDriver();
			}
	}
	public void open(String url) {
		if(Validation.isEmpty(url)) {
			throw new KeywordDrivenException("URL Value is Missing in XLS");
		}
		driver.get(url);
	}
	private List<WebElement> getElements(String target) {
		String arr[] = target.split("=");
		String targetType =arr[0];
		String targetValue = arr[1];
		List<WebElement> element = null;
		if(ID.equals(targetType.toLowerCase())) {
			element = driver.findElements(By.id(targetValue));
		}
		else
		if(NAME.equals(targetType.toLowerCase())) {
			element = driver.findElements(By.name(targetValue));
		}
		else
		if(CLASS.equals(targetType.toLowerCase())) {
			element = driver.findElements(By.className(targetValue));
		}
		else
		if(CSS_SELECTOR.equals(targetType.toLowerCase())) {
			element = driver.findElements(By.cssSelector(targetValue));
		}
		else
			if(XPATH.equals(targetType.toLowerCase())) {
				element = driver.findElements(By.xpath(targetValue));
			}
		return element;
	}
	private WebElement getElement(String target) {
		String arr[] = target.split("=");
		String targetType =arr[0];
		String targetValue = arr[1];
		WebElement element = null;
		if(ID.equals(targetType.toLowerCase())) {
			element = driver.findElement(By.id(targetValue));
		}
		else
		if(NAME.equals(targetType.toLowerCase())) {
			element = driver.findElement(By.name(targetValue));
		}
		else
		if(CLASS.equals(targetType.toLowerCase())) {
			element = driver.findElement(By.className(targetValue));
		}
		else
		if(CSS_SELECTOR.equals(targetType.toLowerCase())) {
			element = driver.findElement(By.cssSelector(targetValue));
		}
		else
			if(XPATH.equals(targetType.toLowerCase())) {
				element = driver.findElement(By.xpath(targetValue));
			}
		return element;
	}
	public void type(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new KeywordDrivenException("Type Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new KeywordDrivenException("Type Command Value is Missing in XLS");
		}
		WebElement element = getElement(target);
		element.sendKeys(value);
		
	}
	public void click(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new KeywordDrivenException("Click Command Target is Missing in XLS");
		}
//		if(Validation.isEmpty(value)) {
//			throw new KeywordDrivenException("Click Command Value is Missing in XLS");
//		}
		WebElement element = getElement(target);
		element.click();
	}
	public void close() {
		if(driver!=null) {
			driver.close();
		}
	}
	public boolean assertTrue(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new KeywordDrivenException("Click Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new KeywordDrivenException("Click Command Value is Missing in XLS");
		}
		List<WebElement> elements = getElements(target);
		return elements.size() == Integer.parseInt(value);
//		return element.getText().equals(value);
		//return true;
	}

}
