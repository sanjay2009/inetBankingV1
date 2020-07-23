package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentReports extent;
	public ExtentTest elogger;
	public ExtentHtmlReporter htmlReporter;
	
	public void onStart(ITestContext testContext)
	{
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName = "Test-Report-"+timestamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Automation Project"); //title of report
		htmlReporter.config().setReportName("Functional Test Report"); //name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
				
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		elogger = extent.createTest(tr.getName());//create new entry in the report
		elogger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		elogger = extent.createTest(tr.getName());//create new entry in the report
		elogger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f = new File(screenshotPath);
		if(f.exists())
		{
			try {
				elogger.fail("Screenshot is below:" +elogger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		elogger = extent.createTest(tr.getName());
		elogger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onTestFinish(ITestResult tr)
	{
		extent.flush();
	}
	
}
