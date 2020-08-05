import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.brainmentors.utils.ConfigConstants;
import com.brainmentors.utils.ConfigReader;
import com.brainmentors.utils.ScreenShot;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chromeDriverPath = ConfigReader.
				getValue(ConfigConstants.DRIVER_PATH);
		String driverName = ConfigReader.getValue(ConfigConstants.DRIVER_NAME);
		System.setProperty(driverName, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		driver.manage().window().maximize();
		try {
			ScreenShot.takeScreenShot(driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
