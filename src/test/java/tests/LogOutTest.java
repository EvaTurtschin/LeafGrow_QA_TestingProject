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
    public void TestPreconditions () {
        new HomePage(driver).NavigateToHomePage();
        new HomePage(driver).ClickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).LoginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
    }

    @AfterTest
    public void TestPostconditions () {
        new HomePage(driver).NavigateToHomePage();
    }

    @Test
    public void PositiveTestLogout() {
        new HomePage(driver)
                .ClickUserCabinetPageLink();
        new UserCabinetPage(driver).LogoutUser();
        Assert.assertTrue(new HomePage(driver)
                .VerifyUserUnauthorized());
    }

    @Test
    public void CanselUserLogout() {
        new HomePage(driver)
                .ClickUserCabinetPageLink();
        new UserCabinetPage(driver).LogoutUser();
        Assert.assertTrue(new UserCabinetPage(driver)
                .CancelLogout()
                .VerifyUserAuthirized());
    }
}
