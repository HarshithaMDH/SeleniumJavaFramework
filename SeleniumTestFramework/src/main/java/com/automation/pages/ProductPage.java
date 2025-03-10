package com.automation.pages;

import com.automation.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BaseTest { // Inherit BaseTest to use wait
	
	LoginPage loginPage; // Creating reference for LoginPage

    public ProductPage() {
        loginPage = new LoginPage(driver); // Initialize LoginPage with driver from BaseTest
    }

    // Locators
    By laptopsCategory = By.xpath("//a[contains(text(),'Laptops')]");
    By laptopItem = By.xpath("//a[normalize-space()='Sony vaio i7']"); // Change laptop name if needed
    By addToCartButton = By.xpath("//a[normalize-space()='Add to cart']");
    By cartLink = By.xpath("//a[normalize-space()='Cart']");
    
    // Step 1: Click on Laptops Category with wait
    public void clickLaptopsCategory() {
        System.out.println("Clicking on Laptops category...");
        wait.until(ExpectedConditions.presenceOfElementLocated(laptopsCategory));
        wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();
    }

    // Step 2: Scroll down to find the laptop and click
    public void selectLaptop() {
        System.out.println("Scrolling to find the laptop...");
        WebElement laptopElement = wait.until(ExpectedConditions.visibilityOfElementLocated(laptopItem));

        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", laptopElement);
        
        System.out.println("Clicking on selected laptop...");
        laptopElement.click();
    }

    // **Updated Step 3: Click "Add to Cart" with retry mechanism**
    public void addToCart() {
        System.out.println("Waiting for Add to Cart button...");

        for (int i = 0; i < 3; i++) { // Retry up to 3 times
            try {
                WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add to cart']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
                addToCartButton.click();

                System.out.println("Waiting for alert popup...");
                wait.until(ExpectedConditions.alertIsPresent());

                System.out.println("Handling alert popup...");
                driver.switchTo().alert().accept();  // Clicking OK on alert
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught! Retrying...");
            
        }
        }
    }

}


    
    
           /*Navigate to Cart with retry logic
            public void goToCart() {
            	System.out.println("Refreshing the page...");
                driver.navigate().refresh();
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
             // Validate that the product is displayed in the cart
                public boolean isProductDisplayed(String productName) {
                    System.out.println("Validating product is displayed in Cart...");
                    return driver.getPageSource().contains(productName);
                }*/
    
        
    

