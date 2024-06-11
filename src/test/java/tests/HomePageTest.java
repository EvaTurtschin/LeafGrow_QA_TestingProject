package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import testData.PositiveTestUserData;

public class HomePageTest extends BaseTest {


    @BeforeClass
    public void ClassPrecondition() {
        new HomePage(driver).NavigateToHomePage();
    }

    @AfterMethod
    public void TestPostconditions() {
        new HomePage(driver).NavigateToHomePage();
    }

    @Test
    public void PositiveAnleitungPageAccessabilityFromHeader() {
        new HomePage(driver).ClickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).LoginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        new HomePage(driver).ClickAnleitungLinkInHeader();
        Assert.assertTrue(new AnleitungPage(driver).VerifyAnleitungPageOpen());
        new HomePage(driver).ClickUserCabinetPageLink();
        new UserCabinetPage(driver).LogoutUser();
     }

    @Test
    public void PositiveMeineToepfePageAccessabilityFromHeader() {
         new HomePage(driver).ClickAnmeldenBtnInHeader();
         new AnmeldenPage(driver).LoginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
         new HomePage(driver).ClickMeineToepfeLinkInHeader();
                Assert.assertTrue(new MeineToepfePage(driver)
                .VerifyMeineToepfePageOpen());
        new HomePage(driver).ClickUserCabinetPageLink();
        new UserCabinetPage(driver).LogoutUser();
    }
    @Test
    public void AnmeldenPageAccessabilityFromBody() {
        new HomePage(driver).ClickAnmeldenBtnInBody();
                Assert.assertTrue(new AnmeldenPage(driver).VerifyAnmeldenPageOpen());
    }

    @Test
    public void GesetzPageAccessabilityFromFAQ() {
        new HomePage(driver).ClickGesetzPagelinkInFAQ();
        Assert.assertTrue(new GesetzPage(driver)
                .VerifyGesetzPageOpen());
    }

    @Test
    //TODO кликает не на текст ссылки, а на пустое место, занимаемое блоком
    public void GesetzPageAccessabilityFromFooter() {
        new HomePage(driver).ClickGesetzPagelinkInFooter();
        Assert.assertTrue(new GesetzPage(driver)
                .VerifyGesetzPageOpen());
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
