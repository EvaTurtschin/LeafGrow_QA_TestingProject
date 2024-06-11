package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.HomePage;
import pages.UserCabinetPage;
import testData.PositiveTestUserData;
import utils.DataProviders;

public class LoginTest extends BaseTest{
    @BeforeTest
    public void TestPreconditions () {
        new HomePage(driver).NavigateToHomePage();
        new HomePage(driver).ClickAnmeldenBtnInHeader();
    }

    @AfterMethod
    public void TestPostconditions () {
        new UserCabinetPage(driver).LogoutUser();
        new HomePage(driver).NavigateToHomePage();
    }

    @Test
    public void PositiveTestLoginWithCheckbox() {
        new AnmeldenPage(driver).LoginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD)
                .checkLoginCheckbox();
        Assert.assertTrue(new HomePage(driver)
                .VerifyLoginSuccess(PositiveTestUserData.USERNAME));
    }

    @Test
    public void PositiveTestLoginNoCheckbox() {
        new AnmeldenPage(driver).LoginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        Assert.assertTrue(new HomePage(driver)
                .VerifyLoginSuccess(PositiveTestUserData.USERNAME));
    }

//    @Test(dataProvider = "userCSVFile", dataProviderClass = DataProviders.class)
//    public void NegativeLoginWithInvalidDataTest(String userEmail, String userPassword) {
//        Assert.assertFalse(new AnmeldenPage(driver)
//                .LoginUser(userEmail, userPassword)
//                .VerifyLoginUnsucceed());
//    }

}
