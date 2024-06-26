package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver init() {
        if (browser.equals("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        } else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--lang=en");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser != null &&
                !browser.equalsIgnoreCase("edge") &&
                !browser.equalsIgnoreCase("firefox") &&
                !browser.equalsIgnoreCase("chrome")) {
            throw new IllegalArgumentException("Browser entered is not correct");
        }

        driver = new EventFiringDecorator(new WDListener()).decorate(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://leafgrow-app-foign.ondigitalocean.app/#/");

        return driver;
    }
    public void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

//TODO
//    public WebDriver init(String[] platforms) {
//        for (String platform : platforms) {
//    public static void main(String[] args) {
//        ApplicationManager example = new ApplicationManager();
//        String[] platforms = {"edge", "firefox", "chrome"};
//        // Initialize WebDriver for each platform in the specified order
//        example.init(platforms);
//        // Optionally, you can return driver from init() and use it further
//    }
}
