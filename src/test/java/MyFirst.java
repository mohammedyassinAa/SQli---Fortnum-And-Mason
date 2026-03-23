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
        driver.get("https://selenium.dev");
        driver.manage().window().maximize();
    }

    @Test
    public void Test() {
        var title = driver.getTitle();
        System.out.println(Optional.ofNullable(title));
        Assert.assertEquals(title, "Selenium");
    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}