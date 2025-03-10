# Automation Framework Using Java Selenium

## Overview
This project is an automation testing framework built from scratch using Java, Selenium WebDriver, and TestNG. The framework is designed to be robust, maintainable, and scalable, and it automates test scenarios for the [Demoblaze](https://www.demoblaze.com/) web application.

Tech Stack
Programming Language: Java
Automation Tool: Selenium WebDriver
Test Framework: TestNG
Build Tool: Maven
Reporting: TestNG reports
Data Handling: Excel (Apache POI) & Random Data Utility

Key features include:
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
3.resources/config.properties/─ test-output/ # Generated TestNG HTML reports/-screenshots/ # Screenshots captured on test failures ├pom.xml # Maven configuration file*-README.md

## Prerequisites
- **Java 21 or later**
- **Maven 3.6+**
- **Chrome Browser** (compatible with your ChromeDriver version)
- **Selenium WebDriver 4.11.0**
- **TestNG 7.7.0**
- **Git**

## Setup Instructions
1. **Clone the Repository:**
   git clone <your-public-repository-url>
   
2.Navigate to the Project Directory:
cd SeleniumTestFramework

3.Configure the Framework:
Open src/test/resources/config.properties and update the URL, browser type, and other settings as required.

4.Build the Project:
mvn clean install

5.Run the Tests:
Using Eclipse:
Right-click on testng.xml and select Run As > TestNG Suite.
Using Maven:mvn test

6.View Test Reports:
Open test-output/index.html in your browser to see the TestNG report.

**Test Scenarios and Their Steps**
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

**Reporting & Logging**
TestNG HTML Reports:
TestNG automatically generates HTML reports in the test-output folder.
Screenshots on Failure:
Screenshots are automatically captured on test failures and stored in the screenshots directory.
Logging:
Console logs provide detailed information on test execution steps.

**EXPLANATION FOR FRAMEWORK**
 I have followed an hybrid framework,Where the project have build with maven as the dependency tool ,where the dependent builds are being updated automatically from remote respository if there is any change is the versions of the builds.In addition to that maven gives the default folder structure like src/mian/java ,src/test/java which helps us to maintain the testcripts in a well organized way. 
 
Generic Utility(Utils package) is the one of the component available in the framework which contain several classes which are reuseable and can be used by any projects. 
Excell Utility which is implemented using Apache Poi library to read data from excel or csv files,by which we can run the testscripts with multiple set of data.  
Java Utility ,most of the TCs required methods like system date and random data.

Listener Implementation which is the implementation class of TestNG ITest Listner which is used to capture failure event in the runtime and capture the screenshot in the screenshot folder. 

POM Utility It is a collection of resuable webelements and business library which can be used to specific business or project.Which makes maintainence and modification of webelements are easy. 
 
BaseTest its contain common TestNG configurations annotations which is required for all the testscripts.As per the automation rule every testscripts should extend base class to use those annotations. 

TestScripts are being created using the testNg annotations and make use of the other components. 
Once after the creation of the testcripts ,for executing the TSc in batch we use testng.xml file ie driver file where the execution starts. 
 
Once its executed the reports are being generated in the report-html component.Report helps us to understand the stability of the application and to share to the stakeholders. 
 
POM.xml where all the dependencies are automatically updated,which helps in the seamless execution of the testscripts. 

README.md: This file provides setup instructions, a framework overview, and details about the test cases and reporting.

**Contact Information**
For any queries or issues regarding the framework, please contact:
Harshitha M D
Email: harshithamdgowda98@gmail.com
Repository URL: https://github.com/HarshithaMDH/SeleniumJavaFramework




