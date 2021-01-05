package ua.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingTab {
    private WebDriver driver;

    public ShippingTab (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "cgv")
    private WebElement checkboxIagree;

    @FindBy(xpath ="//button[@name='processCarrier']")
    private WebElement proceedButtonShippingPage;

    public ShippingTab selectIagreeCheckbox(){
        checkboxIagree.click();
        return this;
    }

    public ShippingTab clickProceedButtonOnShippingTab(){
        proceedButtonShippingPage.click();
        return this;
    }

}
