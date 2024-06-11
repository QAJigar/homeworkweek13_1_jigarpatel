package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {

        By pageTitle =By.xpath("//h1[contains(text(),'Register')]");
        By firstName =By.id("FirstName");
        By lastName =By.id("LastName");
        By email = By.id("Email");
        By password=By.id("Password");
        By confirmPassword=By.id("ConfirmPassword");
        By registerButton = By.id("register-button");

        public String getRegisterText(){
            return getTextFromElement(pageTitle);
        }
        public void sendTextToFirstName(String text){
            sendTextToElement(firstName,text);
        }
        public void sendTextToLastName(String text){
            sendTextToElement(lastName,text);
        }
        public void sendTextToEmail(String text){
            sendTextToElement(email,text);
        }
        public void sendTextToPassword(String text){
            sendTextToElement(password,text);
        }
        public void sendTextToConfirmPassword(String text){
            sendTextToElement(confirmPassword,text);
        }
        public void clickOnRegisterButton(){
            clickOnElement(registerButton);
        }
    }


