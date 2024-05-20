package com.test.pom.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.test.constants.MyConstants;
import com.test.pom.factory.DriverManager;
import org.apache.commons.io.FileUtils;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
        if (System.getProperty("browser") == null) {
            System.setProperty("browser", "chrome");
        }
        String browser = System.getProperty("browser");
        switch (browser.toLowerCase()) {
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

    public String takeScreenShot(String screenShotName, WebDriver driver) {
        // take screenshot
        this.driver=driver;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,
                    new File(System.getProperty("user.dir") + "\\screenshots\\" + screenShotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.getProperty("user.dir") + "\\screenshots\\" + screenShotName;
    }
}
