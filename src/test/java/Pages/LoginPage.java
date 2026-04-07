package Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public  String LOGIN_URL = "https://www.fortnumandmason.com/login";
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[contains(@data-pc-section,\"content\")]//span[text()='Start Shopping']")
    private WebElement startShoppingButton;

    @FindBy(id = "account-link")
    public WebElement loginIcon;

    @FindBy(css = "input[aria-label='Email Address']")
    public WebElement emailField;

    @FindBy(css = "button[aria-label='Login']")
    public WebElement loginButton;

    @FindBy(css = "input[aria-label='Password']")
    public WebElement passwordField;

    @FindBy(css = "button[aria-label='Sign-in']")
    public WebElement signinButton;

    public void acceptCookiesIfPresent() {
        try {

            WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usercentrics-root")));
            SearchContext shadowRoot = shadowHost.getShadowRoot();

            // specific wait for the accept button
            WebDriverWait buttonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookies = buttonWait.until(driver1 -> shadowRoot.findElement(By.cssSelector("[data-testid='uc-accept-all-button']")));
            acceptCookies.click();

            // Wait for the overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("usercentrics-root")));
        } catch (Exception e) {
            System.out.println("Cookies not present !!");
        }
    }

//    public void removeHoverMenu() {
//        Actions actions = new Actions(driver);
//        // Move mouse to (0,0) or to another neutral element out of the way
//        actions.moveByOffset(0, 0).perform();
////        // OR move to the body (page) area
//        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0).perform();
//        // Alternatively, move to another element not covered by the menu
//    }
    public void startShoppingIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(startShoppingButton));
            startShoppingButton.click();
        } catch (Exception e) {
            System.out.println("Start Shopping (country selector) not present, continuing...");
        }
    }

    public void waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Overlay with locator " + locator + " did not disappear in time or not present.");
        }
    }

    public void handleInitialPopupsIfPresent() {
        acceptCookiesIfPresent();
        startShoppingIfPresent();
    }

    public void navigatesToLoginPage() {
        waitForElementToDisappear(By.id("usercentrics-root"));
        waitForElementToDisappear(By.xpath("//div[@class='p-dialog-content']"));
        System.out.println("Navigating to Login Page...");
        wait.until(ExpectedConditions.visibilityOf(loginIcon));
        loginIcon.click();
        wait.until(ExpectedConditions.urlToBe(LOGIN_URL));

    }

    public void enterUsername(String username) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).perform();
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(username);
    }
    public void clickLoginButton() {

        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

//    public void validateLogin() {
//        wait.until(ExpectedConditions.visibilityOf(signinButton));
//        signinButton.click();
//    }
}