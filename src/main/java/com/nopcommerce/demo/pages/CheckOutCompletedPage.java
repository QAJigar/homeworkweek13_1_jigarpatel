package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutCompletedPage extends Utility {

        By thankYouText = By.xpath("//h1[contains(text(),'Thank you')]");
        By orderSuccessfullyProcessedText = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
        By continueButton = By.xpath("//button[normalize-space()='Continue']");
        public String getThankYouText() {
            return getTextFromElement(thankYouText);
        }
        public String getOrderSuccessfullyProcessedText() {
            return getTextFromElement(orderSuccessfullyProcessedText);
        }
        public void clickOnContinueButton() {
            clickOnElement(continueButton);
    }
}
