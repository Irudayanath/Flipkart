package com.uipackages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class FindItems {

	WebDriver driver;
	public FindItems(WebDriver driver)
	{
		this.driver=driver;
		
	}
	@FindBy(how=How.XPATH,using="//input[@type=\"text\"]")
	@CacheLookup
	WebElement item;
   
	@FindBy(how=How.XPATH,using="//div[@class=\"_3wU53n\"]")
	@CacheLookup
	WebElement randomq;
	
	@FindBy(how=How.XPATH,using="//button[@class=\"_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c\"]")
	@CacheLookup
	WebElement checkout;
	
	@FindBy(how=How.XPATH,using="//span[@class=\"_35KyD6\"]")
	@CacheLookup
	WebElement ItemName;
	
	@FindBy(how=How.XPATH,using="//div[@class=\"_1vC4OE _3qQ9m1\"]")
	@CacheLookup
	WebElement ItemPrice;
	
	@FindBy(how=How.XPATH,using="//div[@class=\"_325-ji\"]")
	@CacheLookup
	WebElement checkoutname;
	
	@FindBy(how=How.XPATH,using="//span[@class=\"pMSy0p XU9vZa\"]")
	@CacheLookup
	WebElement checkoutprice;
	
	@FindBy(how=How.XPATH,using="//div[@class=\"v7-Wbf\"]")
	@CacheLookup
	WebElement checkoutnameplus;
	
	public void searchitem(String searchitem)
	{
		try
		{
			Thread.sleep(3000);
			item.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");
		    item.sendKeys(searchitem);
		    item.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            
            randomq.click();
            Thread.sleep(5000);
            Set<String> s= driver.getWindowHandles();
            java.util.Iterator<String> it=s.iterator();
            while(it.hasNext())
            {
            	String window=(String) it.next();
                driver.switchTo().window((String) window);

            }
            String iprice=ItemPrice.getText();
            String iname=ItemName.getText();

            checkout.click();
            Thread.sleep(3000);
            try
            {
            //Verifying Selected Item with cart item name and price using assert
            String cname1=checkoutname.getText();
            String ename=checkoutnameplus.getText();
            String concat1="  (";
            String concat2=")";
            String ename1=concat1+ename+concat2;
            String cname=cname1+ename1;
            Assert.assertEquals(cname, iname);
            
            
            String cprice=checkoutprice.getText();
            
            Assert.assertEquals(iprice, cprice);
            
            System.out.print("Ordered and Checkout Item are Same");
            }
            catch(WebDriverException e)
            {
            	e.printStackTrace();
            }
            
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
