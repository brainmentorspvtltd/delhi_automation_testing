package com.brainmentors.frameworks.hybrid.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brainmentors.frameworks.hybrid.exceptions.CommandException;
import com.brainmentors.frameworks.hybrid.exceptions.HybridException;
import com.brainmentors.frameworks.hybrid.utils.CommandConstants;
import com.brainmentors.frameworks.hybrid.utils.Constants;
import com.brainmentors.frameworks.hybrid.utils.PropertyReader;
import com.brainmentors.frameworks.hybrid.utils.Validation;



public class Command implements CommandConstants{
	WebDriver driver;
	public void browser(String browserName) {
		if(Validation.isEmpty(browserName)) {
			throw new CommandException("Browser Value is Missing in XLS");
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
			throw new CommandException("URL Value is Missing in XLS");
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
	public  void type(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new CommandException("Type Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new CommandException("Type Command Value is Missing in XLS");
		}
		WebElement element = getElement(target);
		element.sendKeys(value);
		
	}
	public void click(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new CommandException("Click Command Target is Missing in XLS");
		}
//		if(Validation.isEmpty(value)) {
//			throw new KeywordDrivenException("Click Command Value is Missing in XLS");
//		}
		WebElement element = getElement(target);
		element.click();
		int timeOut = Integer.parseInt(PropertyReader.getValue(Constants.TIMEOUT));
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		try {
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert is Present in Case of Failure");
		driver.switchTo().alert().accept();
		}
		catch(TimeoutException e) {
			System.out.println("Alert Not Present in Case of Success");
			//throw new HybridException("TIMEOUT HAPPENS ALERT ")
		}
		
		
		
	}
	public void close() {
		if(driver!=null) {
			driver.close();
		}
	}
	public boolean assertTrue(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new CommandException("assertTrue Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new CommandException("assertTrue Command Value is Missing in XLS");
		}
		List<WebElement> elements = getElements(target);
		return elements.size() == Integer.parseInt(value);
//		return element.getText().equals(value);
		//return true;
	}
	public boolean assertContains(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new CommandException("assertContains Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new CommandException("assertContains Command Value is Missing in XLS");
		}
		WebElement element = getElement(target);
		return element.getText().contains(value);
		//return elements.size() == Integer.parseInt(value);
//		return element.getText().equals(value);
		//return true;
	}
	public boolean assertStartWith(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new CommandException("assertStartWith Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new CommandException("assertStartWith Command Value is Missing in XLS");
		}
		WebElement element = getElement(target);
		return element.getText().startsWith(value);
		//return elements.size() == Integer.parseInt(value);
//		return element.getText().equals(value);
		//return true;
	}
	public boolean assertEndsWith(String target , String value) {
		if(Validation.isEmpty(target)) {
			throw new CommandException("assertEndsWith Command Target is Missing in XLS");
		}
		if(Validation.isEmpty(value)) {
			throw new CommandException("assertEndsWith Command Value is Missing in XLS");
		}
		WebElement element = getElement(target);
		return element.getText().endsWith(value);
		//return elements.size() == Integer.parseInt(value);
//		return element.getText().equals(value);
		//return true;
	}

}
