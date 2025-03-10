package com.automation.pages;

import com.automation.base.BaseTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends BaseTest {

    // Locators for Signup
    By signupButton = By.xpath("//a[text()='Sign up']");
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By signupSubmitButton = By.xpath("//button[normalize-space()='Sign up']");
    By signupSuccessPopup = By.xpath("//div[contains(text(),'Sign up successful')]");
    By okButton = By.xpath("//button[text()='OK']");

    // Locators for Navigation & Scrolling
    By homeButton = By.xpath("//li[@class='nav-item active']//a[@class='nav-link']");
    By nextButton = By.xpath("//button[text()='Next']");

    // Step 1: Click Signup
    public void clickSignup() {
        System.out.println("Clicking on Signup...");
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    // Step 2: Enter Username & Password
    public void enterSignupDetails(String username, String password) {
        System.out.println("Entering Signup Details...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    // Step 3: Click Signup Button
    public void submitSignup() {
        System.out.println("Clicking on Signup Button...");
        wait.until(ExpectedConditions.elementToBeClickable(signupSubmitButton)).click();
    }

 // Step 4: Handle Signup Success Popup
    public void handleSignupPopup() {
        try {
            System.out.println("Waiting for Signup Success Alert...");
            
            // Wait for the alert to be present
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert and get its text
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Message: " + alert.getText());

            // Accept the alert (click OK)
            alert.accept();
         // Add a small wait to ensure the page reloads before moving forward
            Thread.sleep(2000);
            System.out.println("Alert handled successfully.");
        } catch (Exception e) {
            System.out.println("No alert appeared, proceeding...");
        }
    }

    
    // Step 5: Navigate to Home Page
    public void navigateToHome() {
        System.out.println("Navigating to Home Page...");
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
    }

    // Step 6: Scroll Down to Load More Products
    public void scrollToBottomAndClickNext() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Scrolling Down...");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
