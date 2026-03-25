package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
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


    @FindBy(xpath = "//div[contains(@class, 'ProductCard__footer__name plp-caps-title') and normalize-space(text())='Paris Espresso']")
    private WebElement parisEspressoTitle;

    @FindBy(xpath = "AddToBagButtonSmall__quantity")
    private WebElement parisEspressoAddButton;

    @FindBy(id = "ta-quantity-selector__custom-field")
    private WebElement parisEspressoQuantityInput;



    public void addParisEspressoWithQuantity(int quantity) {
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