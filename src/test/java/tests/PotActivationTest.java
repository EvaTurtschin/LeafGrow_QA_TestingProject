package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.EveryTopfPage;
import pages.HomePage;
import pages.MeineToepfePage;
import testData.PositiveTestUserData;

public class PotActivationTest extends BaseTest {

    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).navigateToHomePage();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        new HomePage(driver).clickMeineToepfeLinkInHeader();
    }
    @Test
    public void firstPotActivationTest() {
        new MeineToepfePage(driver).firstTopfClick();
        new EveryTopfPage(driver).activateTopf();
        Assert.assertTrue(new EveryTopfPage(driver).verifyTopfActivation());
        new EveryTopfPage(driver).deactivateTopf();
    }

    @Test
    public void firstPotDeactivationTest() {
        new MeineToepfePage(driver).firstTopfClick();
        new EveryTopfPage(driver).activateTopf();
        new EveryTopfPage(driver).deactivateTopf();
        Assert.assertTrue(new EveryTopfPage(driver).verifyTopfDeactivation());
    }
}
