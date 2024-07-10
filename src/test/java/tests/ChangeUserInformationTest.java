package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.UserCabinetPage;
import testData.PositiveTestUserData;

public class ChangeUserInformationTest extends BaseTest{

    @BeforeTest
    public void testPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        new HomePage(driver).clickUserCabinetPageLink();
    }

    @AfterTest
    public void testPostconditions() {
        new HomePage(driver).clickAnmeldenBtnInHeader();
        //TODO возврат пароля
    }

    @Test
    public void testCancelPasswordChange() {
        new UserCabinetPage(driver).cancelPasswordChanging();
        Assert.assertTrue(new UserCabinetPage(driver).verifyPasswordHasNotChanged());
    }

    @Test
    public void testPositivePasswordChanging() {
        new UserCabinetPage(driver).changingPassword();
        Assert.assertTrue(new UserCabinetPage(driver).verifyPasswordChangeSucceeded());
    }

}
