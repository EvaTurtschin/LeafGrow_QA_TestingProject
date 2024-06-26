package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Anleitung']")
    WebElement anleitungLinkHeader;
    @FindBy(xpath = "//a[@href='#/mypots']")
    WebElement meineToepfeLinkHeader;
    @FindBy(xpath = "//button[text()='Anmelden']")
    List<WebElement> anmeldenBtns;
    @FindBy(xpath = "//a[text()='Mehr zu erfahren']")
    WebElement gesetzPageLinkFQA;
    @FindBy(xpath = "//a[text()='Gesetzliche Informationen']")
    WebElement gesetzPageLinkFooter;
    @FindBy(xpath = "//div[@class='css-6y5c9t']")
    WebElement userCabinetIcon;

    public void clickAnleitungLinkInHeader() {
        clickWithJSScroll(anleitungLinkHeader);
    }

    public void clickMeineToepfeLinkInHeader() {
        wait.until(ExpectedConditions.visibilityOf(meineToepfeLinkHeader));
        clickWithJSScroll(meineToepfeLinkHeader);
    }

    public void clickAnmeldenBtnInHeader() {
        clickWithJSScroll(anmeldenBtns.get(0));
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
        return isElementDisplayed(userCabinetIcon);
    }

    public void clickUserCabinetPageLink() {
        clickWithJSScroll(userCabinetIcon);
    }

    public boolean verifyUserUnauthorized() {
        return isElementDisplayed(anmeldenBtns.get(0));
    }

}
