package com.crm.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicListener implements ITestListener {
	
		ExtentReports report;
		ExtentSparkReporter spark;
		ExtentTest test;

		@Override
		public void onTestStart(ITestResult result) {
			String t_name= result.getMethod().getMethodName();
			Reporter.log(t_name+"is Executed");
			test= report.createTest(t_name);
				
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			String t_name= result.getMethod().getMethodName();
			test.log(Status.PASS, t_name+"is Success");		
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String t_name= result.getMethod().getMethodName();
			test.log(Status.FAIL, t_name+"is failed");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			String t_name= result.getMethod().getMethodName();
			test.log(Status.SKIP, t_name+"is Skipped");
			
		}

		@Override
		public void onStart(ITestContext context) {
			spark = new ExtentSparkReporter("./ExtentReport/ListenersMultiple.html");
			spark.config().setDocumentTitle("SampleReport");
			spark.config().setReportName("Gauri Kenjale");
			spark.config().setTheme(Theme.DARK);
			
			report = new ExtentReports();
			report.setSystemInfo("Os", "Windows11");
			report.setSystemInfo("Browser", "Chrome");
			report.attachReporter(spark);	
			
		}

		@Override
		public void onFinish(ITestContext context) {
			report.flush();
			
		}
		
		

	


}