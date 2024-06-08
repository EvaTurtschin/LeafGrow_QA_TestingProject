package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.HomePage;

public class HomePageTest extends BaseTest {


    @BeforeClass
    public void ClassPrecondition() {
        new HomePage(driver).NavigateToHomePage();
    }

    @AfterTest
    public void TestPostconditions() {
        new HomePage(driver).NavigateToHomePage();
    }

    @Test
    public void PositiveAnleitungPageAccessabilityFromHeader() {
        new AnmeldenPage(driver).LoginUser();
        Assert.assertTrue(new HomePage(driver)
                .ClickHomeBtn()
                .ClickAnleitungLinkInHeader()
                .VerifyAnleitungPageOpen());
    }

    @Test
    public void NegativeAnleitungPageAccessabilityFromHeader() {
        Assert.assertFalse(new HomePage(driver)
                .ClickAnleitungLinkInHeader()
                .VerifyAnleitungPageOpen());
    }

    @Test
    public void PositiveMeineToepfePageAccessabilityFromHeader() {
        new AnmeldenPage(driver).LoginUser();
        Assert.assertTrue(new HomePage(driver)
                .ClickHomeBtn()
                .ClickMeineToepfeLinkInHeader()
                .VerifyMeineToepfePageOpen());
    }

    @Test
    public void NegativeMeineToepfePageAccessabilityFromHeader() {
        Assert.assertFalse(new HomePage(driver)
                .ClickMeineToepfeLinkInHeader()
                .VerifyMeineToepfePageOpen());
    }

    @Test
    public void AnmeldenPageAccessabilityFromHeader() {
        Assert.assertTrue(new HomePage(driver)
                .ClickAnmeldenBtnInHeader()
                .VerifyAnmeldenPageOpen());
    }

    @Test
    public void AnmeldenPageAccessabilityFromBody() {
        Assert.assertTrue(new HomePage(driver)
                .ClickAnmeldenBtnInBody()
                .VerifyAnmeldenPageOpen());
    }

    @Test
    public void GesetzPageAccessabilityFromFAQ() {
        Assert.assertTrue(new HomePage(driver)
                .ClickGesetzPagelinkInFAQ()
                //.switchToGesetzPage(1) //если не перенесет автоматически
                .VerifyGesetzPageOpen());
        //.closeCurrentTab()); //тоже по факту, как пропишут
    }

    @Test
    public void GesetzPageAccessabilityFromFooter() {
        Assert.assertTrue(new HomePage(driver)
                .ClickGesetzPagelinkInFooter()
                //.switchToGesetzPage(1) //если не перенесет автоматически
                .VerifyGesetzPageOpen());
        //.closeCurrentTab());  //тоже по факту, как пропишут
    }

}
