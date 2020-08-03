package com.Testpackages;


import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.FlipkartFramework.BrowserFactory;
import com.FlipkartFramework.CaptureScreenshot;
import com.uipackages.FindItems;
import com.uipackages.Flipkartlogin;
import com.uipackages.Logout;
public class TestCaseClass extends Helperclass{
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
	    
		Thread.sleep(3000);
	
		String file=new File("File/MailDB.xlsx").getAbsolutePath();
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook xb=new XSSFWorkbook(fs);
		XSSFSheet sh=xb.getSheetAt(0);

        
	
		Row row = sh.getRow(0);
		String username =row.getCell(0).toString();
		
		String password=row.getCell(1).toString();
		String search=row.getCell(2).toString();
	
		
		driver.get("https://flipkart.com");
	    Flipkartlogin fp=PageFactory.initElements(driver,Flipkartlogin.class);
	   
		fp.login(username,password);
		FindItems fi=PageFactory.initElements(driver,FindItems.class);
		fi.searchitem(search);
		Logout l=PageFactory.initElements(driver, Logout.class);
		String Orderdetails=System.getProperty("user.dir")+"\\"+"Screenshot - "+CaptureScreenshot.getDateTimeStamp()+".png";
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
