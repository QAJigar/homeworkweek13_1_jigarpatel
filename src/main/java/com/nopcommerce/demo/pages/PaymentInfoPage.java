package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class PaymentInfoPage extends Utility {

        By creditCarDropDown = By.id("CreditCardType");
        By cardHolderName = By.id("CardholderName");
        By cardNumber = By.id("CardNumber");
        By expiryMonth = By.id("ExpireMonth");
        By expiryYear = By.id("ExpireYear");
        By cardCode = By.id("CardCode");
        By continueButton = By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentInfo.save()']");
        public void selectCardType(String text) {
            selectByVisibleTextFromDropDown(creditCarDropDown, text);
        }
        public void sendTextToCardHolderName(String text) {
            sendTextToElement(cardHolderName, text);
        }
        public void sendTextToCardNumber(String text) {
            sendTextToElement(cardNumber, text);
        }
        public void selectExpiryMonth(String text) {
            sendTextToElement(expiryMonth, text);
        }
        public void selectExpiryYear(String text) {
            sendTextToElement(expiryYear, text);
        }
        public void sendTextToCardCode(String text) {
            sendTextToElement(cardCode, text);
        }
        public void clickOnContinueButton(){
            clickOnElement(continueButton);
    }

}
