package com.durvesh.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.durvesh.reports.ExtentManager;
import com.durvesh.reports.ExtentTestManager;

public class ExtentListener implements ITestListener {

    private ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {

        System.out.println("========== Extent Listener Started ==========");

        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Running Test : " + result.getMethod().getMethodName());

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());

        ExtentTestManager.setTest(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Passed");

        ExtentTestManager.getTest().pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("========== Flushing Report ==========");

        extent.flush();

    }

}