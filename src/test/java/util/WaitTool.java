package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class WaitTool {

    public static final int DEFAULT_WAIT_4_PAGE = 40;


    public static WebElement waitForElementClickable(WebDriver driver,
                                                     final By by, int timeOutInSeconds) {
        WebElement element;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
            // implicitlyWait()

            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));

            driver.manage().timeouts()
                    .implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
            // implicitlyWait
            return element; // return the element
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

}
