package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.ContactPage;
import com.automation.pages.LoginPage;
import com.automation.utils.RandomDataUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
public class ContactTest extends BaseTest {
    ContactPage contactPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        setup();
        contactPage = new ContactPage();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testContactFormSubmission() {
        System.out.println("Starting Contact Form Test...");

        // Step 1: Login
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        // Step 2: Open Contact Page
        contactPage.openContactPage();

        // Step 3: Fill and Submit Contact Form
        contactPage.enterContactDetails(
                RandomDataUtils.getContactName(), 
                RandomDataUtils.getContactEmail(), 
                RandomDataUtils.getContactMessage()
                
        );
       contactPage.submitContactForm();

        // Step 4: Handle Success Popup
       /* contactPage.handleSuccessPopup();
        System.out.println("Contact Form Test Completed Successfully.");*/
     // Step 4: Handle Success Popup and capture the alert message
        String alertMsg = contactPage.handleSuccessPopup();
        
     // Assert that the alert message contains the expected text (trim spaces)
        Assert.assertTrue(alertMsg.trim().contains("Thanks for the message"),
                "Contact form submission failed: expected success message not found. Actual: '" + alertMsg + "'");

        System.out.println("Contact Form Test Completed Successfully.");
    }

    @AfterMethod
    public void cleanupTest() {
        tearDown();
    }
}
