package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.UserCabinetPage;
import testData.PositiveTestUserData;

public class LogOutTest extends BaseTest{
    @BeforeTest
    public void testPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
    }

    @AfterTest
    public void testPostconditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void positiveTestLogout() {
        new HomePage(driver)
                .clickUserCabinetPageLink();
        new UserCabinetPage(driver).logoutUser();
        Assert.assertTrue(new HomePage(driver)
                .verifyUserUnauthorized());
    }

    @Test
    public void canselUserLogout() {
        new HomePage(driver)
                .clickUserCabinetPageLink();
        new UserCabinetPage(driver).logoutUser();
        Assert.assertTrue(new UserCabinetPage(driver)
                .cancelLogout()
                .verifyUserAuthirized());
    }
}
