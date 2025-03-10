package com.automation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginTest extends BaseTest {

	    @BeforeMethod
	    public void startTest() {
	        setup();
	    }

	    @Test
	    public void testValidLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(
	                By.xpath("//a[@id='nava']"), "PRODUCT STORE"));
	        Assert.assertTrue(driver.getPageSource().contains("PRODUCT STORE"));
	    }

	    @AfterMethod
	    public void endTest() {
	        tearDown();
	    }
}
	
