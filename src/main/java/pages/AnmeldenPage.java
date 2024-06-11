package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnmeldenPage extends BasePage{
    public AnmeldenPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//h3[text()='Schön, dass du wieder da bist!']")
    WebElement anmeldenPageTitle;

    @FindBy(xpath = "//button[@type='button' and text()='Anmelden']")
    WebElement anmeldenBtnInHeader;
    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement anmeldenBtnInForm;
    @FindBy(xpath = "//h3[text()='Oops! Etwas ist schiefgegangen.']")
    WebElement errorLoginMessage;



    public boolean verifyAnmeldenPageOpen() {
        String actualRes = getTextBase(anmeldenPageTitle);
        String expectedRes = "Schön, dass du wieder da bist!";
        return isStringsEqual(actualRes, expectedRes);
    }

    public AnmeldenPage loginUser (String userEmail, String userPassword) {
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver);
        typeText(inputEmail, userEmail);
        typeText(inputPassword, userPassword);
        clickWithJSScroll(anmeldenBtnInForm);
        return new AnmeldenPage(driver);
    }

    public AnmeldenPage checkLoginCheckbox() {
        click(checkbox);
        return new AnmeldenPage(driver);
    }

    public boolean verifyLoginUnsucceed() {
        String actualRes = getTextBase(errorLoginMessage);
        String expectedRes = "Oops! Etwas ist schiefgegangen.";
        return isStringsEqual(actualRes, expectedRes);
    }
}
