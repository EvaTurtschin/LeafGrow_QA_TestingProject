package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {


    @BeforeClass
    public void classPrecondition() {
        new HomePage(driver).navigateToHomePage();
    }

    @AfterTest
    public void testPostconditions() {
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void positiveAnleitungPageAccessabilityFromHeader() {

        Assert.assertTrue(new HomePage(driver)
                .userAnmelden()
                .clickHomeBtn()
                .clickAnleitungLinkInHeader()
                .verifyAnleitungPageOpen());
    }

    @Test
    public void negativeAnleitungPageAccessabilityFromHeader() {
        Assert.assertFalse(new HomePage(driver)
                .clickAnleitungLinkInHeader()
                .verifyAnleitungPageOpen());
    }

    @Test
    public void positiveMeineToepfePageAccessabilityFromHeader() {
        Assert.assertTrue(new HomePage(driver)
                .userAnmelden()
                .clickHomeBtn()
                .clickMeineToepfeLinkInHeader()
                .verifyMeineToepfePageOpen());
    }

    @Test
    public void negativeMeineToepfePageAccessabilityFromHeader() {
        Assert.assertFalse(new HomePage(driver)
                .clickMeineToepfeLinkInHeader()
                .verifyMeineToepfePageOpen());
    }

    @Test
    public void AnmeldenPageAccessabilityFromHeader() {
        Assert.assertTrue(new HomePage(driver)
                .clickAnmeldenlinkInHeader()
                .verifyAnmeldenPageOpen());
    }

    @Test
    public void AnmeldenPageAccessabilityFromBody() {
        Assert.assertTrue(new HomePage(driver)
                .clickAnmeldenlinkInBody()
                .verifyAnmeldenPageOpen());
    }

    @Test
    public void GesetzPageAccessabilityFromFAQ() {
        Assert.assertTrue(new HomePage(driver)
                .clickGesetzPagelinkInFAQ()
                //.switchToGesetzPage(1) //если не перенесет автоматически
                .verifyGesetzPageOpen());
        //.closeCurrentTab()); //тоже по факту, как пропишут
    }

    @Test
    public void GesetzPageAccessabilityFromFooter() {
        Assert.assertTrue(new HomePage(driver)
                .clickGesetzPagelinkInFooter()
                //.switchToGesetzPage(1) //если не перенесет автоматически
                .verifyGesetzPageOpen());
        //.closeCurrentTab());  //тоже по факту, как пропишут
    }

}
