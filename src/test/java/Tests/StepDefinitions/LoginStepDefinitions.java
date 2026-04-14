package Tests.StepDefinitions;

import Pages.LoginPage;
import Tests.Tools.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        System.out.println("Opening Home page and handling popups...");
        loginPage.handleInitialPopupsIfPresent();
    }

    @And("user navigates to Login Page")
    public void userNavigatesToLoginPage() {
        System.out.println("Navigating to Login Page...");
        loginPage.navigatesToLoginPage();
    }

    @When("user fill username {string}")
    public void userFillUsername(String username) {
        System.out.println("Filling username...");
//        replace sys
        loginPage.enterUsername(username);
        loginPage.clickLoginButton();
    }
    @And("user fill password {string}")
    public void userFillPassword(String password) {
        System.out.println("Filling password...");
        loginPage.enterPassword(password);
        loginPage.clickSigninButton();
    }

    @Then("success message is displayed")
    public void sucsessMessageShouldAppear() {
        System.out.println("sucess toast should appear");
        loginPage.successMessageIsDisplayed();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        System.out.println("error toast should appear");
        loginPage.errorMessageIsDisplayed();
    }

    @Then("email error message is displayed")
    public void emailErrorMessageIsDisplayed() {
        System.out.println("email error ");
        loginPage.emailErrorMessageIsDisplayed();
    }

    @Then("password error message is displayed")
    public void passwordErrorMessageIsDisplayed() {
        System.out.println("password error ");
        loginPage.passwordErrorMessageIsDisplayed();
    }
}
