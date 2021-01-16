package com.ebfs.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.properties.HomePageProperties;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends TestBase {


	@FindBy(xpath = HomePageProperties.IMG_LOGO_XPATH)
	@CacheLookup
	WebElement logo;

	@FindBy(xpath = HomePageProperties.FEATURE_PRODUCT_XPATH)
	WebElement featureProducts;

	@FindBy(xpath = HomePageProperties.LNK_CONTACT_US_XPATH)
	WebElement contactsLink;

	@FindBy(xpath = HomePageProperties.LNK_SIGN_IN_XPATH)
	WebElement signInLink;

	@FindBy(id = HomePageProperties.EMAIL_ID)
	WebElement email;

	@FindBy(id = HomePageProperties.PASSWORD_ID)
	WebElement password;

	@FindBy(id = HomePageProperties.BTN_SIGN_IN_ID)
	WebElement accountSignIn;

	@FindBy(xpath = HomePageProperties.CART_XPATH)
	WebElement emptyCart;

	@FindBy(xpath = HomePageProperties.CLOSE_QUICK_VIEW_XPATH)
	WebElement closeQView;

	@FindBy(partialLinkText = HomePageProperties.T_SHIRT_PARTIAL_LINK_TEXT)
	WebElement tShirt;

	@FindBy(id = HomePageProperties.WISH_LIST_BTN_ID)
	WebElement btnWishlist;

	@FindBy(xpath = HomePageProperties.CLOSE_WISH_XPATH)
	WebElement closeWishlist;
	@FindBy(xpath = HomePageProperties.ORDER_DETAIL_XPATH)
	WebElement orderDetail;

	@FindBy(xpath = HomePageProperties.VIEW_ORDER_DETAIL_XPATH)
	WebElement viewOrderDetail;

	@FindBy(xpath = HomePageProperties.LNK_BEST_SELLER_XPATH)
	WebElement bestSellerLink;

	@FindBy(xpath = HomePageProperties.LNK_POPULAR_XPATH)
	WebElement popularLink;

	@FindBy(xpath = HomePageProperties.NEWS_LETTER_SUBSCRIBE_XPATH)
	WebElement newsLetterSubscription;

	@FindBy(xpath = HomePageProperties.BTN_NEWS_SUBSCRIPTION_XPATH)
	WebElement btnNewsSubscription;

	@FindBy(xpath = HomePageProperties.SUCCESS_NEWS_LETTER_XPATH)
	WebElement successSubscription;

	@FindBy(xpath = HomePageProperties.SEARCH_BOX_XPATH)
	WebElement search;
	@FindBy(xpath = HomePageProperties.SUBMIT_SEARCH_XPATH)
	WebElement btnSearch;

	@FindBy(xpath = HomePageProperties.FOLLOW_US_XPATH)
	WebElement followFb;

	@FindBy(id = HomePageProperties.CREAT_ACCOUNT_EMAIL_ID)
	WebElement registerEmail;

	@FindBy(id = HomePageProperties.BTN_CREAT_ACC_ID)
	WebElement registerBtnSubmit;

	@FindBy(xpath = HomePageProperties.GENDER_MALE_XPATH)
	WebElement male;

	@FindBy(id = HomePageProperties.F_NAME_ID)
	WebElement fName;
	@FindBy(id = HomePageProperties.L_NAME_ID)
	WebElement lName;
	@FindBy(id = HomePageProperties.PWD_ID)
	WebElement pwd;
	@FindBy(id = HomePageProperties.DOB_DAY_ID)
	WebElement dobDay;
	@FindBy(id = HomePageProperties.DOB_MONTH_ID)
	WebElement dobMonth;
	@FindBy(id = HomePageProperties.DOB_YEAR_ID)
	WebElement dobYear;
	@FindBy(id = HomePageProperties.SUBMIT_REG_ID)
	WebElement submitReg;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyLogoDisplayed(){
		return logo.isDisplayed();
	}

	public boolean verifyFeatureProductsDisplayed(){
		return featureProducts.isDisplayed();
	}

	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	public void signIn(){
		signInLink.click();
		email.sendKeys("xaim@abc.com");
		password.sendKeys("Compilia");
		accountSignIn.click();
	}
	public boolean verifyEmptyCartDisplayed(){
		return emptyCart.isDisplayed();
	}
	
	public void clkQuickView(){
		featureProducts.click();
		closeQView.click();
	}
	public void addWishList(){
		tShirt.click();
		btnWishlist.click();
		closeWishlist.click();
	}
	public void viewOrderDetail(){
		orderDetail.click();
	}
	public boolean orderDetailPageDisplayed(){
		return viewOrderDetail.isDisplayed();
	}
	public void bestSeller(){
		bestSellerLink.click();
	}
	public boolean bestSellerPageDisplayed(){
		return bestSellerLink.isDisplayed();
	}
	public void popular(){
		popularLink.click();
	}
	public boolean popularPageDisplayed(){
		return popularLink.isDisplayed();
	}
	public void newsLetter(){
	newsLetterSubscription.sendKeys("1gbk4jx@ghy.com");
	btnNewsSubscription.click();
	}
	public boolean successSubscriptionNewsLetterDisplayed(){
		return successSubscription.isDisplayed();
	}

	public void searchItem(){
	search.sendKeys("Blouse");
	btnSearch.click();
}
	public boolean displaFfollow(){
		return followFb.isDisplayed();
	}

	public void register(){
		signInLink.click();
		registerEmail.sendKeys("rfhggi25e@Email.com");
		registerBtnSubmit.submit();
		male.click();
		fName.sendKeys("Reader");
		lName.sendKeys("Tenth Reader");
		pwd.sendKeys("Compilia");
		Select day = new Select(dobDay);
		day.selectByIndex(6);
		Select month = new Select(dobMonth);
		month.selectByIndex(1);
		Select year = new Select(dobYear);
		year.selectByIndex(21);
		submitReg.click();
	}
}
