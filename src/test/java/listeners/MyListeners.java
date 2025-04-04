package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.CommonUtils;
import utils.ElementUtilities;

public class MyListeners implements ITestListener {
	
	ExtentReports report;
	ExtentTest extentTest;
	WebDriver driver;
	
	
	@Override
	public void onStart(ITestContext context) {
		 report = CommonUtils.getExtentReports();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		 extentTest = report.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName()+"Test got Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getName()+"Test got Failed");
		try {
		 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch (Exception e) {
			e.printStackTrace();
		}
		String screenshotFilePath = new ElementUtilities(driver).captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(screenshotFilePath);
		extentTest.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getName()+"Test got Skipped");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\Reports\\ExtentReports.html");
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
