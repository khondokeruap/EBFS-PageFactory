package com.ebfs.qa.testcases;
import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.pages.ProductCartPage;
import com.ebfs.qa.pages.ProductCategoryPage;
import com.ebfs.qa.properties.HomePageProperties;
import com.ebfs.qa.properties.ProductCartProerties;
import com.ebfs.qa.properties.ProductCategoryProperties;
import com.ebfs.qa.testcase.properties.HomePageTestProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import com.ebfs.qa.testcase.properties.ProductCategoryTestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class ProductCartTest extends TestBase {
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    ExtentTestManager extentTestManager;
    ProductCategoryPage productCategoryPage;
    ProductCartPage  productCartPage;
    String sheetName = "Sheet1";
   public ProductCartTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        productCategoryPage = new ProductCategoryPage();
        extentTestManager = new ExtentTestManager();
        productCartPage = new ProductCartPage();
    }
    public void verifyMultipleProductToCartTest() throws InterruptedException {
        extentTestManager.getTest().log(Status.INFO, "Verify to add multiple product in the cart");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        WebElement ele = driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_XPATH));
        Actions act =new Actions(driver);
        act.moveToElement(ele).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS1_ADD_CART_CONTINUE_SHOPPING_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_2_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS2_ADD_CART_CHECKOUT_XPATH)).click();
    }
    @Test (priority = 30)
    public void cartSummaryDisplayItemNoTest() throws InterruptedException { // 3.1 Shopping Cart Summary page should display number of items added to the
        extentTestManager.getTest().log(Status.INFO, "Verify Shopping Cart Summary page should display number of items added to the");
        verifyMultipleProductToCartTest();
        Assert.assertTrue(productCartPage.verifyCartSummaryItemDisplayed());
        String itemDisplayed = driver.findElement(By.xpath(ProductCartProerties.CART_SUM_ITEM_DISPLAY_XPATH)).getText();
        System.out.println("Total number of item in the cart is : "+ itemDisplayed);
    }
    @Test (priority = 31)
    public void cartSummaryDeleteTest() throws InterruptedException { // 3.2 User should be able to delete the item.
        extentTestManager.getTest().log(Status.INFO, "Verify User should be able to delete the item.");
        verifyMultipleProductToCartTest();
        Assert.assertTrue(productCartPage.verifyCartSummaryDelete1Displayed());
        driver.findElement(By.xpath(ProductCartProerties.DELETE1)).click();
    }
    @Test (priority = 32)
    public void cartSummaryAddDeleteTest() throws InterruptedException { // 3.3 User should be able to increase/decrease the quantity of each item added.
        extentTestManager.getTest().log(Status.INFO, "Verify User should be able to delete the item.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.MIN1_XPATH)).click();
        driver.findElement(By.xpath(ProductCartProerties.PRINTED_DRESS2_ADD_XPATH)).click();
    }
        @Test (priority = 33)
    public void cartSummaryCostTest() throws InterruptedException { // 3.4 Total Cost and Shipping cost should display.
        extentTestManager.getTest().log(Status.INFO, "Verify User should be able to see the product cost and shipping cost");
        verifyMultipleProductToCartTest();
        Assert.assertTrue(productCartPage.verifyCartSummaryShippingCostDisplayed());
        String shippingCost = driver.findElement(By.xpath(ProductCartProerties.TOTAL_SHIPPING_COST_XPATH)).getText();
        System.out.println("Total shipping cost is : "+ shippingCost);
        Assert.assertTrue(productCartPage.verifyCartSummaryTotalCostDisplayed());
        String totalCost = driver.findElement(By.xpath(ProductCartProerties.TOTAL_COST_XPATH)).getText();
        System.out.println("Total cost is : "+ totalCost);
    }
    @Test (priority = 34)
    public void cartSummaryContinueShoppingTest() throws InterruptedException { // 3.5 Continue Shopping link should be available for user.
        extentTestManager.getTest().log(Status.INFO, "Verify User should be able to continue shopping from shopping card page.");
        verifyMultipleProductToCartTest();
        Assert.assertTrue(productCartPage.verifyCartSummaryContShoppingDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_SHOP_XPATH)).click();
    }
        @Test (priority = 35)
    public void cartSummaryCreateAccTest() throws InterruptedException { // 3.6 User should be able to create account.
        extentTestManager.getTest().log(Status.INFO, "Verify User should be able to create account.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_CHK_OUT_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.CREAT_ACCOUNT_EMAIL_ID)).sendKeys("chbdhhob@rmain.com");
        driver.findElement(By.id(HomePageProperties.BTN_CREAT_ACC_ID)).click();
        driver.findElement(By.xpath(HomePageProperties.GENDER_MALE_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.F_NAME_ID)).sendKeys("alauddin");
        driver.findElement(By.id(HomePageProperties.L_NAME_ID)).sendKeys("vau");
        driver.findElement(By.id(HomePageProperties.PWD_ID)).sendKeys("Compilia");
        driver.findElement(By.id("days"));
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByIndex(6);
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByIndex(1);
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByIndex(21);
        driver.findElement(By.id(HomePageProperties.SUBMIT_REG_ID)).click();
    }
    @Test (priority = 36)
    public void cartSummarySignInTest() throws InterruptedException { // 3.7 Registered user should be able to login.
        extentTestManager.getTest().log(Status.INFO, "Verify regestered User should be able to log in from shopping cart page.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_CHK_OUT_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.EMAIL_ID)).sendKeys("xaim@abc.com");
        driver.findElement(By.id(HomePageProperties.PASSWORD_ID)).sendKeys("Compilia");
        driver.findElement(By.id(HomePageProperties.BTN_SIGN_IN_ID)).click();
    }
    @Test (priority = 37)
    public void deleveryOptionTest() throws InterruptedException { // 3.8 Different delivery method option should be available for user to select.
        extentTestManager.getTest().log(Status.INFO, "Verify regestered User should be able to choose delievery options from shopping cart page.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_CHK_OUT_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.EMAIL_ID)).sendKeys("xaim@abc.com");
        driver.findElement(By.id(HomePageProperties.PASSWORD_ID)).sendKeys("Compilia");
        driver.findElement(By.id(HomePageProperties.BTN_SIGN_IN_ID)).click();
        driver.findElement(By.xpath(ProductCartProerties.ADDRESS_PROCESS_XPATH)).click();
        Assert.assertTrue(productCartPage.verifyDiffShipOptionsDisplayed());
        String shipOptionText = driver.findElement(By.xpath(ProductCartProerties.SHIPPING_OPTIONS_XPATH)).getText();
        System.out.println("Shipping options are : "+ shipOptionText);
    }
    @DataProvider (name = "login")
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }
        @Test (dataProvider = "login") // End to end test
    public void dataProviderPractive(String Username, String Password) throws InterruptedException { // 3.9 Different payment method should be presented to user.
        extentTestManager.getTest().log(Status.INFO, "Verify regestered User should be presented different payment method.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_CHK_OUT_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.EMAIL_ID)).sendKeys(Username);
        driver.findElement(By.id(HomePageProperties.PASSWORD_ID)).sendKeys(Password);
        driver.findElement(By.id(HomePageProperties.BTN_SIGN_IN_ID)).click();
        driver.findElement(By.xpath(ProductCartProerties.ADDRESS_PROCESS_XPATH)).click();
        Assert.assertTrue(productCartPage.verifyDiffShipOptionsDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.GIFT_OPTION_XPATH)).click();
        driver.findElement(By.xpath(ProductCartProerties.GIFT_TEXTBOX_XPATH)).sendKeys("Khondoker send the gift");
        driver.findElement(By.xpath(ProductCartProerties.TERMS_CHECK_XPATH)).click();
        driver.findElement(By.xpath(ProductCartProerties.SHIPPING_PROCEED_XPATH)).click();
        Assert.assertTrue(productCartPage.verifyBankWireDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.PAY_WIRE_XPATH)).click();
        driver.navigate().back();
        Thread.sleep(3000);
        Assert.assertTrue(productCartPage.verifyBankCheckDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.PAY_CHECK_XPATH)).click();
        driver.navigate().back();
        Thread.sleep(3000);
        Assert.assertTrue(productCartPage.verifyBankCardDisplayed());
        String textCard = driver.findElement(By.xpath(ProductCartProerties.PAY_CARD_XPATH)).getText();
        System.out.println("Credit card text :"+textCard);
    }
    @Test (priority = 38) // End to end test
    public void diffPaymentMethodTest() throws InterruptedException { // 3.9 Different payment method should be presented to user.
        extentTestManager.getTest().log(Status.INFO, "Verify regestered User should be presented different payment method.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_CHK_OUT_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.EMAIL_ID)).sendKeys("xaim@abc.com");
        driver.findElement(By.id(HomePageProperties.PASSWORD_ID)).sendKeys("Compilia");
        driver.findElement(By.id(HomePageProperties.BTN_SIGN_IN_ID)).click();
        driver.findElement(By.xpath(ProductCartProerties.ADDRESS_PROCESS_XPATH)).click();
        Assert.assertTrue(productCartPage.verifyDiffShipOptionsDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.GIFT_OPTION_XPATH)).click();
        driver.findElement(By.xpath(ProductCartProerties.GIFT_TEXTBOX_XPATH)).sendKeys("Khondoker send the gift");
        driver.findElement(By.xpath(ProductCartProerties.TERMS_CHECK_XPATH)).click();
        driver.findElement(By.xpath(ProductCartProerties.SHIPPING_PROCEED_XPATH)).click();
        Assert.assertTrue(productCartPage.verifyBankWireDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.PAY_WIRE_XPATH)).click();
        driver.navigate().back();
        Thread.sleep(3000);
        Assert.assertTrue(productCartPage.verifyBankCheckDisplayed());
        driver.findElement(By.xpath(ProductCartProerties.PAY_CHECK_XPATH)).click();
        driver.navigate().back();
        Thread.sleep(3000);
        Assert.assertTrue(productCartPage.verifyBankCardDisplayed());
        String textCard = driver.findElement(By.xpath(ProductCartProerties.PAY_CARD_XPATH)).getText();
        System.out.println("Credit card text :"+textCard);
   }
    @Test (priority = 39)
    public void giftWrapTest() throws InterruptedException { // 3.10 Gift wrap option should be available for user.
        extentTestManager.getTest().log(Status.INFO, "Verify User should be able to select gift wrap option.");
        verifyMultipleProductToCartTest();
        driver.findElement(By.xpath(ProductCartProerties.CONTINUE_CHK_OUT_XPATH)).click();
        driver.findElement(By.id(HomePageProperties.EMAIL_ID)).sendKeys("xaim@abc.com");
        driver.findElement(By.id(HomePageProperties.PASSWORD_ID)).sendKeys("Compilia");
        driver.findElement(By.id(HomePageProperties.BTN_SIGN_IN_ID)).click();
        driver.findElement(By.xpath(ProductCartProerties.ADDRESS_PROCESS_XPATH)).click();
        Assert.assertTrue(productCartPage.verifyGiftOptionDisplayed());
        String giftText =  driver.findElement(By.xpath(ProductCartProerties.GIFT_OPTION_XPATH)).getText();
        System.out.println("Gift option text :"+giftText);
        driver.findElement(By.xpath(ProductCartProerties.GIFT_OPTION_XPATH)).click();
        driver.findElement(By.xpath(ProductCartProerties.GIFT_TEXTBOX_XPATH)).sendKeys("Khondoker send the gift");
   }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
