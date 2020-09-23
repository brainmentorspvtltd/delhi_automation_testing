package com.tpddl.appiumtesting.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tpddl.appiumtesting.utils.Constants;
import com.tpddl.appiumtesting.utils.PropertyReader;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Command implements Constants{
	static AndroidDriver<AndroidElement> driver = null;
	
	static void install(String appPath){
		driver.installApp(appPath);
	}
	
	public static List getList(String type, String expression) {
		List list=driver.findElements(By.className(expression));
		return list;
	}
	
	static void back() {
		driver.navigate().back();
		
	}
	
	static void forward() {
		driver.navigate().forward();
	}
	
	static void screenShot() throws FileNotFoundException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileOutputStream fs = new FileOutputStream(file);
	}
	
	static String getHybridCode() {
		String sourceCode = driver.getPageSource();
		return sourceCode;
	}
	
	static ScreenOrientation getOrientation() {
		ScreenOrientation s = driver.getOrientation();
		return s;
	}
	
	static String getLocation() {
		String loc = "Lat "+driver.location().getLatitude()+" Lng"+driver.location().getLongitude();
		return loc;
	}
	
	
	public static void scroll(String value) {
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));");
	}
	
	
	public static void XpathContentWise(String expression) {
		driver.findElementByXPath("//*[@content-desc='"+expression+"']").click();
		//driver.findElementByXPath("//*[@content-desc='3']").click();
		//driver.findElementByXPath("//*[@content-desc='45']").click();
	}
	
	public static AndroidElement getXpathContentWise(String expression) {
		return driver.findElementByXPath("//*[@content-desc='"+expression+"']");
		
	}
	
	public static void ratingBar(String expression) {
		//io.appium.android.apis:id/ratingbar2
		//AndroidElement ratingBar = driver.findElement(By.id("io.appium.android.apis:id/ratingbar2"));
	List<AndroidElement> list = 	driver.findElements(By.className("android.widget.RatingBar"));
	
	System.out.println("Rating Bar is "+list.size());
	AndroidElement fiveStarRatingbar = list.get(1);
		//Get start point of fiveStarRatingbar.
		  int startX = fiveStarRatingbar.getLocation().getX();
		  System.out.println(startX);
		  //Get end point of fiveStarRatingbar.
		  int endX = fiveStarRatingbar.getSize().getWidth();
		  System.out.println(endX);
		  //Get vertical location of fiveStarRatingbar.
		  int yAxis = fiveStarRatingbar.getLocation().getY();
		  
		  //Set fiveStarRatingbar tap position to set Rating = 4 star.
		  //You can use endX * 0.2 for 1 star, endX * 0.4 for 2 star, endX * 0.6 for 3 star, endX * 0.8 for 4 star, endX * 1 for 5 star.
		  int tapAt = (int) (endX * 0.9);  
		  //Set fiveStarRatingbar to Rating = 4.5 star using TouchAction class.
		  TouchAction act=new TouchAction(driver);  
		  
		  act.press(PointOption.point(tapAt, yAxis)).release().perform();
		  
	}
	
	public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException{
		String serverURL = PropertyReader.getValue(SERVER_URL_KEY);
		String apkLocation = PropertyReader.getValue(APK_PATH_KEY);
		//String serverURL = "http://127.0.0.1:4723/wd/hub";
		//String apkLocation = "/Users/amit/Documents/tpddl-appium/apk/calc.apk";
		// c:\\apk\\calc.apk
		DesiredCapabilities dc  = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, ANDROID_TEST_FW);
		dc.setCapability(MobileCapabilityType.APP, apkLocation);
		 driver = new AndroidDriver<>(new URL(serverURL),dc);
		 int time = PropertyReader.getIntValue(IMPLICIT_WAIT_TIME);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}
	
	private static AndroidElement getElement(String type, String expression) {
		AndroidElement element =  null;
		if(type.equalsIgnoreCase(ID)) {
			element = driver.findElement(By.id(expression));
		}
		else
		if(type.equalsIgnoreCase(CLASS)) {
			element = driver.findElement(By.className(expression));
		}
		else
		if(type.equalsIgnoreCase(UI_AUTOMATOR)) {
			element = driver.findElementByAndroidUIAutomator(expression);
		}
		else
		if(type.equalsIgnoreCase(XPATH)) {
			element = driver.findElement(By.xpath(expression));
		}
		return element;
	}
	
	
	private static List<AndroidElement> getElements(String type, String expression) {
		List<AndroidElement> elements =  null;
//		if(type.equalsIgnoreCase(ID)) {
//			elements = driver.findElements(By.id(expression));
//		}
//		else
		if(type.equalsIgnoreCase(CLASS)) {
			elements = driver.findElements(By.className(expression));
		}
		else
		if(type.equalsIgnoreCase(UI_AUTOMATOR)) {
			elements = driver.findElementsByAndroidUIAutomator(expression);
		}
		else
		if(type.equalsIgnoreCase(XPATH)) {
			elements = driver.findElements(By.xpath(expression));
		}
		return elements;
	}
	
	
	public static String getText(String type, String expression) {
		AndroidElement element= getElement(type, expression);
		return element.getText();
	}
	public static AndroidElement typeValue(String type, String expression ,String value) {
		AndroidElement element = getElement(type, expression);
		element.sendKeys(value);
		return element;
	}
	
	public static void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	public static void spinnerClock(String type, String expression, String clockType, String clockExpression,int clockIndex, String hourType, String hourExpression , int incrementHours) {
		Command.click(type, expression);
		
		List<AndroidElement> numberPickers = getElements(clockType, clockExpression);
		AndroidElement numberPicker = numberPickers.get(clockIndex);
		for(int i =1 ; i<=Math.abs(incrementHours); i++) {
		if(hourType.equals(CLASS)) {
			numberPicker.findElements(By.className(hourExpression)).get(1).click();
		}
		else
		if(hourType.equals(XPATH)) {
			numberPicker.findElements(By.xpath(hourExpression)).get(1).click();
		}
		}
		
	}
	
	public static void longPress(String type, String expression) {
		TouchAction touchAction = new TouchAction(driver);
		WebElement element = getElement(type, expression);
		touchAction.
		longPress(LongPressOptions.longPressOptions()
				.withElement(
						ElementOption.element(element))
				.withDuration(Duration.ofSeconds(2)))
		.release()
		.perform();
	}
	
	public static  void screenSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int edge = 10;
		TouchAction touchAction = new TouchAction(driver);
		PointOption startPoint = PointOption.point(dim.width/2, dim.height/2);
		// left swipe (right to left)
		//PointOption endPoint = PointOption.point(edge, dim.height/2);
		
		// right swipe
		//PointOption endPoint = PointOption.point(dim.width - edge, dim.height/2);
		
		// top swipe
		//PointOption endPoint = PointOption.point(dim.width/2, edge);
		// Bottom Swipe
		PointOption endPoint = PointOption.point(dim.width/2, dim.height- edge);
		
		touchAction.press(startPoint)
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(endPoint).
		release()
		.perform();
	}
	
	public static void swipe() {
		TouchAction touchAction = new TouchAction(driver);
		XpathContentWise("3");
		AndroidElement ele = getXpathContentWise("15");
		AndroidElement ele2 = getXpathContentWise("45");
		touchAction.longPress(
				LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(ele))
				.withDuration(Duration.ofSeconds(2)))
				.moveTo(ElementOption.element(ele2))
				.release().perform();
	}
	
	
	public static void clockControl(String type, String expression,String hourType, String hourExpression, String hourTime, String minTime, String type3, String okExpression ) {
		click(type, expression);
		click(hourType, hourExpression);
		XpathContentWise(hourTime);
		XpathContentWise(minTime);
		click(type3, okExpression);
		
	}
	
	public static void calendar(String type, String expression, int months, String date, String type2,  String prevExpression, String nextExpression, String type3, String okExpression) {
//		AndroidElement element = getElement(type, expression);
//		element.click();
		click(type, expression);
//		if(months==0) {
//			// nothing
//		}
//		else
		if(months>0) {
			// next
			for(int i = 1;i<=months; i++) {
				getElement(type2, nextExpression).click();
			}
		}
		else
		if(months<0) {
			// Prev
			for(int i = 1;i<=Math.abs(months); i++) {
				getElement(type2, prevExpression).click();
			}
		}
		//Date Select
		driver.findElementByAndroidUIAutomator("UiSelector().description(\""+date+"\")").click();
		
		// Ok Click
		getElement(type3, okExpression).click();
		
	}
	
	public static void spinner(String type, String expression, String type2, String expression2) {
		AndroidElement element = getElement(type, expression);
		element.click();
		AndroidElement element2 = getElement(type2, expression2);
		element2.click();
	}
	
	public static void autoComplete(String type, String expression , String value, int xVal, int yVal) {
		AndroidElement element = typeValue(type, expression, value);
		Point point = element.getLocation();
		System.out.println(point.getX()+" "+point.getY());
		int x = point.getX();
		int y = point.getY();
		x = x + xVal;
		y = y + yVal;
		TouchAction action = new TouchAction(driver).tap(PointOption.point(x, y)).release();
		action.perform();
		
	}
	
	public static void click(String type, String expression) {
		AndroidElement element = getElement(type, expression);
		element.click();
	}
	
	public static void delay() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close() {
		if(driver!=null) {
		driver.quit();
		}
	}
	
}
