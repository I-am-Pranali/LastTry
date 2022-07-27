package com.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.testCases.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) {
		test = report.startTest(result.getName());
		test.log(LogStatus.FAIL, "Test case is failed ");
	
		takeSS(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.startTest(result.getName());
		test.log(LogStatus.PASS, "Test case is passed ");
	}
	

}
