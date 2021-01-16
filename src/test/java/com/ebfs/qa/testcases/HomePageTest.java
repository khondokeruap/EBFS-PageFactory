package com.ebfs.qa.testcases;

import com.ebfs.qa.properties.HomePageProperties;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.testcase.properties.HomePageTestProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;

public class HomePageTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	ExtentTestManager extentTestManager;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();		
		homePage = new HomePage();
		extentTestManager = new ExtentTestManager();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Home Page Title");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, HomePageTestProperties.EXP_HOMEPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyLogoTest(){// 1.1 BruteForce the power of choice..... Logo should be visible to all users.
		extentTestManager.getTest().log(Status.INFO, "Verify Logo in the Home Page");
		Assert.assertTrue(homePage.verifyLogoDisplayed());
	}
	
	@Test(priority=3)
	public void verifyContactUsLinkTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Contact Us Link in the Home Page");
		contactsPage = homePage.clickOnContactsLink();
		
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}


	@Test(priority=4)
	public void verifyFeatureProductsVisibleTest() { // 1.4. Featured Products should be visible to Users
		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");
		Assert.assertTrue(homePage.verifyFeatureProductsDisplayed());
	}

	@Test(priority=5)
	public void verifySignInTest() {// 1.3 Registered user should be able to Login from Home Page
		extentTestManager.getTest().log(Status.INFO, "Verify sign in from home Page");
		homePage.signIn();

	}
	@Test(priority=6)
	public void verifyEmptyCartVisibleTest() {// 1.5 Checkout Cart should be visible to users with Empty.
		extentTestManager.getTest().log(Status.INFO, "Verify empty cart is visible to Users in the Home Page");
		Assert.assertTrue(homePage.verifyEmptyCartDisplayed());
	}
	@Test(priority=7)
	public void verifyQuickViewTest() {// 1.6 User should be able to view the product details layer by clicking quick view
		extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to view the product details layer by clicking quick view");
		homePage.clkQuickView();
	}
	@Test(priority=8)
	public void verifyAddToWishlistTest() {// 1.7 User should be able to add the product to wish list from product details layer.
		extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to add the product to wish list from product details layer");
		homePage.addWishList();
	}
	@Test(priority=9)
	public void verefyDetailOrderFromMyAccTest() {// 1.8 User should be able to view details order from My Account section.
		extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to view details order from My Account section");
		homePage.signIn();
		homePage.viewOrderDetail();
		Assert.assertTrue(homePage.orderDetailPageDisplayed());
	}
	@Test(priority=10)
	public void filterPopularAndBestSellerTest() {// 1.1.1 User should be able to filter result using popular or best seller link.
		extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to filter result using popular or best seller link");
//		homePage.bestSeller();
		driver.findElement(By.xpath(HomePageProperties.LNK_BEST_SELLER_XPATH)).click();
		Assert.assertTrue(homePage.bestSellerPageDisplayed());
		System.out.println("Best Seller page is displayed");
//		homePage.popular();
		driver.findElement(By.xpath(HomePageProperties.LNK_POPULAR_XPATH)).click();
		Assert.assertTrue(homePage.popularPageDisplayed());
		System.out.println("Popular page is displayed");
	}
//	@Test(priority=11)
	public void newsLetterSubscriptionTest() {// 1.1.2 User should be subscribe/unsubscribe for Upcoming newsletter.
		extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to subscribe/unsubscribe for Upcoming newsletter.");
		homePage.newsLetter();
		Assert.assertTrue(homePage.successSubscriptionNewsLetterDisplayed());
		System.out.println("News Letter Subscribed");
	}
	@Test(priority=11)
	public void searchboxSearchTest() {// 1.1.3 User should be able to search for specific products by keyword.
		extentTestManager.getTest().log(Status.INFO, "Verify That User should be able to search for specific products by keyword.");
		homePage.searchItem();
		System.out.println("Search success");
	}
	@Test(priority=12)
	public void verifyFollowUsFacebookVisibleTest() { // 1.1.4. User should be presented to follow us on Facebook link
		extentTestManager.getTest().log(Status.INFO, "Verify that User should be presented to follow us on Facebook link");
		Assert.assertTrue(homePage.displaFfollow());
	}
	@Test(priority=13)
	public void verifyRegisterTest() { // 1.1.5. User should be able to register by clicking Login link
		extentTestManager.getTest().log(Status.INFO, "Verify that User should be User should be able to register by clicking Login link");
		homePage.register();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
