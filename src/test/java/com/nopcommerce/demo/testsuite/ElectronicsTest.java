package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ElectronicsTest extends BaseTest {

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckOutAsGuestLoginPage checkOutAsGuestLoginPage = new CheckOutAsGuestLoginPage();
        RegisterPage registerPage = new RegisterPage();
        RegistrationResultPage registrationResultPage = new RegistrationResultPage();
        CheckOutBillingPage billingPage = new CheckOutBillingPage();
        ShippingMethodPage shippingMethodPage = new ShippingMethodPage();
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage();
        PaymentInfoPage paymentInfoPage = new PaymentInfoPage();
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
        CheckOutCompletedPage checkOutCompletedPage = new CheckOutCompletedPage();
        ProductListPage productListPage= new ProductListPage();


        @Test
        public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
            //1.1 Mouse Hover on “Electronics” Tab
            homePage.mouseHoverOnElectronics();
            //1.2 Mouse Hover on “Cell phones” and click
            homePage.mouseHoverOnCellPhoneAndClick();
            //1.3 Verify the text “Cell phones”
            String expectedText = "Cell phones";
            String actualText = productPage.getTitle();
            Assert.assertEquals(actualText, expectedText, "title is not displayed");
        }
        @Test
        public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
            //2.1 Mouse Hover on “Electronics” Tab
            homePage.mouseHoverOnElectronics();
            //2.2 Mouse Hover on “Cell phones” and click
            homePage.mouseHoverOnCellPhoneAndClick();
            //2.3 Verify the text “Cell phones”
            String expectedText = "Cell phones";
            String actualText = productPage.getTitle();
            Assert.assertEquals(actualText, expectedText, "title is not displayed");
            //2.4 Click on List View Tab
            productPage.clickOnListView();
            //2.5 Click on product name “Nokia Lumia 1020” link
            WebElement clickOnProduct = productListPage.waitUntilNokiaLumiaProductToBeClickable();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", clickOnProduct);
            //2.6 Verify the text “Nokia Lumia 1020”
            expectedText = "Nokia Lumia 1020";
            actualText = productPage.getTextFromProductName();
            Assert.assertEquals(actualText, expectedText, "Title is not displayed");
            //2.7 Verify the price “$349.00”
            expectedText = "$349.00";
            actualText = productPage.getPrice();
            Assert.assertEquals(actualText, expectedText, "Title is not displayed");
            //2.8 Change quantity to 2
            productPage.clearText();
            productPage.sendTextToQty("2");
            //2.9 Click on “ADD TO CART” tab
            productPage.clickOnAddToCart();
            //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
            expectedText = "The product has been added to your shopping cart";
            actualText = productPage.getTexFromGreenBarNotification();
            Assert.assertEquals(actualText, expectedText, "Notification is not displayed");
            //After that close the bar clicking on the cross button.
            productPage.clickOnCrossButton();
            //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            productPage.mouseHoverOnShoppingCart();
            productPage.clickOnGoToCartButton();
            //2.12 Verify the message "Shopping cart"
            expectedText = "Shopping cart";
            actualText = productPage.getTitle();
            Assert.assertEquals(actualText, expectedText, "Text is not displayed");
            //2.13 Verify the quantity is 2
            expectedText = "2";
            actualText = cartPage.getValueFromQty();
            Assert.assertEquals(actualText, expectedText, "Quantity is incorrect");
            //2.14 Verify the Total $698.00
            expectedText = "$698.00";
            actualText = cartPage.getTotalPrice();
            Assert.assertEquals(actualText, expectedText, "Total is incorrect");
            //2.15 click on checkbox “I agree with the terms of service”
            cartPage.clickOnTermsOfServiceCheckBox();
            //2.16 Click on “CHECKOUT”
            cartPage.clickOnCheckoutButton();
            //2.17 Verify the Text “Welcome, Please Sign In!”
            expectedText = "Welcome, Please Sign In!";
            actualText = checkOutAsGuestLoginPage.getWelcomeSignInText();
            Assert.assertEquals(actualText, expectedText, "Text is not displayed");
            //2.18 Click on “REGISTER” tab
            checkOutAsGuestLoginPage.clickOnRegisterButton();
            //2.19 Verify the text “Register”
            expectedText = "Register";
            actualText = registerPage.getRegisterText();
            //2.20 Fill the mandatory fields
            registerPage.sendTextToFirstName("TestFN");
            registerPage.sendTextToLastName("TestLN");
            registerPage.sendTextToEmail("testfnln114@gmail.com");
            registerPage.sendTextToPassword("test@123");
            registerPage.sendTextToConfirmPassword("test@123");
            //2.21 Click on “REGISTER” Button
            registerPage.clickOnRegisterButton();
            //2.22 Verify the message “Your registration completed”
            expectedText = "Your registration completed";
            actualText = registrationResultPage.getRegistrationCompletedText();
            Assert.assertEquals(actualText, expectedText, "title is not displayed");
            //2.23 Click on “CONTINUE” tab
            registrationResultPage.clickOnContinueButton();
            //2.24 Verify the text “Shopping card”
            expectedText = "Shopping cart";
            actualText = cartPage.getShoppingCartText();
            Assert.assertEquals(actualText, expectedText, "Text is not displayed");
            //2.25 click on checkbox “I agree with the terms of service”
            cartPage.clickOnTermsOfServiceCheckBox();
            //2.26 Click on “CHECKOUT”
            cartPage.clickOnCheckoutButton();
            //2.27 Fill the Mandatory fields
            billingPage.selectOptionFromCountryDropdownField("United Kingdom");
            billingPage.sendTextToCity("testCity");
            billingPage.sendTextToAddress1("test address1");
            billingPage.sendTextToZipCode("test 123");
            billingPage.sendTextToPhoneNumber("03421542167");
            //2.28 Click on “CONTINUE”
            billingPage.clickOnContinueButton();
            //2.29 Click on Radio Button “2nd Day Air ($0.00)”
            shippingMethodPage.clickOnSecondDayAirRadioButton();
            //2.30 Click on “CONTINUE”
            shippingMethodPage.clickOnContinueButton();
            //2.31 Select Radio Button “Credit Card”
            paymentMethodPage.clickOnCreditCardRadioButton();
            paymentMethodPage.clickOnContinueButton();
            //2.32 Select “Visa” From Select credit card dropdown
            paymentInfoPage.selectCardType("Visa");
            //2.33 Fill all the details
            paymentInfoPage.sendTextToCardHolderName("TestFN LN");
            paymentInfoPage.sendTextToCardNumber("4444333322221111");
            paymentInfoPage.selectExpiryMonth("10");
            paymentInfoPage.selectExpiryYear("2028");
            paymentInfoPage.sendTextToCardCode("143");
            //2.34 Click on “CONTINUE”
            paymentInfoPage.clickOnContinueButton();
            //2.35 Verify “Payment Method” is “Credit Card”
            expectedText = "Credit Card";
            actualText = confirmOrderPage.getPaymentMethodText();
            Assert.assertEquals(actualText, expectedText, "Payment method is invalid");
            //2.36 Verify “Shipping Method” is “2nd Day Air”
            expectedText = "2nd Day Air";
            actualText = confirmOrderPage.getShippingMethodText();
            Assert.assertEquals(actualText, expectedText, "Shipping method is not displayed");
            //2.37 Verify Total is “$698.00”
            expectedText = "$698.00";
            actualText = confirmOrderPage.getTotalText();
            Assert.assertEquals(actualText, expectedText, "Total is incorrect");
            //2.38 Click on “CONFIRM”
            confirmOrderPage.clickOnConfirmButton();
            //2.39 Verify the Text “Thank You”
            expectedText = "Thank you";
            actualText = checkOutCompletedPage.getThankYouText();
            Assert.assertEquals(actualText, expectedText, "Title is not displayed");
            //2.40 Verify the message “Your order has been successfully processed!”
            expectedText = "Your order has been successfully processed!";
            actualText = checkOutCompletedPage.getOrderSuccessfullyProcessedText();
            Assert.assertEquals(actualText, expectedText, "text is not displayed");
            //2.41 Click on “CONTINUE”
            checkOutCompletedPage.clickOnContinueButton();
            //2.42 Verify the text “Welcome to our store”
            expectedText = "Welcome to our store";
            actualText = homePage.getWelcomeText();
            Assert.assertEquals(actualText, expectedText, "text is not displayed");
            //2.43 Click on “Logout” link
            homePage.clickOnLogOut();
            //2.44 Verify the URL is “https://demo.nopcommerce.com/”
            String expectedUrl = "https://demo.nopcommerce.com/";
            String actualUrl = homePage.getUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "Url is invalid");
    }
}
