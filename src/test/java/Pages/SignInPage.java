package Pages;

import Tests.Tools.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public  String SIGNIN_URL = "https://www.fortnumandmason.com/login";
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(id = "account-link")
    public WebElement loginIcon;

    @FindBy(xpath = "//button[normalize-space()='Create an Account']")
    public WebElement signInButton;

    @FindBy(css = "input[aria-label='Email Address']")
    public WebElement emailField;


    public void waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Overlay with locator " + locator + " did not disappear in time or not present.");
        }
    }

    public void navigatesToSignINPage() {
        waitForElementToDisappear(By.id("usercentrics-root"));
        waitForElementToDisappear(By.xpath("//div[@class='p-dialog-content']"));
        System.out.println("Navigating to Sign in Page...");
        wait.until(ExpectedConditions.visibilityOf(loginIcon));
        loginIcon.click();
        wait.until(ExpectedConditions.urlToBe(SIGNIN_URL));
        Utils.clearUIState(driver);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
}

