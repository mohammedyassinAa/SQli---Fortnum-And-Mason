package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HeaderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ta-mini-basket__open")
    private WebElement panierLink;

    public void goToPanier() {
        wait.until(ExpectedConditions.elementToBeClickable(panierLink));
        panierLink.click();
    }
}