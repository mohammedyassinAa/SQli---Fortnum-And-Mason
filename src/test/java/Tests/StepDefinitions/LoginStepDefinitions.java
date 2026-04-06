package Tests.StepDefinitions;

import Pages.LoginPage;
import Tests.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage = new LoginPage(Hooks.driver);;

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        System.out.println("Opening Home page...");
        loginPage.acceptCookies();
    }

    @And("user choose country")
    public void userChooseCountry() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Choosing country...");
        loginPage.startShopping();
    }

    @And("user navigates to Login Page")
    public void userNavigatesToLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
