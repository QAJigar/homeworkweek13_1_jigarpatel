package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class RegistrationResultPage extends Utility {

        By resultText = By.xpath("//div[@class='result'][contains(text(),'registration completed')]");
        By registerContinueButton = By.className("register-continue-button");

        public String getRegistrationCompletedText() {
            return getTextFromElement(resultText);
        }

        public void clickOnContinueButton() {
            clickOnElement(registerContinueButton);
    }
}
