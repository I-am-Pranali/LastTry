package com.testCases;


import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver ;
	protected static ExtentReports report ;
	protected static ExtentTest test;
	
	@BeforeClass
	public static void start()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"//test-output//SAUCEReport.html");
		//test = report.startTest("demo");
	}
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");	
	}
	
	public static void takeSS(String filename)
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		//File destFile = new File(System.getProperty("user.dir")+"\\Aaa\\ss1.png");
		File destFile = new File(".\\Aaa\\"+filename+".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@AfterClass
	public void end()
	{
		//report.endTest(test);
		report.flush();
	}
	

}
