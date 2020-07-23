package com.inetBanking.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;



public class BaseClass {
	
	
	public static WebDriver driver;
	public static Logger logger;
		
	ReadConfig read = new ReadConfig();
		
	public String url = read.getURL();
	public String username= read.getUserName();
	public String password = read.getPassword();
	
	public String n = read.addCustomerNameNew();
	public String dob = read.dateOfBirthNew();
	public String address = read.addressNew();
	public String city = read.cityNew();
	public String state = read.stateNew();
	public String pinno = read.pinNew();
	public String telNo = read.telNoNew();
	public String emailid = read.emailidNew();
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String bro) 
	{
		if (bro.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", read.getChromeDriver());
			
			driver = new ChromeDriver();
		}
		
		else if (bro.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", read.getFirefoxDriver());
			
			driver = new FirefoxDriver();
		}
		
		else if (bro.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", read.getIEDriver());
			driver = new InternetExplorerDriver();
		}
		
		driver.get(read.getURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
		
		
	}
	
	@AfterClass
	public void teadDown() throws Throwable
	{
		
		driver.close();
		
	}
	
	public void captureScreenShot(WebDriver driver, String tname) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target =  new File(System.getProperty("user.dir") + "/Screenshots/" + tname +".png"); 
		FileUtils.copyFile(source, target);
		System.out.println("Screen shot taken");
		
	}

}
