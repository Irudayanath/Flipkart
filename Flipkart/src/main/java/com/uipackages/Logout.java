package com.uipackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Logout {
	WebDriver driver;
public Logout(WebDriver driver)
{
	this.driver=driver;
}

@FindBy(how=How.XPATH,using="//button[@class=\"_3Jk8fm\"]")
@CacheLookup
WebElement logout;


@FindBy(how=How.XPATH,using="//a[@class=\"_2fqf-l\"]")
@CacheLookup
WebElement logoutcomplete;
public void logoutpress() throws InterruptedException
{
	
	logout.click();
	Thread.sleep(3000);
	logoutcomplete.click();
	Thread.sleep(3000);
}
}
