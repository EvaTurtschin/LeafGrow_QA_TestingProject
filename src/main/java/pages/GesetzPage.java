package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GesetzPage extends BasePage{
    public GesetzPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement gesetzPageTitle;

    public boolean VerifyGesetzPageOpen() {
        String actualRes = GetTextBase(gesetzPageTitle);
        String expectedRes = "Gesetzliche Informationen";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public HomePage switchToHomePage(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return new HomePage(driver);
    }

//    public GesetzPage closeCurrentTab() {
//        driver.close();
//        return this;
//    }
}
