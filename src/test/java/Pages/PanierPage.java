package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PanierPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PanierPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // TODO: locator for "Valider" button
    @FindBy(xpath = "//button[@id='ta-mini-basket__checkout' and normalize-space(.)='Valider votre panier']")
    private WebElement validerButton;

    public void validerCommande() {
        wait.until(ExpectedConditions.elementToBeClickable(validerButton));
        validerButton.click();
    }
}