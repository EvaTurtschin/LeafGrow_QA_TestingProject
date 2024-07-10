package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EveryTopfPage extends BasePage{
    public EveryTopfPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//button[text()='Topf activieren']")
    WebElement topfActivate;
    @FindBy(xpath = "//button[text()='Topf entfernen']")
    WebElement topfDeactivate;
    @FindBy(xpath = "//button[text()='Bestätigen']")
    WebElement deactivationConfirm;
    @FindBy(xpath = "//button[text()='X']")
    WebElement deactivationCancel;

    public void activateTopf() {
        click(topfActivate);
    }
    public void deactivateTopf() {
        clickWithJSScroll(topfDeactivate);
        click(deactivationConfirm);
    }
    public void topfDeactivationCancel() {
        clickWithJSScroll(topfDeactivate);
        click(deactivationCancel);
    }
    public boolean verifyTopfActivation() {
        return isElementDisplayed(topfDeactivate);
    }
    public boolean verifyTopfDeactivation() {
        return isElementDisplayed(topfActivate);
    }
}
