package com.durvesh.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.durvesh.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver() {

        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {

        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;

        default:
            throw new RuntimeException("Browser not supported : " + browser);
        }

        if (Boolean.parseBoolean(ConfigReader.getProperty("maximize"))) {
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("implicitWait"))));

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("pageLoadTimeout"))));

        driver.get(ConfigReader.getProperty("url"));

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
        }
    }

}