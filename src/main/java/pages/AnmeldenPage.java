package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnmeldenPage extends BasePage{
    public AnmeldenPage(WebDriver driver) { super(driver);}
    @FindBy(xpath = "//h3[text()='Schön, dass du wieder da bist!']")
    WebElement anmeldenPageTitle;
    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement anmeldenBtnInForm;
    @FindBy(xpath = "//button[text()='Registrieren']")
    WebElement regisrterierenBtn;

    public boolean verifyAnmeldenPageOpen() {
        String actualRes = getTextBase(anmeldenPageTitle);
        String expectedRes = "Schön, dass du wieder da bist!";
        return isStringsEqual(actualRes, expectedRes);
    }
    public void loginUser (String userEmail, String userPassword) {
        new HomePage(driver).clickAnmeldenBtnInHeader();
        new AnmeldenPage(driver);
        clear(inputEmail);
        typeText(inputEmail, userEmail);
        clear(inputPassword);
        typeText(inputPassword, userPassword);
        click(checkbox);
        click(anmeldenBtnInForm);
    }
    public void clickRegisterBtn() {
        new AnmeldenPage(driver).clickWithJSScroll(regisrterierenBtn);
    }

}
