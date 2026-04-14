package Tests.StepDefinitions;

//import Pages.SignInPage;
import Pages.SignInPage;
import Tests.Tools.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;

public class SignInStepDefinitions {
    WebDriver driver;
    SignInPage signInPage = new SignInPage(Hooks.driver);


    @And("user navigates to SignIn Page")
    public void userNavigatesToSignInPage() {
        System.out.println("Navigating to Login Page...");
        signInPage.navigatesToSignINPage();

    }

}
