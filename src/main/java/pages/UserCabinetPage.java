package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCabinetPage extends BasePage{
    public UserCabinetPage (WebDriver driver) { super(driver);}

    @FindBy(xpath = "//button[@class='css-rxsnli' and text()='Abmelden']")
    WebElement abmeldenBtn;
    @FindBy(xpath = "//button[@class='css-1f8sraa' and text()='Abmelden']")
    WebElement confirmAbmeldenBtn;
    @FindBy(xpath = "//button[@class='css-ng1tv9' and text()='X']")
    WebElement cancelAbmeldenCross;
    @FindBy(xpath = "//button[@class='css-2oq7gq' and text()='Konto löschen']")
    WebElement deleteKontoBtn;
    @FindBy(xpath = "//button[@class='css-1f8sraa' and text()='Konto löschen']")
    WebElement confirmDeletKontoBtn;
    @FindBy(xpath = "//button[@class='css-ng1tv9' and text()='X']")
    WebElement cancelDelCross;
    @FindBy(xpath = "//div[@class='css-11u27a6']")
    WebElement userCabinetIcon;

    public void logoutUser() {
        new HomePage(driver).clickUserCabinetPageLink();
        new UserCabinetPage(driver);
        clickWithJSScroll(abmeldenBtn);
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
        click(abmeldenBtn);
        click(cancelAbmeldenCross);
        return new UserCabinetPage(driver);
    }

//TODO
//    @FindBy(xpath = "//button[text()=' Passwort ändern']")
//    WebElement passwordAndern;
//    @FindBy(xpath = "//button[text()='X']")
//    WebElement cancelPasAndernCross;
//    @FindBy(xpath = "//input[@name='newPassword']")
//    WebElement inputNewPassword;
//    @FindBy(xpath = "//button[text()='Bestätigen']")
//    WebElement confirmPasAndernBtn;
//TODO
//    public UserCabinetPage CancelPasChanging() {
//        Click(passwordAndern);
//        Click(cancelPasAndernCross);
//        return new UserCabinetPage(driver);
//    }
//    public UserCabinetPage changingPassword() {
//        ClickWithJSScroll(passwordAndern);
//        Click(confirmPasAndernBtn);
//        return UserCabinetPage(driver);
//    }
}
