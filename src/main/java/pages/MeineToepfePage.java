package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MeineToepfePage extends BasePage{
    public MeineToepfePage(WebDriver driver) { super(driver);}
    @FindBy(xpath = "//h3[text()='Topf 1']")
    WebElement firstTopfTitle;
    @FindBy(xpath = "//p[@class='css-pmqoh1']")
    WebElement pageAccessError;
    @FindBy(xpath = "//span[text()='Zurück zum Homepage ']")
    List<WebElement> clickBackToHomePage;
    @FindBy(xpath = "//div[@class='css-tr0eku']")
    WebElement firstTopfBtn;

    public boolean verifyMeineToepfePageOpen() {
        return isElementDisplayed(firstTopfTitle);
    }

    public boolean verifyMeineToepfePageAccessError() {
        String actualRes = getTextBase(pageAccessError);
        String expectedRes = "Diese Seite ist nur für registrierte und eingeloggte Benutzer/innen verfügbar";
        return isStringsEqual(actualRes, expectedRes);
    }
    public void firstTopfClick() {
        click(firstTopfBtn);
    }
}
