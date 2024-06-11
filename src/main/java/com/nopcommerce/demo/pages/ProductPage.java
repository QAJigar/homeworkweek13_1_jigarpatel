package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ProductPage extends Utility {


        By productTitle = By.xpath("//div[@class='page-title']//h1");
        //By.xpath("//h1[contains(text(),'Build your own computer')]");
        By productNameText = By.xpath("//div[@class='product-name']//h1");

        By listView = By.linkText("List");
        // ------------------ For DeskTop Page--------------------------------
        By processorDropdown = By.id("product_attribute_1");
        By ramDropdown = By.id("product_attribute_2");
        By hddRadioButton = By.xpath("//label[contains(text(),'400 GB')]");
        By osRadioButton = By.xpath("//label[contains(text(),'Vista Premium')]");
        By checkBoxMicrosoftOffice = By.xpath("//label[contains(text(),'Microsoft Office')]");
        By checkBoxTotalCommander = By.xpath("//label[contains(text(),'Total Commander')]");
        By price = By.xpath("//div[@class='product-price']/span");
        By addToCartButton = By.xpath("//div[@class='add-to-cart-panel']//button");
                //By.xpath("//button[text()='Add to cart']");
        By greenBarProductNotificationMessage = By.xpath("//div[@class='bar-notification success']");
        By closeBarCrossButton = By.xpath("//span[@title='Close']");
        By hoverShoppingCartLink = By.xpath("//span[@class='cart-label']");
        By goToCartButton = By.xpath("//button[contains(text(),'Go to cart')]");

        // ----------------------------------- Cell-phones page-----------------
        By nokiaLumiaPhone = By.xpath("//a[contains(text(),'Nokia Lumia 1020')]");
    //   By nokiaLumiaPhone = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a");
        By qtyInputField = By.className("qty-input");
       // By addToCartBtn =By.xpath("//div[@class='add-to-cart-panel']//button");
        public String getTitle() {
            return getTextFromElement(productTitle);
        }
        public String getTextFromProductName() {
            return getTextFromElement(productNameText);
        }
        public void selectOptionFromProcessorDropDown(String text) {
            selectByVisibleTextFromDropDown(processorDropdown, text);
        }
        public void selectOptionFromRAMDropDown(String text) {
            selectByVisibleTextFromDropDown(ramDropdown, text);
        }
        public void clickOptionFromHDDRadioButton() {
            clickOnElement(hddRadioButton);
        }
        public void clickOptionFromOSRadioButton() {
            clickOnElement(osRadioButton);
        }
        public void clickOnMicrosoftOfficeCheckBoxOption() {
            clickOnElement(checkBoxMicrosoftOffice);
        }
        public void clickOnSoftwareCheckBoxOption() {
            clickOnElement(checkBoxTotalCommander);
        }
        public String getPrice() {
            return getTextFromElement(price);
        }
        public void clickOnAddToCart() {
            clickOnElement(addToCartButton);
        }
        public String getTexFromGreenBarNotification() {
            return getTextFromElement(greenBarProductNotificationMessage);
        }
        public void clickOnCrossButton() {
            clickOnElement(closeBarCrossButton);
        }
        public void mouseHoverOnShoppingCart() {
            mouseHoverToElement(hoverShoppingCartLink);
        }
        public void clickOnGoToCartButton() {
            clickOnElement(goToCartButton);
        }
        public void clickOnListView() {
            clickOnElement(listView);
        }
        public void clickOnNokiaLumiaLink() {
            clickOnElement(nokiaLumiaPhone);
        }
        public void clearText() {
            clearText(qtyInputField);
        }
        public void sendTextToQty(String text) {
            sendTextToElement(qtyInputField, text);
    }

        public Boolean waitForTotalPriceTextToBeVisible(String text, int time) {
        return waitUntilElementTextToBeVisible(price, text,time);
}
}
