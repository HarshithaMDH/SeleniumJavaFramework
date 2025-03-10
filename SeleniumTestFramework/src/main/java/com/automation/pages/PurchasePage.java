package com.automation.pages;

import com.automation.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchasePage extends BaseTest {
    // Reference for LoginPage (if needed)
    private LoginPage loginPage;
    
    // Locators
    private By cartLink = By.xpath("//a[normalize-space()='Cart']");  
    private By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");
    private By nameField = By.xpath("//input[@id='name']");
    private By countryField = By.xpath("//input[@id='country']");
    private By cityField = By.xpath("//input[@id='city']");
    private By creditCardField = By.xpath("//input[@id='card']");
    private By monthField = By.xpath("//input[@id='month']");
    private By yearField = By.xpath("//input[@id='year']");
    private By purchaseButton = By.xpath("//button[normalize-space()='Purchase']");
    private By thankYouPopup = By.xpath("//h2[text()='Thank you for your purchase!']");
    private By okButton = By.xpath("//button[normalize-space()='OK']");

    public PurchasePage() {
        this.loginPage = new LoginPage(driver);
    }
    public void refreshPageAfterLogin() {
        System.out.println("Refreshing the page after login...");
        driver.navigate().refresh();
        // Wait for a known element (e.g., Cart link) to ensure the page is reloaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLink));
        System.out.println("Page refreshed successfully.");
    }

    // Step 1: Navigate to Cart with retry logic
    public void goToCart() {
        System.out.println("Navigating to Cart...");
        
        for (int i = 0; i < 3; i++) {
            try {
                WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
                cartElement.click();
                System.out.println("Cart Page Opened.");
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying Cart link due to stale element...");
            }
        }
    }

    // Step 2: Click "Place Order" and wait for the order modal
    public void placeOrder() {
        System.out.println("Clicking on Place Order...");
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        try {
            Thread.sleep(2000); // Wait briefly for modal to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[@id='orderModal']//div[@class='modal-header']")));
        System.out.println("Order Modal Appeared.");
    }

    // Step 3: Fill Purchase Details with scrolling where needed
    public void fillPurchaseDetails(String name, String country, String city, String card, String month, String year) {
        System.out.println("Filling purchase details...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryField)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardField)).sendKeys(card);
        
        // Scroll to the month field
        WebElement monthElement = driver.findElement(monthField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monthElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthField)).sendKeys(month);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearField)).sendKeys(year);
        
        // Scroll to the Purchase button
        WebElement purchaseBtn = driver.findElement(purchaseButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", purchaseBtn);
    }

    // Step 4: Confirm Purchase
    public void confirmPurchase() {
        System.out.println("Clicking on Purchase...");
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }

    // Step 5: Handle Thank You Popup
    public void handleThankYouPopup() {
        System.out.println("Waiting for Thank You popup...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouPopup));
        System.out.println("Clicking OK on popup...");
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }
}
