package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.constants.MyConstants;
import com.test.pom.base.BaseTest;
import com.test.pom.pages.CartPage;
import com.test.pom.pages.CheckOutPage;
import com.test.pom.pages.ConfirmationPage;
import com.test.pom.pages.HomePage;
import com.test.pom.pages.StorePage;

public class FirstTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        
        HomePage homePage = new HomePage(driver);
        homePage.load(MyConstants.BASE_URL);
        StorePage storePage = homePage.clickStoreMenuLink();
        // builder pattern enterSearchText returns the object of the same class
        // storePage.enterSearchText(null, "blue").clickSearchButton()

        // functional page object pattern
        storePage.search("blue");
        Assert.assertEquals(storePage.getSearchTitle(), "Search results: “blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(2000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();
        ConfirmationPage confirmationPage = checkOutPage.
        enterFirstName("John").
        enterLastName("Doe").
        selectCountry().
        enterAddress("13230").
        enterCity("Monroe").
        enterZip("98272").
        enterPhone("1234567890").
        enterEmail("ravi@test.com").
        enterZip("98272").
        clickPlaceOrderButton();
        Assert.assertTrue(
                confirmationPage.getConfirmationMessage().contains("Thank you. Your order has been received."));

    }
}
