package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    protected WebDriverWait wait;
    static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clickWithJSScroll(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    protected boolean isStringsEqual(String actualRes, String expectedRes) {
        if (actualRes.equals(expectedRes)) {
            return true;
        } else {
            logger.info("actual res: " + actualRes +
                    " expected res " + expectedRes);
            return false;
        }
    }

    public void waitTill (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }

    public boolean isElementDisplayed(WebElement element) {

        return element.isDisplayed();
    }

    public void navigateToHomePage() {
        driver.get("https://leafgrow-app-foign.ondigitalocean.app/#/");
    }

    public void typeText(WebElement element, String text) {
        click(element);
        element.clear();
        element.sendKeys(text);
    }
}
