package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class RegistrationPage extends BasePage{
    public RegistrationPage (WebDriver driver) { super(driver);}

    @FindBy(xpath = "//button[text()='Registrieren']")
    WebElement regisrterierenBtn;
    @FindBy(xpath = "//input[@name='username']")
    WebElement inputBenutzerName;
    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement kontoErstellenBtn;
    @FindBy(xpath = "//h1[@class='css-4fphkl']")
    WebElement emailSendingMessage;
    @FindBy(xpath = "//input[@name='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//p[text()='Ungültige E-Mail']")
    WebElement invalidEmailErrorMessage;
    @FindBy(xpath = "//p[text()='Für dein Passwort wähle mindestens 8 Zeichen mit 1 Kleinbuchstabe, 1 Großbuchstabe und 1 Ziffer']")
    WebElement invalidPasswordErrorMessage;
    @FindBy(xpath = "//p[@class='css-1qyeu3y']")
    WebElement invalidUsernameErrorMessage;
    @FindBy(xpath = "//button[@type='button' and text()='Anmelden']")
    WebElement anmeldenBtnInHeader;
    @FindBy(xpath = "//p[@class='css-15c750i']")
    WebElement existedEmailErrorMessage;
    @FindBy(xpath = "//p[@class='css-15c750i']")
    WebElement existedUsernameErrorMessage;
    @FindBy(xpath = "//div[text()='Checkbox muss akzeptiert werden']")
    WebElement unsignedCheckboxErrorMessage;

    public RegistrationPage registerUser(String userName, String userEmail, String userPassword) {
        new AnmeldenPage(driver).clickWithJSScroll(regisrterierenBtn);
        new RegistrationPage(driver);
        typeText(inputBenutzerName, userName);
        typeText(inputEmail, userEmail);
        typeText(inputPassword, userPassword);
        clickWithJSScroll(checkbox);
        clickWithJSScroll(kontoErstellenBtn);
        return new RegistrationPage(driver);
    }

    public RegistrationPage registerNoCeckbox(String userName, String userEmail, String userPassword) {
        new AnmeldenPage(driver).clickWithJSScroll(regisrterierenBtn);
        new RegistrationPage(driver);
        typeText(inputBenutzerName, userName);
        typeText(inputEmail, userEmail);
        typeText(inputPassword, userPassword);
        clickWithJSScroll(kontoErstellenBtn);
        return new RegistrationPage(driver);
    }


    public boolean verifyEmailSendingSuccess() {
        String actualRes = getTextBase(emailSendingMessage);
        String expectedRes = "Wir haben dir eine E-Mail mit dem Verifizierungslink geschickt.";
        return isStringsEqual(actualRes, expectedRes);
    }

    public boolean verifyInvalidEmailErrorMessage() {
        String actualRes = getTextBase(invalidEmailErrorMessage);
        String expectedRes = "Ungültige E-Mail";
        return isStringsEqual(actualRes, expectedRes);
    }

    public boolean verifyInvalidPasswordErrorMessage() {
        String actualRes = getTextBase(invalidPasswordErrorMessage);
        String expectedRes1 = "Für dein Passwort wähle mindestens 8 Zeichen mit 1 Kleinbuchstabe, 1 Großbuchstabe und 1 Ziffer";
        return isStringsEqual(actualRes, expectedRes1);
    }

    public boolean verifyInvalidUsernameErrorMessage() {
        return isElementDisplayed(invalidUsernameErrorMessage);
    }

    public boolean verifyAlreadyExistedEmailErrorMessage() {
        String actualRes = getTextBase(existedEmailErrorMessage);
        String expectedRes = "Dieser Benutzername oder E-Mail werden bereits verwendet. Bitte, verwende einen anderen Benutzernamen oder E-Mail";
        return isStringsEqual(actualRes, expectedRes);
    }

    public boolean verifyAlreadyExistedUsernameErrorMessage() {
        String actualRes = getTextBase(existedUsernameErrorMessage);
        String expectedRes = "Dieser Benutzername oder E-Mail werden bereits verwendet. Bitte, verwende einen anderen Benutzernamen oder E-Mail";
        return isStringsEqual(actualRes, expectedRes);
    }

    public boolean verifyUnsignetCheckboxErrorMessage() {
        String actualRes = getTextBase(unsignedCheckboxErrorMessage);
        String expectedRes = "Checkbox muss akzeptiert werden";
        return isStringsEqual(actualRes, expectedRes);
    }

    public RegistrationPage clickToAnmeldenBtnInHeader() {
        clickWithJSScroll(anmeldenBtnInHeader);
        return new RegistrationPage(driver);
    }
}
