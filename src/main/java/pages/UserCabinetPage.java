package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testData.PositiveTestUserData;

public class UserCabinetPage extends BasePage{

    public UserCabinetPage (WebDriver driver) { super(driver);}
    @FindBy(xpath = "//button[@type='button' and text()='Abmelden']")
    WebElement abmeldenBtn;
    @FindBy(xpath = "//button[@class='css-1qrir7p' and text()='Abmelden']")
    WebElement confirmAbmeldenBtn;
    @FindBy(xpath = "//button[@class='css-gqn8te' and text()='X']")
    WebElement cancelAbmeldenCross;
    @FindBy(xpath = "//button[@class='css-iq7xz6' and text()='Konto löschen']")
    WebElement deleteKontoBtn;
    @FindBy(xpath = "//button[@class='css-1qrir7p' and text()='Konto löschen']")
    WebElement confirmDeletKontoBtn;
    @FindBy(xpath = "//button[@class='css-gqn8te' and text()='X']")
    WebElement cancelDelCross;
    @FindBy(xpath = "//a[@href='#/account']")
    WebElement userCabinetIcon;

    public void logoutUser() {
        new HomePage(driver).clickUserCabinetPageLink();
        logger.info("user cabinet link clicked");
        new UserCabinetPage(driver);
        click(abmeldenBtn);
        click(confirmAbmeldenBtn);
    }

    public void deleteUser() {
        click(deleteKontoBtn);
        click(confirmDeletKontoBtn);
    }

    public UserCabinetPage cancelDeletion() {
        clickWithJSScroll(deleteKontoBtn);
        clickWithJSScroll(cancelDelCross);
        return new UserCabinetPage(driver);
    }

    public boolean verifyUserAuthirized() {
        return isElementDisplayed(userCabinetIcon);
    }

    public UserCabinetPage cancelLogout() {
        new HomePage(driver).clickUserCabinetPageLink();
        logger.info("user cabinet link clicked");
        new UserCabinetPage(driver);
        click(abmeldenBtn);
        click(cancelAbmeldenCross);
        return new UserCabinetPage(driver);
    }

    @FindBy(xpath = "//button[text()=' Passwort ändern']")
    WebElement passwordAndern;
    @FindBy(xpath = "//button[@class='css-gqn8te' and text()='X']")
    WebElement cancelPasAndernCross;
    @FindBy(xpath = "//input[@name='newPassword']")
    WebElement inputNewPassword;
    @FindBy(xpath = "//button[text()='Bestätigen']")
    WebElement confirmPasAndernBtn;
    @FindBy(xpath = "//p[@class='css-1yilg80']")
    WebElement passwordError;
    public UserCabinetPage cancelPasswordChanging() {
        click(passwordAndern);
        click(cancelPasAndernCross);
        return new UserCabinetPage(driver);
    }
    public UserCabinetPage changingPassword() {
        clickWithJSScroll(passwordAndern);
        typeText(inputNewPassword, "Bbb12345");
        click(confirmPasAndernBtn);
        return new UserCabinetPage(driver);
    }

    public boolean verifyPasswordHasNotChanged() {
        logoutUser();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        return isElementDisplayed(userCabinetIcon);
    }

    public boolean verifyPasswordChangeSucceeded() {
        logoutUser();
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver).loginUser(PositiveTestUserData.EMAIL, PositiveTestUserData.PASSWORD);
        String actualRes = getTextBase(passwordError);
        String expectedRes = "Deine E-Mail-Adresse oder dein Passwort sind falsch.";
        return isStringsEqual(actualRes, expectedRes);
    }

}
