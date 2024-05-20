package com.test.pom.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

    public static ExtentReports getExtentReport() {
        ExtentSparkReporter extentSparkReporter;
        ExtentReports extentReports;
        String reportPath = System.getProperty("user.dir") + "\\target\\reports\\index.html";
        extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setReportName("AutomationTestResults"); // this is the title of the report
        extentSparkReporter.config().setDocumentTitle("TestReport"); // this is the name of the report

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter); // attaching the reporter to the extent object
        extentReports.setSystemInfo("Tester", "RaviGajul"); // setting the system info
        return extentReports;
    }
}
