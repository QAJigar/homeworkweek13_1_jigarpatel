package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutAsGuestLoginPage extends Utility {

        By welcomeSignInText =By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
        By checkoutAsGuestButton =By.xpath("//button[contains(text(),'Checkout as Guest')]");
        By checkOutRegisterButton =By.className("register-button");
        public String getWelcomeSignInText(){
            return getTextFromElement(welcomeSignInText);
        }
        public  void clickOnCheckOutAsGuestButton(){
            clickOnElement(checkoutAsGuestButton);
        }
        public void clickOnRegisterButton(){
            clickOnElement(checkOutRegisterButton);
    }
}
