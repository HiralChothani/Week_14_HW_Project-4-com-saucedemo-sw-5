package com.saucedemo.www.testsuite;

import com.saucedemo.www.customlisteners.CustomListeners;
import com.saucedemo.www.pages.LoginPage;
import com.saucedemo.www.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValid() {
        // Enter “standard_user” username
        loginPage.enterUserName("standard_user");
        //Enter “secret_sauce” password
        loginPage.enterPassword("secret_sauce");
        //  Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        //  Verify the text “PRODUCTS”
        String expectedText = "Products";
        Assert.assertEquals(loginPage.verifyText(), expectedText, "Text not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username
        loginPage.enterUserName("standard_user");
        //Enter “secret_sauce” password
        loginPage.enterPassword("secret_sauce");
        //  Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        //  Verify that six products are displayed on page
        int expectedNumberOfProductDisplayed = 6;
        Assert.assertEquals(loginPage.actualNumberOfProductDisplayed(), expectedNumberOfProductDisplayed);
    }
}
