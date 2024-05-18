package com.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.pom.base.BasePage;

public class ConfirmationPage extends BasePage{

    private final By confirmationReceived = By.cssSelector(".woocommerce-thankyou-order-received");
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }   
    public String getConfirmationMessage() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(confirmationReceived).getText();
    }

}
