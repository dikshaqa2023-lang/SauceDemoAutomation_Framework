package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

public class ExtentListener implements ITestListener {
    private static final ExtentReports EXTENT = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        TEST.set(EXTENT.createTest(
                result.getTestClass().getName() + " - " +
                result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TEST.get().fail(result.getThrowable());
        String path = ScreenshotUtil.captureScreenshot(
                result.getMethod().getMethodName() + "_" + System.currentTimeMillis());
        if (!path.isEmpty()) {
            try {
                TEST.get().addScreenCaptureFromPath(path);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TEST.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        EXTENT.flush();
    }
}
