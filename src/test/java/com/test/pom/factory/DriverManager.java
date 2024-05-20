package com.test.pom.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    public WebDriver initializeDriver(String browser) {
        WebDriver driver = null;
        if (browser.equals("chrome")) {
            // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        } else if (browser.equals("msedge")) {
            System.out.println("Firefox Browser");
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser");
        }
        if (driver != null) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}
