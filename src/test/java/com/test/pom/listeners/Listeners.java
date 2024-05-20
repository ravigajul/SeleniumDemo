package com.test.pom.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.pom.base.BaseTest;
import com.test.pom.extentreports.Reporter;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = Reporter.getExtentReport();
    ExtentTest test;
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass(result.getMethod().getMethodName());
        // test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        /*
         * try {
         * driver = (WebDriver)
         * result.getTestClass().getRealClass().getField("driver").get(result.
         * getInstance());
         * } catch (Exception e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         * // take screenshot and attach to report
         * String filePath = takeScreenShot(result.getMethod().getMethodName() +
         * ".png",driver);
         * test.addScreenCaptureFromPath(filePath);
         */
        test.fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
