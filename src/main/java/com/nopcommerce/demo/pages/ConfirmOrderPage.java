package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ConfirmOrderPage extends Utility {

        By paymentMethodText = By.xpath("//li[@class='payment-method']//span[@class='value']");
        By shippingMethodText =By.xpath("//li[@class='shipping-method']//span[@class='value']");
        By totalText =By.xpath("//span[@class='value-summary']//strong");
        By confirmButton =By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; ConfirmOrder.save()']");
        public String getPaymentMethodText(){
            return getTextFromElement(paymentMethodText);
        }
        public String getShippingMethodText(){
            return getTextFromElement(shippingMethodText);
        }
        public String getTotalText(){
            return getTextFromElement(totalText);
        }
        public void clickOnConfirmButton(){
            clickOnElement(confirmButton);
    }
}
