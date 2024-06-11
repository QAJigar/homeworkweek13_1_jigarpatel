package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage extends Utility {

        By dropDownSortyBy = By.id("products-orderby");
        By addToCartButton = By.xpath("//div[@data-productid='1']//button[1]");
        By productTitle = By.xpath("//div[@class='page-title']//h1");
        By productList = By.xpath("//h2[@class='product-title']//a");
        By listView = By.linkText("List");
        By nokiaLumiaPhone = By.xpath("//a[contains(text(),'Nokia Lumia 1020')]");

        public void selectDropDownSortBy(String text) {
            selectByVisibleTextFromDropDown(dropDownSortyBy, text);
        }
        public void clickOnAddToCartButton() {
            clickOnElement(addToCartButton);
        }
        public String getTitle() {
            return getTextFromElement(productTitle);
        }
        public void clickOnListView() {
            clickOnElement(listView);
        }

   /* public void clickOnNokiaLumiaLink() {
        clickOnElement(nokiaLumiaPhone);
    }*/
        public List<WebElement> getProductList() {
            return getListOfElements(productList);
        }
        public WebElement waitUntilNokiaLumiaProductToBeClickable() {
            return waitUntilElementToBeClickable(nokiaLumiaPhone, 60);
    }

}
