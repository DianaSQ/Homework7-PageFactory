package ua.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInTabCheckout {
    private WebDriver driver;

    public SignInTabCheckout (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailToLogin;

    @FindBy(id = "passwd")
    private WebElement passToLogin;

    @FindBy(xpath = "//button[@name='SubmitLogin']")
    private WebElement submitToLogin;

    @FindBy(xpath ="//button[@name='processAddress']")
    private WebElement proceedButtonAddresstab;

    public SignInTabCheckout enterEmailToSignIn(){
        emailToLogin.sendKeys("test+15@test.com");
        return this;
    }
    public SignInTabCheckout enterPassToSignIn(){
        passToLogin.sendKeys("123123");
        return this;
    }

    public SignInTabCheckout clickSubmitToSignIn(){
        submitToLogin.click();
        return this;
    }

    public SignInTabCheckout clickProceedButtonAddressTab(){
        proceedButtonAddresstab.click();
        return this;
    }
}
