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
    WebElement anmeldenBtnHeader;
    @FindBy(xpath = )
    WebElement anmeldenBtnBody;
    @FindBy(xpath = )
    WebElement gesetzPageLinkFQA;
    @FindBy(xpath = )
    WebElement gesetzPageLinkFooter;
    @FindBy(xpath = )
    WebElement userCabinetIcon;

    public HomePage ClickHomeBtn() {
        Click(homeBtn);
        return new HomePage(driver);
    }

    public AnleitungPage ClickAnleitungLinkInHeader() {
        Click(anleitungLinkHeader);
        return new AnleitungPage(driver);
    }

    public MeineToepfePage ClickMeineToepfeLinkInHeader() {
        Click(meinetoepfeLinkHeader);
        return new MeineToepfePage(driver);
    }

    public AnmeldenPage ClickAnmeldenBtnInHeader() {
        Click(anmeldenBtnHeader);
        return new AnmeldenPage(driver);
    }

    public AnmeldenPage ClickAnmeldenBtnInBody() {
        ClickWithJSScroll(anmeldenBtnBody, 0, 200);
        return new AnmeldenPage(driver);
    }

    public GesetzPage ClickGesetzPagelinkInFAQ() {
        ClickWithJSScroll(gesetzPageLinkFQA, 0, 200);
        return new GesetzPage(driver);
    }

//    public GesetzPage switchToGesetzPage(int index) {
//        List<String> windows = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windows.get(index));
//        return new GesetzPage(driver);
//
//    }

    public GesetzPage ClickGesetzPagelinkInFooter() {
        ClickWithJSScroll(gesetzPageLinkFooter, 0, 500);
        return new GesetzPage(driver);
    }

    public boolean VerifyLoginSuccess(String userName) {
        String actualRes = GetTextBase(userCabinetIcon);
        String expectedRes = userName;
        return IsStringsEqual(actualRes, expectedRes);
    }

    public UserCabinetPage ClickUserCabinetPageLink() {
        Click(userCabinetIcon);
        return new UserCabinetPage(driver);
    }

    public boolean VerifyUserUnauthorized() {
        return IsElementDisplayed(anmeldenBtnHeader);
    }

}
