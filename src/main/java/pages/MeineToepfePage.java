package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MeineToepfePage extends BasePage{
    public MeineToepfePage(WebDriver driver) { super(driver);}
    @FindBy(xpath = "//h3[text()='Topf 1']")
    WebElement firstTopfTitle;
    @FindBy(xpath = "//p[@class='css-db06rd']")
    WebElement pageAccessError;

//    public boolean verifyMeineToepfePageOpen() {
//        wait.until(ExpectedConditions.visibilityOf(firstTopfTitle));
//        String actualRes = getTextBase(firstTopfTitle);
//        String expectedRes = "Topf 1";
////        return isStringsEqual(actualRes, expectedRes);
//
//        boolean isPageOpen = actualRes.equals(expectedRes);
//        if (isPageOpen) {
//            logger.info("Meine Toepfe page verified successfully.");
//        } else {
//            logger.error("Expected result: " + expectedRes + ". Actual result: " + actualRes);
//        }
//        return isPageOpen;
//    }

    public boolean verifyMeineToepfePageOpen() {
        try {
            logger.info("Waiting for the first topf title to be visible.");
            wait.until(ExpectedConditions.visibilityOf(firstTopfTitle));
            String actualRes = getTextBase(firstTopfTitle);
            String expectedRes = "Topf 1";
            logger.info("Actual result: " + actualRes); // Логируем значение

            boolean isPageOpen = actualRes.equals(expectedRes);
            if (isPageOpen) {
                logger.info("Meine Toepfe page verified successfully.");
            } else {
                logger.error("Expected result: " + expectedRes + ". Actual result: " + actualRes);
            }
            return isPageOpen;
        } catch (Exception e) {
            logger.error("Error during verifying Meine Toepfe page: ", e);
            return false;
        }
    }

    public boolean verifyMeineToepfePageAccessError() {
        String actualRes = getTextBase(pageAccessError);
        String expectedRes = "Diese Seite ist nur für registrierte und eingeloggte Benutzer/innen verfügbar";
        return isStringsEqual(actualRes, expectedRes);
    }
}
