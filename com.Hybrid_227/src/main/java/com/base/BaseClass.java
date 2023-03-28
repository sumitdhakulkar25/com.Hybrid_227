package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.PropertiesUtils;

public class BaseClass {
	public static WebDriver driver=null;
	public static ExtentReports report =null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;

	
	public static void initilization() throws Exception {
		
		String browser=PropertiesUtils.readProperty("browser");
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","chromedrivernew.exe");
		driver=new ChromeDriver();
		}
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","chromedrivernew.exe");
			driver=new FirefoxDriver();
		}
		driver.get(PropertiesUtils.readProperty("url"));
		driver.manage().window().maximize();
	}
	  public void reportInit() {
		  report=new ExtentReports();
		  spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
	      report.attachReporter(spark);
	  }
}
