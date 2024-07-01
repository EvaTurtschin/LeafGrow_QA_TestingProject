package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Anleitung']")
    WebElement anleitungLinkHeader;
    @FindBy(xpath = "//a[@href='#/mypots']")
    WebElement meineToepfeLinkHeader;
    @FindBy(xpath = "//button[text() = 'Anmelden']")
    List<WebElement> anmeldenBtns;
    @FindBy(xpath = "//a[text()='Mehr zu erfahren']")
    WebElement gesetzPageLinkFQA;
    @FindBy(xpath = "//a[text()='Gesetzliche Informationen']")
    WebElement gesetzPageLinkFooter;
    @FindBy(xpath = "//a[@href='#/account']")
    WebElement userCabinetIcon;
    @FindBy(xpath = "//a[text()='Home']")
    WebElement homePageLinkInHeader;
    @FindBy(xpath = "//span[text()='Zurück zum Homepage ']")
    List<WebElement> clickBackToHomePage;

    public void clickAnleitungLinkInHeader() {
        clickWithJSScroll(anleitungLinkHeader);
    }

    public void clickMeineToepfeLinkInHeader() {
            click(meineToepfeLinkHeader);
            logger.info("Clicked on Meine Toepfe link in header.");
    }

    public void clickAnmeldenBtnInHeader() {
        click(anmeldenBtns.get(0));
    }

    public void clickAnmeldenBtnInBody() {
        clickWithJSScroll(anmeldenBtns.get(1));
    }

    public void clickGesetzPagelinkInFAQ() {
        clickWithJSScroll(gesetzPageLinkFQA);
    }

    public void clickGesetzPagelinkInFooter() {
        clickWithJSScroll(gesetzPageLinkFooter);
    }

    public boolean verifyLoginSuccess() {
        clickWithJSScroll(homePageLinkInHeader);
        return isElementDisplayed(userCabinetIcon);
    }

    public void clickUserCabinetPageLink() {
        click(userCabinetIcon);
    }

    public boolean verifyUserUnauthorized() {
        return isElementDisplayed(anmeldenBtns.get(0));
    }

    public void clickBackToHomePageAfterError() {
        click(clickBackToHomePage.get(0));
    }
}
