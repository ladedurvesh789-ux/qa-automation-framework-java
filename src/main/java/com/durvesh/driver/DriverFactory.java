package com.durvesh.driver;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.durvesh.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {

        
        logger.info("Initializing Browser : {}", browser);

        switch (browser.toLowerCase()) {

        case "chrome":

            logger.info("Setting up ChromeDriver");

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            logger.info("Chrome Browser Launched Successfully");

            break;

        case "firefox":

            logger.info("Setting up FirefoxDriver");

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

            logger.info("Firefox Browser Launched Successfully");

            break;

        case "edge":

            logger.info("Setting up EdgeDriver");

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();

            logger.info("Edge Browser Launched Successfully");

            break;

        default:

            logger.error("Unsupported Browser : {}", browser);

            throw new RuntimeException("Browser not supported : " + browser);
        }

        if (Boolean.parseBoolean(ConfigReader.getProperty("maximize"))) {

            driver.manage().window().maximize();

            logger.info("Browser Window Maximized");
        }

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("implicitWait"))));

        logger.info("Implicit Wait Applied");

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("pageLoadTimeout"))));

        logger.info("Page Load Timeout Applied");

        String url = ConfigReader.getProperty("url");

        logger.info("Opening URL : {}", url);

        driver.get(url);

        logger.info("Application Opened Successfully");

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            logger.info("Closing Browser");

            driver.quit();

            logger.info("Browser Closed Successfully");

            driver = null;
        }
    }
}