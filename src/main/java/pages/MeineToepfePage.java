package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MeineToepfePage extends BasePage{
    public MeineToepfePage(WebDriver driver) { super(driver);}
    @FindBy(xpath = "//h3[text()='Topf 1']")
    WebElement firstTopfTitle;
    @FindBy(xpath = "//p[@class='css-ck0lbs']")
    WebElement pageAccessError;
    @FindBy(xpath = "//span[text()='Zurück zum Homepage ']")
    List<WebElement> clickBackToHomePage;

    public boolean verifyMeineToepfePageOpen() {
        return isElementDisplayed(firstTopfTitle);
    }

    public boolean verifyMeineToepfePageAccessError() {
        String actualRes = getTextBase(pageAccessError);
        String expectedRes = "Diese Seite ist nur für registrierte und eingeloggte Benutzer/innen verfügbar";
        return isStringsEqual(actualRes, expectedRes);
    }

    public void clickBackToHomePageAfterError() {
        click(clickBackToHomePage.get(0));
    }
}
