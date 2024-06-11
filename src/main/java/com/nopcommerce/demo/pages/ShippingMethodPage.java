package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShippingMethodPage extends Utility {

        By nextDayAirShippingMethod = By.xpath("//label[contains(text(),'Next Day Air')]");
        By continueButton =By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; ShippingMethod.save()']");
        By secondDayAirRadioButton = By.id("shippingoption_2");

        public void clickOnNextDayAirRadioButton(){
            clickOnElement(nextDayAirShippingMethod);
        }
        public void clickOnSecondDayAirRadioButton(){
            clickOnElement(secondDayAirRadioButton);
        }
        public void clickOnContinueButton(){
            clickOnElement(continueButton);
}

}
