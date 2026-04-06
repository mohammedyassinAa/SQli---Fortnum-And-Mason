package Tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void setUp() {
//        System.out.println("DEBUG: HOOK IS RUNNING - INITIALIZING DRIVER");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

// 1. Enlever la barre "Chrome est contrôlé par un logiciel de test automatisé"
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
// 2. Masquer la variable WebDriver à JavaScript (très utilisé par les anti-bots)

        options.addArguments("--disable-blink-features=AutomationControlled");

// 3. (Optionnel) Définir un User-Agent de navigateur classique

        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
// On lance le driver avec nos nouvelles options furtives
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.fortnumandmason.com/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
