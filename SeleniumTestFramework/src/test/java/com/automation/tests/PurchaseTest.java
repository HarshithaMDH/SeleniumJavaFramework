package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.PurchasePage;
import com.automation.utils.ExcelUtils;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    LoginPage loginPage;
    PurchasePage purchasePage;

    @BeforeMethod
    public void startTest() {
        setup();
        loginPage = new LoginPage(driver);
        purchasePage = new PurchasePage();
    }

    @Test
    public void testPurchaseWithExcelData() throws InterruptedException {
        System.out.println("Starting Purchase Test using Excel Data...");
        
        // Step 1: Perform Login
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
        // Step 2: Refresh the page after login to ensure elements are reloaded
        purchasePage.refreshPageAfterLogin();
        
        // Load Excel file with purchase data
        ExcelUtils.loadExcel("PurchaseData");
        // Read data from Excel
        String name = ExcelUtils.getCellData(1, 0);     // First data row, column 0
        String country = ExcelUtils.getCellData(1, 1);
        String city = ExcelUtils.getCellData(1, 2);
        String card = ExcelUtils.getCellData(1, 3);
        String month = ExcelUtils.getCellData(1, 4);
        String year = ExcelUtils.getCellData(1, 5);

        // Step 3: Perform purchase action
        purchasePage.goToCart();
        purchasePage.placeOrder();
        purchasePage.fillPurchaseDetails(name, country, city, card, month, year);
        purchasePage.confirmPurchase();
        purchasePage.handleThankYouPopup();

     // Validate that the purchase was successful (the confirmation message appears)
        Assert.assertTrue(driver.getPageSource().contains("Thank you for your purchase!"),
            "Purchase failed: Confirmation message not found.");
        
        // Close Excel file
        ExcelUtils.closeExcel();
    }

    @AfterMethod
    public void endTest() {
        tearDown();
    }
}
