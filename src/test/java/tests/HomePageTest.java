package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest{

    @BeforeClass
    public void classPrecondition (){
        new HomePage(driver).navigateToHomePage();
    }

    @AfterTest
    public void testPostconditions (){
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void positiveAnleitungPageAccessabilityFromHeader () {

    }

    @Test
    public void negativeAnleitungPageAccessabilityFromHeader () {

    }

    @Test
    public void positiveMeineToepfePageAccessabilityFromHeader () {

    }

    @Test
    public void negativeMeineToepfePageAccessabilityFromHeader () {

    }

    @Test
    public void AnmeldenPageAccessabilityFromHeader () {

    }

    @Test
    public void AnmeldenPageAccessabilityFromBody () {

    }

    @Test
    public void GesetzPageAccessabilityFromHeader () {

    }

    @Test
    public void GesetzPageAccessabilityFromFooter () {

    }

}
