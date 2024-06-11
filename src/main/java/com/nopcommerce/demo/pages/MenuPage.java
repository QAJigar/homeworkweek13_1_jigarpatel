package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class MenuPage extends Utility {

    By menuText = By.xpath("//div[@class='page-title']/h1");
    By desktopLink = By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']");
    public void clickOnDeskTopLink() {
        clickOnElement(desktopLink);
    }
    public String getMenuText() {
        return getTextFromElement(menuText);
}

}
