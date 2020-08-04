import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.brainmentors.utils.ConfigConstants;
import com.brainmentors.utils.ConfigReader;

public class AjaxDemo {

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath = ConfigReader.
				getValue(ConfigConstants.DRIVER_PATH);
		String driverName = ConfigReader.getValue(ConfigConstants.DRIVER_NAME);
		System.setProperty(driverName, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		driver.manage().window().maximize();
		WebElement div = driver.findElement(By.id("loadajax"));
		div.click();
		WebElement div2 = driver.findElement(By.id("ajaxdiv"));
		
		// Default 10 sec
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // Implcit Wait
		//Thread.sleep(3000); // Happy Cases
		System.out.println("Div2 "+div2.getText());
		//String div2Text = div2.getText();
		
		// Explicit Wait
		/*WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#ajaxdiv>p")));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ajaxdiv>p")));
		String div2Text = driver.findElement(By.cssSelector("div#ajaxdiv>p")).getText();
		*/
		// Fluent Wait
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(30,TimeUnit.SECONDS);
		wait.pollingEvery(3,TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		WebElement pTag = (WebElement)wait.until(new Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return driver.findElement(By.cssSelector("div#ajaxdiv>p"));
			}
			
		});
		String div2Text = pTag.getText();
		System.out.println("Div2 Text "+div2Text);
		if(div2Text.contains("The following text")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
			throw new RuntimeException("Test Fail");
		}
		Thread.sleep(2000);
		driver.close();

	}

}
