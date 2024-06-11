package tests;

import org.testng.annotations.AfterMethod;
import testData.PositiveTestUserData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

    @BeforeTest
    public void testPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
    }

    @AfterMethod
    public void testPostconditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void positiveTestRegistrationWithoutEmailConfirmation() {
        Assert.assertTrue(new RegistrationPage(driver)
                       .registerUser(PositiveTestUserData.USERNAME, PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD)
                       .verifyEmailSendingSuccess());
    }

//    @Test
//    public void RegistrationWithInvalidEmail () {
//        Assert.assertTrue(new RegistrationPage(driver)
//                .RegisterUser("J", "mail", "Aaa12345")
//                .VerifyInvalidEmailErrorMessage());
//    }

//    @Test
//    public void RegistrationWithInvalidPassword () {
//        Assert.assertTrue(new RegistrationPage(driver)
//                .RegisterUser("J", "mail", "Aaa12345")
//                .VerifyInvalidPasswordErrorMessage());
//    }

//    @Test
//    public void RegistrationWithInvalidUsername () {
//        Assert.assertTrue(new RegistrationPage(driver)
//                .RegisterUser("J", "mail", "Aaa12345")
//                .VerifyInvalidUsernameErrorMessage());
//    }

//    @Test
//    public void RegistrationWithAlreadyExistedEmail () {
//        Assert.assertTrue(new RegistrationPage(driver)
//                .RegisterUser("J", "mail", "Aaa12345")
//                .VerifyAlreadyExistedEmailErrorMessage());
//    }

//    @Test
//    public void RegistrationWithAlreadyExistedUsername () {
//        Assert.assertTrue(new RegistrationPage(driver)
//                .RegisterUser("J", "mail", "Aaa12345")
//                .VerifyAlreadyExistedUsernameErrorMessage());
//    }

//    @Test
//    public void RegistrationWithUnsignetCheckbox () {
//        Assert.assertTrue(new RegistrationPage(driver)
//                .RegisterUser("J", "mail", "Aaa12345")
//                .VerifyUnsignetCheckboxErrorMessage());
//    }



}
