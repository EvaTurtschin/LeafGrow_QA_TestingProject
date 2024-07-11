package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPotsPage extends BasePage{
    public MyPotsPage(WebDriver driver) { super(driver);}
    @FindBy(xpath = "//h3[text()='Topf 1']")
    WebElement firstPotTitle;
    @FindBy(xpath = "//p[@class='css-pmqoh1']")
    WebElement pageAccessError;
//    @FindBy(xpath = "//div[@class='css-tr0eku']")
//    WebElement firstPotBtn;
    @FindBy(xpath = "//h3[text()='Topf 2']")
    WebElement secondPotTitle;
    @FindBy(xpath = "//h3[text()='Topf 3']")
    WebElement thirdPotTitle;

    public boolean verifyMyPotsPageOpen() {
        return isElementDisplayed(firstPotTitle);
    }

    public boolean verifyMyPotsPageAccessError() {
        String actualRes = getTextBase(pageAccessError);
        String expectedRes = "Diese Seite ist nur für registrierte und eingeloggte Benutzer/innen verfügbar";
        return isStringsEqual(actualRes, expectedRes);
    }
    public void firstPotClick() {
        click(firstPotTitle);
    }
    public void secondPotClick() {
        click(secondPotTitle);
    }
    public void thirdPotClick() {
        click(thirdPotTitle);
    }
    public boolean verifyPotDeactivated() {
        return isElementDisplayed(firstPotTitle);
    }
}
