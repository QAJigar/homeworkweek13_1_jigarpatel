package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutBillingPage extends Utility {

        By firstNameInputField = By.id("BillingNewAddress_FirstName");
        By latNameInputField = By.id("BillingNewAddress_LastName");
        By emailInputField = By.id("BillingNewAddress_Email");
        By countryDropdownField = By.id("BillingNewAddress_CountryId");
        By cityInputField = By.id("BillingNewAddress_City");
        By address1InputField = By.id("BillingNewAddress_Address1");
        By zipcodeInputField = By.id("BillingNewAddress_ZipPostalCode");
        By phoneNumberInputField = By.id("BillingNewAddress_PhoneNumber");
        By continueButton = By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']");
        public void sendTextToFirstName(String text) {
            sendTextToElement(firstNameInputField, text);
        }
        public void sendTextToLastName(String text) {
            sendTextToElement(latNameInputField, text);
        }
        public void sendTextToEmail(String text) {
            sendTextToElement(emailInputField, text);
        }
        public void selectOptionFromCountryDropdownField(String text) {
            selectByVisibleTextFromDropDown(countryDropdownField, text);
        }
        public void sendTextToCity(String text) {
            sendTextToElement(cityInputField, text);
        }
        public void sendTextToAddress1(String text) {
            sendTextToElement(address1InputField, text);
        }
        public void sendTextToZipCode(String text) {
            sendTextToElement(zipcodeInputField, text);
        }
        public void sendTextToPhoneNumber(String text) {
            sendTextToElement(phoneNumberInputField, text);
        }
        public void clickOnContinueButton() {
            clickOnElement(continueButton);
    }


    }

