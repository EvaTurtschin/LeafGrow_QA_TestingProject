package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    WebDriver driver;
    //static Logger logger = LoggerFactory.getLogger(pages.BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Click(WebElement element) {
        element.click();
    }

    public void ClickWithJSScroll(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }

    protected boolean IsStringsEqual(String actualRes, String expectedRes) {
        if (actualRes.equals(expectedRes)) {
            return true;
        } else {
            System.out.println("actual res: " + actualRes +
                    " expected res " + expectedRes);
            return false;
        }
    }

      public String GetTextBase(WebElement element) {
          return element.getText().trim();
      }

    public boolean IsElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void NavigateToHomePage() {
        driver.get("http://localhost:5173/");
    }

    public void TypeText(WebElement element, String text) {
        Click(element);
        element.clear();
        element.sendKeys(text);
    }

}
