package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.SignupPage;
import com.automation.utils.RandomDataUtils;
import org.testng.annotations.*;

public class SignUpTest extends BaseTest {
    SignupPage signupPage;

    @BeforeMethod
    public void setupTest() {
        setup();
        signupPage = new SignupPage();
    }

    @DataProvider(name = "SignupData")
    public Object[][] getSignupData() {
        return new Object[][] {
            { RandomDataUtils.getUsername(), RandomDataUtils.getPassword() },
            { RandomDataUtils.getUsername(), RandomDataUtils.getPassword() },
            { RandomDataUtils.getUsername(), RandomDataUtils.getPassword() }
        };
    }

    @Test(dataProvider = "SignupData")
    public void testSignup(String username, String password) {
        System.out.println("Starting Signup Test for: " + username);

        signupPage.clickSignup();
        signupPage.enterSignupDetails(username, password);
        signupPage.submitSignup();
        signupPage.handleSignupPopup();

        signupPage.navigateToHome();
        signupPage.scrollToBottomAndClickNext();

        System.out.println("Signup Test Completed for: " + username);
    }

    @AfterMethod
    public void cleanupTest() {
        tearDown();
    }
}
