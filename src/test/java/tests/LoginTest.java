package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.UserCabinetPage;
import testData.PositiveTestUserData;

public class LoginTest extends BaseTest{
    @BeforeTest
    public void testPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
    }

    @AfterMethod
    public void testPostconditions() {
        new UserCabinetPage(driver).logoutUser();
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void positiveTestLogin() {
        Assert.assertTrue(new HomePage(driver).verifyLoginSuccess());
    }
}
