package ua.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutifincationPageTest {
    private WebDriver driver1;

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(xpath = "//i[@class='icon-user left']")
    private WebElement createAccountButton;

    public AutifincationPageTest (WebDriver driver1){
        this.driver1=driver1;
        PageFactory.initElements(driver1, this);
    }

    public AutifincationPageTest enterEmailField(){
        //  WebElement emailField = driver1.findElement(By.id("email_create"));
        emailField.sendKeys("test+15@test.com");
        return this;
    }

    public AutifincationPageTest pressCreateAccountButton(){
        //       WebElement createAccountButton = driver1.findElement(By.xpath("//i[@class='icon-user left']"));
        createAccountButton.click();
        return this;
    }
}
