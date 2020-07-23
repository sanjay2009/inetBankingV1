package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.pageObjects.LoginPage;

public class LoginTC001 extends BaseClass{
	
	@Test(priority = 1)
	public void loginTest() throws Throwable
	{
		driver.get(url);
		logger.info("URL is open");
		LoginPage loginTC = new LoginPage(driver);
		loginTC.getUserName(username);
		logger.info("Entered Username");
		loginTC.getUpassWord(password);
		logger.info("Entered Password");
		loginTC.clikSinginButton();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("LoginTC001 Passes!!!!");
		}
		else
		{	
			captureScreenShot(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("LoginTC001 Failed!!!");
		}
		
		
		
	}

}
