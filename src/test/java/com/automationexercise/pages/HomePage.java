package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By loggedInUserText = By.xpath("//a[contains(text(),'Logged in as')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    public boolean isLoggedInUserDisplayed() {
        return driver.findElement(loggedInUserText).isDisplayed();
    }

    public String getLoggedInUserNameText() {
        return driver.findElement(loggedInUserText).getText();
    }
}