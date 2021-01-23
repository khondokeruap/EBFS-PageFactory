package com.ebfs.qa.testcases;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.properties.HomePageProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class google extends TestBase {
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    ExtentTestManager extentTestManager;
    String sheetName1 = "Search";
    String sheetName2 = "char";
    String sheetName3 = "integer";
    String sheetName4 = "product";
    public google() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        extentTestManager = new ExtentTestManager();
    }
    @Test
    public void userButtonOnlySearch() {
        //      extentTestManager.getTest().log(Status.INFO, "Verify That User should able to search without writing anything in the search box");
        driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
        Assert.assertTrue(homePage.blankSearchBox());
    }

    @Test
    public void userClickOnlySearch() {
//      extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to click in the search box and without writing anything press search button ");
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).click();
        driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
        Assert.assertTrue(homePage.blankSearchBox());
        }
    @DataProvider(name = "int")
    public Object[][] intSearch(){
        Object data[][] = TestUtil.getTestData(sheetName3);
        return data;
    }
    @Test (dataProvider = "int")
    public void userIntSearch(String integerData) {
//      extentTestManager.getTest().log(Status.INFO, "Verify That User will search invalid search by input integer value in the search box ");
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).clear();
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).sendKeys(integerData);
        driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
        Assert.assertTrue(homePage.blankSearchBox());
        String text = driver.findElement(By.xpath(HomePageProperties.BLANK_SEARCH_XPATH)).getText();
        System.out.println("Search result for "+integerData + " is : " + text);
    }
@Test
    public void blankSearch() {
//       extentTestManager.getTest().log(Status.INFO, "Verify That User should able to search by pressing spacebar in the search box.");
    driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).clear();
    driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).sendKeys(Keys.SPACE);
    driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
    Assert.assertTrue(homePage.blankSearchBox());
    }
    @DataProvider(name = "char")
    public Object[][] character(){
        Object data[][] = TestUtil.getTestData(sheetName2);
        return data;
    }
    @Test (dataProvider = "char")
    public void characterSearch(String specialChar) {
//       extentTestManager.getTest().log(Status.INFO, "Verify That User should able to search by different character in the search box.");
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).clear();
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).sendKeys(specialChar);
        driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
        Assert.assertTrue(homePage.blankSearchBox());
        String text = driver.findElement(By.xpath(HomePageProperties.BLANK_SEARCH_XPATH)).getText();
        System.out.println("Search result for "+specialChar+ " is : "+ text);
    }

    @DataProvider(name = "search")
    public Object[][] keywordSearch(){
        Object data[][] = TestUtil.getTestData(sheetName1);
        return data;
    }
    @Test (dataProvider = "search")
    public void Search(String search) {
//        extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to search by anything in the search box");
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).sendKeys(search);
        driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
        Assert.assertTrue(homePage.blankSearchBox());
        String text = driver.findElement(By.xpath(HomePageProperties.BLANK_SEARCH_XPATH)).getText();
        System.out.println("Search result for ("+search+ ") is : =="+ text + "==");
        }
    @DataProvider(name = "product")
    public Object[][] actualSearch(){
        Object data[][] = TestUtil.getTestData(sheetName4);
        return data;
    }
    @Test (dataProvider = "product")
    public void SearchProduct(String search) {
//        extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to search categorised product in the search box");
        driver.findElement(By.xpath(HomePageProperties.SEARCH_BOX_XPATH)).sendKeys(search);
        driver.findElement(By.xpath(HomePageProperties.SUBMIT_SEARCH_XPATH)).click();
        Assert.assertTrue(homePage.foundSearchBox());
        String text = driver.findElement(By.xpath(HomePageProperties.SEARCH_FOUND_XPATH)).getText();
        System.out.println("Search result for ("+search+ ") is : =="+ text + "==");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
