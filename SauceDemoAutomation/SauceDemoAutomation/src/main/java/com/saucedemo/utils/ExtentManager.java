package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public final class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager() {}

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            new File("test-output").mkdirs();
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");
            reporter.config().setDocumentTitle("SauceDemo Automation Report");
            reporter.config().setReportName("Selenium Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Application", "SauceDemo");
            extent.setSystemInfo("Framework", "Selenium + Java + TestNG");
        }
        return extent;
    }
}
