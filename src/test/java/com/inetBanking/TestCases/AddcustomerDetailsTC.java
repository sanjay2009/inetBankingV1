package com.inetBanking.TestCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCutsomer;
import com.inetBanking.pageObjects.BaseClass;
import com.inetBanking.pageObjects.LoginPage;

public class AddcustomerDetailsTC extends BaseClass {
	
	
	@Test
	public void addNewCustomerDetails() throws Throwable
	{	
		
		LoginPage loginTC = new LoginPage(driver);
		loginTC.getUserName(username);
		logger.info("Entered Username");
		loginTC.getUpassWord(password);
		logger.info("Entered Password");
		loginTC.clikSinginButton();
		
		AddNewCutsomer ncd = new AddNewCutsomer(driver);
		ncd.customerLink();
		ncd.customerName(n);
		ncd.customerDOB(dob);
		ncd.customerAddress(address);
		ncd.customerCity(city);
		ncd.customerState(state);
		//ncd.customerPinno(pno);
		ncd.customerTelno(telNo);
		ncd.customerEmail(emailid);
		logger.info("cusomer details entered");
		ncd.customerlogout();
		driver.switchTo().alert().accept();
	}
	
	

}
