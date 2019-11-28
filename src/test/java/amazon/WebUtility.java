package amazon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WebUtility<result> {
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
    }

    private static ChromeDriver _driver;

    public static ChromeDriver getChromeInstance() {
        if (_driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            _driver = new ChromeDriver(options);
        }
        return _driver;
    }

    public static String getValueAttributeObject(By id) {
        waitForElementVisible(id);
        String valueAttributeObject = _driver.findElement(id).getAttribute("class");
        return valueAttributeObject;
    }

    public static void redirectTo(String url) {
        _driver.navigate().to(url);
    }

    public static void waitForElementVisible(By id) {
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        wait.until(visibilityOfElementLocated(id));
    }

    public static String getValue(By id) {
        waitForElementVisible(id);
        waitForAction(300);
        String getValue = _driver.findElement(id).getText();
        return getValue;
    }

    public static void waitAndFill(By id, String value) {
        waitForElementVisible(id);
        Actions actions = new Actions(_driver);
        actions.moveToElement(_driver.findElement(id));
        actions.click();
        actions.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
        actions.build().perform();
    }

    public static void waitAndClick(By id) {
        waitForElementVisible(id);
        waitForAction(500);
        _driver.findElement(id).click();
    }

    public static void waitForAction(int millsec) {
        try {
            Thread.sleep(millsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void closeBrowser() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _driver.close();
    }
}