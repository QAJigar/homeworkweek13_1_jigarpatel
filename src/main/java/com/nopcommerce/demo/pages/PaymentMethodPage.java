package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class PaymentMethodPage extends Utility {


        By creditCardRadioButton = By.xpath("//input[@value='Payments.Manual']");
        By continueButton = By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentMethod.save()']");
        public void clickOnCreditCardRadioButton() {
            clickOnElement(creditCardRadioButton);
        }
        public void clickOnContinueButton() {
            clickOnElement(continueButton);
    }
}
