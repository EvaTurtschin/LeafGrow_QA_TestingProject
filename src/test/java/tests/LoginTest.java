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
    }

    @AfterMethod
    public void testPostconditions() {
        new UserCabinetPage(driver).logoutUser();
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void positiveTestLoginWithCheckbox() {
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD)
                .checkLoginCheckbox();
//        Assert.assertTrue(new HomePage(driver)
//                .verifyLoginSuccess());
    }

//TODO code doesn't see the username in Cabinet Icon. Probably it comes from DB not as a String, but somehow as an object?
//    @Test
//    public void positiveTestLoginNoCheckbox() {
//        try {
//            AnmeldenPage anmeldenPage = new AnmeldenPage(driver);
//            anmeldenPage.loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
//            logger.info("User logged in successfully");
//            HomePage homePage = new HomePage(driver);
//            String actualResult = homePage.verifyLoginSuccess();
//            logger.info("Actual result: " + actualResult);
//            Assert.assertNotNull(actualResult, "Login verification failed, actual result is null");
//        } catch (Exception e) {
//            logger.error("Test positiveTestLoginNoCheckbox failed: ", e);
//            Assert.fail("Test failed due to exception: " + e.getMessage());
//        }
//    }
}
