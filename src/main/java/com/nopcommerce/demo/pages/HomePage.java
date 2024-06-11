package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    //storing numbers of the locators
    By loginLink = By.linkText("Log in");
    By registerLink = By.linkText("Register");
    By menuList = By.xpath("//ul[@class='top-menu notmobile']/li/a");

    //action method
    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
    //1.1 Click on Computer Menu.
        By computerMenu = By.linkText("Computers");
        By electronicsMenu = By.linkText("Electronics");
        By cellPhoneLink = By.linkText("Cell phones");
        By welcomeText = By.xpath("//h2[contains(text(),'Welcome to our store')]");
        By logOutLink = By.linkText("Log out");
        public void clickOnComputerMenu() {
            clickOnElement(computerMenu);
        }
        public void clickOnElectronicsMenu() {
            clickOnElement(electronicsMenu);
        }
        public String getWelcomeText() {
            return getTextFromElement(welcomeText);
        }
        public void mouseHoverOnElectronics() {
            mouseHoverToElement(electronicsMenu);
        }
        public void mouseHoverOnCellPhoneAndClick() {
            mouseHoverToElementAndClick(cellPhoneLink);
        }
        public void clickOnLogOut() {
            clickOnElement(logOutLink);
        }
        public String getUrl() {
            return driver.getCurrentUrl();
    }
    public List<WebElement> getAllMenus() {
        return getListOfElements(menuList);
    }

//        By laptopAndNoteBookProductList =By.xpath("(//p[@class='price'])");
//        public List<WebElement> getLaptopAndNotebookProductList(){
//            return getListOfElements(laptopAndNoteBookProductList);
//}

}




