package com.SauceDemo.TestClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClass.HomePOMClass;
import com.SauceDemo.POMClass.LoginPOMClass;
import com.SauceDemo.POMClass.TestBaseClass;
import com.SauceDemo.UtilityClass.ScreenshotClass;

public class TC02_VerifyLogOutFunctionality extends TestBaseClass
{
	@Test
	public void VerifyLogOutFunctionality() throws IOException, InterruptedException 
	{	
	HomePOMClass hp = new HomePOMClass (driver);
	hp.clickMenuButton();	
	log.info("Clicked on menu button");
	hp.clickLogOutButton();
	log.info("Clicked on LogOut button");
	ScreenshotClass.takeScreenshot(driver);
	log.info("apply the validation");		
    String expectedTitle = "Swag Labs";    //dev/BA			
    String actualTitle = driver.getTitle();
    System.out.println(actualTitle);
    Assert.assertEquals(actualTitle, expectedTitle);
  }
  }
