package com.Testpackages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.FlipkartFramework.BrowserFactory;
import com.FlipkartFramework.CaptureScreenshot;
import com.uipackages.FindItems;
import com.uipackages.Flipkartlogin;
import com.uipackages.Logout;

public class TestCaseClass extends Helperclass {
public TestCaseClass()
{
	
}
@Test
public void Flipkart()
{
	try
	{
		System.out.print("Flipkart");
		Thread.sleep(3000);
		driver.get("https://flipkart.com");
		Flipkartlogin fp=PageFactory.initElements(driver,Flipkartlogin.class);
		Thread.sleep(3000);
		fp.login("irudayanath@gmail.com","123pass");
		FindItems fi=PageFactory.initElements(driver,FindItems.class);
		fi.searchitem("camera");
		Logout l=PageFactory.initElements(driver, Logout.class);
		String Orderdetails=System.getProperty("user.dir")+"\\"+"ScreenShots\\orderdetails - "+CaptureScreenshot.getDateTimeStamp()+".png";
		try
		{
			CaptureScreenshot.getScreenshot(BrowserFactory.getDriver(),Orderdetails);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		l.logoutpress();		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
