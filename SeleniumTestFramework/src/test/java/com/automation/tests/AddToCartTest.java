package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    private ProductPage productPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void startTest() {
        setup();
        productPage = new ProductPage();
        loginPage = new LoginPage(driver); // Initialize LoginPage with driver
    }

    @Test
    public void testLoginAndAddToCart() throws InterruptedException {
        System.out.println("Starting Login and Add to Cart Test...");

        // Step 1: Perform Login
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(2000); // Allow page to refresh and stabilize

        // Step 2: Click on Laptops Category
        productPage.clickLaptopsCategory();

        // Step 3: Select Laptop and scroll into view
        productPage.selectLaptop();

        // Step 4: Add the selected product to the Cart
        productPage.addToCart();

        System.out.println(" Add to Cart Test Completed Successfully.");
    }

    @AfterMethod
    public void endTest() {
        tearDown();
    }
}
