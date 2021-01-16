package com.ebfs.qa.pages;
import com.ebfs.qa.properties.HomePageProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.properties.ProductCategoryProperties;

public class ProductCategoryPage extends TestBase {
    @FindBy(xpath = ProductCategoryProperties.DRESS_XPATH)
    @CacheLookup
    WebElement dressLink;
    @FindBy(xpath = ProductCategoryProperties.DRESS_CATALOG_CATAGORY_1_XPATH)
    WebElement subCat1;
    @FindBy(xpath = ProductCategoryProperties.DRESS_CATALOG_CATAGORY_2_XPATH)
    WebElement subCat2;
    @FindBy(xpath = ProductCategoryProperties.DRESS_CATALOG_CATAGORY_3_XPATH)
    WebElement subCat3;
    @FindBy(xpath = ProductCategoryProperties.SORT_XPATH)
    WebElement sort;
    @FindBy(xpath = ProductCategoryProperties.DRESS_LIST_XPATH)
    WebElement dressList;
    @FindBy(xpath = ProductCategoryProperties.DRESS_GRID_XPATH)
    WebElement dressGrid;
    @FindBy(xpath = ProductCategoryProperties.DRESS_PRODUCT_COUNT_XPATH)
    WebElement dressProductCount;
    @FindBy(xpath = ProductCategoryProperties.DRESS_SIZE_SMALL_XPATH)
    WebElement smallDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_SIZE_MEDIUM_XPATH)
    WebElement mediumDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_SIZE_LARGE_XPATH)
    WebElement largeDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_COLOR_ORANGE_XPATH)
    WebElement orangeDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_COLOR_YELLOW_XPATH)
    WebElement yellowDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_COMPOSITIONS_COTTON_XPATH)
    WebElement cottonDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_COMPOSITIONS_POLYESTER_XPATH)
    WebElement polyesterDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_STYLE_CASUAL_XPATH)
    WebElement casualDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_STYLE_GIRLY_XPATH)
    WebElement girlyDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_PROPERTIES_COLOURFUL_XPATH)
    WebElement colourfulDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_PROPERTIES_SHORT_XPATH)
    WebElement shortDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_AVAILABLITY_INSTOCK_XPATH)
    WebElement inStockDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_MANUFACTURER_FASHION_XPATH)
    WebElement manufacturerDress;
    @FindBy(xpath = ProductCategoryProperties.DRESS_CONDITION_NEW_XPATH)
    WebElement conditionDress;
    @FindBy(xpath = ProductCategoryProperties.DISCOVER_OUR_STORE_XPATH)
    WebElement DressOurStore;
    @FindBy(xpath = ProductCategoryProperties.ADDRESS_INPUT_XPATH)
    WebElement searchBoxLocation;
    @FindBy(xpath = ProductCategoryProperties.ADDRESS_SEARCH_XPATH)
    WebElement locationSearchBTN;
    @FindBy(xpath = ProductCategoryProperties.ADDRESS_SEARCH_BOX_CLOSE)
    WebElement locationSearchBtnClose;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_1_XPATH)
    WebElement printedDressOne;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_1_ADD_TO_CART_XPATH)
    WebElement printDress1Add;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_1_MORE_XPATH)
    WebElement printDress1More;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_1_OUT_STOCK_XPATH)
    WebElement printDress1Out;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_2_IN_STOCK_XPATH)
    WebElement printDress2In;
    @FindBy(xpath = ProductCategoryProperties.DRESS_1_QUICK_VIEW)
    WebElement dress1QuickView;

    @FindBy(xpath = ProductCategoryProperties.INFO_DELIVERY_XPATH)
    WebElement deleveryInfoDisplay;
    @FindBy(xpath = ProductCategoryProperties.INFO_LEGAL_XPATH)
    WebElement legalInfoDisplay;
    @FindBy(xpath = ProductCategoryProperties.INFO_TC_XPATH)
    WebElement termsInfoDisplay;
    @FindBy(xpath = ProductCategoryProperties.INFO_ABOUT_US_XPATH)
    WebElement aboutUsInfoDisplay;
    @FindBy(xpath = ProductCategoryProperties.INFO_PAYMENT_XPATH)
    WebElement paymentInfoDisplay;
    @FindBy(xpath = ProductCategoryProperties.INFO_STORE_XPATH)
    WebElement storeInfoDisplay;
    @FindBy(xpath = ProductCategoryProperties.DRESS1_ADD_CART_CONTINUE_SHOPPING_XPATH)
    WebElement dress1CartCont;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_2_XPATH)
    WebElement dressTwo;
    @FindBy(xpath = ProductCategoryProperties.PRINTED_DRESS_2_ADD_TO_CART_XPATH)
    WebElement printDress2Add;
    @FindBy(xpath = ProductCategoryProperties.DRESS2_ADD_CART_CHECKOUT_XPATH)
    WebElement Dress2CheckOut;
    @FindBy(xpath = ProductCategoryProperties.CART_SUMMERY_XPATH)
    WebElement cartSummery;
    @FindBy(xpath = ProductCategoryProperties.DRESS2_ADD_CART_CONTINUE_SHOPPING_XPATH)
    WebElement dress2CartCont;
    @FindBy(xpath = ProductCategoryProperties.CART_XPATH)
    WebElement cart;
    @FindBy(xpath = ProductCategoryProperties.CHECK_OUT_FROM_OVER_LAY_XPATH)
    WebElement checkOutFmOverlay;
    @FindBy(xpath = ProductCategoryProperties.SLIDE_BAR_LEFT_XPATH)
    WebElement leftSlide;
    @FindBy(xpath = ProductCategoryProperties.SLIDE_BAR_RIGHT_XPATH)
    WebElement rightSlide;


    public ProductCategoryPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean verifySubCatagoryDress1Displayed(){
        return subCat1.isDisplayed();
    }
    public boolean verifySubCatagoryDress2Displayed(){
        return subCat2.isDisplayed();
    }
    public boolean verifySubCatagoryDress3Displayed(){
        return subCat3.isDisplayed();
    }
    public boolean verifySortEnable(){return sort.isEnabled(); }
    public boolean verifyDressProductCountDisplayed(){
        return dressProductCount.isDisplayed();
    }
    public boolean verifyAddToCartPrintedDress1Displayed(){
        return printDress1Add.isDisplayed();
    }
    public boolean verifyMorePrintedDress1Displayed(){
        return printDress1More.isDisplayed();
    }
    public boolean verifyPrintedDress1StockDisplayed(){
        return printDress1Out.isDisplayed();
    }
    public boolean verifyPrintedDress2StockDisplayed(){
        return printDress2In.isDisplayed();
    }
    public boolean verifyDress1SQuickViewDisplayed(){
        return dress1QuickView.isDisplayed();
    }

    public boolean verifyDelieveryInfoDisplayed(){
        return deleveryInfoDisplay.isDisplayed();
    }
    public boolean verifyLegalInfoDisplayed(){
        return legalInfoDisplay.isDisplayed();
    }
    public boolean verifyTermsInfoDisplayed(){
        return termsInfoDisplay.isDisplayed();
    }
    public boolean verifyAboutUSInfoDisplayed(){
        return aboutUsInfoDisplay.isDisplayed();
    }
    public boolean verifyPaymentInfoDisplayed(){
        return paymentInfoDisplay.isDisplayed();
    }
    public boolean verifyStoreInfoDisplayed(){
        return storeInfoDisplay.isDisplayed();
    }
    public boolean verifyCheckoutFmOverlayDisplayed(){return checkOutFmOverlay.isDisplayed();}
}
