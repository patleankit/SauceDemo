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

public class TC03_VerifyBagProductFunctionality extends TestBaseClass
{
	@Test
	public void verifyBagProductFunctionality() throws IOException
	{	
	//bag product
	HomePOMClass hp = new HomePOMClass(driver);
	hp.clickBagButton();
	ScreenshotClass.takeScreenshot(driver);
	log.info("Bag product will get selected");
	ScreenshotClass.takeScreenshot(driver);
	//--validation--//
	String exceptedProduct = "1";
	String actualProduct = hp.getTextFromAddToCart();
	System.out.println("actual product->"+actualProduct);
	log.info("apply validation");
	Assert.assertEquals(actualProduct,exceptedProduct);	
   
	}
    }
