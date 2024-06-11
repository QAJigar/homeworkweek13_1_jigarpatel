package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerTest extends BaseTest {

        HomePage homePage = new HomePage();
        MenuPage menuPage = new MenuPage();
        ProductListPage productListPage = new ProductListPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckOutAsGuestLoginPage checkOutAsGuestLoginPage = new CheckOutAsGuestLoginPage();
        CheckOutBillingPage billingPage = new CheckOutBillingPage();
        ShippingMethodPage shippingMethodPage = new ShippingMethodPage();
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage();
        PaymentInfoPage paymentInfoPage = new PaymentInfoPage();
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
        CheckOutCompletedPage checkOutCompletedPage = new CheckOutCompletedPage();

        @Test
        public void verifyProductArrangeInAlphaBaticalOrder () {
            //1.1 Click on Computer Menu.
            homePage.clickOnComputerMenu();
            // 1.2 Click on Desktop
            menuPage.clickOnDeskTopLink();
            //before sorting products
            List<WebElement> products = productListPage.getProductList();
            List<String> productNamesBeforeSort = new ArrayList<>();
            for (WebElement e : products) {
                productNamesBeforeSort.add(e.getText());
            }
            //sort products in ascending order
            Collections.sort(productNamesBeforeSort);
            // System.out.println(productNamesBeforeSort);
            //1.3 Select Sort By position "Name: Z to A"
            productListPage.selectDropDownSortBy("Name: Z to A");
            //product list after sorting by 'Product Name'
            products = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
            List<String> productNamesAfterSort = new ArrayList<>();
            for (WebElement e : products) {
                productNamesAfterSort.add(e.getText());
            }
            //1.4 Verify the Product will arrange in Descending order.
            Assert.assertEquals(productNamesAfterSort, productNamesBeforeSort, "products are not sorted by Name:Z to A");

//            //  List<WebElement> originalProductList = ;
//            //1.3 Select Sort By position "Name: Z to A"
//            productListPage.selectDropDownSortBy("Name: Z to A");
//            //1.4 Verify the Product will arrange in Descending order.

        }

        @Test
        public void verifyProductAddedToShoppingCartSuccessFully () {
            //2.1 Click on Computer Menu.
            homePage.clickOnComputerMenu();
            //2.2 Click on Desktop
            menuPage.clickOnDeskTopLink();
            //2.3 Select Sort By position "Name: A to Z"
            productListPage.selectDropDownSortBy("Name: A to Z");
            //2.4 Click on "Add To Cart"
            //WebElement addToCartButton = productListPage.waitUntilAddToCartButtonToBeClickable(60);
            //        JavascriptExecutor js = (JavascriptExecutor) driver;
            //        js.executeScript("arguments[0].click();", addToCartButton);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-productid='1']//button[1]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", addToCartButton);
            //desktopsPage.clickOnAddTocartButton();
            //2.5 Verify the Text "Build your own computer"
            String expectedText = "Build your own computer";
            String actualText = productPage.getTextFromProductName();
            Assert.assertEquals(actualText, expectedText, "Title is not displayed");
            //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
            productPage.selectOptionFromProcessorDropDown("2.2 GHz Intel Pentium Dual-Core E2200");
            //2.7.Select "8GB [+$60.00]" using Select class.
            productPage.selectOptionFromRAMDropDown("8GB [+$60.00]");
            //2.8 Select HDD radio "400 GB [+$100.00]"
            productPage.clickOptionFromHDDRadioButton();
            //2.9 Select OS radio "Vista Premium [+$60.00]"
            productPage.clickOptionFromOSRadioButton();
            //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
            //productPage.clickOnMicrosoftOfficeCheckBoxOption();
            productPage.clickOnSoftwareCheckBoxOption();
            //2.11 Verify the price "$1,475.00"
            String expectedPrice = "$1,475.00";
            productPage.waitForTotalPriceTextToBeVisible("$1,475.00",60);
            String actualPrice = productPage.getPrice();
            Assert.assertEquals(actualPrice, expectedPrice, "Incorrect price");
            //2.12 Click on "ADD TO CARD" Button.
            productPage.clickOnAddToCart();
            //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
            productPage.getTexFromGreenBarNotification();
            //After that close the bar clicking on the cross button.
            productPage.clickOnCrossButton();
            //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            productPage.mouseHoverOnShoppingCart();
            productPage.clickOnGoToCartButton();
            //2.15 Verify the message "Shopping cart"
            expectedText = "Shopping cart";
            actualText = cartPage.getShoppingCartText();
            Assert.assertEquals(actualText, expectedText, "Title is not displayed");
            //2.16 Change the Qty to "2" and Click on "Update shopping cart"
            cartPage.updateQty();
            //2.17 Verify the Total"$2,950.00"
            String expectedTotal = "$2,950.00";
            String actualTotal = cartPage.getTotalPrice();
            Assert.assertEquals(actualTotal, expectedTotal, "Incorrect total");
            //2.18 click on checkbox “I agree with the terms of service”
            cartPage.clickOnTermsOfServiceCheckBox();
            //2.19 Click on “CHECKOUT”
            cartPage.clickOnCheckoutButton();
            //2.20 Verify the Text “Welcome, Please Sign In!”
            expectedText = "Welcome, Please Sign In!";
            actualText = checkOutAsGuestLoginPage.getWelcomeSignInText();
            Assert.assertEquals(actualText, expectedText, "Title is not displayed");
            //2.21Click on “CHECKOUT AS GUEST” Tab
            checkOutAsGuestLoginPage.clickOnCheckOutAsGuestButton();
            //2.22 Fill the all mandatory field
            billingPage.sendTextToFirstName("TestFirstName");
            billingPage.sendTextToLastName("TestLastName");
            billingPage.sendTextToEmail("testfnln123@gmail.com");
            billingPage.selectOptionFromCountryDropdownField("United Kingdom");
            billingPage.sendTextToCity("London");
            billingPage.sendTextToAddress1("110,Test Road");
            billingPage.sendTextToZipCode("T12 6UA");
            billingPage.sendTextToPhoneNumber("08954324021");
            //2.23 Click on “CONTINUE”
            billingPage.clickOnContinueButton();
            //2.24 Click on Radio Button “Next Day Air($0.00)”
            shippingMethodPage.clickOnNextDayAirRadioButton();
            //2.25 Click on “CONTINUE”
            shippingMethodPage.clickOnContinueButton();
            //2.26 Select Radio Button “Credit Card”
            paymentMethodPage.clickOnCreditCardRadioButton();
            paymentMethodPage.clickOnContinueButton();
            //2.27 Select “Master card” From Select credit card dropdown
            paymentInfoPage.selectCardType("Master card");
            //2.28 Fill all the details
            paymentInfoPage.sendTextToCardHolderName("test fn ln");
            paymentInfoPage.sendTextToCardNumber("5555555555554444");
            paymentInfoPage.selectExpiryMonth("12");
            paymentInfoPage.selectExpiryYear("2030");
            paymentInfoPage.sendTextToCardCode("843");
            //2.29 Click on “CONTINUE”
            paymentInfoPage.clickOnContinueButton();
            //2.30 Verify “Payment Method” is “Credit Card”
            expectedText = "Credit Card";
            actualText = confirmOrderPage.getPaymentMethodText();
            Assert.assertEquals(actualText, expectedText, "Payment method is incorrect");
            //2.32 Verify “Shipping Method” is “Next Day Air”
            expectedText = "Next Day Air";
            actualText = confirmOrderPage.getShippingMethodText();
            Assert.assertEquals(actualText, expectedText, "shipping method is incorrect");
            //2.33 Verify Total is “$2,950.00”
            expectedText = "$2,950.00";
            actualText = confirmOrderPage.getTotalText();
            Assert.assertEquals(actualText, expectedText, "Total in invalid");
            //2.34 Click on “CONFIRM”
            confirmOrderPage.clickOnConfirmButton();
            //2.35 Verify the Text “Thank You”
            expectedText = "Thank you";
            actualText = checkOutCompletedPage.getThankYouText();
            Assert.assertEquals(actualText, expectedText, "Text is not displayed");
            //2.36 Verify the message “Your order has been successfully processed!”
            expectedText = "Your order has been successfully processed!";
            actualText = checkOutCompletedPage.getOrderSuccessfullyProcessedText();
            Assert.assertEquals(actualText, expectedText, "text is not displayed");
            //2.37 Click on “CONTINUE”
            checkOutCompletedPage.clickOnContinueButton();
            //2.37 Verify the text “Welcome to our store”
            expectedText = "Welcome to our store";
            actualText = homePage.getWelcomeText();
            Assert.assertEquals(actualText, expectedText, "Text is not displayed");

        }
    }
