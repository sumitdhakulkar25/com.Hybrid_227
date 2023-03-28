package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utils.DriverUtils;

public class MyListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	
	}

	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS,"Test is passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test is failede");
        String path=DriverUtils.getScreenshot(result.getName());
        test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Test is skip");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
         report.flush();		
	}

}
