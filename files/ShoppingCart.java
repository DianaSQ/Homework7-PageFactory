package ua.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
    private WebDriver driver;

    public ShoppingCart (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    private WebElement proceedButton;

    public ShoppingCart clickProceedButtonCart(){
        proceedButton.click();
        return this;
    }

}
