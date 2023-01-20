package com.crm.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Takescreenshotwhenitsfailed implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		 test = report.createTest(methodname);
		 Reporter.log(methodname+"-----method started excuted");
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"method is successs");
		Reporter.log("method got excuted successs");
	}

	public void onTestFailure(ITestResult result) {
//		WebdriverUtility welib=new WebdriverUtility();
//		try {
//			welib.getScreenShot(baseClass.sdriver, "Screenshot"+ new JavaUtility().getSystemDateAndTimeInFormat());
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String Screenshot = result.getMethod().getMethodName();
		String Sc="Screenshot"+ new JavaUtility().getSystemDateAndTimeInFormat();
		EventFiringWebDriver wb=new EventFiringWebDriver(baseClass.sdriver);
		File src=wb.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+Sc+".png");
		String path = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL,result.getThrowable());
		Reporter.log("method got failed");
	}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"---method got skipped");
		Reporter.log("method got skipped");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./report/Report.html");
		htmlreport.config().setDocumentTitle("SDET-45 PROJECT REPORT");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("ProudEdu");
		
		 report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("project", "proudedu");
		report.setSystemInfo("windows", "lenovo");
		report.setSystemInfo("reportname", "mohammed ashir");
		report.setSystemInfo("url", "https://localhost:8888");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	

}
