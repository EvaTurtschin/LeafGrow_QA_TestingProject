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
        new HomePage(driver).clickAnleitungLinkInHeader();
        Assert.assertTrue(new AnleitungPage(driver).verifyAnleitungPageOpen());
     }

    @Test
    public void positiveMeineToepfePageAccessabilityFromHeader() {
         new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        logger.info("User logged in successfully.");
         new HomePage(driver).clickMeineToepfeLinkInHeader();
        logger.info("Clicked on 'Meine Toepfe' link in header.");
         Assert.assertTrue(new MeineToepfePage(driver).verifyMeineToepfePageOpen());
        logger.info("Verified Meine Toepfe page is open.");
    }

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
