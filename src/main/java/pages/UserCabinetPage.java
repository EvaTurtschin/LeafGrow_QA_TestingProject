package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCabinetPage extends BasePage{
    public UserCabinetPage (WebDriver driver) { super(driver);}

    @FindBy(xpath = )
    WebElement abmeldenBtn;
    @FindBy(xpath = )
    WebElement deleteKontoBtn;
    @FindBy(xpath = )
    WebElement confirmDeletKontoBtn;
    @FindBy(xpath = )
    WebElement cancelCross;
    @FindBy(xpath = )
    WebElement userCabinetIcon;

    public void LogoutUser() {
        Click(abmeldenBtn);
    }

    public UserCabinetPage DeleteUser() {
        Click(deleteKontoBtn);
        Click(confirmDeletKontoBtn);
        return new UserCabinetPage(driver);
    }


    public UserCabinetPage CancelDeletion() {
        Click(deleteKontoBtn);
        Click(cancelCross);
        return new UserCabinetPage(driver);
    }

    public boolean VerifyUserAuthirized() {
        return IsElementDisplayed(userCabinetIcon);
    }
}
