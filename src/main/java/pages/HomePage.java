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


    public AnleitungPage clickAnleitungLinkInHeader() {
        clickWithJSScroll(anleitungLinkHeader);
        return new AnleitungPage(driver);
    }

    public MeineToepfePage clickMeineToepfeLinkInHeader() {
        clickWithJSScroll(meinetoepfeLinkHeader);
        return new MeineToepfePage(driver);
    }

    public AnmeldenPage clickAnmeldenBtnInHeader() {
        clickWithJSScroll(anmeldenBtnHeader);
        return new AnmeldenPage(driver);
    }

    public void clickAnmeldenBtnInBody() {
        clickWithJSScroll(anmeldenBtnBody);
    }

    public GesetzPage clickGesetzPagelinkInFAQ() {
        clickWithJSScroll(gesetzPageLinkFQA);
        return new GesetzPage(driver);
    }

    public GesetzPage clickGesetzPagelinkInFooter() {
        clickWithJSScroll(gesetzPageLinkFooter);
        return new GesetzPage(driver);
    }

    public boolean verifyLoginSuccess(String userName) {
        String actualRes = getTextBase(userCabinetIcon);
        String expectedRes = PositiveTestUserData.USERNAME;
        return isStringsEqual(actualRes, expectedRes);
    }

    public UserCabinetPage clickUserCabinetPageLink() {
        clickWithJSScroll(userCabinetIcon);
        return new UserCabinetPage(driver);
    }

    public boolean verifyUserUnauthorized() {
        return isElementDisplayed(anmeldenBtnHeader);
    }

}
