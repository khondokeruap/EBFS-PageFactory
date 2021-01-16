package com.ebfs.qa.testcases;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class google extends TestBase {
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    ExtentTestManager extentTestManager;

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
    public void searchboxSearchTest() {// 1.1.3 User should be able to search for specific products by keyword.
        extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to search for specific products by keyword.");
        homePage.searchItem();
        System.out.println("Search success");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
