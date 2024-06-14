package tests;

import org.testng.annotations.AfterMethod;
import testData.PositiveTestUserData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utils.DataProviders;

public class RegistrationTest extends BaseTest{

    @BeforeTest
    public void testPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
    }

    @AfterMethod
    public void testPostconditions() {
        new RegistrationPage(driver).clickToAnmeldenBtnInHeader();
    }

    @Test(dataProvider = "positiveRegistration", dataProviderClass = DataProviders.class)
    public void positiveTestRegistrationWithoutEmailConfirmation(String userName, String userEmail, String userPassword) {
        Assert.assertTrue(new RegistrationPage(driver)
                       .registerUser(userName, userEmail, userPassword)
                       .verifyEmailSendingSuccess());
    }

    @Test(dataProvider = "invalidEmail", dataProviderClass = DataProviders.class)
    public void RegistrationWithInvalidEmail (String userName, String userEmail, String userPassword) {
        Assert.assertTrue(new RegistrationPage(driver)
                .registerUser(userName, userEmail, userPassword)
                .verifyInvalidEmailErrorMessage());
    }

    @Test(dataProvider = "invalidPassword", dataProviderClass = DataProviders.class)
    public void RegistrationWithInvalidPassword (String userName, String userEmail, String userPassword) {
        Assert.assertTrue(new RegistrationPage(driver)
                .registerUser(userName, userEmail, userPassword)
                .verifyInvalidPasswordErrorMessage());
    }

    @Test(dataProvider = "invalidUsername", dataProviderClass = DataProviders.class)
    public void RegistrationWithInvalidUsername (String userName, String userEmail, String userPassword) {
        Assert.assertTrue(new RegistrationPage(driver)
                .registerUser(userName, userEmail, userPassword)
                .verifyInvalidUsernameErrorMessage());
    }

    @Test
    public void RegistrationWithAlreadyExistedEmail () {
        Assert.assertTrue(new RegistrationPage(driver)
                .registerUser(PositiveTestUserData.USERNAME, PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD)
                        .clickToAnmeldenBtnInHeader()
                        .registerUser("KirshCraft", PositiveTestUserData.EMAIL, "Aaa12345")
                .verifyAlreadyExistedEmailErrorMessage());
    }

    @Test
    public void RegistrationWithAlreadyExistedUsername () {
        Assert.assertTrue(new RegistrationPage(driver)
                .registerUser(PositiveTestUserData.USERNAME, PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD)
                .clickToAnmeldenBtnInHeader()
                .registerUser(PositiveTestUserData.USERNAME, "test500@mail.com", "Aaa12345")
                .verifyAlreadyExistedUsernameErrorMessage());
    }

    @Test
    public void RegistrationWithUnsignetCheckbox () {
        Assert.assertTrue(new RegistrationPage(driver)
                .registerNoCeckbox("Turtle", "test600@mail.com", "Aaa12345")
                .verifyUnsignetCheckboxErrorMessage());
    }
}
