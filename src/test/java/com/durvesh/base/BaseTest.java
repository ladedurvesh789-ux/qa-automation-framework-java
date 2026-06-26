package com.durvesh.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.durvesh.driver.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        driver = DriverFactory.initializeDriver(browser);

    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();

    }

}