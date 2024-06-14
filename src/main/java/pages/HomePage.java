package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testData.PositiveTestUserData;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Anleitung']")
    WebElement anleitungLinkHeader;
    @FindBy(xpath = "//a[@href='#/mypots']")
    WebElement meinetoepfeLinkHeader;
    @FindBy(xpath = "//div[@class='css-fpykxv']")
    WebElement anmeldenBtnHeader;
    @FindBy(xpath = "//div[@class='css-l8sm9m']")
    WebElement anmeldenBtnBody;
    @FindBy(xpath = "//a[text()='Mehr zu erfahren']")
    WebElement gesetzPageLinkFQA;
    @FindBy(xpath = "//a[text()='Gesetzliche Informationen']")
    WebElement gesetzPageLinkFooter;
    @FindBy(xpath = "//div[@class='css-11u27a6']")
    WebElement userCabinetIcon;

    public void clickAnleitungLinkInHeader() {
        clickWithJSScroll(anleitungLinkHeader);
    }

    public void clickMeineToepfeLinkInHeader() {
        clickWithJSScroll(meinetoepfeLinkHeader);
    }

    public void clickAnmeldenBtnInHeader() {
        clickWithJSScroll(anmeldenBtnHeader);
    }

    public void clickAnmeldenBtnInBody() {
        clickWithJSScroll(anmeldenBtnBody);
    }

    public void clickGesetzPagelinkInFAQ() {
        clickWithJSScroll(gesetzPageLinkFQA);
    }

    public void clickGesetzPagelinkInFooter() {
        clickWithJSScroll(gesetzPageLinkFooter);
    }

    public boolean verifyLoginSuccess(String userName) {
        String actualRes = getTextBase(userCabinetIcon);
        String expectedRes = PositiveTestUserData.USERNAME;
        return isStringsEqual(actualRes, expectedRes);
    }

    public void clickUserCabinetPageLink() {
        clickWithJSScroll(userCabinetIcon);
    }

    public boolean verifyUserUnauthorized() {
        return isElementDisplayed(anmeldenBtnHeader);
    }

}
