package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // TODO: put a reliable locator for login page (title, form, etc.)
    @FindBy(xpath = "XPATH_FOR_LOGIN_UNIQUE_ELEMENT")
    private WebElement loginUniqueElement;

    public boolean isDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginUniqueElement));
            return loginUniqueElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}