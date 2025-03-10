package com.automation.listeners;

import com.automation.base.BaseTest;
import com.automation.utils.ScreenshotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        ScreenshotUtils.captureScreenshot(result.getName() + "_Failed");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        ScreenshotUtils.captureScreenshot(result.getName() + "_Success");
    }
}
