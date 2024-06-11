package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "")
    WebElement registrationConfirmedMessage;

    @FindBy(xpath = "//input[@name='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//p[text()='Ungültige E-Mail']")
    WebElement invalidEmailErrorMessage;

    @FindBy(xpath = "//p[text()='Passwort ist erforderlich']")
    WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = "//p[@class='css-1qyeu3y']")
    WebElement invalidUsernameErrorMessage;

    @FindBy(xpath = "//a[@class='css-yf0dah']")
    WebElement backToRegisterForm;

//    @FindBy(xpath = )
//    WebElement existedEmailErrorMessage;
//
//    @FindBy(xpath = )
//    WebElement existedUsernameErrorMessage;

    @FindBy(xpath = "//div[text()='Checkbox muss akzeptiert werden']")
    WebElement unsignedCheckboxErrorMessage;

    public RegistrationPage RegisterUser(String userName, String userEmail, String userPassword) {
        new AnmeldenPage(driver).Click(regisrterierenBtn);
        new RegistrationPage(driver);
        TypeText(inputBenutzerName, userName);
        TypeText(inputEmail, userEmail);
        TypeText(inputPassword, userPassword);
        Click(checkbox);
        Click(kontoErstellenBtn);
        return new RegistrationPage(driver);
    }

    public boolean VerifyEmailSendingSuccess() {
        String actualRes = GetTextBase(emailSendingMessage);
        String expectedRes = "Wir haben dir eine E-Mail mit dem Verifizierungslink geschickt.";
        return IsStringsEqual(actualRes, expectedRes);
    }

//    public boolean VerifyUserRegisterationSuccess() {
//        String actualRes = GetTextBase(registrationConfirmedMessage);
//        String expectedRes = "Du hast dich erfolgreich registriert";
//        return IsStringsEqual(actualRes, expectedRes);
//    }

    public boolean VerifyInvalidEmailErrorMessage() {
        String actualRes = GetTextBase(invalidEmailErrorMessage);
        String expectedRes = "Ungültige E-Mail";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public boolean VerifyInvalidPasswordErrorMessage() {
        String actualRes = GetTextBase(invalidPasswordErrorMessage);
        String expectedRes1 = "Mindestens 8 Zeichen";
        //TODO String expectedRes2 = "Mindestens 1 Ziffer";
        //TODO String expectedRes3 = "Mindestens 1 Kleinbuchstabe";
        //TODO String expectedRes4 = "Mindestens 1 Großbuchstabe";
        return IsStringsEqual(actualRes, expectedRes1);
    }


    public boolean VerifyInvalidUsernameErrorMessage() {
        String actualRes = GetTextBase(invalidUsernameErrorMessage);
        String expectedRes = "Mindestens 2 Zeichen";
        return IsStringsEqual(actualRes, expectedRes);
    }

//    public boolean VerifyAlreadyExistedEmailErrorMessage() {
//        String actualRes = GetTextBase(existedEmailErrorMessage);
//        String expectedRes = "Dieser Email wird bereits verwendet. Bitte, verwende einen anderen Email";
//        return IsStringsEqual(actualRes, expectedRes);
//    }
//
//    public boolean VerifyAlreadyExistedUsernameErrorMessage() {
//        String actualRes = GetTextBase(existedUsernameErrorMessage);
//        String expectedRes = "Dieser Benutzername wird bereits verwendet. Bitte, verwende einen anderen Benutzernamen";
//        return IsStringsEqual(actualRes, expectedRes);
//    }

    public boolean VerifyUnsignetCheckboxErrorMessage() {
        String actualRes = GetTextBase(unsignedCheckboxErrorMessage);
        String expectedRes = "Checkbox muss akzeptiert werden";
        return IsStringsEqual(actualRes, expectedRes);
    }
}
