package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.MenuPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends BaseTest {
    
    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        List<WebElement> menus = homePage.getAllMenus();
        try {
            for (WebElement menuOption : menus) {
                if (menuOption.getText().equalsIgnoreCase(menu)) {
                    menuOption.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            menus = homePage.getAllMenus();
        }
    }

    //1.2 This method should click on the menu whatever name is passed as parameter.
    //1.3. create the @Test method name verifyPageNavigation.use
    // selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() {
        String expectedMenuText = "Electronics";
        selectMenu(expectedMenuText);
        String actualMenuText = menuPage.getMenuText();
        Assert.assertEquals(actualMenuText, expectedMenuText, "user is not navigated to expected page");
    }

}
