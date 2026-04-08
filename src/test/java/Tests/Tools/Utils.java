package Tests.Tools;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static void clearUIState(WebDriver driver) {
        try {
            WebElement body = driver.findElement(By.tagName("body"));

            // 1️⃣ Close hover menus / overlays
            body.sendKeys(Keys.ESCAPE);
            body.sendKeys(Keys.ESCAPE);

            // 2️⃣ Click neutral area (safe reset)
            ((JavascriptExecutor) driver).executeScript(
                    "document.body.click();"
            );

            // 3️⃣ Remove focus from active element
            ((JavascriptExecutor) driver).executeScript(
                    "if(document.activeElement) document.activeElement.blur();"
            );

            // 4️⃣ Small controlled wait (instead of Thread.sleep)
            new WebDriverWait(driver, Duration.ofMillis(300))
                    .until(d -> true);

        } catch (Exception e) {
            System.out.println("UI state cleanup issue: " + e.getMessage());
        }
    }
}