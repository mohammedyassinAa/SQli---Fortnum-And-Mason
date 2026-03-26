package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

//
//    @FindBy(xpath = "//h3[contains(@class,'ProductCard__footer__name') " +
//            "and contains(@class,'plp-caps-title') " +
//            "and normalize-space(.)='Paris Espresso']")

    @FindBy(xpath = "@FindBy(xpath = \"//h3[contains(normalize-space(.), 'Paris Espresso')]\")\n")
    private WebElement parisEspressoTitle;


    @FindBy(xpath = "AddToBagButtonSmall__quantity")
    private WebElement parisEspressoAddButton;

    @FindBy(id = "ta-quantity-selector__custom-field")
    private WebElement parisEspressoQuantityInput;

    public void clickDropdown() {
//        Hovering
        WebElement clickElement = driver.findElement(By.xpath("//div[contains(@class, 'HeaderNavigationBarItem__title') and normalize-space(text())='Café']"));
        clickElement.click();


    }
    public void acceptCookies() {
        WebElement cookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesButton.click();
    }
    public void addParisEspressoWithQuantity(int quantity) {
//        wait for the element
        wait.until(ExpectedConditions.visibilityOf(parisEspressoTitle));
        // Scroll to product
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", parisEspressoTitle);

        // Wait and set quantity
        wait.until(ExpectedConditions.visibilityOf(parisEspressoTitle));
        wait.until(ExpectedConditions.elementToBeClickable(parisEspressoQuantityInput));
        parisEspressoQuantityInput.clear();
        parisEspressoQuantityInput.sendKeys(String.valueOf(quantity));

        // Click add to cart
        wait.until(ExpectedConditions.elementToBeClickable(parisEspressoAddButton));
        parisEspressoAddButton.click();
    }
}