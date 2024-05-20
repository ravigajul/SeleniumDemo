package com.test.pom.base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected final By overlay = By.cssSelector("div.blockUI.blockOverlay");
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void load(String url) {
        driver.get(url);
    }

    public void explicitlyWaitForElementToDisappear(By elementLocator) {
        List<WebElement> elements = driver.findElements(elementLocator);
        if (elements.size() > 0) {
            // explicit wait
            System.out.println("Overlay's noted " + elements.size());
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.invisibilityOfAllElements(elements));
        }
    }

    public void fluentlyWaitForElementToDisappear(By elementLocator) {
        List<WebElement> elements = driver.findElements(elementLocator);
        if (elements.size() > 0) {
            System.out.println("Overlay's noted " + elements.size());
            // fluent wait
            new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.invisibilityOfAllElements(elements));
        }
    }

    public void fluentlyWaitForElementToAppear(By elementLocator) {
        List<WebElement> elements = driver.findElements(elementLocator);
        if (elements.size() > 0) {
            System.out.println("Overlay's noted " + elements.size());
            // fluent wait for element to be visible
            new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfAllElements(elements));

        }
    }
}
