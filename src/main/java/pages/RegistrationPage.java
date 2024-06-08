package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage (WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement registratrierenBtn;

    @FindBy(xpath = )
    WebElement inputBenutzerName;

    @FindBy(xpath = )
    WebElement inputEmail;

    @FindBy(xpath = )
    WebElement inputPassword;

    @FindBy(xpath = )
    WebElement kontoErstellenBtn;

    @FindBy(xpath = )
    WebElement emailSendingMessage;

    @FindBy(xpath = )
    WebElement registrationConfirmedMessage;

    @FindBy(xpath = )
    WebElement checkbox;

    @FindBy(xpath = )
    WebElement invalidEmailErrorMessage;

    @FindBy(xpath = )
    WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = )
    WebElement invalidUsernameErrorMessage;

    @FindBy(xpath = )
    WebElement existedEmailErrorMessage;

    @FindBy(xpath = )
    WebElement existedUsernameErrorMessage;

    @FindBy(xpath = )
    WebElement unsignedCheckboxErrorMessage;

    public RegistrationPage RegisterUser(String userName, String userEmail, String userPassword) {
        Click(registratrierenBtn);
        TypeText(inputBenutzerName, userName);
        TypeText(inputEmail, userEmail);
        TypeText(inputPassword, userPassword);
        Click(checkbox);
        Click(kontoErstellenBtn);
    }

    public boolean VerifyEmailSendingSuccess() {
        String actualRes = GetTextBase(emailSendingMessage);
        String expectedRes = "Wir haben dir eine E-Mail geschickt";
        return IsStringsEqual(actualRes, expectedRes);

    }

    public boolean VerifyUserRegisterationSuccess() {
        String actualRes = GetTextBase(registrationConfirmedMessage);
        String expectedRes = "Du hast dich erfolgreich registriert";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public boolean VerifyInvalidEmailErrorMessage() {
        String actualRes = GetTextBase(invalidEmailErrorMessage);
        String expectedRes = "";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public boolean VerifyInvalidPasswordErrorMessage() {
        String actualRes = GetTextBase(invalidPasswordErrorMessage);
        String expectedRes = "";
        return IsStringsEqual(actualRes, expectedRes);
    }


    public boolean VerifyInvalidUsernameErrorMessage() {
        String actualRes = GetTextBase(invalidUsernameErrorMessage);
        String expectedRes = "";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public boolean VerifyAlreadyExistedEmailErrorMessage() {
        String actualRes = GetTextBase(existedEmailErrorMessage);
        String expectedRes = "";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public boolean VerifyAlreadyExistedUsernameErrorMessage() {
        String actualRes = GetTextBase(existedUsernameErrorMessage);
        String expectedRes = "";
        return IsStringsEqual(actualRes, expectedRes);
    }

    public boolean VerifyUnsignetCheckboxErrorMessage() {
        String actualRes = GetTextBase(unsignedCheckboxErrorMessage);
        String expectedRes = "";
        return IsStringsEqual(actualRes, expectedRes);
    }
}
