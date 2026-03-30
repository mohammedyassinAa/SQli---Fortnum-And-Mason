package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;


public class PanierPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public PanierPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(css = "div.showcart-wrapper")
    private WebElement showCart;

//    @FindBy(css = "li[data-product-item-id='1335']")
//    @FindBy(xpath = "//a[normalize-space()='Paris Espresso'] ")
    @FindBy(xpath = "//div[contains(@class,'block-minicart')]//a[normalize-space()='Paris Espresso']")
    private WebElement parisEspressoCartItem;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;


    public void GotoCart() {
        wait.until(ExpectedConditions.elementToBeClickable(showCart));
        showCart.click();
        wait.until(ExpectedConditions.visibilityOf(parisEspressoCartItem));
    }
    public boolean isParisEspressoInCart() {
        try {
            return parisEspressoCartItem.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }
}