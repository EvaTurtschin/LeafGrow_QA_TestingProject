package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MeineToepfePage extends BasePage{
    public MeineToepfePage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//h3[text()='Topf 1']")
    WebElement firstTopfTitle;
    @FindBy(xpath = "//p[@class='css-db06rd']")
    WebElement pageAccessError;

    public boolean verifyMeineToepfePageOpen() {
        String actualRes = getTextBase(firstTopfTitle);
        String expectedRes = "Topf 1";
        return isStringsEqual(actualRes, expectedRes);
    }

    public boolean verifyMeineToepfePageAccessError() {
        String actualRes = getTextBase(pageAccessError);
        String expectedRes = "Diese Seite ist nur für registrierte und eingeloggte Benutzer/innen verfügbar";
        return isStringsEqual(actualRes, expectedRes);
    }

}
