package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnleitungPage extends BasePage{
    public AnleitungPage (WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement anleitungPageTitle;

    public boolean VerifyAnleitungPageOpen() {
        String actualRes = GetTextBase(anleitungPageTitle);
        String expectedRes = "Anleitung";
        return IsStringsEqual(actualRes, expectedRes);
    }
}
