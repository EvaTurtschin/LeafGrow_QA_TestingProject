package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AnmeldenPage;
import pages.EveryPotPage;
import pages.HomePage;
import pages.MyPotsPage;
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
        new MyPotsPage(driver).firstPotClick();
        new EveryPotPage(driver).activatePot();
        Assert.assertTrue(new EveryPotPage(driver).verifyPotActivated());
        new EveryPotPage(driver).deactivatePot();
    }

    @Test
    public void firstPotDeactivationTest() {
        new MyPotsPage(driver).firstPotClick();
        new EveryPotPage(driver).activatePot();
        new EveryPotPage(driver).deactivatePot();
        Assert.assertTrue(new MyPotsPage(driver).verifyPotDeactivated());
    }

    @Test
    public void firstPotDeactivationCancel(){
        new MyPotsPage(driver).firstPotClick();
        new EveryPotPage(driver).activatePot();
        new EveryPotPage(driver).potDeactivationCancel();
        Assert.assertTrue(new EveryPotPage(driver).verifyPotActivated());
        new EveryPotPage(driver).deactivatePot();
    }

    @Test
    public void secondPotActivationTest() {
        new MyPotsPage(driver).secondPotClick();
        new EveryPotPage(driver).activatePot();
        Assert.assertTrue(new EveryPotPage(driver).verifyPotActivated());
        new EveryPotPage(driver).deactivatePot();
    }
    @Test
    public void secondPotDeactivationTest() {
        new MyPotsPage(driver).secondPotClick();
        new EveryPotPage(driver).activatePot();
        new EveryPotPage(driver).deactivatePot();
        Assert.assertTrue(new MyPotsPage(driver).verifyPotDeactivated());
    }

    @Test
    public void secondPotDeactivationCancel(){
        new MyPotsPage(driver).secondPotClick();
        new EveryPotPage(driver).activatePot();
        new EveryPotPage(driver).potDeactivationCancel();
        Assert.assertTrue(new EveryPotPage(driver).verifyPotActivated());
        new EveryPotPage(driver).deactivatePot();
    }
    @Test
    public void thirdPotActivationTest() {
        new MyPotsPage(driver).thirdPotClick();
        new EveryPotPage(driver).activatePot();
        Assert.assertTrue(new EveryPotPage(driver).verifyPotActivated());
        new EveryPotPage(driver).deactivatePot();
    }
    @Test
    public void thirdPotDeactivationTest() {
        new MyPotsPage(driver).thirdPotClick();
        new EveryPotPage(driver).activatePot();
        new EveryPotPage(driver).deactivatePot();
        Assert.assertTrue(new MyPotsPage(driver).verifyPotDeactivated());
    }

    @Test
    public void thirdPotDeactivationCancel(){
        new MyPotsPage(driver).thirdPotClick();
        new EveryPotPage(driver).activatePot();
        new EveryPotPage(driver).potDeactivationCancel();
        Assert.assertTrue(new EveryPotPage(driver).verifyPotActivated());
        new EveryPotPage(driver).deactivatePot();
    }
}
