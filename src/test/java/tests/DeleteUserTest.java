package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.UserCabinetPage;
import testData.PositiveTestUserData;

public class DeleteUserTest extends BaseTest{

    @BeforeSuite
    public void testPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
    }

    @AfterSuite
    public void testPostconditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void canselUserDeletion() {
        new HomePage(driver)
                .clickUserCabinetPageLink();
        Assert.assertTrue(new UserCabinetPage(driver)
                .cancelDeletion()
                .verifyUserAuthirized());
    }

    @Test
    public void positiveTestDeleteUser() {
        new HomePage(driver)
                .clickUserCabinetPageLink();
        new UserCabinetPage(driver).deleteUser();
        Assert.assertTrue(new HomePage(driver)
                .verifyUserUnauthorized());
    }
}
