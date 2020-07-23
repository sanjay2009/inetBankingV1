package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCutsomer {
	
	WebDriver driver;
		
	@FindBy(name="name")
	WebElement customerName;
	
	@FindBy(name="dob")
	WebElement dateOfBirth;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	WebElement adress;
	
	@FindBy(name="city")
	WebElement cityName;
	
	@FindBy(name="state")
	WebElement stateName;
	
	@FindBy(name="pinno")
	WebElement pinNumber;
	
	@FindBy(name="telephoneno")
	WebElement telNumber;
	
	@FindBy(name="emailid")
	WebElement emailID;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement addCustomerLink;
	
	@FindBy(linkText="Log out")
	WebElement logout;
	
	public AddNewCutsomer(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
		
	public void customerName(String n)
	{
		customerName.sendKeys(n);
	}
	
	public void customerAddress(String address)
	{
		adress.sendKeys(address);
	}
	
	public void customerCity(String city)
	{
		cityName.sendKeys(city);
	}
	public void customerDOB(String dob)
	{
		dateOfBirth.sendKeys(dob);
	}
	
	public void customerState(String state)
	{
		stateName.sendKeys(state);
	}
	
	public void customerPinno(String pno)
	{
		pinNumber.sendKeys(pno);
	}
	
	public void customerTelno(String telNo)
	{
		telNumber.sendKeys(telNo);
	}
	
	public void customerEmail(String emailid)
	{
		emailID.sendKeys(emailid);
		
	}
	
	public void customerLink()
	{
		addCustomerLink.click();
	}
	
	public void customerlogout()
	{
		logout.click();
	}
}