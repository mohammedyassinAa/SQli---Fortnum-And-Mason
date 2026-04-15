package Tests.StepDefinitions;

//import Pages.SignInPage;
import Pages.SignInPage;
import Tests.Tools.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SignInStepDefinitions {
    WebDriver driver;
    SignInPage signInPage = new SignInPage(Hooks.driver);


    @And("user navigates to SignIn Page")
    public void userNavigatesToSignInPage() {
        System.out.println("Navigating to Login Page...");
        signInPage.navigatesToSignINPage();

    }

    @When("user fills in all required fields with valid values {string}, {string}, {string}, {string}, {string}")
    public void userFillsInAllRequiredFieldsWithValidValuesEmailFirstNameLastNamePasswordRepeatPassword(String email , String firstname ,String lastname , String confirmPassword, String pwd ) {
        signInPage.enterEmail(email);
        signInPage.enterFirstName(firstname);
        signInPage.enterLastName(lastname);
        signInPage.enterPwd(pwd);
        signInPage.confirmPassword(confirmPassword);
        signInPage.clickCreateAccountButton();
    }


    @Then("account is created successfully")
    public void accountIsCreatedSuccessfully() {
        signInPage.successMessageIsDisplayed();
    }

    @When("user fills in all blank fields with valid values {string}, {string}, {string}, {string}, {string}")
    public void userFillsInAllBlankFieldsWithValidValuesEmailFirstNameLastNamePasswordRepeatPassword(String email , String firstname ,String lastname , String confirmPassword, String pwd ) {
        signInPage.enterEmail(email);
        signInPage.enterFirstName(firstname);
        signInPage.enterLastName(lastname);
        signInPage.enterPwd(pwd);
        signInPage.confirmPassword(confirmPassword);
        signInPage.clickCreateAccountButton();
    }

}
