package Pages;

import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.PanierPage;
import Pages.ProductsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Step {

    @Test
    public void addParisEspressoAndValidateShowsLogin() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.nespresso.com/fr");

            ProductsPage productsPage = new ProductsPage(driver);
            HeaderPage headerPage     = new HeaderPage(driver);
            PanierPage panierPage     = new PanierPage(driver);
            LoginPage loginPage       = new LoginPage(driver);

            // 1. Add Paris Espresso with quantity 80
            productsPage.addParisEspressoWithQuantity(80);

            // 2. Go to panier
            headerPage.goToPanier();

            // 3. Validate order
            panierPage.validerCommande();

            // 4. Check login page appears
            Assert.assertTrue("Login page should be displayed",
                    loginPage.isDisplayed());

        } finally {
            driver.quit();
        }
    }
}