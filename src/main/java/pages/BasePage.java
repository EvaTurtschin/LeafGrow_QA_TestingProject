package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    WebDriver driver;
    JavascriptExecutor js;
    static Logger logger = LoggerFactory.getLogger(pages.BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void Click(WebElement element) {
        element.click();
    }

    public void ClickWithJSScroll(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        Click(element);
    }

//    public void scrollAndClick(WebElement element) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element);
//        actions.perform();
//        element.click();
//    }

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
        driver.get("");
    }

    public void TypeText(WebElement element, String text) {
        Click(element);
        element.clear();
        element.sendKeys(text);
    }
//
//    protected Keys GetKeyForOSCommandOrControl() {
//        String os = System.getProperty("os.name");
//        System.out.println("my os: " + os);
//        if(os.startsWith("Mac")) {
//            return Keys.COMMAND;
//        } else if(os.startsWith("Win")) {
//            return Keys.CONTROL;
//        }
//        return Keys.CONTROL;
//    }



}
