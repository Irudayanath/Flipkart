package com.FlipkartFramework;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class CaptureScreenshot {
public CaptureScreenshot()
{
	
}
public static void getScreenshot(WebDriver driver,String filepath)
{
	try
	{
	System.out.print("In getScreenShot method");
	TakesScreenshot ts=(TakesScreenshot)driver;
	System.out.print("before getScreenShotsAs");
	File source=ts.getScreenshotAs(OutputType.FILE);
	System.out.print("After GetScreenshotAs");
	FileUtils.copyFile(source,new File(filepath));
	}
	catch(WebDriverException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
public static String getDateTimeStamp()
{
	Date oDate;
	String[] sDatePart;
	String sDateStamp;
	oDate=new Date();
	System.out.print(oDate.toString());
	sDatePart=oDate.toString().split("");
	sDateStamp= sDatePart[5]+"_"+ sDatePart[1] + "_"+sDatePart[2] +"_" +sDatePart[3];
	sDateStamp=sDateStamp.replace(":","__");
	System.out.print(sDateStamp);
	return sDateStamp;
	
}
}
