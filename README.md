# Automated Testing Framework for the
## _[LEAFGROW](https://leafgrow-app-foign.ondigitalocean.app/#/) Web Application_

## Description: 
This project is a Java-based automated testing framework using Selenium WebDriver, TestNG, and Logback for testing functionalities of a web application related to user registration, login, logout, and account management.

## Features

- Page Object Model: Implemented to maintain a clear separation between test code and page-specific code, enhancing code maintainability and reusability.
- Data-Driven Testing: Utilizes CSV files (emailinvalid.csv, passwordinvalid.csv, etc.) and TestNG data providers (DataProviders class) to run tests with multiple sets of data.
- Logging: Configured with Logback to log test execution details to both console (STDOUT) and files (FILE), allowing for easy debugging and troubleshooting.
- TestNG Suite Configuration: Organizes tests into logical groups (HomePageTest, RegistrationTest, etc.) within testng.xml for streamlined test execution.

## Setup Instructions:
- Prerequisites: JDK (Java Development Kit) Maven (for dependency management) IDE (IntelliJ IDEA, Eclipse, etc.) with TestNG and Maven plugins

- Project Setup: Clone the repository from GitHub: git clone Import the project into your IDE as a Maven project.

- Dependencies: Ensure all dependencies (Selenium WebDriver, TestNG, Logback, etc.) are correctly configured in pom.xml.

## Execution:

> Run tests using TestNG:    
> Right-click on testng.xml ->
> Run as TestNG suite
> View test results in the console
> and log files (src/logs/log-${bySecond}.log)

## Contact:  
##### [Eva Turtschin](https://github.com/EvaTurtschin)


# PROJECT ANALYSIS: 
Project Overview This project appears to be a Selenium-based automation testing framework implemented in Java, using TestNG for test management and Logback for logging. It focuses on testing various functionalities related to user registration, login, logout, and account management on a web application.


### Key Components and Structure Pages Package (src/main/java/pages/):
Contains page objects that model the web pages of the application under test. Each page class encapsulates locators and methods to interact with elements on the page. 
- Examples include HomePage, AnmeldenPage, UserCabinetPage, etc. Tests Package: Houses test classes that verify different aspects of the application's functionality. 
```sh
(src/test/java/tests/)
```
- Tests are categorized based on functionalities like registration (RegistrationTest), login (LoginTest), logout (LogOutTest), etc. 
TestNG annotations are used to define test methods and setup/teardown actions:
```sh
@Test, @BeforeTest, @AfterTest, etc.
```
- Utils Package: Contains utility classes such as DataProviders, which provide test data using CSV files (emailinvalid.csv, passwordinvalid.csv, etc.). 
```sh
src/main/java/utils/
src/test/resources/
```
These data providers are used in test classes to run tests with multiple sets of data.

- Test Data: Includes CSV files (emailinvalid.csv, passwordinvalid.csv, etc.) that store different test data sets. Data providers in DataProviders class read these CSV files to supply data for parameterized tests. Configuration:

```sh
src/test/java/tests/BaseTest.java, src/test/resources/testng.xml, src/main/resources/logback.xml
```
- BaseTest.java: Contains setup and teardown methods using TestNG annotations to initialize WebDriver, manage test execution, and handle logging:
```sh
@BeforeSuite, @AfterSuite, etc.
```
- TestNG suite configuration that specifies which test classes to include (HomePageTest, RegistrationTest, etc.). 
 ```sh
 testng.xml:  
 ```
 - Logback configuration for logging to console (STDOUT) and file (FILE), with timestamp-based file naming and rolling file management.
 ```sh
 logback.xml: 
```

BaseTest.java: Contains setup and teardown methods using TestNG annotations (@BeforeSuite, @AfterSuite, etc.) to initialize WebDriver, manage test execution, and handle logging.
testng.xml: TestNG suite configuration that specifies which test classes to include (HomePageTest, RegistrationTest, etc.).
logback.xml: Logback configuration for logging to console (STDOUT) and file (FILE), with timestamp-based file naming and rolling file management.

#### License

MIT
