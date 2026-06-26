package com.durvesh.base;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.durvesh.driver.DriverFactory;

public class BaseTest {
	
    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(getClass());
    
    @BeforeMethod
    public void setUp() {

        logger.info("========== Test Started ==========");

        driver = DriverFactory.initializeDriver();

        logger.info("Browser launched successfully");

    }

    @AfterMethod
    public void tearDown() {

        logger.info("Closing browser");

        DriverFactory.quitDriver();

        logger.info("========== Test Finished ==========");

    }
}