package com.automation;

/*import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;*/
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.automation.pages.*;

public class AddItemsAndRegistration extends BasicClass {
    private PageMain pageMain;
    private AutifincationPageTest  autifincationPageTest;
    private  RegistrationPage registrationPage;
    private ItemsPageTest itemsPageTest;
    private ShoppingCart shoppingCart;
    private SignInTabCheckout signInTabCheckout;
    private ShippingTab shippingTab;


/*    @BeforeClass
    public static void beforeRegistrationPageTest() {
        chrome.navigate().to("http://automationpractice.com/index.php");
    }*/

    @BeforeMethod
    public void setUpPages(){
        pageMain = new PageMain (chrome);
        autifincationPageTest = new AutifincationPageTest(chrome);
        registrationPage = new RegistrationPage(chrome);
        itemsPageTest = new ItemsPageTest(chrome);
       shoppingCart = new ShoppingCart(chrome);
       signInTabCheckout =new SignInTabCheckout(chrome);
       shippingTab = new ShippingTab(chrome);
}

    @Test
    public void registrationUserTest(){
        pageMain.pressSignButton();
        autifincationPageTest.enterEmailField();
        autifincationPageTest.pressCreateAccountButton();
        registrationPage.enterFirstNameField();
        registrationPage.enterLastNameTField();
        registrationPage.enterPasswordToField();
        registrationPage.enterFirstNameInAddress();
        registrationPage.enterLastNameInAddress();
        registrationPage.enterCompanyInAddress();
        registrationPage.enterAddressInAddress();
        registrationPage.enterCityInAddress();
        registrationPage.selectState("Alabama");
        registrationPage.enterPostCodeInAddress();
        registrationPage.enterOtherInAddress();
        registrationPage.enterPhoneInAddress();
        registrationPage.enterPhoneMobileInAddress();
        registrationPage.enterAliasInAddress();
        registrationPage.submitRegisterButton();
        boolean isMyAccountPageDisplayed = chrome.findElement(By.xpath("//i[@class='icon-list-ol']")).isDisplayed();
        Assert.assertTrue(isMyAccountPageDisplayed,"My account page should be opened after registration");
}
    @Test (groups = "positive")
    public void openingDressingTAbAndFiltering(){
        registrationPage.clickDressesTab();
        itemsPageTest.changeToListView();
        itemsPageTest.selectSizeCheckbox();
        itemsPageTest.sortBySize("Price: Lowest first");
        boolean isCheckboxSelected = chrome.findElement(By.id("layered_id_attribute_group_3")).isSelected();
        Assert.assertTrue(isCheckboxSelected, "Size L should be selected");
    }


    @Test (groups = "positive")
    public void addingItemToCart(){
    registrationPage.clickDressesTab();
        itemsPageTest.changeToListView();
        itemsPageTest.selectSizeCheckbox();
    itemsPageTest.addItemToCArtOne();
    itemsPageTest.closeWindowAdd();
   itemsPageTest.addItemToCArtTwo();
   Assert.assertTrue(chrome.findElement(By.className("icon-ok")).isDisplayed(), "Product successfully added to your shopping cart");
    }

    @Test
    public void reviewingCountItemsInTheCart(){
        registrationPage.clickDressesTab();
        itemsPageTest.changeToListView();
        itemsPageTest.selectSizeCheckbox();
        itemsPageTest.addItemToCArtOne();
        itemsPageTest.closeWindowAdd();
        itemsPageTest.addItemToCArtTwo();
        itemsPageTest.proceedToSummaryArea();
        Assert.assertTrue(chrome.findElement(By.xpath("//span[text()='2 Products']")).isDisplayed(),"Two Items should be in the CArt");
    }

    //Test will fail because Total and Total product aren't equal
    @Test (groups = "negative")
    public void verifyTotalAndTotalProducts(){
        registrationPage.clickDressesTab();
        itemsPageTest.changeToListView();
        itemsPageTest.selectSizeCheckbox();
        itemsPageTest.addItemToCArtOne();
        itemsPageTest.closeWindowAdd();
        itemsPageTest.addItemToCArtTwo();
        itemsPageTest.proceedToSummaryArea();
        Assert.assertEquals(chrome.findElement(By.xpath("//td[text()= '$76.99']")), chrome.findElement(By.xpath("//td[text()= '$78.99']")),"Total and Total product should be equal");
    }

        @Test
        public void verifyingBillingAnddress() {
            registrationPage.clickDressesTab();
            itemsPageTest.changeToListView();
            itemsPageTest.selectSizeCheckbox();
            itemsPageTest.addItemToCArtOne();
            itemsPageTest.closeWindowAdd();
            itemsPageTest.addItemToCArtTwo();
            itemsPageTest.proceedToSummaryArea();
            shoppingCart.clickProceedButtonCart();
            signInTabCheckout.enterEmailToSignIn();
            signInTabCheckout.enterPassToSignIn();
            signInTabCheckout.clickSubmitToSignIn();
    Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_firstname.address_lastname")).getText().contains("JaneJane JonesJonny"),"Should be JaneJane JonesJonny");
     Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_company")).getText().contains("TestCompany"),"Should be TestCompany");
    Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_address1.address_address2")).getText().contains("Germany"),"Should be Germany ");
        Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_city.address_state_name.address_postcode")).getText().contains("Berlin, Alabama 07936"), "Should be Berlin, Alabama 07936");
            Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_country_name")).getText().contains("United States"),"Should be United States");
            Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_phone")).getText().contains("777444333"),"Should be 777444333");
        Assert.assertTrue(chrome.findElement(By.cssSelector("ul#address_invoice >li.address_phone_mobile")).getText().contains("+34444445789"),"Should be +34444445789");
    }

    @Test
    public void navigateToShippingTAb(){
            registrationPage.clickDressesTab();
            itemsPageTest.changeToListView();
            itemsPageTest.selectSizeCheckbox();
            itemsPageTest.addItemToCArtOne();
            itemsPageTest.closeWindowAdd();
            itemsPageTest.addItemToCArtTwo();
            itemsPageTest.proceedToSummaryArea();
            shoppingCart.clickProceedButtonCart();
            signInTabCheckout.enterEmailToSignIn();
            signInTabCheckout.enterPassToSignIn();
            signInTabCheckout.clickSubmitToSignIn();
            signInTabCheckout.clickProceedButtonAddressTab();
            shippingTab.selectIagreeCheckbox();
            boolean isIAgreeCheckBoxSelectet = chrome.findElement(By.id("cgv")).isSelected();
        Assert.assertTrue(isIAgreeCheckBoxSelectet,"'I agree' checkbox should be selected");
    }

    @Test
    public void navigateToPaymentTAb() {
        registrationPage.clickDressesTab();
        itemsPageTest.changeToListView();
        itemsPageTest.selectSizeCheckbox();
        itemsPageTest.addItemToCArtOne();
        itemsPageTest.closeWindowAdd();
        itemsPageTest.addItemToCArtTwo();
        itemsPageTest.proceedToSummaryArea();
        shoppingCart.clickProceedButtonCart();
        signInTabCheckout.enterEmailToSignIn();
        signInTabCheckout.enterPassToSignIn();
        signInTabCheckout.clickSubmitToSignIn();
        signInTabCheckout.clickProceedButtonAddressTab();
        shippingTab.selectIagreeCheckbox();
        shippingTab.clickProceedButtonOnShippingTab();
        Assert.assertTrue(chrome.findElement(By.xpath("//span[text()=' Payment']")).isDisplayed(),"'Payment' tab is displayed");
    }

}

