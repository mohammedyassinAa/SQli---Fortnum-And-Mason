package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement coockieElement;

    @FindBy(css = "a.action.create.primary")
    private WebElement create_account_button;

    @FindBy(id = "header-login-link")
    private WebElement login_icon;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement login_button;

    public void acceptCookies() {
        wait.until(ExpectedConditions.visibilityOf(coockieElement)).click();
    }
    public void checkCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(create_account_button));
    }
    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(login_icon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", login_icon);
    }
//    public void clickLoginButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(login_icon));
//        wait.until(ExpectedConditions.elementToBeClickable(login_icon));
//        login_button.click();
//    }
    public void enterUsername(String username) {
        emailField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void validateLogin() {
        login_button.click();
    }
}