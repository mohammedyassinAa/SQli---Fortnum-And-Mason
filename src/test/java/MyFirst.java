import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Optional;

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
    }

    public void acceptCookies() {
        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
//        WebElement btn = driver.findElement(By.className("onetrust-accept-btn-handler"));
//        btn.click();
        cookiesButton.click();
    }

    public void clickDropdown() {
        WebElement element = driver.findElement(By.cssSelector(".AccessibleLink.HeaderNavigationBarDropdown__medium-link"));
        element.click();
    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}