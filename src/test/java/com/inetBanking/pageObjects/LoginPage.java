package com.inetBanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(name="uid")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[5]/a")
	WebElement logoutButton;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void getUserName(String username)
	{
		userName.sendKeys(username);
	}
	
	public void setUserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void getUpassWord(String password)
	{
		passWord.sendKeys(password);
	}
	
	public void setPassword(String pwd)
	{
		passWord.sendKeys(pwd);
	}
	
	public void clikSinginButton()
	{
		loginButton.sendKeys(Keys.ENTER);
	}
	
	public void clickLogout()
	{
		logoutButton.click();
	}
}
