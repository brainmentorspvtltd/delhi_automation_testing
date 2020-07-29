import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.brainmentors.exceptions.NoSuchWebElement;
import com.brainmentors.utils.ConfigConstants;
import com.brainmentors.utils.ConfigReader;
import com.brainmentors.utils.ControlTypes;
import com.brainmentors.utils.Controls;
import com.brainmentors.utils.DriverConstants;

public class First {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//  c:\\Users\\amit\\driver\\chromedriver.exe     windows
//		String chromeDriverPath = ConfigReader.
//				getValue(ConfigConstants.DRIVER_PATH);
//		String driverName = ConfigReader.getValue(ConfigConstants.DRIVER_NAME);
//		System.setProperty(driverName, chromeDriverPath);
		//WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Controls.getDriver(DriverConstants.CHROME);
		Controls.get("https://www.google.com/");
		//driver.get("https://www.google.com/");
		try {
		Controls.fillTextBoxValue("BMW CARS", ControlTypes.NAME, "q");
		Controls.submitButton(ControlTypes.NAME, "btnK");
		}
		catch(NoSuchWebElement e) {
			System.out.println(e);
		}
//		WebElement searchTxtBox= driver.findElement(By.name("q"));
//		searchTxtBox.sendKeys("BMW CARS");
//		WebElement searchButton= driver.findElement(By.name("btnK"));
//		searchButton.submit();
		Thread.sleep(6000);
		Controls.close();
		//driver.close();
		
		
	}

}
