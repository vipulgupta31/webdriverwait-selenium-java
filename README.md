# WebDriverWait in Selenium JAVA

## Waits in Selenium
The waits are mostly applied in web automation tests while dealing with dynamic loading webpages or webpages with heavy loading elements that take time to be available for any interaction.

When executing selenium automation tests, we use them to make our tests reliable and robust. Most commonly, while running automation tests, we see 'ElementNotVisibleException' if there is a delay in loading a particular element with which the Webdriver wants to interact.

Waits helps the user overcome various issues while loading elements on a page after performing some action or navigating across different pages in the application. 

## Types of Waits
1. Implicit Wait
2. Explicit Wait
3. Fluent Wait

### Implicit Wait
This default global wait in Selenium is applied to the entire webDriver session. This means that whatever wait time is defined as implicit wait applies to all the web elements.
```
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
```

### Explicit Wait
Explicit waits, unlike implicit waits, provide more precise waits as they are applied to a specific element with the help of ExpectedConditions and WebDriverWait classes. Explicit waits work like a loop, wherein the driver keeps polling at regular intervals to check if the element is located. If the element is located within the defined wait time, the test progresses and fails with a timeout exception if the web element is not found.
```
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.ID("name")));
```

### Fluent Wait
Fluent waits are used to customise explicit waits to implement waits more effectively by providing a customised polling period and an option to handle exceptions better by ignoring them if required. Fluent waits help to define the time interval at which polling would happen in the given timeout range before throwing an error.
```
Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(30))
       .pollingEvery(Duration.ofSeconds(5))
       .ignoring(NoSuchElementException.class);

fluentWait.until(ExpectedConditions.titleContains("LambdaTest"));
```

## About Project
It is created using the latest Selenium 4 features with Java, TestNG and Maven for Web-based automation.

This is the list of tools, being used in this framework:
1. Apache Maven
2. Java 8
3. Selenium Cloud Grid - [LambdaTest](https://www.lambdatest.com) Platform
4. TestNG Framework

## Steps for Execution
1. Import this project in Eclipse/IntelliJ as “Existing Maven Project”
2. Go to TestPageLoadStrategy.java and Run test case for your desired page load strategy
3. You can see the logs coming up on Console as your execution progresses.
4. Since we are using RemoteWebDriver and executing on Cloud Grid platform, LambdaTest, you can login to same and view detailed logs on dashboard.
