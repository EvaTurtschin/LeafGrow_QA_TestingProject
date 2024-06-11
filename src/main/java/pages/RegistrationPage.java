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

    public RegistrationPage registerUser(String userName, String userEmail, String userPassword) {
        new AnmeldenPage(driver).click(regisrterierenBtn);
        new RegistrationPage(driver);
        typeText(inputBenutzerName, userName);
        typeText(inputEmail, userEmail);
        typeText(inputPassword, userPassword);
        click(checkbox);
        click(kontoErstellenBtn);
        return new RegistrationPage(driver);
    }

    public boolean verifyEmailSendingSuccess() {
        String actualRes = getTextBase(emailSendingMessage);
        String expectedRes = "Wir haben dir eine E-Mail mit dem Verifizierungslink geschickt.";
        return isStringsEqual(actualRes, expectedRes);
    }

//    public boolean verifyUserRegisterationSuccess() {
//        String actualRes = getTextBase(registrationConfirmedMessage);
//        String expectedRes = "Du hast dich erfolgreich registriert";
//        return isStringsEqual(actualRes, expectedRes);
//    }

    public boolean verifyInvalidEmailErrorMessage() {
        String actualRes = getTextBase(invalidEmailErrorMessage);
        String expectedRes = "Ungültige E-Mail";
        return isStringsEqual(actualRes, expectedRes);
    }

    public boolean verifyInvalidPasswordErrorMessage() {
        String actualRes = getTextBase(invalidPasswordErrorMessage);
        String expectedRes1 = "Mindestens 8 Zeichen";
        //TODO изменят сообщение о неверной форме пароля
        return isStringsEqual(actualRes, expectedRes1);
    }


    public boolean verifyInvalidUsernameErrorMessage() {
        String actualRes = getTextBase(invalidUsernameErrorMessage);
        String expectedRes = "Mindestens 2 Zeichen";
        return isStringsEqual(actualRes, expectedRes);
    }

//    public boolean verifyAlreadyExistedEmailErrorMessage() {
//        String actualRes = getTextBase(existedEmailErrorMessage);
//        String expectedRes = "Dieser Email wird bereits verwendet. Bitte, verwende einen anderen Email";
//        return isStringsEqual(actualRes, expectedRes);
//    }
//
//    public boolean verifyAlreadyExistedUsernameErrorMessage() {
//        String actualRes = getTextBase(existedUsernameErrorMessage);
//        String expectedRes = "Dieser Benutzername wird bereits verwendet. Bitte, verwende einen anderen Benutzernamen";
//        return isStringsEqual(actualRes, expectedRes);
//    }

    public boolean verifyUnsignetCheckboxErrorMessage() {
        String actualRes = getTextBase(unsignedCheckboxErrorMessage);
        String expectedRes = "Checkbox muss akzeptiert werden";
        return isStringsEqual(actualRes, expectedRes);
    }
}
