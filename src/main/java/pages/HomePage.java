package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = )
    WebElement homePageTitle;

    @FindBy(xpath = )
    WebElement homeBtn;

    @FindBy(xpath = )
    WebElement anleitungLinkHeader;

    @FindBy(xpath = )
    WebElement meinetoepfeLinkHeader;

    @FindBy(xpath = )
    WebElement anmeldenLinkHeader;

    @FindBy(xpath = )
    WebElement anmeldenLinkBody;

    @FindBy(xpath = )
    WebElement gesetzPageLinkFQA;

    @FindBy(xpath = )
    WebElement gesetzPageLinkFooter;



    public HomePage isHomePageTitleDisplayed() {
        assert isElementDisplayed(homePageTitle);
        return this;
    }

    public HomePage userAnmelden() {

    }
    public HomePage clickHomeBtn() {
        click(homeBtn);
        return new HomePage(driver);
    }

    public AnleitungPage clickAnleitungLinkInHeader() {
        click(anleitungLinkHeader);
        return new AnleitungPage(driver);
    }

    public MeineToepfePage clickMeineToepfeLinkInHeader() {
        click(meinetoepfeLinkHeader);
        return new MeineToepfePage(driver);
    }

    public AnmeldenPage clickAnmeldenlinkInHeader() {
        click(anmeldenLinkHeader);
        return new AnmeldenPage(driver);
    }

    public AnmeldenPage clickAnmeldenlinkInBody() {
        clickWithJSScroll(anmeldenLinkBody, 0, 200);
        return new AnmeldenPage(driver);
    }

    public GesetzPage clickGesetzPagelinkInFAQ() {
        clickWithJSScroll(gesetzPageLinkFQA, 0, 200);
        return new GesetzPage(driver);
    }

//    public GesetzPage switchToGesetzPage(int index) {
//        List<String> windows = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windows.get(index));
//        return new GesetzPage(driver);
//
//    }

    public GesetzPage clickGesetzPagelinkInFooter() {
        clickWithJSScroll(gesetzPageLinkFooter, 0, 500);
        return new GesetzPage(driver);
    }
}
