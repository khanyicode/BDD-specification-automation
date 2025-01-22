package com.parabank.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final String BASE_URL = "https://parabank.parasoft.com/parabank/index.htm";

    protected void setUp() {
        // Configure ChromeOptions to resolve websocket connection issues
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void navigateToHomePage() {
        driver.get(BASE_URL);
    }
}
