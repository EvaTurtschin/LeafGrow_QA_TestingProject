package tests;

import org.testng.annotations.AfterMethod;
import testData.PositiveTestUserData;
import utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

    @BeforeTest
    public void TestPreconditions () {
        new HomePage(driver).NavigateToHomePage();
        new HomePage(driver).ClickAnmeldenBtnInHeader();
    }

    @AfterMethod
    public void TestPostconditions () {
        new HomePage(driver).NavigateToHomePage();
    }

    @Test
    public void PositiveTestRegistrationWithoutEmailConfirmation () {
        Assert.assertTrue(new RegistrationPage(driver)
                       .RegisterUser(PositiveTestUserData.USERNAME, PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD)
                       .VerifyEmailSendingSuccess());
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
