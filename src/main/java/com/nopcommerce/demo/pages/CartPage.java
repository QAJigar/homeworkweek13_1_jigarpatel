package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CartPage extends Utility {


        By shoppingCartTitle = By.xpath("//h1[contains(text(),'Shopping cart')]");
        By qty =By.className("up");
        By totalPrice = By.xpath("//span[@class='value-summary']//strong");
        By agreementCheckBox= By.id("termsofservice");
        By checkoutButton =By.id("checkout");
        By qtyValue= By.xpath("//input[@class='qty-input']");
        public String getShoppingCartText(){
            return getTextFromElement(shoppingCartTitle);
        }
        public void updateQty(){
            clickOnElement(qty);
        }
        public String getValueFromQty(){
            return getAttributeFromElement(qtyValue,"value");
        }
        public String getTotalPrice(){
            return getTextFromElement(totalPrice);
        }
        public void clickOnTermsOfServiceCheckBox(){
        clickOnElement(agreementCheckBox);
        }
        public void clickOnCheckoutButton(){
            clickOnElement(checkoutButton);
    }

}
