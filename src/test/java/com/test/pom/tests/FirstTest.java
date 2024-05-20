package com.test.pom.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.constants.MyConstants;
import com.test.pom.base.BaseTest;
import com.test.pom.objects.BillingAddress;
import com.test.pom.objects.Product;
import com.test.pom.pages.CartPage;
import com.test.pom.pages.CheckOutPage;
import com.test.pom.pages.HomePage;
import com.test.pom.pages.StorePage;
import com.test.pom.utils.JacksonUtils;

public class FirstTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        // Readable but more lines of code
        /*
         * BillingAddress billingAddress = new BillingAddress();
         * //builder pattern
         * billingAddress.setFirstName("John")
         * .setLastName("Doe")
         * .setAddressLineOne("13230")
         * .setCity("Monroe")
         * .setZip("98272")
         * .setPhone("1234567890")
         * .setEmail("ravi@test.com");
         */

        // not readable but less lines of code using constructor both are same
        /*
         * BillingAddress billingAddress = new BillingAddress("John", "Doe", "13230",
         * "Monroe", "98272", "ravi@test.com",
         * "1234567890");
         */

        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

        // getting data from products.json ..logic in product
        Product product = new Product(1215);
        String productName = product.getName();
        HomePage homePage = new HomePage(driver);

        // loading home page
        homePage.load(MyConstants.BASE_URL);

        // navigating to store menu
        StorePage storePage = homePage.navigateToStoreMenu();

        // searching for product
        storePage.SearchProduct("blue");

        // verifying search results
        Assert.assertEquals(storePage.getSearchTitle(), "Search results: “blue”");

        // adding product to cart
        storePage.addToCart("Blue Shoes");
        // Thread.sleep(2000);
        // navigating to cart page
        CartPage cartPage = storePage.viewCart();

        // verifying product in cart
        Assert.assertEquals(cartPage.getProductName(), productName);

        CheckOutPage checkOutPage = cartPage.checkOut().setBillingAddress(billingAddress).placeOrder();

        // verifying order confirmation
        Assert.assertTrue(
                checkOutPage.getConfirmationMessage().contains("Thank you. Your order has been received."));

    }
}
