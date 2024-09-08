package Waits;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestFluentWait extends TestBase {

	@Test(description = "Fluent wait demonstration")
	public void testFluentWait() 
	{
		// Navigate to Dynamic data loading page
		driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");

		// click on the Get Random User Button
		driver.findElement(By.id("save")).click();

		// create a fluent wait object with timeout of 20 sec, polling every 5 sec and
		// ignoring NoSuchElementException
		Wait<RemoteWebDriver> fluentWait = new FluentWait<RemoteWebDriver>(driver)
												.withTimeout(Duration.ofSeconds(20))
												.pollingEvery(Duration.ofSeconds(5))
												.ignoring(NoSuchElementException.class);
		try {
			// wait for the image element to be visible
			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@src,'randomuser.me')]")));

			// Message to confirm that the random user image is visible
			System.out.println("Image of the random user is visible");

			status = "passed";
		} catch (TimeoutException ex) 
		{
			ex.printStackTrace();
		}
	}

}
