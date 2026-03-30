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


//id apres name aprescsssselector apres xpath
//    . means the value of the node element which is h3
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement coockieElement;

    @FindBy(className ="level-top")
    private WebElement cqfeElement;

    @FindBy(css = "li[data-product-item-id='1335']")
    private WebElement parisEspressoItem;


    @FindBy(css = "li[data-product-item-id='1335'] button.action.tocart.primary.list")
    private WebElement parisEspressoAddButton;

    @FindBy(css = "li[data-product-item-id='1335'] input.qty-selector-input[name='qty']")
    private WebElement parisEspressoQuantityInput;


    public void acceptCookies() {
        coockieElement.click();
    }
    public void clickDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(cqfeElement)).click();
    }
    public void addParisEspressoWithQuantity(int quantity) {
//       wait for the element
     wait.until(ExpectedConditions.visibilityOf(parisEspressoItem));
     // Scroll to product
    ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", parisEspressoItem);

        // Wait and set quantity
        wait.until(ExpectedConditions.visibilityOf(parisEspressoItem));
        wait.until(ExpectedConditions.elementToBeClickable(parisEspressoAddButton));
        parisEspressoAddButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(parisEspressoQuantityInput));
        parisEspressoQuantityInput.clear();
        parisEspressoQuantityInput.sendKeys(String.valueOf(quantity));
    }
}