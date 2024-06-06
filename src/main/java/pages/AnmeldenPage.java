package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnmeldenPage extends BasePage{
    public AnmeldenPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement anmeldenPageTitle;

    public boolean verifyAnmeldenPageOpen() {
        String actualRes = getTextBase(anmeldenPageTitle);
        String expectedRes = "Anmelden";
        return isStringsEqual(actualRes, expectedRes);
    }
}
