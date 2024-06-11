package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnleitungPage extends BasePage{
    public AnleitungPage (WebDriver driver) { super(driver);}

    @FindBy(xpath = "//h1[text()='Wesentliche Tipps für den erfolgreichen Cannabisanbau']")
    WebElement anleitungPageTitle;

    public boolean verifyAnleitungPageOpen() {
        String actualRes = getTextBase(anleitungPageTitle);
        String expectedRes = "Wesentliche Tipps für den erfolgreichen Cannabisanbau";
        return isStringsEqual(actualRes, expectedRes);
    }
}
