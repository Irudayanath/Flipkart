package com.uipackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Flipkartlogin {
WebDriver driver;
public Flipkartlogin(WebDriver driver)
{
	this.driver=driver;
}



@FindBy(how=How.XPATH,using="//div[@class=\"_39M2dM JB4AMj\"]/input[@type=\"text\"]")
@CacheLookup
WebElement username;

@FindBy(how=How.XPATH,using="//input[@type=\"password\"]")
@CacheLookup
WebElement password;

@FindBy(how=How.XPATH,using="//div[@class=\"_1avdGP\"]/button[@type=\"submit\"]")
WebElement login;

@FindBy(how=How.XPATH,using="///div[@class=\"_2aUbKa\"][1]")
@CacheLookup
WebElement Verifypageload;

public void login(String use,String pass)
{
	try
	{
		Thread.sleep(5000);
		username.sendKeys(use);
		Thread.sleep(3000);
		password.sendKeys(pass);
		Thread.sleep(3000);
		login.click();
		Thread.sleep(5000);
	
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
}
}
