package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MeineToepfePage extends BasePage{
    public MeineToepfePage(WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement meineToepfePageTitle;


    public boolean verifyMeineToepfePageOpen() {
        String actualRes = getTextBase(meineToepfePageTitle);
        String expectedRes = "Meine Töpfe";
        return isStringsEqual(actualRes, expectedRes);
    }
}
