package Tests.Tools;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static void clearUIState(WebDriver driver) {
        try {
            WebElement body = driver.findElement(By.tagName("body"));

            body.sendKeys(Keys.ESCAPE);
            body.sendKeys(Keys.ESCAPE);

            ((JavascriptExecutor) driver).executeScript(
                    "document.body.click();"
            );

            ((JavascriptExecutor) driver).executeScript(
                    "if(document.activeElement) document.activeElement.blur();"
            );

            new WebDriverWait(driver, Duration.ofMillis(300))
                    .until(d -> true);

        } catch (Exception e) {
            System.out.println("UI state cleanup issue: " + e.getMessage());
        }
    }
}