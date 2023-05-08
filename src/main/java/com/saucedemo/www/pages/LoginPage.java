package com.saucedemo.www.pages;

import com.saucedemo.www.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "user-name")
    WebElement usernameField;
//    By usernameField = By.id("user-name");

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;
//    By passwordField = By.id("password");

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;
    //By loginButton = By.id("login-button");

    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement text;
    //By text = By.xpath("//span[@class='title']");

//    @CacheLookup
//    @FindBy(xpath = "//a/div")
//    WebElement productNumber;
    By productNumber = By.xpath("//a/div");

    public void enterUserName(String userName) {
        sendTextToElement(usernameField, userName);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String verifyText() {
        return getTextFromElement(text);
    }

    public int actualNumberOfProductDisplayed() {
        List<WebElement> product = driver.findElements(productNumber);
        return product.size();
    }

}
