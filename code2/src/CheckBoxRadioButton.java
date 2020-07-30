import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.brainmentors.utils.ConfigConstants;
import com.brainmentors.utils.ConfigReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CheckBoxRadioButton {
	static String params;
	
	// This function prettifies the json response.
	public static String prettify(String json_text) {
	    JsonParser parser = new JsonParser();
	    JsonElement json = parser.parse(json_text);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    return gson.toJson(json);
	}
	
	public static void check (String mkt, String mode) throws Exception {
	    params = "?mkt=" + mkt + "&mode=" + mode;
	   // add the rest of the code snippets here (except prettify() and main())...
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String chromeDriverPath = ConfigReader.
		getValue(ConfigConstants.DRIVER_PATH);
String driverName = ConfigReader.getValue(ConfigConstants.DRIVER_NAME);
System.setProperty(driverName, chromeDriverPath);
WebDriver driver = new ChromeDriver();
//driver.get("https://the-internet.herokuapp.com/checkboxes");
// http://book.theautomatedtester.co.uk/chapter1
driver.get("http://book.theautomatedtester.co.uk/chapter1");
Thread.sleep(3000);
driver.findElement(By.id("radiobutton")).click();
WebElement ele = driver.findElement(By.id("selecttype"));
Select dropDown = new Select(ele);
dropDown.selectByValue("Selenium RC");
System.out.println("Multiple "+dropDown.isMultiple());
//WebElement el = driver.findElement(By.linkText("Home Page"));
WebElement el = driver.findElement(By.partialLinkText("Home"));
el.click();
System.out.println("Page Name "+driver.getTitle());
List<WebElement> links = driver.findElements(By.partialLinkText("Chapter"));
System.out.println("Total Links are "+links.size());
WebElement txt = driver.findElement(By.className("mainbody"));
String textValue = txt.getText();
String sentences [] =textValue.split("\n");
System.out.println(sentences[0]);

// Step for Config (MICROSOFT SERVER)
 String host = "https://api.cognitive.microsoft.com";
 String path = "/bing/v7.0/spellcheck";

 String key = "TYPEURKEYHERE";// API KEY Given by Microsoft

 String mkt = "en-US";
 String mode = "proof";
 String text = sentences[0];
 // FILLING THE URL
 check(mkt, mode);
 // HITTING THE URL
 URL url = new URL(host + path + params);
 HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
 connection.setRequestMethod("POST");
 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
 connection.setRequestProperty("Ocp-Apim-Subscription-Key", key);
 connection.setDoOutput(true);
 // SENDING THE REQUEST WITH DATA TO SERVER
 DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
 
 wr.writeBytes("text=" + text);
 wr.flush();
 wr.close();
 
 BufferedReader in = new BufferedReader(
		 new InputStreamReader(connection.getInputStream()));
		 String line;
		 while ((line = in.readLine()) != null) {
		 	System.out.println(prettify(line));
		 }
		 in.close();
 
//dropDown.deselectAll();
//dropDown.deselectByIndex(0);
//dropDown.selectByIndex(3);
//dropDown.selectByVisibleText("Selenium RC");
//dropDown.selectByValue("");
//List<WebElement> list = driver.findElements(By.cssSelector("input[type='checkbox']"));
//for(WebElement chk: list) {
//	if(!chk.isSelected()) {
//		chk.click();
//	}
//	
//}
Thread.sleep(5000);
driver.close();
	}

}
