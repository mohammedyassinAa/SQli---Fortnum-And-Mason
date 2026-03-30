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


//id  name cssselector  xpath
//    . means the value of the node element which is h3

    @FindBy(className ="level-top")
    private WebElement cqfeElement;

    @FindBy(css = "li[data-product-item-id='1335']")
    private WebElement parisEspressoItem;

    @FindBy(css = "li[data-product-item-id='1335'] button.action.tocart.primary.list")
    private WebElement parisEspressoAddButton;

    @FindBy(css = "li[data-product-item-id='1335'] input.qty-selector-input[name='qty']")
    private WebElement parisEspressoQuantityInput;

    @FindBy(css = "li[data-product-item-id='1335'] button.qty-selector-btn")
    private WebElement parisEspressoQtyOkButton;

    @FindBy(css=".counter-number")
    private WebElement parisEspressoCounterNumber;

    public void clickDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(cqfeElement)).click();
    }
    public void addParisEspressoWithQuantity(int quantity) {
//       wait for the element
     wait.until(ExpectedConditions.visibilityOf(parisEspressoItem));
     // Scroll to product
    ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", parisEspressoItem);
        // Wait and set qt
        wait.until(ExpectedConditions.visibilityOf(parisEspressoItem));
        wait.until(ExpectedConditions.elementToBeClickable(parisEspressoAddButton));
        parisEspressoAddButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(parisEspressoQuantityInput));
        parisEspressoQuantityInput.clear();
        parisEspressoQuantityInput.sendKeys(String.valueOf(quantity));
        parisEspressoQtyOkButton.click();
        wait.until(ExpectedConditions.visibilityOf(parisEspressoCounterNumber));
    }
    public void addProductToCartByName(String productName) {
        By productItem = By.xpath("//li[.//span[contains(text(),'" + productName + "')]]");
        By addButton   = By.xpath("//li[.//span[contains(text(),'" + productName + "')]]//button[contains(@class,'tocart')]");

        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(productItem));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", item);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        button.click();

        wait.until(ExpectedConditions.visibilityOf(parisEspressoCounterNumber));
    }
}