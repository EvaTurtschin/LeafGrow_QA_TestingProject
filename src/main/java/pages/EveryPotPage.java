package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EveryPotPage extends BasePage{
    public EveryPotPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//button[text()='Topf activieren']")
    WebElement potActivate;
    @FindBy(xpath = "//button[text()='Topf entfernen']")
    WebElement potDeactivate;
    @FindBy(xpath = "//button[text()='Bestätigen']")
    WebElement deactivationConfirm;
    @FindBy(xpath = "//button[text()='X']")
    WebElement deactivationCancel;

    public void activatePot() {
        click(potActivate);
    }

    public void deactivatePot() {
        clickWithJSScroll(potDeactivate);
        click(deactivationConfirm);
        logger.info("Pot deactivated");
    }
    public void potDeactivationCancel() {
        clickWithJSScroll(potDeactivate);
        click(deactivationCancel);
    }
    public boolean verifyPotActivated() {
        Actions actions = new Actions(driver);
        actions.moveToElement(potDeactivate);
        actions.perform();
        return isElementDisplayed(potDeactivate);
    }

}
