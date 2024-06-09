package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnmeldenPage extends BasePage{
    public AnmeldenPage(WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement anmeldenPageTitle;
    @FindBy(xpath = )
    WebElement anmeldenBtnInHeader;
    @FindBy(xpath = )
    WebElement inputEmail;
    @FindBy(xpath = )
    WebElement inputPassword;
    @FindBy(xpath = )
    WebElement checkbox;
    @FindBy(xpath = )
    WebElement anmeldenBtnInForm;
    @FindBy(xpath = )
    WebElement abmeldenBtn;
    @FindBy(xpath = )
    WebElement confirmAbmeldenBtn;
    @FindBy(xpath = )
    WebElement errorLoginMessage;



    public boolean VerifyAnmeldenPageOpen() {
        String actualRes = GetTextBase(anmeldenPageTitle);
        String expectedRes = "Anmelden";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public AnmeldenPage LoginUser (String userEmail, String userPassword) {
        Click(anmeldenBtnInHeader);
        TypeText(inputEmail, userEmail);
        TypeText(inputPassword, userPassword);
        Click(anmeldenBtnInForm);
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
