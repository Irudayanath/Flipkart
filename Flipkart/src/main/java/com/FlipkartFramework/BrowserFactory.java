package com.FlipkartFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
public static WebDriver driver;
public BrowserFactory()
{
	
}
public static WebDriver getDriver()
{
	if(driver==null)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		System.setProperty("webdriver.chrome.driver","/Users/Roselin/eclipse-workspace/chromedriver 16");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
		
	}
	return driver;
}
public static WebDriver getDriver(String browsername)
{
	if(driver==null)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.setProperty("webdriver.chrome.driver","/Users/Roselin/eclipse-workspace/chromedriver 16");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			
		}
	}
	return driver;
}
}
