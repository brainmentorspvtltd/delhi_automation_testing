import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.brainmentors.utils.ConfigConstants;
import com.brainmentors.utils.ConfigReader;

public class MethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String chromeDriverPath = ConfigReader.
				getValue(ConfigConstants.DRIVER_PATH);
		String driverName = ConfigReader.getValue(ConfigConstants.DRIVER_NAME);
		System.setProperty(driverName, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		// Page Navigation
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsCodes = "var buttons = document.querySelectorAll('button'); buttons[0].click()";
		js.executeScript(jsCodes);
		//		List<WebElement> buttons = driver.findElements(By.tagName("button"));
//		System.out.println("Total Buttons are "+buttons.size());
//		buttons.get(2).click();
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		
//		alert.sendKeys("Hello How are U ");
//		Thread.sleep(2000);
//		alert.accept();
//		//alert.dismiss();
		//driver.navigate().refresh();
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.switchTo().frame(1);
		//Thread.sleep(3000);
		//String source = driver.switchTo().frame(0).getPageSource();
		//String source = driver.switchTo().frame(driver.findElement(By.id("frame-left"))).getPageSource();
		//System.out.println("Frame Source is "+source);
		//driver.close(); // current
		Thread.sleep(3000);
		driver.quit(); // all

	}

}
