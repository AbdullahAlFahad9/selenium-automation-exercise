package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    // Credentials manually created on https://www.automationexercise.com/
    private String validEmail = "abdulahalfahad9@gmail.com";
    private String validPassword = "12345678";

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://www.automationexercise.com/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        // Step 1: Navigate to Login page
        homePage.clickSignupLogin();

        // Step 2 & 3: Enter registered email, password and submit login form
        loginPage.login(validEmail, validPassword);

        // Step 4: Verify that the login was successful
        Assert.assertTrue(homePage.isLoggedInUserDisplayed(), "Login failed: 'Logged in as username' is not visible.");
        System.out.println("Login status: " + homePage.getLoggedInUserNameText());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}