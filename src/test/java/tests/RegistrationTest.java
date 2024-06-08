package tests;

import utils.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

    @BeforeTest
    public void TestPreconditions () {
        new HomePage(driver).NavigateToHomePage();
        new HomePage(driver).ClickAnmeldenBtnInHeader();
    }

    @AfterTest
    public void TestPostconditions () {
        new AnmeldenPage(driver).LogoutUser();
        new HomePage(driver).NavigateToHomePage();
    }

    @Test(dataProvider = "usingCSVFile", dataProviderClass = DataProviderClass.class)
    public void PositiveTestRegistrationWithoutEmailConfirmation (String userName, String userEmail, String userPassword) {
        Assert.assertTrue(new RegistrationPage(driver)
                       .RegisterUser(userName, userEmail, userPassword)
                       .VerifyEmailSendingSuccess());
    }

    @Test
    public void PositiveTestRegistrationWithEmailConfirmation () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("John", "mail5@mail.com", "Aaa12345")
                .VerifyUserRegisterationSuccess());
    }

    @Test
    public void RegistrationWithInvalidEmail () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("J", "mail", "Aaa12345")
                .VerifyInvalidEmailErrorMessage());
    }

    @Test
    public void RegistrationWithInvalidPassword () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("J", "mail", "Aaa12345")
                .VerifyInvalidPasswordErrorMessage());
    }

    @Test
    public void RegistrationWithInvalidUsername () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("J", "mail", "Aaa12345")
                .VerifyInvalidUsernameErrorMessage());
    }

    @Test
    public void RegistrationWithAlreadyExistedEmail () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("J", "mail", "Aaa12345")
                .VerifyAlreadyExistedEmailErrorMessage());
    }

    @Test
    public void RegistrationWithAlreadyExistedUsername () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("J", "mail", "Aaa12345")
                .VerifyAlreadyExistedUsernameErrorMessage());
    }

    @Test
    public void RegistrationWithUnsignetCheckbox () {
        Assert.assertTrue(new RegistrationPage(driver)
                .RegisterUser("J", "mail", "Aaa12345")
                .VerifyUnsignetCheckboxErrorMessage());
    }



}
