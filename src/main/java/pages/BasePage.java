package pages;

import org.openqa.selenium.JavascriptExecutor;
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

    public void click(WebElement element) {
        element.click();
    }

    public void clickWithJSScroll(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        click(element);
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

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }

    public String getAttributeBase(WebElement el, String attributeName) {
        return el.getAttribute(attributeName);
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void navigateToHomePage() {
        driver.get("");
    }

    public void type(WebElement element, String text) {
        click(element);
        element.clear();
        element.sendKeys(text);
    }

}
