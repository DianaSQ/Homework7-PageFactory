package ua.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemsPageTest {
    private WebDriver driver;

    public ItemsPageTest (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listView;

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sizeCheckbox;

    @FindBy (css = "div.button-container.col-xs-7.col-md-12 > a[data-id-product='3']")
    private WebElement addToCartOne;

    @FindBy (css = "div.button-container.col-xs-7.col-md-12 > a[data-id-product='4']")
    private WebElement addToCartTwo;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeWindowAfterAddingItem;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement summaryArea;

    public ItemsPageTest changeToListView(){
        listView.click();
        return this;
    }

    public ItemsPageTest selectSizeCheckbox(){
        sizeCheckbox.click();
        return this;
    }

    public void sortBySize(String text) {
        WebElement sortDropdown = driver.findElement(By.id("selectProductSort"));
        Select value = new Select(sortDropdown);
        value.selectByVisibleText(text);
    }

    public ItemsPageTest addItemToCArtOne(){
        addToCartOne.click();
        return this;
    }

    public ItemsPageTest addItemToCArtTwo(){
        addToCartTwo.click();
        return this;
    }
    public ItemsPageTest closeWindowAdd(){
        closeWindowAfterAddingItem.click();
     return this;
 }
    public ItemsPageTest proceedToSummaryArea(){
        summaryArea.click();
        return this;
    }



}
