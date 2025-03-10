# Automation Framework Using Java Selenium

## Overview
This project is an automation testing framework built from scratch using Java, Selenium WebDriver, and TestNG. The framework is designed to be robust, maintainable, and scalable, and it automates test scenarios for the [Demoblaze](https://www.demoblaze.com/) web application. Key features include:

- **Page Object Model (POM):** Separates page-specific actions from test logic.
- **Data-Driven Testing:** Uses random data generation (via `RandomDataUtils`) to eliminate hardcoded values.
- **Detailed Reporting:** Generates TestNG HTML reports (located in the `test-output` folder) and captures screenshots on failures.
- **Meaningful Logging and Error Handling:** Uses console logging and retry logic to enhance stability.
- **Cross-Browser Support:** Configurable through the `config.properties` file.
- **Version Control:** Managed via Git and hosted on a public repository.

## Framework Structure
SeleniumTestFramework
1.src/main/java/─ com.automation.base─ BaseTest.java/com.automation.pages/── LoginPage.java/ProductPage.java/PurchasePage.java /ContactPage.java/com.automation.utils/── ExcelUtils.java/── RandomDataUtils.java
2.src/test/java/-com.automation.tests/-LoginTest.java/-AddToCartTest.java/─ PurchaseTest.java/─ ContactTest.java
3.resources/config.properties/─ test-output/ # Generated TestNG HTML reports ├── screenshots/ # Screenshots captured on test failures ├── pom.xml # Maven configuration file*-README.md

## Prerequisites
- **Java or later**
- **Maven 3.6+**
- **Chrome Browser** (compatible with your ChromeDriver version)
- **Selenium WebDriver 4.11.0**
- **TestNG 7.7.0**
- **Git**

## Setup Instructions
1. **Clone the Repository:**
   sh
   git clone <your-public-repository-url>
   
Navigate to the Project Directory:

cd SeleniumTestFramework

Configure the Framework:

Open src/test/resources/config.properties and update the URL, browser type, and other settings as required.

Build the Project:
mvn clean install

Run the Tests:
Using Eclipse:
Right-click on testng.xml and select Run As > TestNG Suite.
Using Maven:mvn test

View Test Reports:
Open test-output/index.html in your browser to see the TestNG report.
Test Scenarios and Their Steps
1. Login Test(LoginTest.java)(Login to application by entering username and password and click on login button)
Objective: Validate that the user can successfully log in.
Steps:
Launch the Application: The URL is read from config.properties.
Click on the Login Link: Use the LoginPage object to click the login link.
Enter Credentials: Input the username and password from config.properties or from a data provider.
Submit the Login Form: Click the login button.
Validation: Assert that the page contains a "Welcome" message or another element that confirms successful login.

2. Add to Cart(AddToCart.java)(Login, go to cart link, select product then click on add to cart)
Objective: Automate the process of selecting a product and verifying it is added to the cart.
Steps:
Login: The user logs in with valid credentials.
Navigate to the Laptops Category: Use the ProductPage object to click the Laptops category.
Select a Product: Choose a specific product (e.g., "Sony Vaio i7") by scrolling to it and clicking.
Add Product to Cart: Click the "Add to Cart" button and handle any confirmation alerts.
Refresh and Navigate to Cart: Refresh the page after adding the product, then click on the Cart link.
Validation: Assert that the cart page displays the added product by checking for the product name (e.g., "Sony Vaio i7").

3. Signup(SignTest.java)(sign up to application by entering name, email, and password, and validate)
Objective: Automate the signup process and the subsequent contact form submission.
Steps:
Signup:
Click on the signup link.
Enter random username and password (using RandomDataUtils).
Submit the signup form.
Handle the signup confirmation popup.
Navigate to Home Page:
After signup, click on the Home link and ensure the home page loads.
scroll down to till get the next button
then click on next button

4.Contact(ContactTest.java)(Login, click on contact link, provide the data then send a message, validate)
Login: The user logs in with valid credentials.
Contact Form Submission:
Click on the Contact link.
Fill the contact form with random contact name, email, and message (using RandomDataUtils).
Click on "Send message."
Handle the confirmation popup (alert).
Validation: Assert that the confirmation alert text matches the expected success message (e.g., "Thanks for the message").

5.Purchase(PurchaseTest.java)(Login, go to cart, click on place order, provide all the data, click place order button, validate)
Login: The user logs in with valid credentials.
Refresh the page
click on cart page, wait till naviagte to cart page
click on place order button
input the all the field get data from randomdata page
clcik on placeorder
handle place order popup
validate the popup using alert

Reporting & Logging
TestNG HTML Reports:
TestNG automatically generates HTML reports in the test-output folder.
Screenshots on Failure:
Screenshots are automatically captured on test failures and stored in the screenshots directory.
Logging:
Console logs provide detailed information on test execution steps.


README.md: This file provides setup instructions, a framework overview, and details about the test cases and reporting.

Contact Information
For any queries or issues regarding the framework, please contact:
Harshitha M D
Email: harshithamdgowda98@gmail.com

