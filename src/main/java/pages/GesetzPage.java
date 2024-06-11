package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GesetzPage extends BasePage{
    public GesetzPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//h3[text()=' Erlaubter Besitz von Cannabis ']")
    WebElement gesetzPageTitle;

    public boolean verifyGesetzPageOpen() {
        String actualRes = getTextBase(gesetzPageTitle);
        String expectedRes = "Erlaubter Besitz von Cannabis";
        return isStringsEqual(actualRes, expectedRes);
    }
}
