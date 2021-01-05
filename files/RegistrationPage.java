package ua.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_firstname")
    private WebElement enterFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement enterLastName;

    @FindBy(name = "passwd")
    private WebElement enterPassword;

    @FindBy(id = "firstname")
    private WebElement enterFirName;

    @FindBy(id = "lastname")
    private WebElement enterLasName;

    @FindBy(id = "company")
    private WebElement setCompanyName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement setAddress1;

    @FindBy(id = "city")
    private WebElement setCityName;

    @FindBy(id = "postcode")
    private WebElement setPostCode;

    @FindBy(id = "other")
    private WebElement setOther;

    @FindBy(id = "phone")
    private WebElement setPhone;

    @FindBy(id = "phone_mobile")
    private WebElement setPhoneMobile;

    @FindBy(id = "alias")
    private WebElement setAlias;

    @FindBy(id = "submitAccount")
    private WebElement clickSubmitAccount;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement erMessage;

    @FindBy(xpath = "//i[@class='icon-list-ol']")
    private WebElement myAcPage;

    @FindBy(css = "div#block_top_menu> ul > li > a[title='Dresses']")
    private WebElement dressesTab;

    //"div#block_top_menu > ul > li.sfHoverForce > a"

    public void selectState(String text) {
        WebElement stateDropdown = driver.findElement(By.id("id_state"));
        Select value = new Select(stateDropdown);
        value.selectByVisibleText(text);
    }

    public RegistrationPage enterFirstNameField() {
        enterFirstName.sendKeys("Jane");
        return this;
    }

    public RegistrationPage enterLastNameTField() {
        enterLastName.sendKeys("Jones");
        return this;
    }

    public RegistrationPage enterPasswordToField() {
        enterPassword.sendKeys("123123");
        return this;
    }

    public RegistrationPage enterFirstNameInAddress() {
        enterFirName.sendKeys("Jane");
        return this;
    }

    public RegistrationPage enterLastNameInAddress() {
        enterLasName.sendKeys("Jonny");
        return this;
    }

    public RegistrationPage enterCompanyInAddress() {
        setCompanyName.sendKeys("TestCompany");
        return this;
    }

    public RegistrationPage enterAddressInAddress() {
        setAddress1.sendKeys("Germany");
        return this;
    }

    public RegistrationPage enterCityInAddress() {
        setCityName.sendKeys("Berlin");
        return this;
    }

    public RegistrationPage enterPostCodeInAddress() {
        setPostCode.sendKeys("07936");
        return this;
    }

    public RegistrationPage enterOtherInAddress() {
        setOther.sendKeys("other text");
        return this;
    }

    public RegistrationPage enterPhoneInAddress() {
        setPhone.sendKeys("777444333");
        return this;
    }

    public RegistrationPage enterPhoneMobileInAddress() {
        setPhoneMobile.sendKeys("+34444445789");
        return this;
    }

    public RegistrationPage enterAliasInAddress() {
        setAlias.sendKeys("al");
        return this;
    }

    public RegistrationPage submitRegisterButton() {
        clickSubmitAccount.click();
        return this;
    }

    public RegistrationPage errorDisplayedMessage() {
        erMessage.isDisplayed();
        return this;
    }

 public RegistrationPage clickDressesTab(){
        dressesTab.click();
        return this;

 }

}
