package Waits;

import java.net.*;
import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public RemoteWebDriver driver = null;
	String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS_KEY");
	String status = "failed";

	@BeforeMethod
	public void setUp() 
	{
		try 
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 10");
			chromeOptions.setBrowserVersion("127");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("build", "WebDriverWaits in Selenium Java");
			ltOptions.put("name", "WebDriverWaits in Selenium Java");
			chromeOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() 
	{
		driver.executeScript("lambda-status=" + status);
		driver.quit();
	}

}
