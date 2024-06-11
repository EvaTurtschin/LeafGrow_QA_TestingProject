package pages;

import dev.failsafe.internal.util.Assert;
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



    public boolean VerifyAnmeldenPageOpen() {
        String actualRes = GetTextBase(anmeldenPageTitle);
        String expectedRes = "Schön, dass du wieder da bist!";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public AnmeldenPage LoginUser (String userEmail, String userPassword) {
        new HomePage(driver).ClickAnmeldenBtnInHeader();
        new AnmeldenPage(driver);
        TypeText(inputEmail, userEmail);
        TypeText(inputPassword, userPassword);
        ClickWithJSScroll(anmeldenBtnInForm);
        return new AnmeldenPage(driver);
    }

    public AnmeldenPage checkLoginCheckbox() {
        Click(checkbox);
        return new AnmeldenPage(driver);
    }

    public boolean VerifyLoginUnsucceed() {
        String actualRes = GetTextBase(errorLoginMessage);
        String expectedRes = "Oops! Etwas ist schiefgegangen.";
        return IsStringsEqual(actualRes, expectedRes);
    }
}
