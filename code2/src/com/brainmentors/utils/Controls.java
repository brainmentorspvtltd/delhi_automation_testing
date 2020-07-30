package com.brainmentors.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.brainmentors.exceptions.NoSuchWebElement;

public class Controls implements DriverConstants, ControlTypes {
	static WebDriver driver = null;
	public static void get(String url) {
		driver.get(url);
	}
	
	private static List<WebElement> getElements(String type, String controlName) {
		List<WebElement> element = null;
		
		if(type.equals(NAME)) {
			element = driver.findElements(By.name(controlName));
		}
		else if(type.equals(CSS_SELECTOR)) {
			element = driver.findElements(By.name(controlName));
		}
			
		return element;
	}
	
	private static WebElement getElement(String type, String controlName) {
		WebElement element = null;
		if(type.equals(ID)) {
			element = driver.findElement(By.id(controlName));
		}
		else if(type.equals(NAME)) {
			element = driver.findElement(By.name(controlName));
		}
		else if(type.equals(CSS_SELECTOR)) {
			element = driver.findElement(By.name(controlName));
		}
			
		return element;
	}
	
	
	public static void close() {
		if(driver!=null) {
			driver.close();
		}
	}
	
	public static void tickCheckBox(String type, String controlName) throws NoSuchWebElement {
		List<WebElement>  list = getElements(type,controlName );
		if(list==null || list.size()==0) {
			throw new NoSuchWebElement();
		}
		for(WebElement chk: list) {
			if(!chk.isSelected()) {
				chk.click();
			}
		}
			
	}
	
	public static void submitButton (String type, String controlName) throws NoSuchWebElement {
		WebElement searchButton= null;
		searchButton = getElement(type, controlName);
		if(searchButton==null) {
			throw new NoSuchWebElement();
		}
		searchButton.submit();
	}
	
	/**
	 * fillTextBoxValue this is for filling the text box
	 * 
	 * @param value it is for text box values and use by send keys
	 * @param type it is for identifiy the id, name, class, xpath 
	 * @param controlName it is name of the control in html
	 * @throws NoSuchWebElement 
	 */
	public static void fillTextBoxValue(String value, String type, String controlName) throws NoSuchWebElement {
		WebElement element = getElement(type, controlName);
		if(element == null) {
			throw new NoSuchWebElement();
		}
		element.sendKeys(value);
	}
	
	public static WebDriver getDriver(String driverType){
		
		String driverPath = ConfigReader.
				getValue(ConfigConstants.DRIVER_PATH);
		String driverName = ConfigReader.getValue(ConfigConstants.DRIVER_NAME);
		System.setProperty(driverName, driverPath);
		if(driverType.equals(CHROME)) {
			driver = new ChromeDriver();
		}
		else
		if(driverType.equals(FIREFOX))	{
			driver = new FirefoxDriver();
		}
		else
			if(driverType.equals(IE))	{
				driver = new InternetExplorerDriver();
			}
		return driver;
	}

}
