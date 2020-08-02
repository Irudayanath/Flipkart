package com.Testpackages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.FlipkartFramework.BrowserFactory;

public class Helperclass {
public static WebDriver driver;
BrowserFactory obj1;
public Helperclass()
{
	
}
@BeforeSuite
public void beforeSuite()
{
	
}
@BeforeClass
public void beforeClass()
{
	System.out.print("In Beforeclass");
}
@BeforeTest
public void BeforeMethod()
{
	System.out.print("in @BeforeMethod");
	Helperclass.driver=BrowserFactory.getDriver("chrome");
}
@AfterMethod
public void close()
{
	
}
@AfterClass
public void afterclass()
{
	
}
@AfterSuite
public void aftersuite() throws IOException
{
	driver.quit();
}
}
