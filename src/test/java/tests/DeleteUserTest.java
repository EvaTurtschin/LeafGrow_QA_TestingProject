package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.UserCabinetPage;
import testData.PositiveTestUserData;

public class DeleteUserTest extends BaseTest{

    @BeforeSuite
    public void TestPreconditions () {
        new HomePage(driver).NavigateToHomePage();
        new HomePage(driver).ClickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).LoginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
    }

    @AfterSuite
    public void TestPostconditions () {
        new HomePage(driver).NavigateToHomePage();
    }

    @Test
    public void CanselUserDeletion() {
        new HomePage(driver)
                .ClickUserCabinetPageLink();
        Assert.assertTrue(new UserCabinetPage(driver)
                .CancelDeletion()
                .VerifyUserAuthirized());
    }

    @Test
    public void PositiveTestDeleteUser() {
        new HomePage(driver)
                .ClickUserCabinetPageLink();
        new UserCabinetPage(driver).DeleteUser();
        Assert.assertTrue(new HomePage(driver)
                .VerifyUserUnauthorized());
    }
}
