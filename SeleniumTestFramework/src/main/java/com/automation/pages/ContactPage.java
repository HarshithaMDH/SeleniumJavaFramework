package com.automation.pages;

import com.automation.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BaseTest {

    // Locators
    By contactLink = By.xpath("//a[normalize-space()='Contact']");
    By contactEmailField = By.xpath("//input[@id='recipient-email']");
    By contactNameField = By.xpath("//input[@id='recipient-name']");
    By contactMessageField = By.xpath("//textarea[@id='message-text']");
    By sendMessageButton = By.xpath("//button[normalize-space()='Send message']");

    // Step 1: Click on "Contact" Page
    public void openContactPage() {
        System.out.println("Navigating to Contact Page...");
        //wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
        // Retry logic in case of StaleElementReferenceException
        for (int i = 0; i < 3; i++) {  // Retry up to 3 times
            try {
                WebElement contactElement = wait.until(ExpectedConditions.elementToBeClickable(contactLink));
                contactElement.click();
                System.out.println("Contact Page Opened.");
                break; // Exit loop if click is successful
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Retrying to locate Contact link due to StaleElementReferenceException...");
            }
        }
    }

    // Step 2: Fill Contact Form
    public void enterContactDetails(String name, String email, String message) {
        System.out.println("Filling Contact Form...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNameField)).sendKeys(name);
        driver.findElement(contactEmailField).sendKeys(email);
        driver.findElement(contactMessageField).sendKeys(message);
    }

    // Step 3: Click "Send Message"
    public void submitContactForm() {
        System.out.println("Clicking on Send Message...");
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton)).click();
    }

 // Step 4: Handle Success Popup and return its message
    public String handleSuccessPopup() {
        String alertText = "";
        try {
            System.out.println("Waiting for Success Alert...");
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            System.out.println("Alert Message: " + alertText);
            alert.accept(); // Click OK
            System.out.println("Message Sent Successfully.");
        } catch (Exception e) {
            System.out.println("No alert appeared, proceeding...");
        }
        return alertText;
    }
    }

