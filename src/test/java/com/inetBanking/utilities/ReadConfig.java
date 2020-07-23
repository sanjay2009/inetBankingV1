package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public String getURL()
	{
		String url = properties.getProperty("url");
		return url;
	}
	
	public String getChromeDriver()
	{
		String cDriver = properties.getProperty("chromedriverpath");
		return cDriver;
	}
	
	public String getFirefoxDriver()
	{
		String fDriver = properties.getProperty("firefoxdriver");
		return fDriver;
	}
	
	public String getIEDriver()
	{
		String iDriver = properties.getProperty("ieDriver");
		return iDriver;
	}
	
	public String getUserName()
	{
		String username = properties.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = properties.getProperty("password");
		return password;
	}
	
	public  String addCustomerNameNew()
	{
		String name = properties.getProperty("n");
		return name;
	}
	
	public String dateOfBirthNew()
	{
		String DOB = properties.getProperty("dob");
		return DOB;
	}
	
	public String addressNew()
	{
		String address = properties.getProperty("address");
		return address;
	}
	
	public String cityNew()
	{
		String city = properties.getProperty("city");
		return city;
	}
	
	public String stateNew()
	{
		String state = properties.getProperty("state");
		return state;
	}
	
	public String pinNew()
	{
		String  pinNumber = properties.getProperty("pinno");
		return pinNumber;
	}
	
	public String telNoNew()
	{
		String  telNo = properties.getProperty("telNo");
		return telNo;
	}
	
	public String emailidNew()
	{
		String  emailid = properties.getProperty("emailid");
		return emailid;
	}
}
