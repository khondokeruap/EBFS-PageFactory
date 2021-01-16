package com.ebfs.qa.testcases;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.pages.ProductCategoryPage;
import com.ebfs.qa.properties.ProductCategoryProperties;
import com.ebfs.qa.testcase.properties.HomePageTestProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import com.ebfs.qa.testcase.properties.ProductCategoryTestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductCategoryTest extends TestBase {

    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    ExtentTestManager extentTestManager;
    ProductCategoryPage productCategoryPage;

    public ProductCategoryTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        productCategoryPage = new ProductCategoryPage();
        extentTestManager = new ExtentTestManager();
    }

        @Test(priority=14)
    public void verifyProductCatagoryTest() {// 2.1 User should be able to navigate to one of the product category page by clicking  Dresses/T-Shirts
        extentTestManager.getTest().log(Status.INFO, "Verify navigate to catagory by clicking dress");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        String catagoryTitle = driver.getTitle();
        Assert.assertEquals(catagoryTitle, ProductCategoryTestProperties.EXP_DRESS_PAGE_TITLE);
    }

        @Test (priority = 15)
    public void verifySubCategoryLinkTest() {// 2.2 Sub-Categories link should be presented to the User.
        extentTestManager.getTest().log(Status.INFO, "Verify that Sub-Categories link should be presented to the User ");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifySubCatagoryDress1Displayed());
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_CATALOG_CATAGORY_1_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifySubCatagoryDress2Displayed());
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_CATALOG_CATAGORY_2_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifySubCatagoryDress3Displayed());
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_CATALOG_CATAGORY_3_XPATH)).click();
    }

        @Test(priority=16)
    public void verifySortTest() {// 2.3 Sort Functionality is available for User to sort the products.
        extentTestManager.getTest().log(Status.INFO, "Verify Sort Functionality is available ");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifySortEnable());
        driver.findElement(By.xpath(ProductCategoryProperties.SORT_XPATH)).click();
    }

    @Test(priority = 17)
    public void verifyViewChangeProductListTest() throws InterruptedException {// 2.4 User can change the view of the product list by clicking Grid or List.
        extentTestManager.getTest().log(Status.INFO, "Verify User can change the view of the product list by clicking Grid or List");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_LIST_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_GRID_XPATH)).click();
        Thread.sleep(3000);
    }

    @Test(priority = 18)
    public void verifyDressProductCountTest() throws InterruptedException {// 2.5 Number of products showing should display on the page.
        extentTestManager.getTest().log(Status.INFO, "Verify Number of products showing should display on the page.");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyDressProductCountDisplayed());
        String text = driver.findElement(By.xpath(ProductCategoryProperties.DRESS_PRODUCT_COUNT_XPATH)).getText();
        System.out.print("Number of products showing in the Dress catagory is: "+text);
        Thread.sleep(3000);
    }
    @Test(priority = 19)
    public void verifyDressFilterTest() throws InterruptedException {// 2.6 Filter the dress from left panel
        extentTestManager.getTest().log(Status.INFO, "Verify user can filter the search.");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_SIZE_SMALL_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_SIZE_MEDIUM_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_SIZE_LARGE_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_COLOR_ORANGE_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_COLOR_YELLOW_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_COMPOSITIONS_COTTON_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_COMPOSITIONS_POLYESTER_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_STYLE_CASUAL_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_STYLE_GIRLY_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_PROPERTIES_COLOURFUL_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_PROPERTIES_SHORT_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_AVAILABLITY_INSTOCK_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_MANUFACTURER_FASHION_XPATH)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_CONDITION_NEW_XPATH)).click();
        Thread.sleep(2000);
    }
    @Test(priority = 20)// slide bar problem
    public void verifySlideTest() throws InterruptedException {// 2.7 User should be able to filter item using the Price Range bar
        extentTestManager.getTest().log(Status.INFO, "Verify filter using slide bar");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();

        WebElement leftSlideBar = driver.findElement(By.xpath(ProductCategoryProperties.SLIDE_BAR_LEFT_XPATH));
        WebElement rightSlideBar = driver.findElement(By.xpath(ProductCategoryProperties.SLIDE_BAR_RIGHT_XPATH));
        Actions action = new Actions(driver);
        action.dragAndDropBy(leftSlideBar, 307,0).release().build().perform();
        action.dragAndDropBy(rightSlideBar, -50,0).release().build().perform();
    }
    @Test(priority = 21)
    public void verifyLocationSearchTest() throws InterruptedException {// 2.8 User should be able to find the store locationby clicking “DiscoverOurStores”
        extentTestManager.getTest().log(Status.INFO, "Verify search location");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DISCOVER_OUR_STORE_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.ADDRESS_INPUT_XPATH)).sendKeys("90650");
        driver.findElement(By.xpath(ProductCategoryProperties.ADDRESS_SEARCH_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.ADDRESS_SEARCH_BOX_CLOSE)).click();
        Thread.sleep(3000);
    }

    @Test(priority = 22)
    public void verifyMouseOverOnDressTest() throws InterruptedException {// 2.9 AddtoCartorMoreButton should be visiblewhenuser mouse overto product.
        extentTestManager.getTest().log(Status.INFO, "Verify filter using slide bar");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        WebElement ele = driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_XPATH));
       Actions act =new Actions(driver);
       act.moveToElement(ele).perform();
        Assert.assertTrue(productCategoryPage.verifyAddToCartPrintedDress1Displayed());
        Assert.assertTrue(productCategoryPage.verifyMorePrintedDress1Displayed());
        Thread.sleep(3000);
    }
        @Test(priority = 23)
    public void verifyInOrOutStockTest() throws InterruptedException {// 2.10 in stock/out stock should be displayed
        extentTestManager.getTest().log(Status.INFO, "Verify in stock/out stock should be displayed");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyPrintedDress1StockDisplayed());
        System.out.println("Printed Dress one stock verefy ");
        Assert.assertTrue(productCategoryPage.verifyPrintedDress2StockDisplayed());
        System.out.println("Printed Dress two stock verefy ");
        Thread.sleep(3000);
    }
    @Test(priority = 24)
    public void verifyQuickViewDisplayedOnMouseHoverTest() throws InterruptedException {// 2.11 Quick View link should be visible when user mouse over to product
        extentTestManager.getTest().log(Status.INFO, "Verify Quick view link is visible when mouse hover on dress");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        WebElement ele = driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_XPATH));
        Actions act =new Actions(driver);
        act.moveToElement(ele).perform();
        Assert.assertTrue(productCategoryPage.verifyDress1SQuickViewDisplayed());
        System.out.println("Quick View displayed ");
        Thread.sleep(3000);
    }
    @Test(priority = 25)
    public void verifyInfoLinkTest() throws InterruptedException {// 2.12 Information with different link is available for User
        extentTestManager.getTest().log(Status.INFO, "Verify information link ");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();

        Assert.assertTrue(productCategoryPage.verifyDelieveryInfoDisplayed());
        System.out.println("Information link displayed: Delievery ");
        driver.findElement(By.xpath(ProductCategoryProperties.INFO_DELIVERY_XPATH)).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

        Assert.assertTrue(productCategoryPage.verifyLegalInfoDisplayed());
        System.out.println("Information link displayed: Legal ");
        driver.findElement(By.xpath(ProductCategoryProperties.INFO_LEGAL_XPATH)).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

        Assert.assertTrue(productCategoryPage.verifyTermsInfoDisplayed());
        System.out.println("Information link displayed: Terms and Conditions ");
        driver.findElement(By.xpath(ProductCategoryProperties.INFO_TC_XPATH)).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

        Assert.assertTrue(productCategoryPage.verifyAboutUSInfoDisplayed());
        System.out.println("Information link displayed: About US ");
        driver.findElement(By.xpath(ProductCategoryProperties.INFO_ABOUT_US_XPATH)).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

        Assert.assertTrue(productCategoryPage.verifyPaymentInfoDisplayed());
        System.out.println("Information link displayed: Payment Info ");
        driver.findElement(By.xpath(ProductCategoryProperties.INFO_PAYMENT_XPATH)).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

        Assert.assertTrue(productCategoryPage.verifyStoreInfoDisplayed());
        System.out.println("Information link displayed: Store Info ");
        driver.findElement(By.xpath(ProductCategoryProperties.INFO_STORE_XPATH)).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

    }
    @Test(priority = 26)
    public void verifyMultipleProductToCartTest() throws InterruptedException {// 2.13 User should be able to add multiple product to cart from Product Category page.
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

        // need an assert

    }

    @Test(priority = 27)
    public void verifyUpDateCartTest() throws InterruptedException {// 2.14 Cart should be updated after product added to cart..
        extentTestManager.getTest().log(Status.INFO, "Verify cart is updated");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        WebElement ele = driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_XPATH));
        Actions act =new Actions(driver);
        act.moveToElement(ele).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS1_ADD_CART_CONTINUE_SHOPPING_XPATH)).click();

        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_2_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS2_ADD_CART_CHECKOUT_XPATH)).click();
        String text = driver.findElement(By.xpath(ProductCategoryProperties.CART_SUMMERY_XPATH)).getText();
        System.out.println("Product in the cart is : "+text);

    }
    @Test(priority = 28)
    public void verifyCheckOutFromProductOverlayTest() throws InterruptedException {// 2.15 Check out button should be available for user from Product Overlay.
        extentTestManager.getTest().log(Status.INFO, "Verify checkout button from product overlay");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        WebElement ele = driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_XPATH));
        Actions act =new Actions(driver);
        act.moveToElement(ele).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS1_ADD_CART_CONTINUE_SHOPPING_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_2_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS2_ADD_CART_CONTINUE_SHOPPING_XPATH)).click();
        WebElement elem = driver.findElement(By.xpath(ProductCategoryProperties.CART_XPATH));
        act.moveToElement(elem).perform();
        Thread.sleep(3000);
        Assert.assertTrue(productCategoryPage.verifyCheckoutFmOverlayDisplayed());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryProperties.CHECK_OUT_FROM_OVER_LAY_XPATH)).click();
    }

    @Test(priority = 29)
    public void verifyCheckOutToShopingCartTest() throws InterruptedException {// 2.16 Check out button should navigate to shopping cart summary page.
        extentTestManager.getTest().log(Status.INFO, "Verify checkout button should take to product summery page");
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS_XPATH)).click();
        WebElement ele = driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_XPATH));
        Actions act =new Actions(driver);
        act.moveToElement(ele).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_1_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS1_ADD_CART_CONTINUE_SHOPPING_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.PRINTED_DRESS_2_ADD_TO_CART_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryProperties.DRESS2_ADD_CART_CONTINUE_SHOPPING_XPATH)).click();
        WebElement elem = driver.findElement(By.xpath(ProductCategoryProperties.CART_XPATH));
        Actions acti =new Actions(driver);
        acti.moveToElement(elem).perform();
        driver.findElement(By.xpath(ProductCategoryProperties.CHECK_OUT_FROM_OVER_LAY_XPATH)).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, ProductCategoryTestProperties.EXP_SHOPPING_CART_PAGE_TITLE);
    }

        @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
