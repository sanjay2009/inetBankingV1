package com.inetBanking.TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDTTest(String username, String password) throws InterruptedException
	{	
		driver.get(url);
		logger.info("URL is open");
		LoginPage lp= new LoginPage(driver);
		logger.info("Enter userName");
		lp.setUserName(username);
		logger.info("Enter password");
		lp.setPassword(password);
				
		lp.clikSinginButton();
		logger.info("Execution completed");
		
		if(isAlertPresent()==true)
		{
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
		
	}
	
	public boolean isAlertPresent()
	{
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
		
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws Throwable
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/TestCase.xlsx";
		int rownum = XLUtils.getRowCount(path, "data");
		int cellcnt = XLUtils.getCellCount(path, "data", 1);
		
		String logindata[][] = new String[rownum][cellcnt];
		for (int i=1; i<=rownum;i++)
		{
			for (int j=0; j < cellcnt; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "data", i, j);
			}
		}
		return logindata;
	}
	
	

}
