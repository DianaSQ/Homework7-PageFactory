package ua.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMain {
    private WebDriver driver;



    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInButton;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement submitField;

    public PageMain (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public PageMain pressSignButton(){
        //       WebElement signInButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signInButton.click();
        return this;

    }

    public PageMain fillSearchField(){
        //       WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.clear();
        searchField.sendKeys("Blouse");
        return this;
    }

    public PageMain submitSearchField (){
//        WebElement submitField = driver.findElement(By.xpath("//button[@name='submit_search']"));
        submitField.click();
        return this;
    }
}
