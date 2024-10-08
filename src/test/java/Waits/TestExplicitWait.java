package Waits;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;


public class TestExplicitWait extends TestBase{
	
	@Test(description="WebDriverWait demonstration 1")
	public void testExplicitWait_1()
	{
		// Initialize WebDriverWait with a timeout of 10 seconds
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// LambdaTest e-commerce website to check for dynamic loading elements
		driver.get("https://ecommerce-playground.lambdatest.io/");
		
		try {
			// ExpectedCondition to wait for element to be present : presenceOfElementLocated
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("entry_217966")));
			 
			// ExpectedCondition to check if element is clickable and then click on it: elementToBeClickable
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("entry_217966")));
			element.click();
			 
			// ExpectedCondition to wait for element to be visible after the click: visibilityOfElementLocated
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='iPod Touch']")));
			
			// ExpectedCondition to wait for all input type elements : visibilityOfAllElementsLocatedBy
			// assert if the expected length of elements located is 15 
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='carousel-item active']")));
			Assert.assertEquals(elements.size(), 15);
			
			status = "passed";
		} catch (TimeoutException ex) 
		{
			ex.printStackTrace();
		}

	}
	
	@Test(description="WebDriverWait demonstration 2")
	public void testExplicitWait_2()
	{
		// Initialize WebDriverWait with a timeout of 10 seconds
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Navigate to iframe demo page
		driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
		
		try {
			// ExpectedCondition to wait for title to contain given text: titleContains
			wait.until(ExpectedConditions.titleContains("Selenium Playground"));
			System.out.println("Page title is : " + driver.getTitle());
			
			// ExpectedCondition to wait for element using the text : textToBe
			wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(text(),'containing webpage')]"), "Simple iFrame containing webpage"));
		
			// ExpectedCondition to wait for iFrame and switch to it : frameToBeAvailableAndSwitchToIt
			driver = (RemoteWebDriver) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iFrame2")));
		
			// Verify switch to iframe is successful using expected condition by comparing text
			// ExpectedCondition to wait/verify for presence of element by text : textToBePresentInElementLocated
			Boolean iFrame = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(@href,'api-doc')]"), "API"));
			System.out.println("Switched to iframe : " + iFrame);
		
			status = "passed";
		}  catch (TimeoutException ex) 
		{
			ex.printStackTrace();
		}
	}
	
	@Test(description="WebDriverWait demonstration 3")
	public void testExplicitWait_3()
	{
		// Initialize WebDriverWait with a timeout of 10 seconds
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Navigate to iframe demo page
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		
		try {
			
			// Click on the button to get alert
			driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
			
			// ExpectedCondition to wait for alert : alertIsPresent
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert text is : " + driver.switchTo().alert().getText());
			
			status = "passed";
			
		}  catch (TimeoutException ex) 
		{
			ex.printStackTrace();
		}
	}
		
	@Test(description="WebDriverWait demonstration 4")
	public void testExplicitWait_4()
	{
		// Initialize WebDriverWait with a timeout of 10 seconds
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Navigate to iframe demo page
		driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		
		try {
			// check the checkbox to display message
			driver.findElement(By.id("isAgeSelected")).click();
			
			// ExpectedCondition to wait for checkbox to be selected: elementToBeSelected
			wait.until(ExpectedConditions.elementToBeSelected(By.id("isAgeSelected")));
			
			// uncheck the checkbox to hide the message
			driver.findElement(By.id("isAgeSelected")).click();
			
			// ExpectedCondition to wait for element to be invisible : invisibilityOf
			// Verify that the message is invisible now.
			Boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("txtAge"))));
			System.out.println("Messsage is invisible : " + isInvisible);
		
			status = "passed";
		}  catch (TimeoutException ex) 
		{
			ex.printStackTrace();
		}
	}
}
