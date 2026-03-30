package Flows;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class loginFlow {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public loginFlow(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
    }

    public void login(String username, String password) {
        // Login part
        loginPage.acceptCookies();
        loginPage.clickLoginButton();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.validateLogin();
    }
}