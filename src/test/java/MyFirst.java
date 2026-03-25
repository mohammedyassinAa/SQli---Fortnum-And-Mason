import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyFirst {
    ChromeDriver driver;  // Declare but don't initialize yet

    @BeforeTest
    public void main() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\chromedriver.exe");

        driver = new ChromeDriver();  // ✅ Now initialize AFTER setting property
        driver.get("https://www.nespresso.com/fr");
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        acceptCookies();
        clickDropdown();
        clickJeCommand();
    }

    public void acceptCookies() {
        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesButton.click();
    }

    public void clickDropdown() {
//        Hovering
        WebElement hoverElement = driver.findElement(By.className("HeaderNavigationBarItem__title"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

    }
    public void clickJeCommand(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement hiddenElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".AccessibleLink.HeaderNavigationBarDropdown__medium-link")
                )
        );
        hiddenElement.click();

    }
    @AfterTest
    public void closeSession() { driver.quit();}

}