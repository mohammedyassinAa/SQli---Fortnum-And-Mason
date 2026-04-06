package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(xpath = "//div[contains(@data-pc-section,\"content\")]//span[text()='Start Shopping']")
    private WebElement startShoppingButton;

//    @FindBy(css = "a.action.create.primary")
//    private WebElement create_account_button;

//    @FindBy(id = "header-login-link")
//    private WebElement login_icon;
//
//    @FindBy(id = "email")
//    private WebElement emailField;
//
//    @FindBy(id = "pass")
//    private WebElement passwordField;
//
//    @FindBy(id = "send2")
//    private WebElement login_button;
//
//    @FindBy(className = "base")
//    private WebElement accountHeader;
//
//    @FindBy(css = "div[data-ui-id='message-error']")
//    private WebElement errorMessage;
//
//    @FindBy(id = "email-error")
//    private WebElement errorEmailMessage;
//
//    @FindBy(id = "pass-error")
//    private WebElement errorPasswordMessage;


    public void acceptCookies() {
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usercentrics-root")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement acceptCookiesButton = shadowRoot.findElement(By.cssSelector("[data-testid='uc-accept-all-button']"));
        acceptCookiesButton.click();
    }
    public void startShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(startShoppingButton));
        startShoppingButton.click();
    }
}
