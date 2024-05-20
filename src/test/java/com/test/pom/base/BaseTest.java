package com.test.pom.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.test.constants.MyConstants;
import com.test.pom.factory.DriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
        if(System.getProperty("browser") == null) {
            System.setProperty("browser", "chrome");
        }
        String browser = System.getProperty("browser");
        switch (browser) {
            case "chrome":
                MyConstants.BROWSER = "chrome";
                break;
            case "msedge":
                MyConstants.BROWSER = "msedge";
                break;
            case "firefox":
                MyConstants.BROWSER = "firefox";
                break;
            default:
                throw new IllegalArgumentException("Invalid Browser");
        }
        driver = new DriverManager().initializeDriver(MyConstants.BROWSER);

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
        driver.quit();
    }
}
