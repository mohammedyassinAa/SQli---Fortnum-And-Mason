package Tests;
import Pages.LoginPage;
import Pages.PanierPage;
import Pages.ProductsPage;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Collections;

public class addParisEspresso {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
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
        driver.get("https://www.nespresso.com/ma/fr");
    }

    @Test
    public void addParisEspressoAndValidateShowsLogin() {

        ProductsPage productsPage = new ProductsPage(driver);
        PanierPage panierPage = new PanierPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.acceptCookies();
        productsPage.clickDropdown();
        productsPage.addParisEspressoWithQuantity(80);
//      Panier
        panierPage.GotoCart();
        panierPage.clickProceedToCheckout();
//     Login
        loginPage.checkCreateAccountButton();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}