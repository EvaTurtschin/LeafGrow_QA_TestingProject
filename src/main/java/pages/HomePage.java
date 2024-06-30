package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testData.PositiveTestUserData;

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
    @FindBy(xpath = "//div[@class='css-11u27a6']")
    WebElement userCabinetIcon;

    public void clickAnleitungLinkInHeader() {
        clickWithJSScroll(anleitungLinkHeader);
    }

//    public void clickMeineToepfeLinkInHeader() {
//        clickWithJSScroll(meineToepfeLinkHeader);
//    }

    public void clickMeineToepfeLinkInHeader() {
        try {
            logger.info("Waiting for Meine Toepfe link to be clickable.");
            wait.until(ExpectedConditions.elementToBeClickable(meineToepfeLinkHeader));
            clickWithJSScroll(meineToepfeLinkHeader);
            logger.info("Clicked on Meine Toepfe link in header.");
        } catch (Exception e) {
            logger.error("Failed to click on Meine Toepfe link: ", e);
            throw e; // Проброс исключения для последующей обработки в тесте
        }
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

    public String verifyLoginSuccess() {
        try {
            logger.info("Waiting for the user cabinet icon to be visible");
            wait.until(ExpectedConditions.visibilityOf(userCabinetIcon));
            String actualRes = getTextBase(userCabinetIcon);
            logger.info("Actual result after login: " + actualRes);
            return actualRes;
        } catch (Exception e) {
            logger.error("Error during verifying login success: ", e);
            return null;
        }
//        return isElementDisplayed(userCabinetIcon);
    }

    public void clickUserCabinetPageLink() {
        clickWithJSScroll(userCabinetIcon);
    }

    public boolean verifyUserUnauthorized() {
        return isElementDisplayed(anmeldenBtns.get(0));
    }

}
