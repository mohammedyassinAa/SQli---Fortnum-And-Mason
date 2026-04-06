package Tests;

import Pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        System.out.println("Opening Home page...");
        loginPage = new LoginPage(Hooks.driver);
        loginPage.acceptCookies();
    }


    @And("user navigates to Login Page")
    public void userNavigatesToLoginPage() {
        System.out.println("Opening login page...");
        loginPage.clickLoginButton();
    }

    @When("user fill username {string} and password {string}")
    public void userFillUsernameUsernameAndPasswordPassword(String username, String password) {
        System.out.println("Filling username and password...");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.validateLogin();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        System.out.println("Successfully logged in");
        loginPage.checkAccountHeader();
    }

}