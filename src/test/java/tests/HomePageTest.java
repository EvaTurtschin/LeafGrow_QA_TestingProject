package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import testData.PositiveTestUserData;

public class HomePageTest extends BaseTest {

    @BeforeClass
    public void classPrecondition() {
        new HomePage(driver).navigateToHomePage();
    }

    @AfterMethod
    public void testPostconditions() {
        new HomePage(driver).navigateToHomePage();
        logger.info("Navigated back to the home page.");
    }

    @Test
    public void positiveAnleitungPageAccessabilityFromHeader() {
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        logger.info("User logged in successfully.");
        new HomePage(driver).clickAnleitungLinkInHeader();
        Assert.assertTrue(new AnleitungPage(driver).verifyAnleitungPageOpen());
     }

//TODO somehow I can't click on Toepfe link in Heade
//    @Test
//    public void positiveMeineToepfePageAccessabilityFromHeader() {
//        try {
//            AnmeldenPage anmeldenPage = new AnmeldenPage(driver);
//            anmeldenPage.loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
//            logger.info("User logged in successfully.");
//            HomePage homePage = new HomePage(driver);
//            homePage.clickMeineToepfeLinkInHeader();
//            logger.info("Clicked on Meine Toepfe link in header.");
//            MeineToepfePage meineToepfePage = new MeineToepfePage(driver);
//            boolean isPageOpen = meineToepfePage.verifyMeineToepfePageOpen();
//            Assert.assertTrue(isPageOpen, "Failed to verify Meine Toepfe page is open.");
//            logger.info("Verified Meine Toepfe page is open.");
//        } catch (Exception e) {
//            logger.error("Test positiveMeineToepfePageAccessabilityFromHeader failed: ", e);
//            Assert.fail("Test failed due to exception: " + e.getMessage());
//        }
//    }

    @Test
    public void anmeldenPageAccessabilityFromBody() {
        new HomePage(driver).clickAnmeldenBtnInBody();
                Assert.assertTrue(new AnmeldenPage(driver).verifyAnmeldenPageOpen());
    }

    @Test
    public void gesetzPageAccessabilityFromFAQ() {
        new HomePage(driver).clickGesetzPagelinkInFAQ();
        Assert.assertTrue(new GesetzPage(driver)
                .verifyGesetzPageOpen());
    }

    @Test
    public void negativeAnleitungPageAccessabilityFromHeader() {
        new HomePage(driver).clickAnleitungLinkInHeader();
        Assert.assertTrue(new AnleitungPage(driver)
                .verifyAnleitungPageAccessError());
    }

    @Test
    public void negativeMeineToepfePageAccessabilityFromHeader() {
        new HomePage(driver).clickMeineToepfeLinkInHeader();
        Assert.assertTrue(new MeineToepfePage(driver)
                .verifyMeineToepfePageAccessError());
    }

    @Test
    public void gesetzPageAccessabilityFromFooter() {
        new HomePage(driver).clickGesetzPagelinkInFooter();
        Assert.assertTrue(new GesetzPage(driver)
                .verifyGesetzPageOpen());
    }
}
