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

public void logoutpress()
{
	driver.navigate().back();
	logout.click();
}
}
