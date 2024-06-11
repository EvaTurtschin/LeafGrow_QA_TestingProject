package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testData.PositiveTestUserData;


public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/guide']")
    WebElement anleitungLinkHeader;
    @FindBy(xpath = "//a[@href='/mypots']")
    WebElement meinetoepfeLinkHeader;
    @FindBy(xpath = "//div[@class= 'css-fpykxv']")
    WebElement anmeldenBtnHeader;
    @FindBy(xpath = "//div[@class='css-l8sm9m']")
    WebElement anmeldenBtnBody;
    @FindBy(xpath = "//a[text()='Mehr zu erfahren']")
    WebElement gesetzPageLinkFQA;
    @FindBy(xpath = "//a[text()='Gesetzliche Informationen']")
    WebElement gesetzPageLinkFooter;
    @FindBy(xpath = "//div[@class='css-11u27a6']")
    WebElement userCabinetIcon;


    public AnleitungPage ClickAnleitungLinkInHeader() {
        ClickWithJSScroll(anleitungLinkHeader);
        return new AnleitungPage(driver);
    }

    public MeineToepfePage ClickMeineToepfeLinkInHeader() {
        ClickWithJSScroll(meinetoepfeLinkHeader);
        return new MeineToepfePage(driver);
    }

    public AnmeldenPage ClickAnmeldenBtnInHeader() {
        ClickWithJSScroll(anmeldenBtnHeader);
        return new AnmeldenPage(driver);
    }

    public void ClickAnmeldenBtnInBody() {
        ClickWithJSScroll(anmeldenBtnBody);
    }

    public GesetzPage ClickGesetzPagelinkInFAQ() {
        ClickWithJSScroll(gesetzPageLinkFQA);
        return new GesetzPage(driver);
    }

    public GesetzPage ClickGesetzPagelinkInFooter() {
        ClickWithJSScroll(gesetzPageLinkFooter);
        return new GesetzPage(driver);
    }

    public boolean VerifyLoginSuccess(String userName) {
        String actualRes = GetTextBase(userCabinetIcon);
        String expectedRes = PositiveTestUserData.USERNAME;
        return IsStringsEqual(actualRes, expectedRes);
    }

    public UserCabinetPage ClickUserCabinetPageLink() {
        ClickWithJSScroll(userCabinetIcon);
        return new UserCabinetPage(driver);
    }

    public boolean VerifyUserUnauthorized() {
        return IsElementDisplayed(anmeldenBtnHeader);
    }

}
