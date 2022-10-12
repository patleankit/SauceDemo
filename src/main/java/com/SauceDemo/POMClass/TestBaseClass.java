package com.SauceDemo.POMClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.UtilityClass.ScreenshotClass;

public class TestBaseClass
    {   
	public WebDriver driver;
	public Logger log = Logger.getLogger("SauceDemo1");
	@Parameters("browserName")
    @BeforeMethod
    public void setUp(String browserName) throws IOException
    {
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","./DriverFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else 
		{
			System.setProperty("webdriver.gecko.driver","./DriverFiles\\geckodriver.exe");			
			driver =  new FirefoxDriver();
		}
		
		PropertyConfigurator.configure("log4j.properties");
		
	log.info("browser is opened");
	driver.manage().window().maximize();
	log.info("browser is maximized");	
	driver.get("https://www.saucedemo.com/");
	log.info("SauceDemo URL is opened");
	//take screesnhot
	ScreenshotClass.takeScreenshot(driver);	
 	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	//loginPage elements find +action perform
	LoginPOMClass x = new LoginPOMClass(driver);	
	x.sendUsername();
	log.info("username is entered");	
	x.sendPassword();
	log.info("Password is entered");	
	x.clickOnLoginButton();
	log.info("Clicked on login button");   
	ScreenshotClass.takeScreenshot(driver);			
    } 
    @AfterMethod
    public void tearDown()
    {
    driver.quit();
    log.info("browser is closed");
       
    log.info("end of Program");	
  }
}
