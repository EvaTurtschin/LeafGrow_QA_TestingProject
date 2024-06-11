package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasePage {
    WebDriver driver;
    static Logger logger = LoggerFactory.getLogger(pages.BasePage.class);

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
            System.out.println("actual res: " + actualRes +
                    " expected res " + expectedRes);
            return false;
        }
    }

      public String getTextBase(WebElement element) {
          return element.getText().trim();
      }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void navigateToHomePage() {
        driver.get("http://localhost:5173/");
    }

    public void typeText(WebElement element, String text) {
        click(element);
        element.clear();
        element.sendKeys(text);
    }

}
