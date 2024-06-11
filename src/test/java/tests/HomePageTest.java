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
    }

    @Test
    public void positiveAnleitungPageAccessabilityFromHeader() {
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        new HomePage(driver).clickAnleitungLinkInHeader();
        Assert.assertTrue(new AnleitungPage(driver).verifyAnleitungPageOpen());
        new HomePage(driver).clickUserCabinetPageLink();
        new UserCabinetPage(driver).logoutUser();
     }

    @Test
    public void positiveMeineToepfePageAccessabilityFromHeader() {
         new HomePage(driver).clickAnmeldenBtnInHeader();
         new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
         new HomePage(driver).clickMeineToepfeLinkInHeader();
                Assert.assertTrue(new MeineToepfePage(driver)
                .verifyMeineToepfePageOpen());
        new HomePage(driver).clickUserCabinetPageLink();
        new UserCabinetPage(driver).logoutUser();
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
    //TODO кликает не на текст ссылки, а на пустое место, занимаемое блоком
    public void gesetzPageAccessabilityFromFooter() {
        new HomePage(driver).clickGesetzPagelinkInFooter();
        Assert.assertTrue(new GesetzPage(driver)
                .verifyGesetzPageOpen());
    }

//    @Test
//    public void NegativeAnleitungPageAccessabilityFromHeader() {
//        Assert.assertFalse(new HomePage(driver)
//                .ClickAnleitungLinkInHeader()
//                .VerifyAnleitungPageOpen());
//    }

//    @Test
//    public void NegativeMeineToepfePageAccessabilityFromHeader() {
//        new HomePage(driver).ClickMeineToepfeLinkInHeader();
//                Assert.assertFalse(new MeineToepfePage(driver)
////                .VerifyMeineToepfePageOpen());
//    }

}
