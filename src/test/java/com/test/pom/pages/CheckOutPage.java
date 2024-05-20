package com.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.pom.base.BasePage;
import com.test.pom.objects.BillingAddress;

public class CheckOutPage extends BasePage {
    private final By firstName = By.id("billing_first_name");
    private final By lastName = By.id("billing_last_name");
    private final By countryDropDown = By.id("select2-billing_country-container");
    private final By countryOption = By.xpath("//li[text()='United States (US)']");
    private final By address = By.id("billing_address_1");
    private final By city = By.id("billing_city");
    private final By zip = By.id("billing_postcode");
    private final By phone = By.id("billing_phone");
    private final By email = By.id("billing_email");
    private final By radioDirectTransfer = By.id("payment_method_bacs");
    private final By placeOrderBtn = By.id("place_order");
    private final By confirmationReceived = By.cssSelector(".woocommerce-thankyou-order-received");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String text) {
        driver.findElement(firstName).sendKeys(text);
        return this;
    }

    public CheckOutPage enterLastName(String text) {
        driver.findElement(lastName).sendKeys(text);
        return this;
    }

    public CheckOutPage selectCountry() throws InterruptedException {
        driver.findElement(countryDropDown).click();
        Thread.sleep(2000);
        driver.findElement(countryOption).click();
        return this;
    }

    public CheckOutPage enterAddress(String text) {
        driver.findElement(address).clear(); // clear the address field before entering the address (this is a bug fix
        driver.findElement(address).sendKeys(text);
        return this;
    }

    public CheckOutPage enterCity(String text) {
        driver.findElement(city).clear(); // clear the address field before entering the city (this is a bug fix
        driver.findElement(city).sendKeys(text);
        return this;
    }

    public CheckOutPage enterZip(String text) {
        driver.findElement(zip).clear(); // clear the address field before entering the zip code (this is a bug fix
        driver.findElement(zip).sendKeys(text);
        return this;
    }

    public CheckOutPage enterPhone(String text) {
        driver.findElement(phone).clear(); // clear the address field before entering the phone number (this is a bug
                                           // fix
        driver.findElement(phone).sendKeys(text);
        return this;
    }

    public CheckOutPage enterEmail(String text) {
        driver.findElement(email).sendKeys(text);
        return this;
    }

    public CheckOutPage selectDirectTransfer() {
        driver.findElement(radioDirectTransfer).click();
        return this;
    }

    public CheckOutPage placeOrder() {
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public CheckOutPage setBillingAddress(BillingAddress billingaddress) throws InterruptedException {
        enterFirstName(billingaddress.getFirstName()).enterLastName(billingaddress.getLastName()).selectCountry()
                .enterAddress(billingaddress.getAddressLineOne()).enterCity(billingaddress.getCity())
                .enterZip(billingaddress.getZip()).enterPhone(billingaddress.getPhone())
                .enterEmail(billingaddress.getEmail());
        return this;
    }

    public String getConfirmationMessage() {
        fluentlyWaitForElementToAppear(confirmationReceived);
        return driver.findElement(confirmationReceived).getText();
    }

}
